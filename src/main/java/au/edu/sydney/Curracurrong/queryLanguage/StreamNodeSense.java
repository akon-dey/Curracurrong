package au.edu.sydney.Curracurrong.queryLanguage;

/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */

import au.edu.sydney.Curracurrong.datatype.DInteger64;
import java.util.*;

public class StreamNodeSense extends StreamNode implements Constants {

    @Override
    boolean isSenseOp() {
       return true;
    }

    @Override
    void setOutBandwidth(double inputBandwidth) {
        double rate = DEFAULT_SAMPLE_RATE;
        if (propertyList.containsKey("rate")) {
            rate = (Double)propertyList.get("rate");
        }
        //outBandwidth = rate * 5 * 4 ;
        outBandwidth = rate * 15 * 8 * 8;
    }

    @Override
    void setOutType(String inputType){
        
    }

   @Override
   void setPropertyList(Map<String,Object> plist){
       propertyList = plist;
       init();
   }


    @Override
    void init() {
       super.init(); 
       if (!propertyList.containsKey("node")) {
          System.out.println("CASCADE: Sensor node is missing in sense operation " + getId());
       }
       outType = "R[DInteger64,DInteger64,DFloat,DInteger64,DInteger64,DInteger64,DInteger64]";//,DInteger64,DInteger64,DInteger64,DInteger64,DInteger64,DInteger64,DInteger64,DInteger64,DInteger64]";
    }   
}
