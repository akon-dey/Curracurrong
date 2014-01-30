/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;

import au.edu.sydney.Curracurrong.datatype.DRecord;
import au.edu.sydney.Curracurrong.datatype.DString;
import au.edu.sydney.Curracurrong.datatype.Data;
import au.edu.sydney.Curracurrong.datatype.ParsingException;

import java.io.*;
import java.util.Hashtable;


/**
 * 
 * @author Vasvi Kakkad, Akon Dey University of Sydney
 */
public class StreamOpSink extends StreamOperator {
	private PrintStream out;

	// count receive packets
	private int counter;

	private static final String DEFAULT_SINK_OPERATOR = "runtime.DefaultSink";
	private Sink sink;

	/**
	 * This method initializes Sink operator parameters
	 * 
	 * @param opID Operator Id
	 */
	public void initialize(int opID, Hashtable propertyMap) {
		super.initialize(opID, propertyMap);
		// initialize CSV file
		super.initialize(opID, propertyMap);

		try {
			if (propertyMap.containsKey("sink")) {
				DRecord property = (DRecord) propertyMap.get("sink");
				DString sensorName;
				try {
					sensorName = (DString) property.getElement(1);
					sink = (Sink) Class.forName(
							"runtime." + sensorName.tostring()).newInstance();
				} catch (ParsingException e) {
					e.printStackTrace();
					sink = (Sink) Class.forName(DEFAULT_SINK_OPERATOR)
							.newInstance();
				}
			} else {
				sink = (Sink) Class.forName(DEFAULT_SINK_OPERATOR)
						.newInstance();
			}
			sink.initialize(opID, propertyMap);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		counter = 0;
	}

	/**
	 * This method executes the Sink operator
	 */
	public synchronized void execute() {
		String a;
		int size = getInputChannel(0).size();

		for (int j = 0; j < size; j++) {
			Data d = ((Data) peek(0, j));
			if (d != null) {
				a = d.tostring();
				System.out.println("Data to be written in file:" + a);
				sink.write(d);
				// out.println(a);
				receive(0);
				counter++;
			}
		}
	}
}
