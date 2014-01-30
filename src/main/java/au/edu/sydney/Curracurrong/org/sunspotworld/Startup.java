/*
 * Startup.java
 *
 * Created on 22/07/2010 5:58:21 PM;
 */

package au.edu.sydney.Curracurrong.org.sunspotworld;

//import com.sun.spot.peripheral.Spot;
//import com.sun.spot.peripheral.radio.RadioFactory;
//import com.sun.spot.peripheral.radio.IRadioPolicyManager;
//import com.sun.spot.io.j2me.radiostream.*;
//import com.sun.spot.io.j2me.radiogram.*;
//import com.sun.spot.util.*;

import java.util.logging.Logger;
import java.util.logging.LogManager;


import au.edu.sydney.Curracurrong.util.IDGenerator;


import java.io.*;
//import javax.microedition.io.*;
//import javax.microedition.midlet.MIDlet;
//import javax.microedition.midlet.MIDletStateChangeException;

///**
// * The startApp method of this class is called by the VM to start the
// * application.
// * 
// * The manifest specifies this class as MIDlet-1, which means it will
// * be selected for execution.
// */
//public class Startup extends MIDlet {
//
//    //private ITriColorLED [] leds = EDemoBoard.getInstance().getLEDs();
//
//    protected void startApp() throws MIDletStateChangeException {
//       
//    }
//
//    protected void pauseApp() {
//        // This is not currently called by the Squawk VM
//    }
//
//    /**
//     * Called if the MIDlet is terminated by the system.
//     * I.e. if startApp throws any exception other than MIDletStateChangeException,
//     * if the isolate running the MIDlet is killed with Isolate.exit(), or
//     * if VM.stopVM() is called.
//     * 
//     * It is not called if MIDlet.notifyDestroyed() was called.
//     *
//     * @param unconditional If true when this method is called, the MIDlet must
//     *    cleanup and release all resources. If false the MIDlet may throw
//     *    MIDletStateChangeException  to indicate it does not want to be destroyed
//     *    at this time.
//     */
//    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {
//        for (int i = 0; i < 8; i++) {
////            leds[i].setOff();
//        }
//    }
//}
