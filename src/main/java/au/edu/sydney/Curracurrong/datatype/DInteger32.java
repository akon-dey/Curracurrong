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
public class DInteger32 extends DInteger {

    private int value;

    /**
     * constructor 
     */
    public DInteger32() {
        value = (int) 0;
    }

    /**
     * constructor with passing value
     * @param sh value of DInteger16
     */
    public DInteger32(int n) {
        value = n;
    }

    /**
     * return the data type of DInteger16
     * @return data type DInteger16
     */
    public String getType() {
        return "DInteger32";
    }

    /**
     * set value of DInteger16
     * @param n new value
     */
    public void setValue(int n) {
        value = n;
    }

    /**
     *
     */
     public int getValue() {
         return value;
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
        this.value = ois.readInt();
    }

    /**
     * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
     */
    public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeInt(value);
    }
}
