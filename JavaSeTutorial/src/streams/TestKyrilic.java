/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 24, 2015 by i059884
 * 
 */

package streams;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class TestKyrilic {
  public static void main(String[] args) throws UnsupportedEncodingException {

    String ru = "Киро Тест!";
    PrintStream ps = new PrintStream(System.out, true, "UTF-32");
    System.out.println(ru.length());
//    System.out.println(ru);
    ps.println(ru);
    ps.println(ru);
  }
}
