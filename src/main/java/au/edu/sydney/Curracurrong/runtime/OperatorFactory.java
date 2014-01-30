/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.runtime;


/**
 * This class is responsible for creating stream operators and scheduling semantic objects
 * it is separated from administrative class because of separation of concerns to separate the responsibility
 * of complex creation and hide creation logic from administrative class (factory pattern)
 *
 * @author Saeed Attar, Vasvi Kakkad
 * The University of Sydney
 */
public class OperatorFactory {

    public static StreamOperator streamOperator;


    /**
     * This method returns the stream operator from the operator factory
     * @param operatorType type of the operator
     * @return Stream operator reference
     */
    public static StreamOperator getStreamOperator(String operatorType)
    {
        String type = operatorType.substring("StreamNode".length());
        operatorType = "StreamOp" + type;
        try {
            String className = "runtime." + operatorType;
            streamOperator = (StreamOperator) Class.forName(className).newInstance();
        }
        catch (InstantiationException e) {
            System.out.println("CASCADE: failed in Operatorfactory caught" + e);
        }
        catch (IllegalAccessException f) {
            System.out.println("CASCADE: failed in Operatorfactory caught" + f);
        }
        catch (ClassNotFoundException c) {
            System.out.println("CASCADE: failed in Operatorfactory caught" + c);
        }
        catch (Exception ei) {
            System.out.println("CASCADE: failed in Operatorfactory caught" + ei);
        }
        return streamOperator;
    }
}
