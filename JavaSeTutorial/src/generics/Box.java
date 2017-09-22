/**
 * Copyright (c) 2015 by SAP Labs Bulgaria,
 * url: http://www.sap.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of SAP AG, Walldorf. You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with SAP.
 * 
 * Created on Mar 7, 2015 by I059884
 *   
 */
 
package generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T> {

  private T t;          

  public void set(T t) {
      this.t = t;
  }

  public T get() {
      return t;
  }

  public <U extends Number> void inspect(U u){
      System.out.println("T: " + t.getClass().getName());
      System.out.println("U: " + u.getClass().getName());
  }

  public static void main(String[] args) {
      Box<Integer> integerBox = new Box<Integer>();
      integerBox.set(new Integer(10));
//      integerBox.inspect("some text"); // error: this is still String!
      
      ArrayList<String> list = new ArrayList<String>();
      
      Class<?>[] interfaces = list.getClass().getInterfaces();
      System.out.println(Arrays.toString(interfaces));
  }
}