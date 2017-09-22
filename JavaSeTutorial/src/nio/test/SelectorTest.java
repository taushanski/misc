/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jul 1, 2015 by i059884
 * 
 */

package nio.test;

import java.io.IOException;
import java.nio.channels.Selector;

public class SelectorTest {

  public static void main(String[] args) throws IOException {
    Selector selector = Selector.open();
    System.out.println(selector);

  }

}
