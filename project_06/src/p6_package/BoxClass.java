package p6_package;

/**
 * BoxClass for use as a LinkedList Node.
 * @author Alexander Burdiss
 *
 */
public class BoxClass implements Comparable<BoxClass>
   {
    /**
     * Static field that starts by holding 'A'
     */
    private static int boxId_Base = 0;
    
    /**
     * integer boxWidth and boxHeight fields
     */
    private int boxWidth, boxHeight;
    
    /**
     * character letter field to identify a given box
     */
    private int boxID;
    
    /**
     * Boolean field to indicate if a box has been used
     */
    private boolean boxUsedState;
    
    /**
     * Reference to next box
     */
    public BoxClass nextRef;
    
    /**
     * Default constructor for BoxClass
     */
    public BoxClass()
    {
     boxWidth = 0;
     boxHeight = 0;
     boxID = boxId_Base;
     boxUsedState = false;
     
     nextRef = null;
     
     boxId_Base++;
    }

    /**
     * Initialization constructor for BoxClass
     * 
     * @param initBoxWidth integer nitial box width for new box
     * 
     * @param initBoxHeight integer initial box height for new box
     */
    public BoxClass( int initBoxWidth, int initBoxHeight )
    {
     boxWidth = initBoxWidth;
     boxHeight = initBoxHeight;
     
     boxID = boxId_Base;
     boxUsedState = false;
     
     nextRef = null;
     
     boxId_Base++;
    }

    /**
     * Copy constructor for BoxClass
     * <p>
     * Note: Box ID will remain identical for all boxes
     * 
     * @param copied BoxClass object to be copied
     */
    public BoxClass( BoxClass copied )
    {
     boxWidth = copied.boxWidth;
     boxHeight = copied.boxHeight;
     
     boxID = copied.boxID;
     boxUsedState = copied.boxUsedState;
    }

    /**
     * Implements comparison operation
     * 
     * @param other BoxClass object to be compared
     * 
     * @return integer result of comparison; zero is equal,
     * any other result is not
     */
    public int compareTo( BoxClass other )
       {
        int diff = boxWidth - other.boxWidth;
        
        if( diff == 0 )
           {
            return boxHeight - other.boxHeight;
           }
        
        return diff; 
       }
    
    /**
     * Exchanges width and height values to rotate box
     * 
     */
    public void rotate()
       {
        int tempWidth = boxWidth;
        
        boxWidth = boxHeight;
        
        boxHeight = tempWidth;
       }
    
    /**
     * Gets width of box
     * 
     * @return width of box
     */
    public int getWidth()
       {
        return boxWidth;
       }
    
    /**
     * Gets height of box
     * 
     * @return height of box
     */
    public int getHeight()
       {
        return boxHeight;
       }
    
    /**
     * Gets box ID letter
     * 
     * @return box ID letter
     */
    public int getID()
       {
        return boxID;
       }
    
    /**
     * Gets used state of box
     * 
     * @return used state of box
     */
    public boolean isUsed()
       {
        return boxUsedState;
       }
    
    /**
     * Sets width of box
     * 
     * @param widthSetting Value with which to set width
     */
    public void setWidth( int widthSetting )
       {
        boxWidth = widthSetting;
       }
    
    /**
     * Sets height of box
     * 
     * @param heightSetting Value with which to set height
     */
    public void setHeight( int heightSetting )
       {
        boxHeight = heightSetting;
       }
    
    /**
     * Sets used state of box to true
     * 
     */
    public void setUsedState()
       {
        boxUsedState = true;
       }
    
    /**
     * Sets used state of box to false
     * 
     */
    public void unsetUsedState()
       {
        boxUsedState = false;
       }
    
    /**
     * Sets used state of box to false
     * 
     */
    @Override
    public String toString()
       {
        String outputStr = "box " + boxID + ", width: " + boxWidth 
                                  + ", height: " + boxHeight + ", used state: ";
        
        if( boxUsedState )
           {
            return outputStr + "true";
           }
        
        return outputStr + "false";
       }
    
   }  // end class
