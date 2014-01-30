/**
 * @author Akon Dey (akon.dey@gmail.com)
 *
 */
package au.edu.sydney.Curracurrong.runtime;

/**
 * @author Akon Dey (akon.dey@gmail.com)
 */
public abstract class Administrator extends Thread {
    /**
     * This method gets operatorID as a parameter and returns the record of operatorIDs that will
     * send message to this operator
     * @param operatorID of receiver operator
     * @return the record of sender operator IDs
     */
    public abstract String[][] getInputQueues(int operatorID);

    /**
     * This method gets and operatorID as a parameter and returns the record of operatorIDs that will
     * receive message from this operator
     * @param operatorID ID of sender operator
     * @return the record of receiver operator IDs
     */
    public abstract String[][] getOutputputQueues(int operatorID);
}
