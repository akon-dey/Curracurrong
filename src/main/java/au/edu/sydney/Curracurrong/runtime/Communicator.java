/**
 * Copyright 2014 University of Sydney, Australia.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package au.edu.sydney.Curracurrong.runtime;

/**
 * @author Akon Dey (akon.dey@sydney.edu.au), University of Sydney
 * @author Vasvi Kakkad (vasvi.kakkad@sydney.edu.au), University of Sydney
 * @author Bernhard Scholz (bernhard.scholz@sydney.edu.au), University of Sydney
 */
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
