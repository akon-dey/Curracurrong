package au.edu.sydney.Curracurrong.queryLanguage;

/**
 *
 * @author Vasvi Kakkad, Saeed Attar
 * University of Sydney
 */
public class StreamEdge {
    /**
     * Source node of the edge
     */
   protected StreamNode source;
   /**
    * Tail node of the edge
    */
   protected StreamNode tail;
   /**
    * Unique edge id
    */
   protected int id;
   /**
    * Bandwidth of the edge
    */
   protected double bandwidth;
   /**
    * Type of the data propagated on the edge
    */
   protected String type;

   StreamEdge(StreamNode src, StreamNode dest) {
      source = src;
      tail = dest;
   }

   /**
    * This method returns the source node of the edge
    * @return source node
    */
   StreamNode getSource() {
     return source;
   }

   /**
    * This method returns the tail node of the edge
    * @return tail node
    */
   StreamNode getTail() {
     return tail;
   }

   /**
    * This method sets the unique id to the edge
    * @param id Unique edge id
    */
   void setId(int id) {
     this.id =  id;
   }

   /**
    * This method returns the unique edge id
    * @return Edge id
    */
   int getId() {
     return id;
   }

   /**
    * This method sets the bandwidth for the edge
    * @param bwd Bandwidth/capacity
    */
   void setBandwidth(double bwd) {
       bandwidth = bwd;
   }

   /**
    * This method returns the bandwidth of the edge
    * @return Bandwidth/capacity
    */
   double getBandwidth() {
       return bandwidth;
   }

   /**
    * This method sets the data type for the edge
    * @param datatype Type of propagating data
    */
   void setType(String datatype) {
       type = datatype;
   }

   /**
    * This method returns the data type for the edge
    * @return Type of propagating data
    */
   String getType() {
       return type;
   }
}
