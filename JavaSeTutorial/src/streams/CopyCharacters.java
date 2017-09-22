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

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class CopyCharacters {
  public static void main(String[] args) throws IOException {
    FileReader reader = null;
    FileWriter writer = null;
    URL inFileUrl = CopyBytes.class.getResource("xanadu.txt");
    try {
      reader = new FileReader(inFileUrl.getPath());
      writer = new FileWriter("characteroutput.txt");

      int c;
      while ((c = reader.read()) != -1) {
        writer.write(c);
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
        try {
          writer.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
  }
}
