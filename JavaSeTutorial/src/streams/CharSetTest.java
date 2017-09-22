/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 10, 2015 by I059884
 * 
 */

package streams;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class CharSetTest {

  public static void main(String[] args) {
    System.out.println("Default Charset=" + Charset.defaultCharset());
//    System.setProperty("file.encoding", "Latin-1");
    System.out.println("file.encoding=" + System.getProperty("file.encoding"));
    System.out.println("Default Charset=" + Charset.defaultCharset());
    System.out.println("Default Charset in Use=" + getDefaultCharSet());
  }

  private static String getDefaultCharSet() {
    OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
    String enc = writer.getEncoding();
    return enc;
  }
}