/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;

import au.edu.sydney.Curracurrong.datatype.DFloat;
import au.edu.sydney.Curracurrong.datatype.DRecord;
import au.edu.sydney.Curracurrong.datatype.DString;
import au.edu.sydney.Curracurrong.datatype.Data;
import au.edu.sydney.Curracurrong.datatype.ParsingException;
import java.util.Hashtable;

/**
 *
 * @author Vasvi Kakkad
 */
public class StreamOpLowPass extends StreamOpFilter {

    /**
     * number of data elements for average
     */
    private int orderNum;
    private float alpha; 
    private float[] y;
    private int windowSz;

    /**
     * Initializes the stream operator
     * @param opID operator id
     * @param propertyMap property list
     */
    public void initialize(int opID, Hashtable propertyMap) {

       // initialize
       super.initialize(opID,propertyMap);


       // filter operator specific section
       Data order = getPropertyValue("order");
        if(order != null) {
             orderNum = Integer.parseInt(order.tostring());
        } else {
           orderNum = 3;
        }

       // cut off frequency for low-pass filter
       float cutOffFreq;
       Data freqValue = getPropertyValue("freq");
        if(freqValue != null) {
             cutOffFreq = Float.parseFloat(freqValue.tostring());
        } else {
           cutOffFreq = 10;
        }

       // create filter
       y = new float[orderNum];

       float dT;
       float pi = 3.14f;
   
       Data dataValue = getPropertyValue("dt");
        if(dataValue != null) {
             dT = Float.parseFloat(dataValue.tostring());
        } else {
           dT = 1;
        }

       alpha = dT / (2 * pi * cutOffFreq + dT);
    }

    /**
     * executes the stream operator
     */
    public synchronized void execute() {
        if (isDataAvailable(windowSz)) {

            // compute new value
            float sum = 0;
            for (int idx = 0; idx < windowSz; idx++) {
                float val = Float.parseFloat(((DFloat) peek(idx)).tostring());
                sum = sum + alpha * val + (1-alpha) * y[idx];
            }
            DFloat out = new DFloat(sum);

            // update output rate 
            for (int idx = windowSz-1; idx>0; idx--) {
                y[windowSz-1] = y[windowSz];
            }
            y[windowSz-1] = sum;
            
            receive();
            send(out);
        }
    }
}