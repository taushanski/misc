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

public class SimpleRemoteControl {

  private Command slot;

  public SimpleRemoteControl() {
  }

  public void setCommand(Command command) {
    this.slot = command;
  }

  public void buttonWasPressed() {
    if (slot == null) {
      throw new IllegalStateException("The command is not initialized yet...");
    }
    slot.execute();
  }
}
