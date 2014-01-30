package au.edu.sydney.Curracurrong.queryLanguage;
/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */
public class StreamNodeSplit extends StreamNode {
    StreamNodeSplit() {
      super();
      setSensorNode("0.0.0.0");
    }

    @Override
    boolean isSenseOp() {
        return false;
    }

    /**
     * This method decides the type of Splitter: Duplicate or Round-robin
     * @return True if Splitter type is Duplicate, false otherwise
     */
    boolean isDuplicate() {
        if (propertyList.containsKey("type")) {
            return ((String)propertyList.get("type")).equals("duplicate");
        } else {
            return false;
        }
    }
    
    @Override
    void setOutBandwidth(double inputBandwidth) {
        outBandwidth = inputBandwidth; 
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
       if (!propertyList.containsKey("type")) {
          System.out.println("CASCADE: type parameter is missing in split operation " + getId());
       }
    }
    
}

