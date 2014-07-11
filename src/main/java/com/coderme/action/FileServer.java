package com.coderme.action;


import java.net.InetAddress;
import java.util.Date;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/fileServer")
public class FileServer {
	
	private Server server;
	
	private static Integer PORT = 9080;
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public String create() {
		return "fileServerCreate";
	} 
	
	@RequestMapping(value="/start",method = RequestMethod.POST)
	public String start(Model model, String addr, String port) throws Exception {
		if (null != port && port.length()>0) {
			PORT = Integer.valueOf(port);
		}
		server = new Server(PORT);
		if (server.isRunning()) {
			return null;
		}
		if (null == addr) {
			addr = "/";
		}
		ResourceHandler resourceHandler = new ResourceHandler();
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setResourceBase(addr);
		resourceHandler.setStylesheet("");
		
		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resourceHandler, new DefaultHandler() });
		server.setHandler(handlers);

		server.start();
		String localIp = InetAddress.getLocalHost().getHostAddress();
		model.addAttribute("localIp", localIp);
		model.addAttribute("port", PORT);
//		server.join();
		return "fileServer";
	}
	
	@RequestMapping(value="stop",method = RequestMethod.GET)
	@ResponseBody
	public String stop() throws Exception {
		server.stop();
		
		return Server.getVersion()+"\br fileServer start @" + new Date();
	}
}