/*
 * Copyright 2010 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.example.http.websocketx.autobahn;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

/**
 * A Web Socket echo server for running the <a href="http://www.tavendo.de/autobahn/testsuite.html">autobahn</a>
 * test suite
 * 
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author <a href="http://gleamynode.net/">Trustin Lee</a>
 * @author <a href="http://www.veebsbraindump.com/">Vibul Imtarnasan</a>
 */
public class WebSocketServer {
	public static void main(String[] args) {
		ConsoleHandler ch = new ConsoleHandler();
		ch.setLevel(Level.FINE);
		Logger.getLogger("").addHandler(ch);
		Logger.getLogger("").setLevel(Level.FINE);
		
		// Configure the server.
		ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
				Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
		
		//bootstrap.setOption("child.tcpNoDelay", true);
		
		// Set up the event pipeline factory.
		bootstrap.setPipelineFactory(new WebSocketServerPipelineFactory());

		// Bind and start to accept incoming connections.
		bootstrap.bind(new InetSocketAddress(9000));
		
		System.out.println("Web Socket Server started on 9000. Open your browser and navigate to http://localhost:9000/");
	}
}
