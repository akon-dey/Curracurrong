/**
 * @author Akon Dey (akon.dey@gmail.com)
 *
 */
package au.edu.sydney.Curracurrong.runtime;

import java.util.HashMap;


/**
 * @author akon
 *
 */
public class Registry extends HashMap {	
	private static Registry _instance = new Registry();

	public Registry() {
		super();
	}
	
	public static Registry getInstance() {
		if (_instance == null) {
			_instance = new Registry();
		}
		return _instance;
	}
}
