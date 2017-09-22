/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jul 1, 2015 by i059884
 * 
 */

package text;

import java.io.UnsupportedEncodingException;

public class EncodingTest {

  public static void printBytes(byte[] array, String name) {
    for (int k = 0; k < array.length; k++) {
      System.out.println(name + "[" + k + "] = " + "0x" + String.format("%02X", array[k]));
    }
  }

  public static void main(String[] args) {

    String original = new String("A" + "\u00ea" + "\u00f1" + "\u00fc" + "C");

    System.out.println(original);

    // lets try to convert it to UTF-8

    try {
      byte[] utf8Bytes = original.getBytes("UTF8");
      byte[] defaultBytes = original.getBytes();

      String roundTrip = new String(utf8Bytes, "UTF8");
      System.out.println("roudTrip=" + roundTrip);

      System.out.println();
      printBytes(utf8Bytes, "utf8Bytes");
      System.out.println();
      System.out.println(original);
      printBytes(defaultBytes, "defaultBytes");

    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
