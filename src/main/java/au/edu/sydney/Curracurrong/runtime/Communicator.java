package au.edu.sydney.Curracurrong.runtime;

public abstract class Communicator extends Thread
{
	
	/**
     * This method sends the data to the next operator on the channel.
     * <ul>
     * <li>If the operator is deployed on the same node then simply put the data on to the
     * input channel of the next operator.
     * <li>If the operator is not on the same node then based on the routing table
     * propagate data to the right node as radiogram
     * </ul>
     * @param channelId channel id on which data is to be sent
     * @param data data
     */
    public abstract void send(int channelId, Object data);

}
