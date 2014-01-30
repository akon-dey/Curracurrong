/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.datatype;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * @author Saeed Attar, Vasvi Kakkad
 * The University of Sydney
 */
public class DInteger8 extends DInteger {

    private byte value;

    /**
     * constructor 
     */
    public DInteger8() {
        value = (byte) 0;
    }

    /**
     * constructor with passing value
     * @param sh value of DInteger8
     */
    public DInteger8(byte b) {
        value = (byte) b;
    }

    /**
     * return the data type of DInteger8
     * @return data type DInteger8
     */
    public String getType() {
        return "DInteger8";
    }

    /**
     * set value of DInteger8
     * @param n new value
     */
    public void setValue(byte b) {
        value = b;
    }

    /**
     *
     * @return
     */
    public boolean isPrimitive() {
        return true;
    }

    /**
     *
     * @return
     */
    public String tostring() {
        return String.valueOf(value);
    }


    /**
     *
     * @return
     */
    public byte getValue() {
        return value;
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
        this.value = ois.readByte();
    }

    /**
     * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
     */
    public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeByte(value);
    }
}
