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

import java.util.*;

public class ListDemo {

  static void displayValues(Locale currentLocale) {

    ResourceBundle stats = ResourceBundle.getBundle("internationalization.StatsBundle", currentLocale);

    Integer gdp = (Integer) stats.getObject("GDP");
    System.out.println("GDP = " + gdp.toString());
    Double pop = (Double) stats.getObject("Population");
    System.out.println("Population = " + pop.toString());
    Double lit = (Double) stats.getObject("Literacy");
    System.out.println("Literacy = " + lit.toString());

  } // displayValues

  static public void main(String[] args) {

    Locale[] supportedLocales = {new Locale("en", "CA"), new Locale("ja", "JP"), new Locale("fr", "FR")};

//    for (int i = 0; i < supportedLocales.length; i++) {
//      System.out.println("Locale = " + supportedLocales[i]);
//      displayValues(supportedLocales[i]);
//      System.out.println();
//    }
    
    displayValues(supportedLocales[1]);

  } // main

} // class