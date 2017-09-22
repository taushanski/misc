/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on May 17, 2015 by i059884
 * 
 */

package exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListOfNumbers {
  private List<Integer> list;
  private static final int SIZE = 10;

  public ListOfNumbers() {
    list = new ArrayList<Integer>();

    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
  }

  public void writeList() {
    PrintWriter out = null;
    try {
      out = new PrintWriter(new FileWriter("OutFile.txt"));
      for (int i = 0; i < SIZE; i++) {
        // The get(int) method throws IndexOutOfBoundsException, which must be caught.
        out.println("Value at: " + i + " = " + list.get(i));
      }
    } catch (ArrayIndexOutOfBoundsException | IOException ex) {
      ex.printStackTrace();
      // } catch (IOException e) {
      // // TODO Auto-generated catch block
      // e.printStackTrace();
    } finally {
      out.close();
    }
  }
}
