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
 * Thrown when code is reached that is not implemented yet.
 * @author   Markus Bestehorn
 * @version   1.0
 */
public abstract class AbstractNotImplementedException extends RuntimeException 
{
	private static final long serialVersionUID = 1765239978781006196L;

	protected Class calledBy;
	
	public AbstractNotImplementedException(Class calledby, String msg) 
	{
		super(msg);
		
		this.calledBy = calledby;
	}
		
	public Class getCallingClass()
	{
		return this.calledBy;
	}
}
