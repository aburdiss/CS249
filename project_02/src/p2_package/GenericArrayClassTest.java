package p2_package;

public class GenericArrayClassTest
   {

      public static void main ( String[] args )
         {
            GenericArrayClass< String > testArray = new GenericArrayClass<> ();

            print ( Boolean.toString ( testArray.isEmpty () ) );

            testArray.appendItem ( "A" );
            testArray.appendItem ( "B" );

            print ( testArray.accessItemAt ( 0 ) );

            printArray ( testArray );

            testArray.insertItemAt ( 1, "C" );

            printArray ( testArray );

            testArray.removeItemAt ( 0 );

            printArray ( testArray );
            print ( Integer.toString ( testArray.getCurrentSize () ) );

            print ( Integer.toString ( testArray.getCurrentCapacity () ) );
            testArray.resize ( 25 );
            printArray ( testArray );
            print ( Integer.toString ( testArray.getCurrentCapacity () ) );

            GenericArrayClass< StudentClass > testStudents = new GenericArrayClass<> ();
            testStudents
                  .appendItem ( new StudentClass ( "John", 52456, 'M', 4.3 ) );
            testStudents
                  .appendItem ( new StudentClass ( "Qian", 97111, 'F', 5.9 ) );
            testStudents
                  .appendItem ( new StudentClass ( "Alex", 54321, 'M', 1.2 ) );
            testStudents
                  .appendItem ( new StudentClass ( "Zack", 10000, 'M', 0.0 ) );

            printArray ( testStudents );

            testStudents.runInsertionSort ();
            printArray ( testStudents );
         }

      public static void print ( String input )
         {
            System.out.println ( input );
         }

      public static void printArray ( GenericArrayClass input )
         {
            int index;
            for (index = 0; index < input.getCurrentSize (); index++)
               {
                  System.out.print ( input.accessItemAt ( index ) + ", " );
               }
            System.out.println ();
         }

   }
