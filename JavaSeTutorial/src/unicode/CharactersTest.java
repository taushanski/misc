/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 27, 2015 by I059884
 * 
 */

package unicode;

import java.util.Arrays;

public class CharactersTest {
  public static void main(String[] args) {
    char[] chars = Character.toChars(0x11170);
    System.out.println(chars.length);
    for (char c : chars) {
      System.out.println(Integer.toHexString(c));
    }

    System.out.println("Now some dommy test");

    int[] codepoints = {66000, 66001};
    String stringOfSupplementaryChars = new String(codepoints, 0, 2);

    System.out.println(stringOfSupplementaryChars.codePointCount(0, stringOfSupplementaryChars.length()));

    String cyrilic = "Тест";
    System.out.println(cyrilic.length());
    System.out.println("Start");
    for (int i = 0; i < cyrilic.length(); i++) {
      System.out.println(cyrilic.codePointAt(i));
    }

  }
}
