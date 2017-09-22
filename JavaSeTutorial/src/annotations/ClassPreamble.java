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

import java.lang.annotation.Documented;

@Documented
public @interface ClassPreamble {
  String author();

  String date() default "15.02.2015";

  int currentRevission() default 1;

  String lastModified() default "N/A";

  String lastModifiedBy() default "N/A";

  String[] reviewers();
}
