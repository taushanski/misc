/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 14, 2015 by I059884
 * 
 */

package streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map.Entry;
import java.util.SortedMap;

public class ReadFileCharset {
  public static void main(String[] args) throws IOException {
    URL inFileUrl = ReadFileCharset.class.getResource("cirilic.txt");

    InputStreamReader in = null;
    OutputStreamWriter out = null;

    // String charSet = Charset.defaultCharset().toString();
//    String charSet = "ISO8859_5";
    // System.out.println(charSet);

    SortedMap<String, Charset> availableCharsets = Charset.availableCharsets();
    for (Entry<String, Charset> nextEntry : availableCharsets.entrySet()) {
      try {
        Charset nextCharset = nextEntry.getValue();
        String nextFileName = "out_" + nextEntry.getKey()+ ".txt";
        System.out.println("will read the file with the following charset: " + nextCharset);
        in = new InputStreamReader(new FileInputStream(inFileUrl.getPath()), nextCharset);

        out = new OutputStreamWriter(new FileOutputStream(nextFileName), nextCharset);

        int next;
        while ((next = in.read()) != -1) {
          out.write(next);
        }
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        if (in != null) {
          in.close();
        }
        if (out != null) {
          out.close();
        }
      }
    }
//
//    for (Entry<String, Charset> nextEntry : availableCharsets.entrySet()) {
//      System.out.println(nextEntry.getKey() + ":" + nextEntry.getValue());
//    }
  }
}
