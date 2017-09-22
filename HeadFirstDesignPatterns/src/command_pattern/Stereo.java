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

public class Stereo {
  private String name ;

  public Stereo(String string) {
    this.name = string;
  }
  
  

  public void on() {
    System.out.println("Stereo is On.");
  }

  public void off() {
    System.out.println("Stereo is off.");
  }

  public void setCd() {
    System.out.println("Setting up CD");
  }

  public void setDvd() {
    System.out.println("Setting up DVD");
  }

  public void setRadio() {
    System.out.println("Setting up Radio");
  }

  public void setVolume(int volume) {
    System.out.println("Setting up Volume " + volume);
  }
}
