package p4_package;

public class PointClass
   {
    /**
     * position x of the point class
     */
    private int pos_X;
    
    /**
     * position y of the point class
     */
    private int pos_Y;
    
    /**
     * Default constructor
     * <p>
     * Simple point class to be used for rectangle location
     * 
     */
    PointClass()
        {
         pos_X = 0;
         pos_Y = 0;
        }
    
    /**
     * Initialization constructor
     * <p>
     * Simple point class to be used for rectangle location
     * 
     * @param initPosX Initial x position value
     * 
     * @param initPosY Initial y position value
     */
    PointClass( int initPosX, int initPosY )
       {
        pos_X = initPosX;
        pos_Y = initPosY;
       }
    
    /**
     * Copy constructor
     * <p>
     * Simple point class to be used for rectangle location
     * 
     * @param copied PointClass object to be copied 
     */
    PointClass( PointClass copied )
       {
        pos_X = copied.pos_X;
        pos_Y = copied.pos_Y;
       }
    
    /**
     * Gets x position of point
     * 
     * @return x position of point
     */
    public int getXPos()
       {
        return pos_X;
       }
    
    /**
     * Gets y position of point
     * 
     * @return y position of point
     */
    public int getYPos()
       {
        return pos_Y;
       }
    
    /**
     * Sets x position of point
     * 
     * @param xPosSetting x position value to be set
     */
    public void setXPos( int xPosSetting )
       {
        pos_X = xPosSetting;
       }
    
    /**
     * Sets y position of point
     * 
     * @param yPosSetting y position value to be set
     */
    public void setYPos( int yPosSetting )
       {
        pos_Y = yPosSetting;
       }    
    
   }
