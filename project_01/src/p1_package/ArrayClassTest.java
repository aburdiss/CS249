package p1_package;

public class ArrayClassTest
   {

      public static void main ( String[] args )
         {
            
            ArrayClass newArrayClass = new ArrayClass (10, 9, 0);
            System.out.println(newArrayClass.isEmpty ());
            System.out.println (newArrayClass.getCurrentCapacity ());
            System.out.println (newArrayClass.getCurrentSize ());
            newArrayClass.insertItemAt( 5, 6 );
            System.out.println(newArrayClass.isFull ());
            System.out.println(newArrayClass.getCurrentSize());
            newArrayClass.removeItemAt ( 3 );
            newArrayClass.resize ( 30 );
            System.out.println(newArrayClass.getCurrentSize ());
            System.out.println(newArrayClass.getCurrentCapacity ());
            
            
            int index;
            for (index = 0; index < newArrayClass.getCurrentSize (); index++)
               {
                  System.out.print ( newArrayClass.accessItemAt ( index ) + ",");
               }
         }
   }
