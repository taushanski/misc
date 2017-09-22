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

public class GarageDoorDownCommand implements Command {
  private GarageDoor door;

  public GarageDoorDownCommand(GarageDoor door) {
    this.door = door;
  }

  @Override
  public void execute() {
    door.down();
  }

  @Override
  public void undo() {
    door.up();
  }

}
