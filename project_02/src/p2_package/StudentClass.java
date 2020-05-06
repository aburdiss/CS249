package p2_package;

/**
 * Description: class manages data for a student, including name, student ID, 
 * gender, and gpa
 *  
 *  @author Michael Leverington
 * 
 */
public class StudentClass implements Comparable<StudentClass>
   {
    /**
     * public enumeration of name key
     */
    static public final int SORT_BY_NAME = 0;

    /**
     * public enumeration of ID key
     */
    static public final int SORT_BY_ID = 1;

    /**
     * public enumeration of gender key
     */
    static public final int SORT_BY_GENDER = 2;
    
    /**
     * public enumeration of GPA key
     */
    static public final int SORT_BY_GPA = 3;
    
    /**
     * public enumeration of sorting forward key
     */
    static public final int SORT_FORWARD = 4;

    /**
     * public enumeration of sorting backward key
     */
    static public final int SORT_BACKWARD = 5;
    
    /**
     * member data - name
     */
    private String name;

    /**
     * member data - student ID
     */
    private int studentID;

    /**
     * member data - gender
     */
    private char gender;

    /**
     * member data - gpa
     */
    private double gpa;

    /**
     * member data - sort direction key storage
     */
    private static int sortKey; 
    
    /**
     * member data - sort key storage
     */
    private static int sortDirKey; 
    
    /** Default constructor, initializes all student data to default values
     * 
     */
    public StudentClass()
       {
        name = "---";
        studentID = 0;
        gender = '-';
        gpa = 0.000;
        sortKey = SORT_BY_NAME;
        sortDirKey = SORT_FORWARD;
       }
      
    /** 
     * Copy constructor, sets all data to copied object
     * 
     * @param copiedSC StudentClass object to be copied
     */
    public StudentClass( StudentClass copiedSC )
       {
        name = copiedSC.name;
        studentID = copiedSC.studentID;
        gender = copiedSC.gender;
        gpa = copiedSC.gpa;

/*      OR        
        this( copiedSC.name, copiedSC.studentID, copiedSC.gender, copiedSC.gpa );
*/
       }
      
    /** 
     * Initialization constructor, individually sets data values
     * 
     * @param nameIn name of student (String)
     * 
     * @param studentIDIn student ID number (int)
     * 
     * @param genderIn gender of student (char)
     * 
     * @param gpaIn gpa of student (double)
     * 
     */
    public StudentClass( String nameIn, int studentIDIn, 
                                                char genderIn, double gpaIn )
       {
        name = nameIn;
        studentID = studentIDIn;
        gender = genderIn;
        gpa = gpaIn;
       }
      
    /** 
     * Provides required method for comparing this object 
     * to another StudentClass object
     * 
     * @param student object of StudentClass with which to compare
     */
    public int compareTo( StudentClass student )
       {
        int compareResult = 0, index = 0;
        
        switch( sortKey )
           {
            case SORT_BY_GPA:
               
                compareResult = (int)( ( this.gpa - student.gpa ) * 10000 );                
               
                break;
               
            case SORT_BY_ID:
               
                compareResult = this.studentID - student.studentID;  
               
                break;
               
            case SORT_BY_GENDER:
               
                compareResult = (int)( this.gender - student.gender );
               
                break;
               
            default:  // SORT_BY_NAME
               {
                while( index < this.name.length() 
                         && index < student.name.length() 
                              && compareResult == 0 )
                   {
                    compareResult = 
                          toLowerCase( this.name.charAt( index ) ) 
                               - toLowerCase( student.name.charAt( index ) );
                  
                    if( compareResult == 0 )
                       {
                        index++;  
                       }
                   }
              
                if( compareResult == 0 )
                   {
                    compareResult = this.name.length() - student.name.length();
                   }                
               }
               
               break;
            }
        
        if( sortDirKey == SORT_BACKWARD )
           {
            compareResult *= -1;
           }                

        return compareResult;
       }

    /** 
     * Sets sort key for sorting by different internal data
     * 
     * @param sortKeyCode integer code provided via given constants
     * 
     */
    public static void setSortKey( int sortKeyCode )
       {
        sortKey = sortKeyCode;
       }
    
    /** 
     * Sets sort direction key for sorting by data forward/backward
     * 
     * @param sortDirKeyCode integer code provided via given constants
     * 
     */
    public static void setSortDirKey( int sortDirKeyCode )
       {
        sortDirKey = sortDirKeyCode;
       }
    
    /** 
     * Changes character to lower case only if character was originally 
     * an upper case letter
     * 
     * @param testChar Character to be tested, if it is upper case it will 
     * be converted to lower case;
     * otherwise the testChar will be returned unchanged
     * 
     * @return returns the lower case version of a letter 
     * if it was an upper case letter;
     * otherwise, the character is returned unchanged
     */
    public char toLowerCase( char testChar )
       {
        if( testChar >= 'A' && testChar <= 'Z' )
           {
            testChar = (char)( testChar - 'A' + 'a' );
           }
        
        return testChar;
       }

    /** 
     * Overrides Object.toString, provides raw data from object
     * <p>
     * Note: sortKey and sortDirKey not displayed
     * 
     */
    @Override
    public String toString()
       {
        return name + '/' + studentID + '/' + gender + '/' + gpa;
       }
    
   }

    
