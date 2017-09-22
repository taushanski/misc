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

import java.util.Map;
import java.util.Properties;

import com.sap.conn.jco.ext.DestinationDataEventListener;
import com.sap.conn.jco.ext.DestinationDataProvider;

// all the configuration will be fetched from here by the JCODestinationManager when creating JCoDestination object
public class MyDestinationDataProvider implements DestinationDataProvider {

  private Properties properties;

  public MyDestinationDataProvider(Map<String, String> jcoProperties) {
    properties = new Properties();
    properties.putAll(jcoProperties);
  }

  @Override
  public Properties getDestinationProperties(String arg0) {
    Properties connectProps = new Properties();
    connectProps.setProperty(DestinationDataProvider.JCO_ASHOST, "ldcigjt.wdf.sap.corp");
    connectProps.setProperty(DestinationDataProvider.JCO_SYSNR, "21");
    connectProps.setProperty(DestinationDataProvider.JCO_CLIENT, "200");
    connectProps.setProperty(DestinationDataProvider.JCO_USER, "TAUSHANSKI");
    connectProps.setProperty(DestinationDataProvider.JCO_PASSWD, "Abcd1234");
    connectProps.setProperty(DestinationDataProvider.JCO_LANG, "en");
    return connectProps;
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
