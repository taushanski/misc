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

public class RemoteControl {
  Command[] onCommands;
  Command[] offCommands;
  Command undoCommand;

  public RemoteControl() {
    onCommands = new Command[7];
    offCommands = new Command[7];

    Command noCommand = new NoCommand();
    for (int i = 0; i < 7; i++) {
      onCommands[i] = noCommand;
      offCommands[i] = noCommand;
    }

    undoCommand = noCommand;
  }

  public void setCommand(int slot, Command onCommand, Command offCommand) {
    // TODO - verify that slot is between 0 and 6

    onCommands[slot] = onCommand;
    offCommands[slot] = offCommand;
  }

  public void onButtonWasPressed(int slot) {
    // TODO validate the slot parameter
    onCommands[slot].execute();
    undoCommand = onCommands[slot];
  }

  public void offButtonWasPressed(int slot) {
    // TODO validate the slot parameter
    offCommands[slot].execute();
    undoCommand = offCommands[slot];
  }

  public void undoButtonWasPressed() {
    undoCommand.undo();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n------Remote Control---------\n");
    for (int i = 0; i < onCommands.length; i++) {
      sb.append("[slot ").append(i).append(" ] ").append(onCommands[i].getClass().getName()).append("   ")
          .append(offCommands[i].getClass().getName()).append("\n");

    }
    sb.append("[undo]").append(undoCommand.getClass().getName()).append("\n");
    return sb.toString();
  }
}
