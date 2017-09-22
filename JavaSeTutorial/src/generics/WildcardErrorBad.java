/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Mar 9, 2015 by i059884
 * 
 */

package generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardErrorBad {

  // void swapFirst(List<? extends Number> l1, List<? extends Number> l2) {
  // Number temp = l1.get(0);
  // l1.set(0, l2.get(0)); // expected a CAP#1 extends Number,
  // // got a CAP#2 extends Number;
  // // same bound, but different types
  // l2.set(0, temp); // expected a CAP#1 extends Number,
  // // got a Number
  // }

  void testMethod(List<?> testList) {
    for (Object object : testList) {

    }
  }

  public static void main(String[] args) {
    List<? super Integer> list1 = new ArrayList<>();
    list1.add(1);
  }
}