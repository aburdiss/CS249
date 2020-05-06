package p9_package;

/**
 * Array-based generic min heap class used as a priority queue for generic data
 * 
 * @author Alexander Burdiss
 */
public class OpCodeHeapClass
{
   /**
    * Management data for array
    */
   private int arrayCapacity;

   /**
    * Management data for array
    */
   private int arraySize;

   /**
    * Initial array capacity
    */
   public final int DEFAULT_ARRAY_CAPACITY = 10;

   /**
    * Display flag can be set to observe bubble up and trickle down operations
    */
   private boolean displayFlag;

   /**
    * Array for heap
    */
   private OpCodeClass[] heapArray;

   /**
    * Default constructor sets up array management conditions and default
    * display flag setting
    */
   public OpCodeHeapClass ()
   {
      arrayCapacity = DEFAULT_ARRAY_CAPACITY;
      arraySize = 0;
      displayFlag = false;
      heapArray = new OpCodeClass[ arrayCapacity ];
   }

   /**
    * Copy constructor copies array and array management conditions and default
    * display flag setting
    * 
    * @param copied - GenericHeapClass object to be copied
    */
   public OpCodeHeapClass ( OpCodeHeapClass copied )
   {
      int index;

      arrayCapacity = copied.arrayCapacity;
      arraySize = copied.arraySize;
      displayFlag = false;
      heapArray = new OpCodeClass[ arrayCapacity ];

      for (index = 0; index < arraySize; index++)
      {
         heapArray[ index ] = new OpCodeClass ( copied.heapArray[ index ] );
      }
   }

   /**
    * Accepts OpCodeClass item and adds it to heap
    * <p>
    * Note: uses bubbleUpArrayHeap to resolve unbalanced heap after data
    * addition
    * <p>
    * Note: must check for resize before attempting to add an item
    * 
    * @param newItem - OpCodeClass item to be added
    */
   public void addItem ( OpCodeClass newItem )
   {
      checkForResize ();
      heapArray[ arraySize ] = newItem;
      
      if ( displayFlag )
      {
         System.out.println ( "\nAdding new Process: " + newItem );
      }
      
      bubbleUpArrayHeap ( arraySize );
      arraySize++; 
   }

   /**
    * Recursive operation to reset data in the correct order for the min heap
    * after new data addition
    * 
    * @param currentIndex - index of current item being assessed, and moved up
    *                     as needed
    */
   private void bubbleUpArrayHeap ( int currentIndex )
   {
      OpCodeClass temp;
      
      if ( currentIndex > 0 )
      {
         int parentIndex = ( currentIndex - 1 ) / 2;
         int currentPriority = heapArray[ currentIndex ].getPriorityValue ();
         int parentPriority = heapArray[ parentIndex ].getPriorityValue ();

         if ( currentPriority < parentPriority )
         {
            temp = heapArray[ parentIndex ];
            heapArray[ parentIndex ] = heapArray[ currentIndex ];
            heapArray[ currentIndex ] = temp;

            if ( displayFlag )
            {
               System.out.println ( "   - Bubble Up:" );
               System.out.println (
                     "     - Swapping parent: " + heapArray[ parentIndex ]
                           + " with child: " + heapArray[ currentIndex ] );
            }
            bubbleUpArrayHeap ( parentIndex );
         }
      }
   }

   /**
    * Automatic resize operation used prior to any new data addition in the heap
    * <p>
    * Tests for full heap array, and resizes to twice the current capacity as
    * required
    */
   private void checkForResize ()
   {
      OpCodeClass[] tempArray;
      int index;
      
      if ( arraySize == arrayCapacity )
      {
         arrayCapacity *= 2;
         tempArray = new OpCodeClass[ arrayCapacity ];
         
         for (index = 0; index < arraySize; index++)
         {
            tempArray[ index ] = heapArray[ index ];
         }
         
         heapArray = tempArray;
      }
   }

   /**
    * Tests for empty heap
    * 
    * @return boolean result of test
    */
   public boolean isEmpty ()
   {
      return arraySize == 0;
   }

   /**
    * Removes GenericData item from top of min heap, thus being the operation
    * with the lowest priority value
    * <p>
    * Note: Uses trickleDownArrayHeap to resolve unbalanced heap after data
    * removal
    * 
    * @return OpCodeClass item removed
    */
   public OpCodeClass removeItem ()
   {
      OpCodeClass removedItem;
      
      if ( !isEmpty () )
      {
         removedItem = heapArray[ 0 ];
         arraySize--;
         heapArray[ 0 ] = heapArray[ arraySize ];
         
         if (displayFlag)
         {
            System.out.println ( "\nRemoving process: " + removedItem );
         }
         
         trickleDownArrayHeap ( 0 );
         return removedItem;
      }
      return null;
   }

   /**
    * Utility method to set the display flag for displaying internal operations
    * of the heap bubble and trickle operations
    * 
    * @param setState - flag to be used to set the state to display, or not
    */
   public void setDisplayFlag ( boolean setState )
   {
      displayFlag = setState;
   }

   /**
    * Dumps Array to screen as is, no filtering or management
    */
   public void showArray ()
   {
      int index;
      for (index = 0; index < arraySize; index++)
      {
         System.out.print ( heapArray[ index ] );
         if ( index != arraySize - 1 )
         {
            System.out.print ( ", " );
         }
      }
      System.out.println ( "\n" );
   }

   /**
    * Recursive operation to reset data in the correct order for the min heap
    * after data removal
    * 
    * @param currentIndex - index of current item being assessed, and moved down
    *                     as required
    */
   private void trickleDownArrayHeap ( int currentIndex )
   {
      /*
       * because of your use of priority value, your sorting messes up
       */
      OpCodeClass temp;
      int leftChildPriority, rightChildPriority;

      int leftChildIndex = currentIndex * 2 + 1;
      int rightChildIndex = currentIndex * 2 + 2;
      int currentPriority = heapArray[ currentIndex ].getPriorityValue ();

      if ( rightChildIndex < arraySize )
      {
         leftChildPriority = heapArray[ leftChildIndex ].getPriorityValue ();
         rightChildPriority = heapArray[ rightChildIndex ].getPriorityValue ();

         if ( leftChildPriority < rightChildPriority )
         {
            if ( leftChildPriority < currentPriority )
            {
               temp = heapArray[ leftChildIndex ];
               heapArray[ leftChildIndex ] = heapArray[ currentIndex ];
               heapArray[ currentIndex ] = temp;

               if ( displayFlag )
               {
                  System.out.println ( "   - Trickle down:" );
                  System.out.println ( "     - Swapping parent: "
                        + heapArray[ currentIndex ] + " with left child: "
                        + heapArray[ leftChildIndex ] );
               }
               trickleDownArrayHeap ( leftChildIndex );
            }
         }

         else if ( rightChildPriority < currentPriority )
         {
            temp = heapArray[ rightChildIndex ];
            heapArray[ rightChildIndex ] = heapArray[ currentIndex ];
            heapArray[ currentIndex ] = temp;

            if ( displayFlag )
            {
               System.out.println ( "   - Trickle down:" );
               System.out.println ( "     - Swapping parent: "
                     + heapArray[ currentIndex ] + " with right child: "
                     + heapArray[ rightChildIndex ] );
            }
            trickleDownArrayHeap ( rightChildIndex );
         }
      }

      else if ( leftChildIndex < arraySize )
      {
         leftChildPriority = heapArray[ leftChildIndex ].getPriorityValue ();
         if ( leftChildPriority < currentPriority )
         {
            temp = heapArray[ leftChildIndex ];
            heapArray[ leftChildIndex ] = heapArray[ currentIndex ];
            heapArray[ currentIndex ] = temp;
            if ( displayFlag )
            {
               System.out.println ( "   - Trickle down:" );
               System.out.println ( "     - Swapping parent: "
                     + heapArray[ currentIndex ] + " with left child "
                     + heapArray[ leftChildIndex ] );
            }
            trickleDownArrayHeap ( leftChildIndex );
         }
      }
   }
}
