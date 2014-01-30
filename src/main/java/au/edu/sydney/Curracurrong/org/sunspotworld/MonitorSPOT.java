/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.org.sunspotworld;

//import com.sun.spot.io.j2me.radiogram.RadiogramConnection;
//import com.sun.spot.peripheral.NoRouteException;
//import com.sun.spot.peripheral.radio.RadioFactory;
//import com.sun.spot.util.IEEEAddress;
import java.io.IOException;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.microedition.io.Connector;
//import javax.microedition.io.Datagram;

import au.edu.sydney.Curracurrong.util.NetworkAddress;

/**
 *
 * @author tarabab
 */
public class MonitorSPOT extends Thread {
    public void run() {
		String ourAddress = null;
		try {
			ourAddress = NetworkAddress.getAddress().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CASCADE: unable to fetch information about network interfaces");
		}
        System.out.println("Our IP address = " + ourAddress);               
    }
}
