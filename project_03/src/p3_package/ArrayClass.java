package p3_package;

/**
 * Description: Class wrapper for a Java array, with additional management
 * operations
 * <p>
 * Note: Maintains a capacity value for maximum number of items that can be
 * stored, and a size value for the number of valid or viable data items in the
 * array
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
            arrayCapacity = DEFAULT_CAPACITY;
            arraySize = 0;
            localArray = new int[arrayCapacity];
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
            if (capacity < DEFAULT_CAPACITY)
               {
                  capacity = DEFAULT_CAPACITY;
               }
            arrayCapacity = capacity;
            arraySize = 0;
            localArray = new int[capacity];
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
       * @param capacity   - maximum capacity specification for the array
       * @param size       - sets the number of items to be filled in array, and
       *                   sets the size of the ArrayClass object
       * @param fill_value - value to be placed in all elements of initialized
       *                   array up to the size
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
       * Generates random number between given low and high values
       * 
       * @param low  lowest value that will be generated by method
       * @param high highest value that will be generated by method
       * @return the generated random value
       */
      public int getRandBetween ( int low, int high )
         {
            // +1 is needed to be inclusive on both ends.
            int value, range = high - low + 1;

            value = (int) ( Math.random () * range );

            return low + value;
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
       * Tests for value found in object array; returns true if value within
       * array, false otherwise
       * 
       * @param testValue - value to be tested
       * @return boolean true if value is found in array, false otherwise
       */
      public boolean isInArray ( int testValue )
         {
            int index;
            for (index = 0; index < arraySize; index++)
               {
                  if ( localArray[ index ] == testValue )
                     {
                        return true;
                     }
               }
            return false;
         }

      /**
       * Loads a specified number of unique random numbers in object
       * <p>
       * Note: This method overwrites all data in the array up to the number of
       * randoms requested
       * <p>
       * Note: If requested number of randoms is greater than the array
       * capacity, the array is resized
       * <p>
       * Note: Size is set to number of random numbers requested
       * <p>
       * Exceptional Condition: If more values are requested than are possible
       * given the range of numbers, method returns false, otherwise, it returns
       * true
       * 
       * @param numRands  - number of random values requested
       * @param lowLimit  - lowest value to be generated
       * @param highLimit - highest value to be generated
       * @return boolean true if method sucessful; false otherwise
       */
      public boolean loadUniqueRandoms ( int numRands, int lowLimit,
            int highLimit )
         {
            int index;
            int uniqueRandom;
            double range = highLimit - lowLimit + 1;

            // Testing the exceptional Condition.
            if ( range >= numRands )
               {
                  // Second Note
                  if ( numRands > arrayCapacity )
                     {
                        resize ( numRands );
                     }

                  // Third Note
                  arraySize = numRands;

                  // First Note
                  for (index = 0; index < numRands; index++)
                     {

                        do
                           {
                              uniqueRandom =
                                    getRandBetween ( lowLimit, highLimit );
                           }

                        while (isInArray ( uniqueRandom ));

                        localArray[ index ] = uniqueRandom;
                     }

                  return true;
               }
            return false;
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

      /**
       * Merges values brought in between a low and high index segment of an
       * array
       * <p>
       * Note: uses locally sized single array for temporary storage
       * 
       * @param lowIndex    - lowest index of array segment to be managed
       * @param middleIndex - middle index of array segment to be managed
       * @param highIndex   - high index of array segment to be managed
       */
      private void runMerge ( int lowIndex, int middleIndex, int highIndex )
         {
            int lowWorkingIndex = lowIndex;
            int highWorkingIndex = middleIndex + 1;

            int sizeToSort = highIndex - lowIndex + 1;
            int[] temporaryArray = new int[ sizeToSort ];

            int temporaryArrayIndex = 0;
            int localArrayIndex = lowIndex;

            while (lowWorkingIndex <= middleIndex
                  && highWorkingIndex <= highIndex)
               {
                  if ( localArray[ lowWorkingIndex ]
                        < localArray[ highWorkingIndex ] )
                     {
                        temporaryArray[ temporaryArrayIndex ] =
                              localArray[ lowWorkingIndex ];
                        lowWorkingIndex++;
                     }

                  else
                     {
                        temporaryArray[ temporaryArrayIndex ] =
                              localArray[ highWorkingIndex ];
                        highWorkingIndex++;
                     }
                  temporaryArrayIndex++;
               }

            while (lowWorkingIndex <= middleIndex)
               {
                  temporaryArray[ temporaryArrayIndex ] =
                        localArray[ lowWorkingIndex ];

                  lowWorkingIndex++;
                  temporaryArrayIndex++;
               }

            while (highWorkingIndex <= highIndex)
               {
                  temporaryArray[ temporaryArrayIndex ] =
                        localArray[ highWorkingIndex ];

                  highWorkingIndex++;
                  temporaryArrayIndex++;
               }

            for (temporaryArrayIndex = 0; temporaryArrayIndex < sizeToSort;
                  temporaryArrayIndex++, localArrayIndex++)
               {
                  localArray[ localArrayIndex ] =
                        temporaryArray[ temporaryArrayIndex ];
               }

         }

      /**
       * Data sorted using merge sort algorithm
       * <p>
       * Note: Call runMergeSortHelper with lower and upper indices of array to
       * be sorted
       */
      public void runMergeSort ()
         {
            runMergeSortHelper ( 0, arraySize - 1 );
         }

      /**
       * Merge sort helper, places low and high indices of array segment to be
       * processed into recursive method, then sorts data using merge sort
       * algorithm
       * 
       * @param lowIndex  - lowest index of array segment to be managed; this
       *                  varies as the segments are broken down recursively
       * @param highIndex - highest index of array segment to be managed; this
       *                  varies as the segments are broken down recursively
       */
      private void runMergeSortHelper ( int lowIndex, int highIndex )
         {
            int middleIndex = ( highIndex + lowIndex ) / 2;
            if ( lowIndex < highIndex )
               {
                  runMergeSortHelper ( lowIndex, middleIndex );
                  runMergeSortHelper ( middleIndex + 1, highIndex );

                  runMerge ( lowIndex, middleIndex, highIndex );
               }
         }

      /**
       * partitions array using the first value as the partition; when this
       * method is complete the partition value is in the correct location in
       * the array
       * 
       * @param lowIndex  - low index of array segment to be partitioned
       * @param highIndex - high index of array segment to be partitioned
       * @return integer index of partition pivot
       */
      private int runPartition ( int lowIndex, int highIndex )
         {
            int pivot = lowIndex;
            int pivotIndex = lowIndex;
            int workingIndex = lowIndex + 1;

            while (workingIndex <= highIndex)
               {
                  if ( localArray[ workingIndex ] <= localArray[ pivot ] )
                     {
                        pivotIndex++;
                        swapValuesAtIndex ( workingIndex, pivotIndex );
                     }
                  workingIndex++;
               }
            swapValuesAtIndex ( pivotIndex, pivot );
            return pivotIndex;
         }

      /**
       * Data sorted using quick sort algorithm
       * <p>
       * Note: Call runQuickSortHelper with lower and upper indices of array to
       * be sorted
       */
      public void runQuickSort ()
         {
            runQuickSortHelper ( 0, arraySize - 1 );
         }

      /**
       * helper method run with parameters that support recursive access
       * 
       * @param lowIndex  - low index of the segment of the array to be
       *                  processed
       * @param highIndex - high index of the segment of the array to be
       *                  processed
       */
      private void runQuickSortHelper ( int lowIndex, int highIndex )
         {
            int partitionIndex;

            if ( lowIndex < highIndex )
               {
                  partitionIndex = runPartition ( lowIndex, highIndex );

                  runQuickSortHelper ( lowIndex, partitionIndex - 1 );
                  runQuickSortHelper ( partitionIndex + 1, highIndex );
               }
         }

      /**
       * Sorts data using the Shell's sort algorithm
       */
      public void runShellSort ()
         {
            int gap, gapPassIndex, insertionIndex;
            int tempItem, testItem;
            boolean continueSearch;

            for (gap = arraySize / 2; gap > 0; gap /= 2)
               {
                  for (gapPassIndex = gap; gapPassIndex < arraySize;
                        gapPassIndex++)
                     {
                        tempItem = localArray[ gapPassIndex ];

                        insertionIndex = gapPassIndex;

                        continueSearch = true;

                        while (continueSearch && insertionIndex >= gap)
                           {
                              testItem = localArray[ insertionIndex - gap ];

                              if ( testItem > tempItem )
                                 {
                                    localArray[ insertionIndex ] =
                                          localArray[ insertionIndex - gap ];

                                    insertionIndex -= gap;
                                 }

                              else
                                 {
                                    continueSearch = false;
                                 }

                           } // end search loop

                        localArray[ insertionIndex ] = tempItem;
                     } // end list loop

               } // end gap size setting loop

         }

      /**
       * swaps values in the object array by taking in the indices of the array
       * locations
       * <p>
       * Note: for a small level of optimization, this method does not swap
       * values if the indices are the same
       * 
       * @param oneIndex   index of the of the values to be swapped
       * @param otherIndex index of the other value to be swapped
       */
      private void swapValuesAtIndex ( int oneIndex, int otherIndex )
         {
            int temp = localArray[ oneIndex ];

            if ( oneIndex != otherIndex )
               {
                  localArray[ oneIndex ] = localArray[ otherIndex ];

                  localArray[ otherIndex ] = temp;
               }
         }

   }
