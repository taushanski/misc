/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 14, 2015 by I059884
 * 
 */

package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18NSample {

  public static void main(String[] args) {

    String language;
    String country;

    if (args.length != 2) {
      language = "en";
      country = "US";
    } else {
      language = args[0];
      country = args[1];
    }

    Locale currentLocale = new Locale(language, country);
    ResourceBundle messages = ResourceBundle.getBundle("internationalization.MessagesBundle", currentLocale);

    System.out.println(messages.getString("greetings"));
    System.out.println(messages.getString("inquiry"));
    System.out.println(messages.getString("farewell"));

  }

}
