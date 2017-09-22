/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 16, 2015 by i059884
 * 
 */

package internationalization;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesDemo {
  static Locale[] supportedLocales = {Locale.FRENCH, Locale.GERMAN, Locale.ENGLISH};

  public static void main(String[] args) {
    Locale currentLocale = supportedLocales[1];
    ResourceBundle labels = ResourceBundle.getBundle("internationalization.LabelsBundle", currentLocale);
    Enumeration bundleKeys = labels.getKeys();

    while (bundleKeys.hasMoreElements()) {
      String key = (String) bundleKeys.nextElement();
      String value = labels.getString(key);
      System.out.println("key = " + key + ", " + "value = " + value);
    }
  }

}
