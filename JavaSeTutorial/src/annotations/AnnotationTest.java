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

import java.util.Comparator;

@ClassPreamble(author = "Kiril Taushasnki", currentRevission = 6, reviewers = {"Iva", "Pesho"})
public class AnnotationTest implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    // TODO Auto-generated method stub
    return 0;
  }

}
