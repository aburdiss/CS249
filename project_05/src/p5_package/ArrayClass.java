package p5_package;

/**
 * Base array wrapper with bounds checking and management
 * 
 * @author Alexander Burdiss
 *
 */
public class ArrayClass
   {
      /**
       * array capacity member
       */
      private int arrayCapacity;

      /**
       * array size member
       */
      private int arraySize;

      /**
       * Constant for default capacity
       */
      private static int DEFAULT_CAPACITY = 10;

      /**
       * Constant for failed access
       */
      public static int FAILED_ACCESS = -999999;

      /**
       * local array member
       */
      private int[] localArray;

      /**
       * Default constructor, initializes array to default capacity
       */
      public ArrayClass ()
         {
            this ( DEFAULT_CAPACITY, 0, 0 );
         }

      /**
       * Copy constructor, initializes array to size and capacity of copied
       * array, then copies only the elements up to the given size
       * 
       * @param copied - ArrayClass object to be copied
       */
      public ArrayClass ( ArrayClass copied )
         {
            arrayCapacity = copied.arrayCapacity;
            arraySize = copied.arraySize;
            localArray = new int[ copied.arrayCapacity ];

            int index;
            for (index = 0; index < copied.arraySize; index++)
               {
                  localArray[ index ] = copied.localArray[ index ];
               }
         }

      /**
       * Initializing constructor, initializes array to specified capacity
       * <p>
       * Note: Must not be initialized to a capacity less than the default
       * capacity
       * 
       * @param capacity - maximum capacity specification for the array
       */
      public ArrayClass ( int capacity )
         {
            this ( capacity, 0, 0 );
         }

      /**
       * Initializing constructor, initializes array to specified capacity, size
       * to specified value, then fills all elements with specified size value
       * <p>
       * Note: If given capacity less than default capacity, capacity must be
       * set to default capacity
       * <p>
       * Note: If given size is greater than given capacity, capacity must be
       * set to given size
       * 
       * @param capacity  - maximum capacity specification for the array
       * @param size      - sets the number of items to be filled in array, and
       *                  sets the size of the ArrayClass object
       * @param fillValue - value to be placed in all elements of initialized
       *                  array up to the size
       */
      public ArrayClass ( int capacity, int size, int fillValue )
         {
            // First Note
            if ( capacity < DEFAULT_CAPACITY )
               {
                  capacity = DEFAULT_CAPACITY;
               }
            // Second Note
            if ( size > capacity )
               {
                  capacity = size;
               }

            arrayCapacity = capacity;
            arraySize = size;
            localArray = new int[ capacity ];

            // If size == 0, this loop will not add anything to the array.
            int index;
            for (index = 0; index < size; index++)
               {
                  localArray[ index ] = fillValue;
               }
         }

      /**
       * Accesses item in array at specified index if index within array size
       * bounds
       * 
       * @param accessIndex - index of requested element value
       * @return accessed value if successful, FAILED_ACCESS (-999999) if not
       */
      public int accessItemAt ( int accessIndex )
         {
            if ( accessIndex < arraySize && accessIndex >= 0 )
               {
                  return localArray[ accessIndex ];
               }
            return FAILED_ACCESS;
         }

      /**
       * Appends item to end of array, if array is not full, e.g., no more
       * values can be added
       * 
       * @param newValue - value to be appended to array
       * @return boolean success if appended, or failure if array was full
       */
      public boolean appendItem ( int newValue )
         {
            if ( !isFull () )
               {
                  localArray[ arraySize ] = newValue;
                  arraySize++;
                  return true;
               }
            return false;
         }

      /**
       * Clears array of all valid values by setting array size to zero, values
       * remain in array but are not accessible
       */
      public void clear ()
         {
            arraySize = 0;
         }

      /**
       * Simple array dump for testing purposes
       */
      @SuppressWarnings("unused")
      private void dump ()
         {
            int index;
            for (index = 0; index < arraySize; index++)
               {
                  System.out.print ( localArray[ index ] + ", " );
               }
            System.out.println ( "\n" );
         }

      /**
       * Description: Gets current capacity of array
       * <p>
       * Note: capacity of array indicates number of values the array can hold
       * 
       * @return capacity of array
       */
      public int getCurrentCapacity ()
         {
            return arrayCapacity;
         }

      /**
       * Description: Gets current size of array
       * <p>
       * Note: size of array indicates number of valid or viable values in the
       * array
       * 
       * @return size of array
       */
      public int getCurrentSize ()
         {
            return arraySize;
         }

      /**
       * Description: Inserts item to array at specified index if array is not
       * full, e.g., no more values can be added
       * <p>
       * Note: Value is inserted at given index, all data from that index to the
       * end of the array is shifted up by one
       * <p>
       * Note: Value can be inserted after the last valid element but not at any
       * index past that point
       * 
       * @param insertIndex - index of element into which value is to be
       *                    inserted
       * @param newValue    - value to be inserted into array
       * @return boolean success if inserted, or failure if array was full
       */
      public boolean insertItemAt ( int insertIndex, int newValue )
         {
            int index;

            // Testing whether the insertIndex is valid.
            if ( !isFull () && insertIndex <= arraySize && insertIndex >= 0 )
               {
                  for (index = arraySize; index > insertIndex; index--)
                     {
                        localArray[ index ] = localArray[ index - 1 ];
                     }
                  localArray[ insertIndex ] = newValue;
                  arraySize++;
                  return true;
               }
            return false;
         }

      /**
       * Tests for size of array equal to zero, no valid values stored in array
       * 
       * @return boolean result of test for empty
       */
      public boolean isEmpty ()
         {
            return arraySize == 0;
         }

      /**
       * Tests for size of array equal to capacity, no more values can be added
       * 
       * @return boolean result of test for full
       */
      public boolean isFull ()
         {
            return arraySize == arrayCapacity;
         }

      /**
       * Description: Removes item from array at specified index if index within
       * array size bounds
       * <p>
       * Note: Each data item from the element immediately above the remove
       * index to the end of the array is moved down by one element
       * 
       * @param removeIndex - index of element value to be removed
       * @return removed value if successful, FAILED_ACCESS (-999999) if not
       */
      public int removeItemAt ( int removeIndex )
         {
            int removedValue;
            int index;

            if ( removeIndex < arraySize && removeIndex >= 0 )
               {
                  removedValue = localArray[ removeIndex ];

                  for (index = removeIndex; index < arraySize - 1; index++)
                     {
                        localArray[ index ] = localArray[ index + 1 ];
                     }
                  arraySize--;
                  return removedValue;
               }
            return FAILED_ACCESS;
         }

      /**
       * Description: Resets array capacity, copies current size and current
       * size number of elements
       * <p>
       * Exception: Method will not resize capacity below current array size,
       * returns false if this is attempted, true otherwise
       * 
       * @param newCapacity - new capacity to be set; must be larger than
       *                    current capacity
       * @return boolean condition of resize success or failure
       */
      public boolean resize ( int newCapacity )
         {
            int[] temporaryArray;
            int index;

            if ( newCapacity > arrayCapacity )
               {
                  temporaryArray = new int[ newCapacity ];

                  for (index = 0; index < arraySize; index++)
                     {
                        temporaryArray[ index ] = localArray[ index ];
                     }
                  arrayCapacity = newCapacity;
                  localArray = temporaryArray;
                  return true;
               }
            return false;
         }
   }
