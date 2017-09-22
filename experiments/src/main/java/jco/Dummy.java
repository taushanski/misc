/**
 * Copyright (c) 2017 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP SE, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 *
 * Created on Apr 25, 2017 by i059884
 *
 */

package jco;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dummy {

  public static void main(String[] args) {
    String[] test = new String[5];
    test[0] = "fromArr";
    Set<String> testSet = new HashSet<String>();
    testSet.add("fromSet");
    System.out.println(Arrays.toString(testSet.toArray(test)));

  }

}
