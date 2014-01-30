/*
 * Copyright 2009, Karlsruhe Sensor Networking Project (Markus Bestehorn)
 * http://www.ipd.uni-karlsruhe.de/KSN
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions 
 * and limitations under the License.
 */

package au.edu.sydney.Curracurrong.exceptions.common;


public class UnsupportedOperationException extends RuntimeException 
{
	/**
     * Constructs a UnsupportedOperationException with no
     * detail message.
     */
    public UnsupportedOperationException() {
    }

    /**
     * Constructs a <tt>UnsupportedOperationException</tt> with the
     * specified detail message.
     *
     * @param message the detail message pertaining to this exception.
     */
    public UnsupportedOperationException(String message) {
    	super(message);
    }
}
