/**
 * Copyright (c) 2017 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP SE, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 *
 * Created on May 4, 2017 by i059884
 *
 */

package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class FormatDate {
  public static void main(String[] args) throws ParseException {
    String dateToFormat = "20170316170925";
    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
    Date parsedDate = formatter.parse(dateToFormat);
    System.out.println(parsedDate);
    System.out.println(formatter.format(parsedDate));
    SimpleDateFormat resultFormatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
    System.out.println(resultFormatter.format(parsedDate));
    System.out.println("=================");

    Date theBeggining = new Date(0);
    System.out.println(theBeggining);
    System.out.println(theBeggining.getTime());

  }
}
