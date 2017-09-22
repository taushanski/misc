
package jco;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONValue;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;
import com.sap.conn.jco.ext.Environment;

/**
 *
 * jcoSon will allow you to call SAP BAPIs and function modules using json. Both the parameters you pass to the function modules and the results you
 * get back will be in json format. Homepage : http://dhorions.github.io/jcoSon Examples : https://github.com/dhorions/jcoSon/blob/master/README.md
 * 
 * @author Dries Horions <dries@quodlibet.be>
 */
public class JcoJson {

  private JCoDestination destination = null;
  private JCoFunction function;

  public JcoJson(String jcoDestinatioName, Map<String, String> jcoProperties, String frcName) throws JCoException {
    try {
      Environment.registerDestinationDataProvider(new MyDestinationDataProvider(jcoProperties));
    } catch (IllegalStateException providerAlreadyRegisteredException) {
      throw new Error(providerAlreadyRegisteredException);
    }

    destination = JCoDestinationManager.getDestination(jcoDestinatioName);
    JCoRepository repository = destination.getRepository();
    function = repository.getFunction(frcName);
  }

  /**
   *
   * @param destination A valid JCo Destination
   * @return json Representation of the JCo Function call
   * @throws JCoException
   */
  public String execute() throws JCoException {
    function.execute(destination);
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    if (function.getExportParameterList() != null) {
      getParameters(function.getExportParameterList(), result);
    }
    // Changing parameters
    if (function.getChangingParameterList() != null) {
      getParameters(function.getChangingParameterList(), result);
    }
    // Table Parameters
    if (function.getTableParameterList() != null) {
      getParameters(function.getTableParameterList(), result);
    }
    return JSONValue.toJSONString(result);
  }

  private void getParameters(JCoParameterList jcoParameters, Map<String, Object> params) {
    JCoFieldIterator jcoParametersIterator = jcoParameters.getFieldIterator();
    while (jcoParametersIterator.hasNextField()) {
      JCoField nextField = jcoParametersIterator.nextField();
      if (nextField.isTable()) {
        params.put(nextField.getName(), getTableParameter(nextField.getTable()));
      } else if (nextField.isStructure()) {
        params.put(nextField.getName(), getStructureParameter(nextField.getStructure()));
      } else {
        params.put(nextField.getName(), nextField.getValue());
      }
    }
  }

  private List<Map<String, Object>> getTableParameter(JCoTable jcoTable) {
    List<Map<String, Object>> table = new LinkedList<Map<String, Object>>();

    for (int rowNumber = 0; rowNumber < jcoTable.getNumRows(); rowNumber++) {
      jcoTable.setRow(rowNumber);
      JCoFieldIterator rowColumnsIterator = jcoTable.getFieldIterator();
      Map<String, Object> nextTableRow = new LinkedHashMap<String, Object>();
      while (rowColumnsIterator.hasNextField()) {
        JCoField nextField = rowColumnsIterator.nextField();
        if (nextField.isTable()) {
          nextTableRow.put(nextField.getName(), getTableParameter(nextField.getTable()));
        } else if (nextField.isStructure()) {
          nextTableRow.put(nextField.getName(), getStructureParameter(nextField.getStructure()));
        } else {
          nextTableRow.put(nextField.getName(), nextField.getValue());
        }
      }
      table.add(nextTableRow);
    }
    return table;
  }

  private Map<String, Object> getStructureParameter(JCoStructure structure) {
    Map<String, Object> convertedStructure = new LinkedHashMap<String, Object>();
    JCoFieldIterator structureIterator = structure.getFieldIterator();
    while (structureIterator.hasNextField()) {
      JCoField nextField = structureIterator.nextField();
      if (nextField.isTable()) {
        convertedStructure.put(nextField.getName(), getTableParameter(nextField.getTable()));
      } else if (nextField.isStructure()) {
        convertedStructure.put(nextField.getName(), getStructureParameter(nextField.getStructure()));
      } else {
        convertedStructure.put(nextField.getName(), nextField.getValue());
      }
    }
    return convertedStructure;
  }

  /**
   * Sets the functions parameters from a Map
   * 
   * @param parameters a Map of parameters of type LinkedHashMap or LinkedList)
   *
   */
  public void setParameters(Map<String, Object> parameters) {
    for (String nextParameterName : parameters.keySet()) {
      setParameter(nextParameterName, parameters.get(nextParameterName));
    }
  }

  /**
   * Sets a single parameter
   * 
   * @param name the name of the parameter
   * @param value the value of the parameter (String, Integer, LinkedHashMap or LinkedList)
   */
  public void setParameter(String name, Object value) {
    if (value instanceof List) {
      setTableParameter(name, (List<Map<String, Object>>) value);
    } else if (value instanceof Map) {
      setStructureParameter(name, (Map<String, Object>) value);
    } else {
      setSimpleParameter(name, value);
    }
  }

  /**
   * Sets a single Importing or Changing parameter that is not a structure
   * 
   * @param name the name of the parameter
   * @param value the value of the parameter
   */
  public void setSimpleParameter(String name, Object value) {
    // Find Simple, non structure or table parameter with this name and set the appropriate value
    // Importing Parameters
    if (function.getImportParameterList() != null) {
      setSimpleParameterValue(function.getImportParameterList(), name, value);
    }
    // Changing Parameters
    if (function.getChangingParameterList() != null) {
      setSimpleParameterValue(function.getChangingParameterList(), name, value);
    }

  }

  private void setSimpleParameterValue(JCoParameterList jcoParameters, String name, Object value) {
    JCoFieldIterator fieldIterator = jcoParameters.getFieldIterator();
    while (fieldIterator.hasNextField()) {
      JCoField nextField = fieldIterator.nextField();
      if (nextField.getName().equals(name) & !nextField.isStructure() & !nextField.isTable()) {
        nextField.setValue(value);
      }
    }
  }

  // TODO: consider also the changing parameters not only the importing params

  public void setStructureParameter(String name, Map<String, Object> map) {
    JCoParameterList importParameters = function.getImportParameterList();
    // TODO: Note: here a ConversionException or JcoRuntimeException may occur
    JCoStructure structure = importParameters.getStructure(name);
    for (String nextParamName : map.keySet()) {
      structure.setValue(nextParamName, map.get(nextParamName));
    }

    // while (iter.hasNextField()) {
    // JCoField f = iter.nextField();
    // if (f.getName().equals(name) & f.isStructure()) {
    // Iterator fieldIter = map.entrySet().iterator();
    // JCoStructure structure = f.getStructure();
    // while (fieldIter.hasNext()) {
    // Entry field = (Map.Entry) fieldIter.next();
    // structure.setValue(field.getKey().toString(), field.getValue().toString());
    // }
    //
    // }
    // }
  }

  // TODO - actually an import parameter could also be of type table so consider this
  public void setTableParameter(String name, List<Map<String, Object>> list) {
    JCoParameterList tableParameters = function.getTableParameterList();
    JCoTable table = tableParameters.getTable(name);
    for (Map<String, Object> nextRow : list) {
      table.appendRow();
      for (String nextFieldName : nextRow.keySet()) {
        table.setValue(nextFieldName, nextRow.get(nextFieldName));
      }
    }

    // JCoFieldIterator iter = function.getTableParameterList().getFieldIterator();
    // while (iter.hasNextField()) {
    // JCoField nextParameter = iter.nextField();
    // if (nextParameter.getName().equals(name) & nextParameter.isTable()) {
    // Iterator recordIter = list.listIterator();
    // JCoTable table = nextParameter.getTable();
    // while (recordIter.hasNext()) {
    // table.appendRow();
    // LinkedHashMap fields = (LinkedHashMap) recordIter.next();
    // Iterator fieldIter = fields.entrySet().iterator();
    // while (fieldIter.hasNext()) {
    // Entry field = (Map.Entry) fieldIter.next();
    // table.setValue(field.getKey().toString(), field.getValue().toString());
    // }
    // }
    // }
    // }

  }
}
