/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;

import au.edu.sydney.Curracurrong.datatype.Data;
import java.util.Hashtable;


//import runtime.server.Administrator;

/**
 *
 * @author Vasvi Kakkad, Bernhard Scholz
 * University of Sydney
 */
public class StreamOpSplit extends StreamOperator {

    int currentChannel = 0;
    boolean copySemantics = false;
    
    /**
     * This method initializes Spit operator parameters
     * @param opID Operator Id
     */
    public void initialize(int opID, Hashtable propertyMap) {
      // Check for copy semantics
        super.initialize(opID,propertyMap);
      
        Data value = getPropertyValue("type");
        if(value != null) {
             if(value.tostring().compareTo("duplicate") == 0) {
                 copySemantics = true;
             }
        }
    }

    /**
     * This method executes the Split operator
     */
    public synchronized void execute() {
        // split the data to the number of output queues
        if(isDataAvailable(0, 0)) {
            Object element = receive(0);
            if (copySemantics) {
                for (int channel = 0; channel < getNumOutputChannels(); channel++) {
                    send(channel,element);
                }
            } else {
                send(currentChannel,element);
                currentChannel = ((currentChannel + 1) % getNumOutputChannels());
            }
        }
    }   
}