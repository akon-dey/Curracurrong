/**
 * @author Akon Dey (akon.dey@sydney.edu.au)
 */
package au.edu.sydney.Curracurrong.runtime;

import java.util.Hashtable;

import au.edu.sydney.Curracurrong.datatype.DInteger32;
import au.edu.sydney.Curracurrong.datatype.DRecord;
import au.edu.sydney.Curracurrong.datatype.DString;
import au.edu.sydney.Curracurrong.datatype.Data;
import au.edu.sydney.Curracurrong.datatype.ParsingException;

/**
 * @author Akon Dey
 * University of Sydney
 */
public abstract class Sensor {
	int opID = -1;
	Hashtable propertyMap = null;
	
	void initialize(int opID, Hashtable propertyMap) {
		this.opID = opID;
		this.propertyMap = propertyMap;
	}
	
	public abstract DRecord read();
	
    Data getPropertyValue(String propertyKey) {
        Data value = null;
        // filter operator specific section
        if (propertyMap.containsKey(propertyKey)) {
            DRecord elem = (DRecord) propertyMap.get(propertyKey);
            try {
                DString readValue = (DString) elem.getElement(1);
                value = new DInteger32 (Integer.parseInt(readValue.tostring()));
            } catch (ParsingException ex) {
                System.out.println(ex);
            }
        }
        return value;
    }
}
