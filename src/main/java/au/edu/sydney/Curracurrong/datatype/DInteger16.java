/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.datatype;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * The University of Sydney
 */
public class DInteger16 extends DInteger {

    private short value;

    /**
     * constructor 
     */
    public DInteger16() {
        value = (short) 0;
    }

    /**
     * constructor with passing value
     * @param sh value of DInteger16
     */
    public DInteger16(short sh) {
        value = sh;
    }

    /**
     * return the data type of DInteger16
     * @return data type DInteger16
     */
    public String getType() {
        return "DInteger16";
    }

    /**
     * set value of DInteger16
     * @param n new value
     */
    public void setValue(short n) {
        value = n;
    }

    /**
     * indicate whether primitive or composite data type
     * @return true DInteger16 is primitive
     */
    public boolean isPrimitive() {
        return true;
    }

    /**
     * get string presentation of DInteger16
     * @return string format of DInteger16
     */
    public String tostring() {
        return Integer.toString(value);
    }

    /**
     *
     * @param ois
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public void readObjectOnSensor(ObjectInputStream ois) throws IOException, ClassNotFoundException, IllegalAccessException,InstantiationException {
        this.value = ois.readShort();
    }

    /**
     * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
     */
    public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeShort(value);
    }
}
