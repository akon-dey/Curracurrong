/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;


/**
 *
 * @author Vasvi Kakkad, Bernhard Scholz
 * University of Sydney
 */
public class StreamOpJoin extends StreamOperator {

     /**
     * This method executes the Join operator
     */
    public synchronized void execute() {
        for(int i = 0; i < getNumInputChannels(); i++) {
            if (isDataAvailable(i,0)) {
                System.out.println("Joining data from input " + i);
                send(0, receive(i));
            }
        }
    }
}