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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserExample extends DefaultHandler {

  private String tempVal;
  private Employee tempEmp;
  private List<Employee> myEmpls = new ArrayList<Employee>();

  public static void main(String[] args) {
    SAXParserExample test = new SAXParserExample();
    test.parseDocument();
  }

  private void parseDocument() {
    // get factory
    SAXParserFactory spf = SAXParserFactory.newInstance();
    URL xml = DomParserExample.class.getResource("employees.xml");
    // get a new instance of the parser
    try {
      SAXParser sp = spf.newSAXParser();

      // parse the file and also register this class for call backs
      sp.parse(xml.getPath(), this);
    } catch (ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    printData();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    // reset
    tempVal = "";
    if (qName.equalsIgnoreCase("Employee")) {
      // create a new instance of employee
      tempEmp = new Employee();
      tempEmp.setType(attributes.getValue("type"));
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    tempVal = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {

    if (qName.equalsIgnoreCase("Employee")) {
      // add it to the list
      myEmpls.add(tempEmp);

    } else if (qName.equalsIgnoreCase("Name")) {
      tempEmp.setName(tempVal);
    } else if (qName.equalsIgnoreCase("Id")) {
      tempEmp.setId(Integer.parseInt(tempVal));
    } else if (qName.equalsIgnoreCase("Age")) {
      tempEmp.setAge(Integer.parseInt(tempVal));
    }
  }

  private void printData() {

    System.out.println("No of Employees '" + myEmpls.size() + "'.");

    for (Employee employee : myEmpls) {
      System.out.println(employee);
    }
  }

}
