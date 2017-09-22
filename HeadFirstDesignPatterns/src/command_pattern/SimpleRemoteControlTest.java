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

public class SimpleRemoteControlTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // initialization
    SimpleRemoteControl remoteControl = new SimpleRemoteControl();
    Light light = new Light("Living Room");
    LightOnCommand command = new LightOnCommand(light);
    remoteControl.setCommand(command);

    // simulate the button pressed
    remoteControl.buttonWasPressed();
    GarageDoor door = new GarageDoor();
    GarageDoorOpenCommand openCommand = new GarageDoorOpenCommand(door);
    remoteControl.setCommand(openCommand);
    remoteControl.buttonWasPressed();
  }
}
