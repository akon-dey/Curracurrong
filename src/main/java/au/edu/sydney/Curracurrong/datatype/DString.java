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
 * University of Sydney
 */
public class DString extends Data {

    private String value;

    public DString() {
        value = "";
    }

    public DString(String s) {
        value = s;
    }

    // return the data type of that data object
    public String getType() {
        return "";
    }

    /**
     *
     * @param s
     */
    public void setValue(String s) {
        value = s;
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
    public String tostring()
    {
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
        this.value = ois.readUTF();
    }

    /**
     * @see nodes.spotSensor.java.io.KSNSerializableInterface#writeObjectOnSensor(ObjectOutputStream)
     */
    public void writeObjectOnSensor(ObjectOutputStream oos) throws IOException {
        oos.writeUTF(value);
    }

}
