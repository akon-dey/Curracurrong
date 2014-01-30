/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.datatype;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
/**
 * This class presents DFloat which is floating point data type
 *
 * @author Saeed Attar, Vasvi Kakkad
 * The University of Sydney
 */
public class DFloat extends Data {

    private float value;

    /**
     * constructor with default value
     */
    public DFloat() {
        value = 0;
    }

    public DFloat(Object o) {
        try {
            value = Float.parseFloat(o.toString());
        }
        catch(Exception e) {
            System.out.println("CASCADE: failed in DFloat, caught" + e);
        }

    }

    /**
     * constructor with value
     * @param f value of DFloat
     */
    public DFloat(float f) {
        value = f;
    }

    /**
     * return the data type of that data object
     * @return data type of the object DFloat
     */
    public String getType() {
        return "DFloat";
    }

    /**
     * indicate whether primitive or composite data type
     * @return true DFloat is primitive
     */
    public boolean isPrimitive() {
        return true;
    }

    /**
     * string presentation of Dfloat object
     * @return string of DFloat object
     */
    public String tostring() {
        return Float.toString(value);
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
        this.value = ois.readFloat();
    }

    /**
     * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
     */
    public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeFloat(value);
    }

}
