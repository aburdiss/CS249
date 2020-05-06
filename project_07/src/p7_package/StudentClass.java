package p7_package;

/**
 * Class for managing student data
 * 
 * @author MichaelL
 *
 */
public class StudentClass implements Comparable<StudentClass>
   {
    /**
     * Name data for class
     */
    public String name;
           
    /**
     * Student ID data for class
     */
    public int studentID;
           
    /**
     * Gender data for class
     */
    public char gender;
     
    /**
     * GPA data for class
     */
    public double gpa;

    /**
     * Initialization constructor for data
     * <p>
     * Note: Class does not require a default constructor
     * 
     * @param inName name of student to be input into object
     * 
     * @param inStudentID ID number of student to be input into object
     * 
     * @param inGender gender of student to be input into object
     * 
     * @param inGPA gpa of student to be input into object
     * 
     */
    public StudentClass( String inName, 
                           int inStudentID, char inGender, double inGPA )
       {
        name = inName;
         
        studentID = inStudentID;
         
        gender = inGender;
         
        gpa = inGPA;
       }
    
    /**
     * Copy constructor
     * <p>
     * Calls other constructor with copied data
     *
     * @param copied StudentClass object to be copied
     */
    public StudentClass( StudentClass copied )
       {
        this( copied.name, copied.studentID, copied.gender, copied.gpa );
       }

    /**
     * Compares student objects
     * <p>
     * Note: Compares name as class key; returns integer result such that 
     * if this name is less than other name, a negative number is returned;
     * if this name is greater than other name, a positive number is returned;
     * if this name is equal to, and the same length as other name, 
     * zero is returned
     * 
     * @param other StudentClass object to be compared with this object
     * 
     * @return integer difference between the names
     */
    @Override
    public int compareTo( StudentClass other )
       {
        String thisString = name;
        String otherString = other.name;
        int thisSize = thisString.length();
        int otherSize = otherString.length();
        int difference, index = 0;
        
        while( index < thisSize && index < otherSize )
           {
            difference = thisString.charAt( index ) 
                                               - otherString.charAt( index );
            
            if( difference != 0 )
               {
                return difference;
               }
            
            index++;
           }
        
        return thisSize - otherSize;
       }
    
    /**
     * Overrides Object toString with local
     */
    @Override
    public String toString()
       {
        return name + '/' + studentID + '/' + gender + '/' + gpa;           
       }      
   }

