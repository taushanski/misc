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

public class GarageDoor {

  public GarageDoor() {
  }

  public void up() {
    System.out.println("Garage door is Opening...");
    System.out.println("Garage door is Open.");
  }

  public void down() {
    System.out.println("Garage door is Closing...");
    System.out.println("Garage door is Closed");

  }

  public void stop() {
    // TODO
  }

  public void lightOn() {
    // TODO
  }

  public void lightOff() {
    // TODO
  }
}
