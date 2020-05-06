package p2_package;

/**
 * Description: Class wrapper for a Java array of generic data (classes), with
 * additional management operations
 * <p>
 * Note: Only works with class that extends Comparable, as shown in class
 * declaration
 * <p>
 * Note: Maintains a capacity value for maximum number of items that can be
 * stored, and a size value for the number of valid or viable data items in the
 * array
 * 
 * @author Alexander Burdiss
 */
public class GenericArrayClass< GenericData extends Comparable< GenericData > >
   {
      private int arrayCapacity;
      private int arraySize;
      private static final int DEFAULT_CAPACITY = 10;
      private Object[] localArray;

      /**
       * Default constructor, initializes array to default capacity (10)
       */
      public GenericArrayClass ()
         {
            arrayCapacity = DEFAULT_CAPACITY;
            arraySize = 0;
            localArray = new Object[DEFAULT_CAPACITY];
         }

      /**
       * Initializing constructor, initializes array to specified capacity
       * 
       * @param capacity - maximum capacity specification for the array
       */
      public GenericArrayClass ( int capacity )
         {
            arrayCapacity = capacity;
            arraySize = 0;
            localArray = new Object[ capacity ];

            int index;

            for (index = 0; index < capacity; index++)
               {
                  localArray[ index ] = 0;
               }
         }

      /**
       * Accesses item in array at specified index if index within array size
       * bounds
       * 
       * @param accessIndex - index of requested element value
       * @return accessed value if successful, null if not
       */
      @SuppressWarnings("unchecked")
      public GenericData accessItemAt ( int accessIndex )
         {
            if ( accessIndex >= 0 && accessIndex < arraySize )
               {
                  return (GenericData) localArray[ accessIndex ];
               }
            return null;
         }

      /**
       * Appends item to end of array, if array is not full, e.g., no more
       * values can be added
       * 
       * @param newItem - value to be appended to array
       * @return Boolean success if appended, or failure if array was full
       */
      public boolean appendItem ( GenericData newItem )
         {
            if ( !isFull () )
               {
                  localArray[ arraySize ] = newItem;
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
       * 
       * @param insertIndex - index of element into which value is to be
       *                    inserted
       * @param newValue    - value to be inserted into array
       * @return Boolean success if inserted, or failure if array was full
       */
      public boolean insertItemAt ( int insertIndex, GenericData newValue )
         {
            int index;

            if ( !isFull () )
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
       * @return Boolean result of test for empty
       */
      public boolean isEmpty ()
         {
            return arraySize == 0;
         }

      /**
       * Tests for size of array equal to capacity, no more values can be added
       * 
       * @return Boolean result of test for full
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
       * @return removed value if successful, null if not
       */
      @SuppressWarnings("unchecked")
      public GenericData removeItemAt ( int removeIndex )
         {
            int index;
            GenericData removedValue;

            if ( removeIndex < arraySize && removeIndex >= 0 )
               {
                  removedValue = (GenericData) localArray[ removeIndex ];
                  for (index = removeIndex; index < arraySize - 1; index++)
                     {
                        localArray[ index ] = localArray[ index + 1 ];
                     }
                  arraySize--;
                  return removedValue;
               }
            return null;
         }

      /**
       * Description: Resets array capacity, copies current size and current
       * size number of elements
       * <p>
       * Exception: Method will not resize capacity below current array
       * capacity, returns false if this is attempted, true otherwise
       * 
       * @param newCapacity - new capacity to be set; must be larger than
       *                    current capacity
       * @return Boolean condition of resize success or failure
       */
      public boolean resize ( int newCapacity )
         {
            Object[] temporaryArray;
            int index;

            if ( newCapacity > arrayCapacity )
               {
                  temporaryArray = new Object[ newCapacity ];

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
       * Description: Sorts elements using the bubble sort algorithm
       * <p>
       * Note: The data is sorted using the compareTo method of the given data
       * set; the compareTo method decides the key and the order resulting
       */
      @SuppressWarnings("unchecked")
      public void runBubbleSort ()
         {
            boolean swapped = true;
            int index;
            GenericData currentItem;
            GenericData nextItem;
            while (swapped)
               {
                  swapped = false;
                  for (index = 0; index < arraySize - 1; index++)
                     {
                        currentItem = (GenericData) localArray[ index ];
                        nextItem = (GenericData) localArray[ index + 1 ];
                        if ( nextItem.compareTo ( currentItem ) < 0 )
                           {
                              swapped = true;
                              swapElements ( index, index + 1 );
                           }
                     }
               }

         }

      /**
       * Description: Sorts elements using the insertion sort algorithm
       * <p>
       * Note: The data is sorted using the compareTo method of the given data
       * set; the compareTo method decides the key and the order resulting
       */
      @SuppressWarnings("unchecked")
      public void runInsertionSort ()
         {
            int index, searchIndex;
            GenericData searchItem, testItem;
            boolean continueRun;

            for (index = 1; index < arraySize; index++)
               {
                  searchItem = (GenericData) localArray[ index ];
                  searchIndex = index;

                  continueRun = true;
                  while (searchIndex > 0 && continueRun)
                     {
                        testItem = (GenericData) localArray[ searchIndex - 1 ];
                        if ( searchItem.compareTo ( testItem ) < 0 )
                           {
                              localArray[ searchIndex ] = localArray[ searchIndex
                                    - 1 ];
                              searchIndex--;
                           }
                        
                        else
                           {
                              continueRun = false;
                           }
                     }
                  localArray[searchIndex] = searchItem;
               }
         }

      /**
       * Description: Sorts elements using the selection sort algorithm
       * <p>
       * Note: The data is sorted using the compareTo method of the given data
       * set; the compareTo method decides the key and the order resulting
       */
      @SuppressWarnings("unchecked")
      public void runSelectionSort ()
         {
            int searchIndex, index, lowestIndex;
            GenericData testItem, lowestItem;

            for (index = 0; index < arraySize - 1; index++)
               {
                  lowestIndex = index;
                  
                  for (searchIndex = index
                        + 1; searchIndex < arraySize; searchIndex++)
                     {
                        lowestItem = (GenericData) localArray[ lowestIndex ];
                        testItem = (GenericData) localArray[ searchIndex ];
                        if ( testItem.compareTo ( lowestItem ) < 0 )
                           {
                              lowestIndex = searchIndex;
                           }
                     }

                  if ( index != lowestIndex )
                     {
                        swapElements ( index, lowestIndex );
                     }
               }
         }

      /**
       * Uses Shell's sorting algorithm to sort an array of integers
       * <p>
       * Shell's sorting algorithm is an optimized insertion algorithm
       * 
       * <p>
       * Note: Creates new StudentClass array, sorts contents of array, and
       * returns the sorted result; does not modify (this) object student array
       * 
       * @return new StudentClass array with sorted items
       */
      @SuppressWarnings("unchecked")
      public void runShellSort ()
         {
            int gap, gapPassIndex, insertionIndex;
            GenericData tempItem, testItem;
            boolean continueSearch;

            for (gap = arraySize / 2; gap > 0; gap /= 2)
               {
                  for (gapPassIndex = gap; gapPassIndex < arraySize; gapPassIndex++)
                     {
                        tempItem = (GenericData) localArray[ gapPassIndex ];

                        insertionIndex = gapPassIndex;

                        continueSearch = true;

                        while (continueSearch && insertionIndex >= gap)
                           {
                              testItem = (GenericData) localArray[ insertionIndex
                                    - gap ];

                              if ( testItem.compareTo ( tempItem ) > 0 )
                                 {
                                    localArray[ insertionIndex ] = localArray[ insertionIndex
                                          - gap ];

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
       * Swaps one element in the local array at a given index with another
       * element in the array at the other given element
       * 
       * @param oneIndex   index of one of two elements to be swapped
       * 
       * @param otherIndex index of second of two elements to be swapped
       */
      private void swapElements ( int oneIndex, int otherIndex )
         {
            Object temp = localArray[ oneIndex ];

            localArray[ oneIndex ] = localArray[ otherIndex ];

            localArray[ otherIndex ] = temp;
         }

   }
