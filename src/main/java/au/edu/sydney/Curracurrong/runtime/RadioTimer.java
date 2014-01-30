/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;

import au.edu.sydney.Curracurrong.runtime.server.ServerAdministrator;
import au.edu.sydney.Curracurrong.runtime.server.ServerCommunicator;

/**
 *
 * @author vasvi kakkad
 */
public class RadioTimer extends Thread{
    private static RadioTimer instance;
    private long sleepTime;
    private long commTime;
    private boolean isOn;

    public static RadioTimer getInstance() {
        return instance;
    }

    public static RadioTimer getInstance(long sleep, long comm) {
        if(instance == null) {
            instance = new RadioTimer(sleep, comm);
        }
        return instance;
    }
    private RadioTimer(long sleep, long comm) {
        long delay = TimeTriggered.getCommDelay();
        sleepTime = sleep - delay;
        commTime = comm + delay;
    }

    public void run() {
        long delay = TimeTriggered.getCommDelay();
        sleepTime = sleepTime - delay;
        commTime = commTime + delay;
        System.out.println("Sleep time " + sleepTime + " comm time " + commTime + " with delay " + delay);
        while(true) {
            try{
                synchronized(this) {
                    System.out.println("comm time in TimeKeeper " + this.getName());
                    try{
                        ServerCommunicator.getCommunicatorInstance().setConnectionClosed(false);
                        ServerAdministrator.getAdministratorInstance().setConnectionClosed(false);
                        isOn = true;
                        this.sleep(commTime*1000);
                        //this.sleep(10000);
                        }
                    catch(InterruptedException e) {
                        System.err.println("error in opening connection from timer");
                    }
                }
                synchronized(this){
                    System.out.println("sleep time in TimeKeeper " + this.getName());
                    try{
                        ServerCommunicator.getCommunicatorInstance().setConnectionClosed(true);
                        ServerAdministrator.getAdministratorInstance().setConnectionClosed(true);
                        isOn = false;
                        this.sleep(sleepTime*1000);
                        //this.sleep(30000);
                    }
                    catch(InterruptedException e) {
                        System.err.println("error in closing connection from timer");
                    }
                }
            }
            catch(Exception ie) {
                System.out.println("CASCADE: Timer thread interrupted");
            }
        }
    }

    public boolean isRadioOn() {
        return isOn;
    }
}
