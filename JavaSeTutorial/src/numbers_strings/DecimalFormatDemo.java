/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Feb 23, 2015 by I059884
 * 
 */

package numbers_strings;

import java.text.*;

public class DecimalFormatDemo {

  static public void customFormat(String pattern, double value) {
    DecimalFormat myFormatter = new DecimalFormat(pattern);
    String output = myFormatter.format(value);
    System.out.println(value + "  " + pattern + "  " + output);
  }

  static public void main(String[] args) {

    customFormat("###,###.###", 123456.789);
    customFormat("###.##", 123456.789);
    customFormat("000000.000", 123.78);
    customFormat("$###,###.###", 12345.67);
  }
}