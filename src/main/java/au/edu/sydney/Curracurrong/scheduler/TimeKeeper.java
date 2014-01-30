/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.scheduler;

/**
 * This class is used to keep the synchronized time of the SunSPOT, so that a
 * singular global time can be implemented across all the spots.
 *
 * @author Saeed Attar
 */
class TimeKeeper {
    private static final TimeKeeper instance = new TimeKeeper();

    private long delta; //the appropriate time delta to keep the spot synchronized to global time

    private TimeKeeper() {
            delta = 0;
    }

    static TimeKeeper getInstance() {
            return instance;
    }

    /**
     * Gets the synchronized time of the spot in milliseconds
     *
     * @return the global system time in milliseconds
     */
    synchronized long getTimeMillis() {
            return System.currentTimeMillis() + delta;
    }
}