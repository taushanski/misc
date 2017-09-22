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

public class RemoteLoader {
  public static void main(String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    Light livingRoomLight = new Light("Living Room");
    Light kitchenLight = new Light("Kitchen");
    GarageDoor door = new GarageDoor();
    Stereo stereo = new Stereo("Livin Room");

    LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
    LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

    LightOnCommand kitchenRoomLightOn = new LightOnCommand(kitchenLight);
    LightOffCommand kitchenRoomLightOff = new LightOffCommand(kitchenLight);

    GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(door);
    GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(door);

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenRoomLightOn, kitchenRoomLightOff);
    remoteControl.setCommand(2, garageDoorOpen, garageDoorDown);

    System.out.println(remoteControl);

    remoteControl.onButtonWasPressed(0);
    remoteControl.offButtonWasPressed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPressed();

    remoteControl.onButtonWasPressed(1);
    remoteControl.offButtonWasPressed(1);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPressed();
    
    remoteControl.onButtonWasPressed(2);
    remoteControl.offButtonWasPressed(2);

    remoteControl.onButtonWasPressed(3);
    remoteControl.offButtonWasPressed(3);
  }
}
