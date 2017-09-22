/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Feb 16, 2015 by i059884
 * 
 */

package interfaces;

public interface DoIt {

  void doSomething(int i, double x);

  int doSomethingElse();

  default boolean didItWork(int i, double x, String s) {
    return false;
  }
}
