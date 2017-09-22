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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class CopyLines {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = null;
    PrintWriter writer = null;
    URL inFileUrl = CopyBytes.class.getResource("xanadu.txt");
    try {
      reader = new BufferedReader(new FileReader(inFileUrl.getPath()));
      writer = new PrintWriter(new FileWriter("characterwriter.txt"));

      String nextLine = null;
      while ((nextLine = reader.readLine()) != null) {
        writer.println(nextLine);
      }
      
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (writer != null) {
        writer.close();

      }
    }
  }
}
