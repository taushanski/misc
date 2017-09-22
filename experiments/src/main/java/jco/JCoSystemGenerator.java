/**
 * Copyright (c) 2017 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP SE, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 *
 * Created on Feb 8, 2017 by i059884
 *
 */

package jco;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

public class JCoSystemGenerator {
  private static final String JCO_REPOSITORY = "GJD";
  private static Properties jcoProperties = new Properties();
  static {
    // details for system GJD
    // jcoProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "ldcigjd.wdf.sap.corp");
    // jcoProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "18");
    // jcoProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "100");
    // jcoProperties.setProperty(DestinationDataProvider.JCO_USER, "TAUSHANSKI");
    // jcoProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "Abcd1234");
    // jcoProperties.setProperty(DestinationDataProvider.JCO_LANG, "en");
    jcoProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "ldcigjt.wdf.sap.corp");
    jcoProperties.setProperty(DestinationDataProvider.JCO_SYSNR, "21");
    jcoProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "200");
    jcoProperties.setProperty(DestinationDataProvider.JCO_USER, "TAUSHANSKI");
    jcoProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "Abcd1234");
    jcoProperties.setProperty(DestinationDataProvider.JCO_LANG, "en");
    Environment.registerDestinationDataProvider(new MyDestinationPrivider(jcoProperties));
  }

  public static void main(String[] args) throws JCoException {
    JCoDestination destination = JCoDestinationManager.getDestination(JCO_REPOSITORY);
    JCoRepository repository = destination.getRepository();
    File resultFile = new File("jcoRepository_" + JCO_REPOSITORY + ".json");
    BufferedWriter out = null;
    try {
      out = new BufferedWriter(new FileWriter(resultFile));
      JCoFunctionTemplate functionTemplate = repository.getFunctionTemplate("GRAC_BUSINESS_ROLE_EXPORT");
      // functionTemplate.
      JCoFunction function = functionTemplate.getFunction();

      JCoParameterList importParameters = function.getImportParameterList();
      importParameters.setValue("IV_CONNECTION_TYPE", "IDM_NW");
      importParameters.setValue("IV_CONNECTOR_GROUP", "IDM_NW_GRC");
      function.execute(destination);
      // JCoParameterList exportParameterList = function.getExportParameterList();
      // for (JCoField jCoField : exportParameterList) {
      // System.out.println("blq");
      // }
      // JCoTable table = exportParameterList.getTable("ET_RESULTS");
      // while (table.nextRow()) {
      // System.out.println();
      //
      // }

      repository.save(out);
      System.out.println("The repository was saved in: " + resultFile.getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  private static class MyDestinationPrivider implements DestinationDataProvider {

    private Properties properties;

    public MyDestinationPrivider(Properties jcoProperties) {
      properties = jcoProperties;
    }

    @Override
    public Properties getDestinationProperties(String arg0) {
      return properties;
    }

    @Override
    public void setDestinationDataEventListener(DestinationDataEventListener arg0) {
      // TODO Auto-generated method stub

    }

    @Override
    public boolean supportsEvents() {
      // TODO Auto-generated method stub
      return false;
    }

  }
}
