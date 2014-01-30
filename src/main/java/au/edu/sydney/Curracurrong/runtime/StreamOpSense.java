/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;

import java.util.Hashtable;

import au.edu.sydney.Curracurrong.datatype.DFloat;
import au.edu.sydney.Curracurrong.datatype.DInteger64;
import au.edu.sydney.Curracurrong.datatype.DRecord;
import au.edu.sydney.Curracurrong.datatype.DString;
import au.edu.sydney.Curracurrong.datatype.Data;
import au.edu.sydney.Curracurrong.datatype.ParsingException;

/**
 * 
 * @author Saeed Attar, Vasvi Kakkad, Akon Dey University of Sydney
 */
public class StreamOpSense extends TimeTriggered {

	private static final String DEFAULT_SENSE_OPERATOR = "runtime.DefaultSensor";
	private Sensor sensor = null;
	private boolean timeTriggered = false;

	public void initialize(int opID, Hashtable propertyMap) {
		super.initialize(opID, propertyMap);

		try {
			if (propertyMap.containsKey("sensor")) {
				DRecord property = (DRecord) propertyMap.get("sensor");
				DString sensorName;
				try {
					sensorName = (DString) property.getElement(1);
					sensor = (Sensor) Class.forName(
							"runtime." + sensorName.tostring()).newInstance();
				} catch (ParsingException e) {
					e.printStackTrace();
					sensor = (Sensor) Class.forName(DEFAULT_SENSE_OPERATOR)
							.newInstance();
				}
			} else {
				sensor = (Sensor) Class.forName(DEFAULT_SENSE_OPERATOR)
						.newInstance();
			}
			sensor.initialize(opID, propertyMap);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method executes the operator
	 */
	public synchronized void execute() {
		DRecord record = null;
		while ((record = sensor.read()) != null) {
			send(0, record);
		}
	}

	/**
	 * Wait for the Communicator to wake it up when there is input.
	 */
	public void block() {
		// this is non-blocking in the time triggered case and
		// must block in the execute() in the event triggered case
		// therefore, do nothing here ...
	}
}