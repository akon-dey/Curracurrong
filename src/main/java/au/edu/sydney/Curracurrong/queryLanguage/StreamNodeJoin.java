package au.edu.sydney.Curracurrong.queryLanguage;

/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */
public class StreamNodeJoin extends StreamNode {
    @Override
    boolean isSenseOp() {
       return false;
    }
    
    void setOutBandwidth(double[] inputBandwidth) {
        double output = 0;
        for(int i = 0; i < inputBandwidth.length; i++) {
            output = output + inputBandwidth[i];
        }
        outBandwidth = output; 
    }

    @Override
    void setOutType(String inputType){
        outType = inputType;
    }

    @Override
    void init() {
       super.init();
       if (!propertyList.containsKey("node")) {
          System.out.println("CASCADE: Sensor node is missing in sense operation " + getId());
       }
       
    }
       
}

