/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.scheduler;

import au.edu.sydney.Curracurrong.runtime.TimeTriggered;

/**
 *
 * @author Saeed Attar
 * University of Sydney
 */
public class RunQueue {
    private PriorityBlockingQueue runQueue;

    public RunQueue() {      
         runQueue = new PriorityBlockingQueue(20);
    }

    /**
     * This method adds new task to the run queue for execution
     * @param task The task to be added
     */
    public synchronized void add(TimeTriggered task) {
        runQueue.add(task);
        notifyAll();
    }

    /**
     * This method removes the task from the run queue
     * @param task The task to be removed
     */
    public synchronized void remove(TimeTriggered task) {
        runQueue.remove( task);
        notifyAll();
    } 

    /**
     * This method returns the first task from the run queue to be executed
     * @return operator
     */
    public synchronized TimeTriggered getRootBlock() {
        while (runQueue.isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
	}
        TimeTriggered se = (TimeTriggered) runQueue.peek();
        return se;
    }

    /**
     * This method returns the status of run queue if it is empty
     * @return true if the queue is empty; false otherwise
     */
    public boolean isEmpty() {
        boolean result;
        if (runQueue.isEmpty())
            result = true;
        else
            result = false;
        return result;
    }

    public boolean contains(TimeTriggered so) {
        return (runQueue.contains(so));
    }
}
