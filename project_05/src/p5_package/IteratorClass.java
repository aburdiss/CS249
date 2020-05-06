package p5_package;

/**
 * Iterator class derived (inherited) from ArrayClass
 * <p>
 * Note: IteratorClass ISA ArrayClass
 * 
 * @author Alexander Burdiss
 *
 */
public class IteratorClass extends ArrayClass
   {
      /**
       * Current index for iterator; lowest element is zero; index is set to -1
       * for empty iterator
       */
      private int currentIndex;

      /**
       * Default constructor, initializes parent and self
       */
      public IteratorClass ()
         {
            super ();

            currentIndex = -1;
         }

      /**
       * Initialization constructor, initializes parent to given capacity and
       * initializes self
       * 
       * @param initialCapacity - integer value representing initial capacity
       */
      public IteratorClass ( int initialCapacity )
         {
            super ( initialCapacity );

            currentIndex = -1;
         }

      /**
       * Copy constructor, copies parent and self data
       * 
       * @param copied - IteratorClass object to be copied
       */
      public IteratorClass ( IteratorClass copied )
         {
            super ( copied.getCurrentCapacity () );

            int index;
            int copiedSize = copied.getCurrentSize ();
            int currentValue;

            for (index = 0; index < copiedSize; index++)
               {
                  currentValue = copied.accessItemAt ( index );

                  appendItem ( currentValue );
               }

            currentIndex = copied.currentIndex;
         }

      /**
       * Adds item to iterator at current index
       * 
       * @param newValue - integer value to be placed in iterator
       * @return Boolean result of operation
       */
      public boolean addItem ( int newValue )
         {
            if (currentIndex == -1) 
               {
                  currentIndex = 0;
               }
            return appendItem ( newValue );
         }

      /**
       * Displays comma-delimited data in iterator with brackets around the
       * element at the current index
       */
      public void displayIteratorList ()
         {
            int arraySize = getCurrentSize ();
            int index, currentItem;

            System.out.println ( "Iterator List:" );

            for (index = 0; index < arraySize; index++)
               {
                  currentItem = accessItemAt ( index );
                  if ( index == currentIndex )
                     {
                        System.out.print ( "[" + currentItem + "]" );
                     }

                  else
                     {
                        System.out.print ( currentItem );
                     }

                  if ( index != arraySize - 1 )
                     {
                        System.out.print ( ", " );
                     }
               }
            System.out.println ();

         }

      /**
       * Returns true if data is available after the current index, false
       * otherwise
       * 
       * @return Boolean result of specification
       */
      public boolean hasNext ()
         {
            return getCurrentSize () > currentIndex;
         }

      /**
       * Returns true if data is available prior to the current index, false
       * otherwise
       * 
       * @return Boolean result of specification
       */
      public boolean hasPrevious ()
         {
            return currentIndex > 0;
         }

      /**
       * Returns true if current index is referencing the first item in the
       * list, false otherwise
       * 
       * @return Boolean result of specification
       */
      public boolean isAtFirstItem ()
         {
            return currentIndex == 0;
         }

      /**
       * Returns true if current index is referencing the last item in the list,
       * false otherwise
       * 
       * @return Boolean result of specification
       */
      public boolean isAtLastItem ()
         {
            return currentIndex == getCurrentSize () - 1;
         }

      /**
       * Removes item at the current index if array is not empty
       * <p>
       * Note: if element is removed from the end of the list, the current index
       * must be adjusted to remain in the list
       * 
       * @return integer value found at current index, or FAILED_ACCESS if empty
       *         list
       */
      public int removeCurrent ()
         {
            int removeIndex = currentIndex;
            if ( !hasNext() )
               {
                  currentIndex--;
               }
            return removeItemAt ( removeIndex );
         }

      /**
       * Returns item at the current index if array is not empty
       * 
       * @return integer value found at current index, or FAILED_ACCESS if empty
       *         list
       */
      public int returnCurrent ()
         {
            return accessItemAt ( currentIndex );
         }

      /**
       * Returns item immediately after the one at the current index if
       * available
       * <p>
       * Note: updates current index to next item upon success
       * 
       * @return integer value or FAILED_ACCESS as appropriate
       */
      public int returnNext ()
         {
            if ( hasNext () )
               {
                  currentIndex++;
                  return accessItemAt ( currentIndex );
               }
            return FAILED_ACCESS;
         }

      /**
       * Returns item immediately prior to the one at the current index if
       * available
       * <p>
       * Note: updates current index to previous item upon success
       * 
       * @return integer value or FAILED_ACCESS as appropriate
       */
      public int returnPrevious ()
         {
            if ( hasPrevious () )
               {
                  currentIndex--;
                  return accessItemAt ( currentIndex );
               }
            return FAILED_ACCESS;
         }

      /**
       * Sets iterator to first item
       * 
       * @return Boolean result depending on success of operation
       */
      public boolean setToFirstItem ()
         {
            if ( getCurrentSize () > 0 && currentIndex != 0)
               {
                  currentIndex = 0;
                  return true;
               }
            return false;
         }

      /**
       * Sets iterator to last item
       * 
       * @return Boolean result depending on success of operation
       */
      public boolean setToLastItem ()
         {
            int arraySize = getCurrentSize ();
            if ( arraySize > 0 && currentIndex != arraySize - 1)
               {
                  currentIndex = arraySize - 1;
                  return true;
               }
            return false;
         }
   }
