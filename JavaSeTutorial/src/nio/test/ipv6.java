/**
 * Copyright (c) 2015 by SAP Labs Bulgaria, url: http://www.sap.com All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP AG, Walldorf. You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered into with SAP.
 * 
 * Created on Jul 1, 2015 by i059884
 * 
 */

package nio.test;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

class ipv6 {
  static public void main(String[] notUsed) {
    try {
      byte[] addr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

      InetAddress inetAddr = InetAddress.getByAddress(addr);

      InetSocketAddress addr_8501 = new InetSocketAddress(inetAddr, 8501);
      InetSocketAddress addr_8502 = new InetSocketAddress(inetAddr, 8502);

      System.out.println("==> 1");

      ServerSocket serverSocket = new ServerSocket();
      serverSocket.bind(addr_8501); // This works

      System.out.println("==> 2");

      ServerSocketChannel channel = ServerSocketChannel.open();
      channel.socket().bind(addr_8502); // This does not work

      System.out.println("==> 3");
    } catch (Throwable t) {
      t.printStackTrace();
    }
  }
}