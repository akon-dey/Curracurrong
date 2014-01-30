/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;


/**
 *
 * @author Vasvi Kakkad
 */
public abstract class TimeTriggered extends StreamOperator {

    /**
     * Start time for operator execution
     */
    private static long startTime;

    /**
     * Repetition factor for operator execution
     */
    private static int repetition;

    /**
     * Time interval between each repeated execution
     */
    private static long timeInterval;

    private static long commDelay;

    protected TimeTriggered() {        
    }

    /**
     * This method initializes the Time-triggered operator
     * @param start start time
     * @param repeat repetition factor
     * @param interval time interval
     */
    public static void initialize(long start, int repeat, long interval) {
        startTime = start;
        repetition = repeat;
        timeInterval = interval;
    }

    /**
     * This method returns the time interval
     * @return time interval
     */
    public long getTimeInterval() {
        return timeInterval;
    }

    /**
     * This method returns the repetition factor
     * @return repetition factor
     */
    public int getRepetition() {
        return repetition;
    }

    /**
     * This method returns the start time
     * @return start time
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * This method is used to set the next start time for the operator
     * @param time start time
     */
    public void setStartTime(long time){
        startTime = time;
    }

    /**
     * This method is used to set the repetition factor
     * @param repeat repetition
     */
    public void setRepeat(int repeat){
        repetition = repeat;
    }

    /**
     * This method is used to set the time interval
     * @param interval time interval
     */
    public void setInterval(long interval) {
        timeInterval = interval;
    }

    
    public static void setCommDelay(long delay) {
        System.out.println("SEtting commdelay...");
        commDelay = delay;
    }

    public static long getCommDelay() {
        return commDelay;
    }
}
