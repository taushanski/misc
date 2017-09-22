/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Feb 15, 2015 by i059884
 * 
 */

package annotations;

public interface House {
  @Deprecated
  public void open();

  public void openFrontDoor();

  public void openBackDoor();
}
