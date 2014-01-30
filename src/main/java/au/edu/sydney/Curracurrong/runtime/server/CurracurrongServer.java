/*
 * SunSpotHostApplication.java
 *
 * Created on 26/07/2010 7:32:49 PM;
 */

package au.edu.sydney.Curracurrong.runtime.server;

import au.edu.sydney.Curracurrong.datatype.ParsingException;

import java.io.*;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import au.edu.sydney.Curracurrong.org.sunspotworld.MonitorSPOT;

import au.edu.sydney.Curracurrong.queryLanguage.TLexer;
import au.edu.sydney.Curracurrong.queryLanguage.TParser;
import au.edu.sydney.Curracurrong.runtime.Registry;
import au.edu.sydney.Curracurrong.scheduler.Scheduler;
import au.edu.sydney.Curracurrong.util.NetworkAddress;

/**
 * Sample Sun SPOT host application
 */
public class CurracurrongServer {
	protected ServerAdministrator admin;
	protected ServerCommunicator comm;
	protected Scheduler sched;
	
	protected String inputStream = "src/queryLanguage/test1";

	public CurracurrongServer() {
	}
	
	public CurracurrongServer(String streamName) {
		inputStream = streamName;
	}
	
	/**
	 * Print out our radio address.
	 */
	public void run() throws IOException, RecognitionException, ParsingException {
		String ourAddress = null;
		try {
			ourAddress = NetworkAddress.getAddress().getHostAddress();
		} catch (Exception e) {
            System.out.println("CASCADE: unable to fetch information about network interfaces");
		}
		System.out.println("Our radio address = " + ourAddress);

		MonitorSPOT monitor = new MonitorSPOT();
		monitor.start();

		System.out.println("start...");

		// create scheduler
		sched = Scheduler.getSchedulerInstance();
		System.out.println("new scheduler " + sched.toString());

		// create communicator
		comm = ServerCommunicator.getCommunicatorInstance();
		System.out.println("neww communicator " + comm.toString());

		// create administartor
		admin = ServerAdministrator.getAdministratorInstance();
		System.out.println("new administrator " + admin.toString());
        
        // Register the Administrator so that other components can find it if needed		
		Registry.getInstance().put("Administrator", admin);
		Registry.getInstance().put("Communicator", comm);

		// run basestation units
		// run administrator unit
		admin.start();
		System.out.println("start administrator...");
		// run communicator
		comm.start();
		System.out.println("start communicator...");
		// run scheduler
		// sched.start();  // this is now done in Administrator.run() after receiving a "commit" message
		System.out.println("postpone scheduler start ...");

		// CharStream input = new ANTLRFileStream("C:\\query\\test7.txt");
		CharStream input = new ANTLRFileStream(inputStream);
		// ANTLRInputStream input = new ANTLRInputStream(System.in);
		TLexer lex = new TLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lex);
		// System.out.println("tokens="+tokens);
		TParser parser = new TParser(tokens);
		parser.program();

		// System.exit(0);
	}

	/**
	 * Start up the host application.
	 * 
	 * @param args
	 *            any command line arguments
	 */
	public static void main(String[] args) throws IOException,
			RecognitionException, ParsingException {
		CurracurrongServer app = null;
		if (args.length > 1 && args[1] != null) {
			System.out.println("Loading query file: [" + args[1] + "]");
			app = new CurracurrongServer(args[1]);
		} else {
			app = new CurracurrongServer();			
		}
		app.run();
	}
}