/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 20, 2015 by i059884
 * 
 */

package command_pattern;

public class Light {

  private String location;

  public Light(String location) {
    this.location = location;
  }

  public void on() {
    System.out.println("The light in " + location + " was switched on!!!");
  }

  public void off() {
    System.out.println("The light in " + location + "shitched off!!!");
  }
}
