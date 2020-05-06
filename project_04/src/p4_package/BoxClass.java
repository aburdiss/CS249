package p4_package;

public class BoxClass
   {
    /**
     * Static field that starts by holding 'A'
     */
    private static char boxLetter = 'A';
    
    /**
     * integer boxWidth and boxHeight fields
     */
    private int boxWidth, boxHeight;
    
    /**
     * character letter field to identify a given box
     */
    private char boxIDLetter;
    
    /**
     * Boolean field to indicate if a box has been used
     */
    private boolean boxUsedState;
    
    /**
     * Default constructor for BoxClass
     */
    public BoxClass()
    {
     boxWidth = 0;
     boxHeight = 0;
     boxIDLetter = boxLetter;
     boxUsedState = false;
     
     boxLetter++;
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
     
     boxIDLetter = boxLetter;
     boxUsedState = false;
     
     boxLetter++;
    }

    /**
     * Copy constructor for BoxClass
     * 
     * @param copied BoxClass object to be copied
     */
    public BoxClass( BoxClass copied )
    {
     boxWidth = copied.boxWidth;
     boxHeight = copied.boxHeight;
     
     boxIDLetter = copied.boxIDLetter;
     boxUsedState = copied.boxUsedState;
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
    public char getID()
       {
        return boxIDLetter;
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
    //@Override
    public String toString()
       {
        if( boxUsedState )
           {
            return "box " + boxIDLetter + ", width: " + boxWidth 
                        + ", height: " + boxHeight + ", used state: true";
           }
        
        return "box " + boxIDLetter + ", width: " + boxWidth 
              + ", height: " + boxHeight + ", used state: false";
       }
    
   }  // end class
