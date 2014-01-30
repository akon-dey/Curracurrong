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
 * @author Saeed Attar, Vasvi kakkad
 * University of Sydney
 */
public class DUnsigned32 extends Data {

    private int value;

    public DUnsigned32() {
        
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
