/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.sydney.Curracurrong.queryLanguage;

import au.edu.sydney.Curracurrong.datatype.DRecord;
import au.edu.sydney.Curracurrong.datatype.DString;
import au.edu.sydney.Curracurrong.datatype.Data;
import au.edu.sydney.Curracurrong.datatype.ParsingException;
import java.lang.reflect.Field;
import java.util.StringTokenizer;

/**
 *
 * @author Saeed Attar, Vasvi Kakkad
 * University of Sydney
 */
public class StreamNodeFilter extends StreamNode {
    private DString filterName;
    @Override
    boolean isSenseOp() {
       return false;
    }

    @Override
    void setOutBandwidth(double inputBandwidth) {
        if(propertyList.containsKey("window")) {
            outBandwidth = inputBandwidth/Integer.parseInt(propertyList.get("window").toString());
            //outBandwidth = inputBandwidth;
        } else if(propertyList.containsKey("field")) {
            int field = 1;
            
            try {
                String value = propertyList.get("field").toString();
                String tmpValue = value;
                StringTokenizer fieldValue = new StringTokenizer(tmpValue, ",");                
                while(fieldValue.hasMoreTokens()){
                    field++;
                    Integer.parseInt(fieldValue.nextToken());
                }
            } catch (Exception ex) {
            	ex.printStackTrace();
                System.out.println("CASCADE: parsing failed during StreamNodeSelect initialize");
            }
            //String tmpType = inType;
            //String[] typeArray = tmpType.split(",");
            //if(typeArray.length > 4) {
                //int noField = typeArray.length - 6;
                int noField = 16 - 6;
                outBandwidth = inputBandwidth - (noField * 8) + (field * 8);
            //}
            //outBandwidth = (4+field)*8;
        } else {
            outBandwidth = inputBandwidth;
        }
    }

    @Override
    void setOutType(String inputType){
        outType = inputType;
    }

    DString getFilterName() {
        return filterName;
    }

    public void setFilterName(String name) {
        filterName = new DString("StreamNode" + name);
    }

    @Override
    void init() {
       super.init();
       if (!propertyList.containsKey("node")) {
          System.out.println("CASCADE: Sensor node is missing in sense operation " + getId());
       }
    }
}
