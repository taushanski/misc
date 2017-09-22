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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomParserExample {

  public static void main(String[] args) {
    // get the factory
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // using the factory to instantiate a document builder

    URL xml = DomParserExample.class.getResource("employees.xml");
    try {
      DocumentBuilder docBuilder = factory.newDocumentBuilder();

      // parse using builder to get DOM representation of the xml file
      Document dom = docBuilder.parse(xml.toString());

      // get the root element
      Element documentElement = dom.getDocumentElement();

      // get a nodelist of elements
      NodeList employeeList = documentElement.getElementsByTagName("Employee");

      List<Employee> myEmpls = new ArrayList<Employee>();
      if (employeeList != null && employeeList.getLength() > 0) {
        // get the employee element
        for (int i = 0; i < employeeList.getLength(); i++) {
          Element el = (Element) employeeList.item(i);

          // get the Employee object
          Employee e = getEmployee(el);

          // add it to list
          myEmpls.add(e);
        }
      }

      for (Employee employee : myEmpls) {
        System.out.println(employee);
      }

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * I take an employee element and read the values in, create an Employee object and return it
   */
  private static Employee getEmployee(Element empEl) {

    // for each <employee> element get text or int values of
    // name ,id, age and name
    String name = getTextValue(empEl, "Name");
    int id = getIntValue(empEl, "Id");
    int age = getIntValue(empEl, "Age");

    String type = empEl.getAttribute("type");

    // Create a new Employee with the value read from the xml nodes
    Employee e = new Employee(id, name, age, type);

    return e;
  }

  /**
   * I take a xml element and the tag name, look for the tag and get the text content i.e for <employee><name>John</name></employee> xml snippet if
   * the Element points to employee node and tagName is 'name' I will return John
   */
  private static String getTextValue(Element ele, String tagName) {
    String textVal = null;
    NodeList nl = ele.getElementsByTagName(tagName);
    if (nl != null && nl.getLength() > 0) {
      Element el = (Element) nl.item(0);
      textVal = el.getFirstChild().getNodeValue();
    }

    return textVal;
  }

  /**
   * Calls getTextValue and returns a int value
   */
  private static int getIntValue(Element ele, String tagName) {
    // in production application you would catch the exception
    return Integer.parseInt(getTextValue(ele, tagName));
  }

}
