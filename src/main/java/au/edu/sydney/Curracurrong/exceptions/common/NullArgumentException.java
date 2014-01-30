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

/**
 * Thrown when an argument passed to a method or constructor was a null pointer even though this method must not
 * be called with a null pointer.
 * @author Markus Bestehorn
 * @version 1.0
 */
public class NullArgumentException extends IllegalArgumentException
{
	/** Name of the argument whose value was a NULL pointer */
	private String argumentName;
	
	/** Expected class type of the argument that was a NULL pointer */
	private Class expectedType;
	
	public NullArgumentException(String argName, Class expectedType)
	{
		this(argName, expectedType, "Expected an argument of " + expectedType.getName() + " for the argument \"" + argName + "\" but got a NULL pointer instead!");
	}
		
	public NullArgumentException(String argName, Class expectedType, String msg)
	{
		super(msg);
		
		if ((argName == null) || (argName.equalsIgnoreCase("")))
			throw new NullPointerException("The constructor of " + this.getClass().getName() + " must not be called using a NULL value for the \"argName\" parameter!");
		else this.argumentName = argName;
		
		if ((expectedType == null) || (argName.equalsIgnoreCase("")))
			throw new NullPointerException("The constructor of " + this.getClass().getName() + " must not be called using a NULL value for the \"expectedType\" parameter!");
		else this.expectedType = expectedType;
	}
	
	public String getArgumentName()
	{
		return this.argumentName;
	}
	
	public Class getExpectedType()
	{
		return this.expectedType;
	}
	
	public String toString()
	{
		return this.getClass().getName() + " [ Argument Name=\"" + this.argumentName + "\"; Expected Type=" + this.expectedType.getName() + "\" ]";
	}
}
