/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.datatype;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */
public class DUnsigned16 extends Data {

    /**
     *
     */
    private byte value;

    public DUnsigned16() {
    }


    /**
     *
     * @return
     */
    public String getType() {
        return "";
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
