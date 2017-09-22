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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class CopyBytes {

  public static void main(String[] args) throws IOException {

    FileInputStream fis = null;
    FileOutputStream fos = null;

    URL inFileUrl = CopyBytes.class.getResource("xanadu.txt");
    try {
      fis = new FileInputStream(inFileUrl.getPath());
      fos = new FileOutputStream("outagain.txt");

      int nextChar;
      
      while ((nextChar = fis.read()) != -1) {
        fos.write(nextChar);
      }

    } finally { // do some cleaning
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }

  }

}
