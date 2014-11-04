package gov.nist.healthcare.ttt.webapp.direct.listener;

import gov.nist.healthcare.ttt.webapp.common.config.ApplicationPropertiesConfig;
import gov.nist.healthcare.ttt.webapp.common.db.DatabaseInstance;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

public class DirectListener implements Runnable {

	private int port = 25;
	private int maxConnections = 0;
	
	private DatabaseInstance db;
	private ServletContext context;
	private ArrayList<Thread> threadsList = new ArrayList<Thread>();

	// Config Json

	Properties settings;
	
	private static Logger logger = Logger.getLogger(DirectListener.class.getName());

	public DirectListener(DatabaseInstance db, ServletContext context) {
		this.db = db;
		this.context = context;
		try {
			this.settings = ApplicationPropertiesConfig.getConfig();
			this.port = Integer.parseInt(this.settings.getProperty("direct.listener.port"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Listen for incoming connections and handle them
	public void run() {
		if(this.port == 0) {
			logger.info("Listener port is configured to 0 so the listener is not starting");
			return;
		}
		logger.info("Starting listener on port: " + this.port);
		int i = 0;

		try{
			ServerSocket listener = new ServerSocket(port);
			Socket server;

			while((i++ < maxConnections) || (maxConnections == 0)) {
				server = listener.accept();
				logger.debug("Running listener");
				ListenerProcessor processor = new ListenerProcessor(server, settings, db, context.getContextPath(), this.port);
				Thread t = new Thread(processor);
				threadsList.add(t);
				t.start();
			}
			listener.close();
		} 
		catch (IOException ioe) {
			System.out.println("IOException on socket listen: " + ioe);
			ioe.printStackTrace();
		}
		catch (Exception ioe) {
			System.out.println("Exception on socket listen: " + ioe);
			ioe.printStackTrace();
		}
	}
	
	public void stopThreads() {
		for(Thread t : threadsList) {
			t.interrupt();
		}
	}

}