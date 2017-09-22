/**
 * Copyright (c) 2017 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP SE, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jan 23, 2017 by i059884
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
import com.sap.conn.jco.JCoRecordMetaData;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.ext.DestinationDataProvider;
import com.sap.conn.jco.ext.Environment;

public class JcoTestProgram {
  private static final Map<String, String> connectProps = new HashMap<String, String>();

  static {
    connectProps.put(DestinationDataProvider.JCO_ASHOST, "ldcigjt.wdf.sap.corp");
    connectProps.put(DestinationDataProvider.JCO_SYSNR, "21");
    connectProps.put(DestinationDataProvider.JCO_CLIENT, "200");
    connectProps.put(DestinationDataProvider.JCO_USER, "TAUSHANSKI");
    connectProps.put(DestinationDataProvider.JCO_PASSWD, "Abcd1234");
    connectProps.put(DestinationDataProvider.JCO_LANG, "en");
  }

  public static void main(String[] args) throws JCoException {
    Environment.registerDestinationDataProvider(new MyDestinationDataProvider(connectProps));

    JCoDestination destination = JCoDestinationManager.getDestination("GJT_SYSTEM");

    System.out.println("Attributes:");
    System.out.println(destination.getAttributes());
    System.out.println("================================");
    destination.ping();
    System.out.println("Connection is pingable");

    JCoRepository repository = destination.getRepository();
    // JCoFunction businessRoleExportRfc = repository.getFunction("GRAC_BUSINESS_ROLE_EXPORT");
    // bapi1(destination, repository);
    bapi2(destination, repository);
  }

  private static void bapi1(JCoDestination destination, JCoRepository repository) throws JCoException {
    JCoFunction stfcConnectionFunction = repository.getFunction("STFC_CONNECTION");
    JCoParameterList importParameterList = stfcConnectionFunction.getImportParameterList();
    importParameterList.setValue("REQUTEXT", "SP_COR!");

    try {
      stfcConnectionFunction.execute(destination);
    } catch (JCoException e) {
      e.printStackTrace();
      return;
    }
    System.out.println("STFC_CONNECTION finished:");

    System.out.println("Echo: " + stfcConnectionFunction.getExportParameterList().getString("ECHOTEXT"));
    System.out.println("Response: " + stfcConnectionFunction.getExportParameterList().getString("RESPTEXT"));

    JCoFieldIterator fieldIterator = importParameterList.getFieldIterator();
    while (fieldIterator.hasNextField()) {
      JCoField type = fieldIterator.nextField();
      System.out.println(type.getTypeAsString());
    }

    JCoParameterList exportParameterList = stfcConnectionFunction.getExportParameterList();
    JCoRecordMetaData recordMetaData = exportParameterList.getListMetaData().getRecordMetaData(0);
    System.out.println(recordMetaData);
  }

  private static void bapi2(JCoDestination destination, JCoRepository repository) throws JCoException {
    JCoFunction stfcConnectionFunction = repository.getFunction("RFC_SYSTEM_INFO");

    try {
      stfcConnectionFunction.execute(destination);
    } catch (JCoException e) {
      e.printStackTrace();
      return;
    }

    JCoParameterList exportParameterList = stfcConnectionFunction.getExportParameterList();

    JCoStructure exportStructure = exportParameterList.getStructure("RFCSI_EXPORT");

    JCoRecordMetaData metaData = exportStructure.getRecordMetaData();
    JCoMetaData baseMetaData = exportStructure.getMetaData();
    for (int i = 0; i < exportStructure.getMetaData().getFieldCount(); i++) {
      System.out.println(exportStructure.getMetaData().getName(i) + ":\t" + exportStructure.getString(i));
    }

    for (JCoField nextField : exportStructure) {
      // nextField.getName()
      System.out.println(nextField.getName() + ":\t" + nextField.getTypeAsString());
    }

  }
}
