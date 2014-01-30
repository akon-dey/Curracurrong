/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.datatype;

/**
 *
 * @author Saeed Attar
 * University of Sydney
 */
public abstract class Composite extends Data {

    /**
     * get the element at index equal idx
     * @param idx index of object
     * @return Data object 
     * @throws ParsingException if given index is out of band
     */
    abstract public Data getElement(int idx) throws ParsingException;

    /**
     * set the passes element in specific index
     * @param idx index
     * @param element Data Object
     * @throws ParsingException if given index is out of band
     */
    abstract public void setElement(int idx, Data element) throws ParsingException;   
}
