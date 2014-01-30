package au.edu.sydney.Curracurrong.queryLanguage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */
public class StreamNodeSink extends StreamNode {
    @Override
    boolean isSenseOp() {
       return false;
    }

    @Override
    void setOutBandwidth(double inputBandwidth) {
        outBandwidth = 0; 
    }

    @Override
    void setOutType(String inputType){
        outType = "";
    }

    @Override
    void init() {
       super.init();
       if (!propertyList.containsKey("node")) {
          System.out.println("CASCADE: Sensor node is missing in sense operation " + getId());
       }
    }
}
