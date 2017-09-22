/**
 * Copyright (c) 2017 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP SE, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jan 25, 2017 by i059884
 * 
 */

package jco;

import java.util.HashMap;
import java.util.Map;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

public class JCoClient {
  private static final String EXPORT_ROLE_RFC = "GRAC_BUSINESS_ROLE_EXPORT";
  private static final String JCO_DESTINATIO_NAME = "GJT_SYSTEM";
  private static final Map<String, String> gjtJcoProperties = new HashMap<String, String>();

  static {
    gjtJcoProperties.put(DestinationDataProvider.JCO_ASHOST, "ldcigjt.wdf.sap.corp");
    gjtJcoProperties.put(DestinationDataProvider.JCO_SYSNR, "21");
    gjtJcoProperties.put(DestinationDataProvider.JCO_CLIENT, "200");
    gjtJcoProperties.put(DestinationDataProvider.JCO_USER, "TAUSHANSKI");
    gjtJcoProperties.put(DestinationDataProvider.JCO_PASSWD, "Abcd1234");
    gjtJcoProperties.put(DestinationDataProvider.JCO_LANG, "en");
  }

//  private JCoDestination destination;

//  public JCoClient(Map<String, String> jcoProperties) throws JCoException {
//    Environment.registerDestinationDataProvider(new MyDestinationDataProvider(jcoProperties));
//    destination = JCoDestinationManager.getDestination(JCO_DESTINATIO_NAME);
//  }

//  private void executeFunctionModule(String rfcName, Map<String, Object> params) throws JCoException {
//    JCoRepository repository = destination.getRepository();
//    JCoFunction rfcFunction = repository.getFunction(rfcName);
//    JCoParameterList importParameters = rfcFunction.getImportParameterList();
//
//    System.out.println(result);
//
//  }

  private void extractParameters(JCoParameterList exportParameterList) {
    Map<String, Object> result = new HashMap<String, Object>();
    JCoFieldIterator fieldIterator = exportParameterList.getFieldIterator();
    while (fieldIterator.hasNextField()) {
      JCoField nextField = fieldIterator.nextField();
      switch (nextField.getType()) {
        case JCoMetaData.TYPE_TABLE: {

          break;
        }
        case JCoMetaData.TYPE_INT: {
          result.put(nextField.getName(), nextField.getValue());
          break;
        }
        default: {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws JCoException {
    // JCoClient client = new JCoClient(gjtJcoProperties);
     Map<String, Object> params = new HashMap<String, Object>();
     params.put("IV_LAST_CHANGED_ON", null);
     params.put("IV_CONNECTION_TYPE", "IDM_NW");
     params.put("IV_CONNECTOR_GROUP", "IDM_NW_GRC");
     params.put("IV_ROLE_STATUS", "PRD");
    // client.executeFunctionModule(EXPORT_ROLE_RFC, params);

//    Map<String, Object> params = new HashMap<String, Object>();
//    params.put("MAX_ROWS", "10");
    // client.executeFunctionModule("BAPI_USER_GETLIST", params);
    //
    JcoJson client = new JcoJson(JCO_DESTINATIO_NAME, gjtJcoProperties, EXPORT_ROLE_RFC);
    client.setParameters(params);
    String result = client.execute();
    System.out.println(result);
  }

}
