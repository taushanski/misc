/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Feb 16, 2015 by i059884
 * 
 */

package interfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class SimpleTimeClient implements TimeClient {
  private LocalDateTime dateAndTime;

  public SimpleTimeClient() {
    dateAndTime = LocalDateTime.now();
  }

  public void setTime(int hour, int minute, int second) {
    LocalDate currentDate = LocalDate.from(dateAndTime);
    LocalTime timeToSet = LocalTime.of(hour, minute, second);
    dateAndTime = LocalDateTime.of(currentDate, timeToSet);
  }

  public void setDate(int day, int month, int year) {
    LocalDate dateToSet = LocalDate.of(day, month, year);
    LocalTime currentTime = LocalTime.from(dateAndTime);
    dateAndTime = LocalDateTime.of(dateToSet, currentTime);
  }

  public void setDateAndTime(int day, int month, int year, int hour, int minute, int second) {
    LocalDate dateToSet = LocalDate.of(day, month, year);
    LocalTime timeToSet = LocalTime.of(hour, minute, second);
    dateAndTime = LocalDateTime.of(dateToSet, timeToSet);
  }

  public LocalDateTime getLocalDateTime() {
    return dateAndTime;
  }

  @Override
  public String toString() {
    return dateAndTime.toString();
  }

  public static void main(String... args) {
    TimeClient myTimeClient = new SimpleTimeClient();
    System.out.println(myTimeClient.toString());
  }

}
