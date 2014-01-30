/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;


/**
 *
 * @author Saeed Attar, Vasvi Kakkad, Bernhard Scholz
 * University of Sydney
 */

abstract public class StreamOpFilter extends StreamOperator {

   /**
     * This method checks for the availability of the specified data in input channel
     * @param item index of the data item
     * @return true if data available, false otherwise
     */
    protected boolean isDataAvailable(int item) {
        return isDataAvailable(0,item);
    }

    /**
     * This method returns the top element of the channel and removes it.
     * @return data
     */
    protected Object receive(){
        return receive(0);
    }

   /**
     * This method returns the n-th element of the channel (but does not remove it).
     * @param item index of the data item
     * @return data
     */
    protected Object peek(int item){
        return peek(0,item);
    }

    /**
     * This method sends the data to next operator with specified output channel
     * @param item data
     */
    protected void send(Object item){
        send(0,item);
    }
}