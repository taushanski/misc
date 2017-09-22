/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jun 16, 2015 by i059884
 * 
 */

package xml;

public class Employee {
  private int id;
  private String name;
  private int age;
  private String type;

  public Employee(int id, String name, int age, String type) {
    this.setId(id);
    this.setName(name);
    this.setAge(age);
    this.setType(type);
  }

  public Employee() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Employee Details - ");
    sb.append("Name:").append(getName()).append(", Type:").append(getType()).append(", Id:").append(getId()).append(", Age:").append(getAge());
    return sb.toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
