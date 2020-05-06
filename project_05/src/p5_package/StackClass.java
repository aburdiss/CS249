package p5_package;

/**
 * StackClass uses ArrayClass as data for its operations
 * <p>
 * Note: StackClass HASA ArrayClass
 * <p>
 * Note: Top of stack is at index zero of the ArrayClass; bottom of stack at
 * current size - 1
 * 
 * @author Alexander Burdiss
 *
 */

public class StackClass
   {
      /**
       * ArrayClass data structure used for object
       */
      private ArrayClass stackArray;

      /**
       * Constant value for top index of stack
       */
      private static int TOP_INDEX = 0;

      /**
       * Default constructor
       */
      public StackClass ()
         {
            stackArray = new ArrayClass();
         }

      /**
       * Initialization constructor
       * 
       * @param initialCapacity - integer value indicating initial capacity for
       *                        object
       */
      public StackClass ( int initialCapacity )
         {
            stackArray = new ArrayClass(initialCapacity);
         }

      /**
       * Copy constructor for object
       * 
       * @param copied - StackClass object to be duplicated
       */
      public StackClass ( StackClass copied )
         {
            stackArray = new ArrayClass(copied.stackArray);
         }

      /**
       * Clears stack
       */
      public void clear ()
         {
            stackArray.clear ();
         }

      /**
       * Displays comma-delimited list showing data from bottom of stack to top,
       * from left to right
       */
      public void displayStack ()
         {
            int arraySize = stackArray.getCurrentSize ();
            int index, currentItem;
            System.out.print("Stack Display:\nBottom of Stack -|");
            for (index = arraySize - 1; index >= TOP_INDEX; index--)
               {
                  currentItem = stackArray.accessItemAt ( index );

                  System.out.print ( currentItem );

                  if ( index != TOP_INDEX )
                     {
                        System.out.print ( ", " );
                     }
               }
            System.out.print ("<- Top of Stack\n");
         }

      /**
       * Returns true if stack is empty, false otherwise
       * 
       * @return Boolean result representing specification
       */
      public boolean isEmpty ()
         {
            return stackArray.isEmpty ();
         }

      /**
       * Returns true if stack is full, false otherwise
       * 
       * @return Boolean result representing specification
       */
      public boolean isFull ()
         {
            return stackArray.isFull ();
         }

      /**
       * Returns value at top of stack without removing it
       * 
       * @return integer value returned if stack not empty, FAILED_ACCESS
       *         otherwise
       */
      public int peek ()
         {
            return stackArray.accessItemAt ( TOP_INDEX );
         }

      /**
       * Returns value at top of stack upon removing it
       * 
       * @return integer value returned if stack not empty, FAILED_ACCESS
       *         otherwise
       */
      public int pop ()
         {
            return stackArray.removeItemAt ( TOP_INDEX );
         }

      /**
       * Places new value at the top of the stack
       * 
       * @param newValue - integer value to be pushed on to stack
       * @return Boolean result of operation success
       */
      public boolean push ( int newValue )
         {
            return stackArray.insertItemAt ( TOP_INDEX, newValue );
         }

      /**
       * Resizes stack - must resize to capacity larger than current
       * 
       * @param newCapacity - integer value indicating capacity to which to be
       *                    resized
       * @return Boolean result of operation success
       */
      public boolean resizeStack ( int newCapacity )
         {
            return stackArray.resize ( newCapacity );
         }
   }
