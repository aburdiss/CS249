package p3_package;

public class ArrayClassTest
   {
      public static void main(String[] args)
      {
         System.out.println ("Testing Constructor 4");
         ArrayClass test1 = new ArrayClass(6, 4, 100);
         printArray("test1", test1);
         
         System.out.println("Testing Copy Constructor");
         ArrayClass test2 = new ArrayClass(test1);
         printArray("test2", test2);
         
         System.out.println("Testing Default Constructor");
         ArrayClass test3 = new ArrayClass();
         printArray("test3", test3);
         
         System.out.println("Testing appendItem()");
         test2.appendItem ( 2 );
         printArray("test2", test2);
         
         System.out.println("Testing clear()");
         test2.clear();
         printArray("test2", test2);
         
         System.out.println("Testing getCurrentSize()");
         System.out.println("test2");
         System.out.println(test2.getCurrentSize () + "\n");
         
         System.out.println("Testng insertItemAt()");
         test2.insertItemAt ( 0, 123 );
         printArray("test2", test2);
         
         System.out.println("Testing isInArray()");
         System.out.println(test1.isInArray ( 100 ));
         System.out.println(test3.isInArray ( 1 ));
         System.out.println(test2.isInArray ( 100 ) + "\n");
         
         System.out.println("Testing loadUniqueRandoms");
         System.out.println("Array Capacity before: " + test3.getCurrentCapacity());
         System.out.println("Array Size before: "+ test3.getCurrentSize ());
         test3.loadUniqueRandoms ( 12, 1, 12 );
         System.out.println("Array Capacity After: " + test3.getCurrentCapacity());
         System.out.println("Array Size After: " + test3.getCurrentSize ());
         System.out.println("(Should Be Random)");
         printArray("test3", test3);
         
         System.out.println("Testing Merge Sort");
         test3.runMergeSort ();
         printArray("test3", test3);
         
         System.out.println("Testing Quick Sort");
         test1.loadUniqueRandoms ( 10, 1, 10 );
         test1.resize ( 20 );
         test1.appendItem ( 5 );
         test1.appendItem ( 4 );
         printArray ( "test1", test1 );
         test1.runQuickSort();
         printArray("test1", test1);
         
         System.out.println("Testing Shell Sort");
         test2.loadUniqueRandoms ( 15, 26, 40 );
         printArray("test2", test2);
         test2.runShellSort ();
         printArray("test2", test2);
         
      }
      
      public static void printArray ( String name, ArrayClass input )
         {
            int index;
            System.out.print(name + " Contents: ");
            for (index = 0; index < input.getCurrentSize (); index++)
               {
                  System.out.print ( input.accessItemAt ( index ) + ", " );
               }
            System.out.println ("\n");
         }
   }
