/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jul 1, 2015 by i059884
 * 
 */

package text;

import java.text.BreakIterator;
import java.util.Arrays;
import java.util.Locale;

public class BreakIteratorTest {
  public static void main(String[] args) {
    Locale[] locales = BreakIterator.getAvailableLocales();
    System.out.println(Arrays.toString(locales));
  }
}
