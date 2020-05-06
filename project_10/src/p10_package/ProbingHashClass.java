package p10_package;

/**
 * Simple generic hash class
 * 
 * @author Alexander Burdiss
 *
 */
public class ProbingHashClass
{
   /**
    * Table size default
    */
   private final int DEFAULT_TABLE_SIZE = 11;

   /**
    * Constant for returning item not found with search
    */
   public final int ITEM_NOT_FOUND = -1;

   /**
    * Constant for setting linear probing
    */
   public static final int LINEAR_PROBING = 101;

   /**
    * Flag for setting linear or quadratic probing
    */
   private int probeFlag;

   /**
    * Constant for setting quadratic probing
    */
   public static final int QUADRATIC_PROBING = 102;

   /**
    * Array for hash table
    */
   private StudentClass[] tableArray;

   /**
    * Size of the array table
    */
   private int tableSize;

   /**
    * Default Constructor
    * <p>
    * Initializes to default table size with probe flag set to linear probing
    */
   public ProbingHashClass ()
   {
      /*
       * -- need to make sure all slots are null when table is initialized -
       * Java might do this for you, but other languages won't!
       */
      probeFlag = LINEAR_PROBING;
      tableSize = DEFAULT_TABLE_SIZE;
      tableArray = new StudentClass[ DEFAULT_TABLE_SIZE ];
   }

   /**
    * Initialization constructor
    * <p>
    * Initializes to default table size with probe flag set to probe flag
    * parameter
    * 
    * @param inProbeFlag - sets linear or quadratic probing
    */
   public ProbingHashClass ( int inProbeFlag )
   {
      /*
       * -- need to make sure all slots are null when table is initialized -
       * Java might do this for you, but other languages won't!
       */
      probeFlag = inProbeFlag;
      tableSize = DEFAULT_TABLE_SIZE;
      tableArray = new StudentClass[ DEFAULT_TABLE_SIZE ];
   }

   /**
    * Initialization constructor
    * 
    * @param inTableSize - sets table size (capacity) but does not allow table
    *                    size to be less than default capacity
    * @param inProbeFlag - sets linear or quadratic probing
    */
   public ProbingHashClass ( int inTableSize, int inProbeFlag )
   {
      /*
       * -- need to make sure all slots are null when table is initialized -
       * Java might do this for you, but other languages won't!
       */
      probeFlag = inProbeFlag;
      tableSize = inTableSize;
      tableArray = new StudentClass[ inTableSize ];
   }

   /**
    * Adds GenericData item to hash table
    * <p>
    * Note: Uses hash index value from generateHash
    * <p>
    * Note: Shows probed index with data at the point of insertion
    * <p>
    * Note: Probe attempts are limited to the current size (capacity) of the
    * table
    * 
    * @param newItem - GenericData item
    * 
    * @return Boolean success of operation
    */
   public boolean addItem ( StudentClass newItem )
   {
      String outputString = "Indices probed: ";
      int initialIndex = generateHash ( newItem );
      int index = 1, indexExtension;

      int newItemIndex = initialIndex;

      while (tableArray[ newItemIndex ] != null && index <= tableSize)
      {
         outputString += newItemIndex + ", ";

         newItemIndex = initialIndex;

         if ( probeFlag == LINEAR_PROBING )
         {
            indexExtension = index;
         }
         // Assumed Quadratic Probing
         else
         {
            // toPower squares the index
            indexExtension = toPower ( index, 2 );
         }

         newItemIndex = ( newItemIndex + indexExtension ) % tableSize;
         index++;
      }

      outputString += newItemIndex;

      if ( index > tableSize )
      {
         return false;
      }

      tableArray[ newItemIndex ] = newItem;

      System.out.println ( outputString );
      System.out
            .println ( newItem + ", " + initialIndex + " -> " + newItemIndex );
      return true;
   }

   /**
    * Clears hash table by setting all bins to null
    */
   public void clearHashTable ()
   {
      int index;

      for (index = 0; index < tableSize; index++)
      {
         tableArray[ index ] = null;
      }
   }

   /**
    * Returns item found
    * 
    * @param searchItem - GenericData value to be found; uses findItemIndex
    * 
    * @return GenericData item found
    */
   public StudentClass findItem ( StudentClass searchItem )
   {
      int itemIndex = findItemIndex ( searchItem );

      if ( itemIndex == ITEM_NOT_FOUND )
      {
         return null;
      }

      return tableArray[ itemIndex ];
   }

   /**
    * Searches for item index in hash table
    * <p>
    * Note: Uses linear or quadratic probing as configured
    * <p>
    * Note: probing attempts limited to table size (capacity)
    * 
    * @param searchItem - GenericData value to be found
    * 
    * @return integer index location of search item
    */
   private int findItemIndex ( StudentClass searchItem )
   {
      String outputString = "Indices probed: ";
      int initialIndex = generateHash ( searchItem );
      int index = 0, indexExtension;
      boolean found = false;

      int searchItemIndex = initialIndex;

      while (!found && index < tableSize)
      {
         searchItemIndex = initialIndex;

         if ( probeFlag == LINEAR_PROBING )
         {
            indexExtension = index;
         }
         // Assumed Quadratic Probing
         else
         {
            // toPower squares the index
            indexExtension = toPower ( index, 2 );
         }

         searchItemIndex = ( searchItemIndex + indexExtension ) % tableSize;

         if ( tableArray[ searchItemIndex ] != null )
         {
            if ( searchItem.compareTo ( tableArray[ searchItemIndex ] ) == 0 )
            {
               found = true;
            }
         }

         if ( !found )
         {
            outputString += searchItemIndex + ", ";
         }
         index++;
      }

      outputString += searchItemIndex;

      if ( index > tableSize )
      {
         return ITEM_NOT_FOUND;
      }

      System.out.println ( outputString );
      return searchItemIndex;

   }

   /**
    * Method converts GenericData hash value to index for use in hash table
    * 
    * @param item - GenericData value to be converted to hash value
    *             <p>
    *             Note: gets data from object via hashCode, then calculates
    *             index
    *             <p>
    *             Note: Uses hashCode from object
    * 
    * @return integer hash value
    */
   public int generateHash ( StudentClass item )
   {
      return item.hashCode () % tableSize;
   }

   /**
    * Removes item from hash table
    * 
    * @param toBeRemoved - GenericData value used for requesting data uses
    *                    findItemIndex
    * 
    * @return GenericData item removed, or null if not found
    */
   public StudentClass removeItem ( StudentClass toBeRemoved )
   {
      int removedIndex = findItemIndex ( toBeRemoved );
      if ( removedIndex == ITEM_NOT_FOUND )
      {
         return null;
      }

      StudentClass removed = tableArray[ removedIndex ];
      tableArray[ removedIndex ] = null;
      return removed;
   }

   /**
    * traverses through all array bins, finds min and max number of contiguous
    * elements, and number of empty nodes; also shows table loading
    * <p>
    * NOTE: Generates string of used and unused bins in addition to displaying
    * results on screen
    * 
    * @return String result of hash table analysis
    */
   public String showHashTableStatus ()
   {
      String bins = "\nHash Table Status: ";
      String arrayDump = "";
      int index;
      int emptyBins = 0;
      int minContiguousBins = tableSize;
      int maxContiguousBins = 0;
      int workingContBins = 0;

      for (index = 0; index < tableSize; index++)
      {
         if ( tableArray[ index ] == null )
         {
            bins += "N";
            arrayDump += "\nnull";
            emptyBins++;
            if ( workingContBins < minContiguousBins && workingContBins != 0 )
            {
               minContiguousBins = workingContBins;
            }
            workingContBins = 0;
         }

         else
         {
            workingContBins++;
            if ( workingContBins > maxContiguousBins )
            {
               maxContiguousBins = workingContBins;
            }
            bins += "D";
            arrayDump += "\n" + tableArray[ index ];
         }

      }
      System.out.println ( bins );
      System.out
            .println ( "\n     Minimum contiguous bins: " + minContiguousBins );
      System.out
            .println ( "     Maximum contiguous bins: " + maxContiguousBins );
      System.out.println ( "        Number of empty bins: " + emptyBins );
      System.out.println ( "\nArray Dump:" + arrayDump );

      return bins;
   }

   /**
    * Local recursive method to calculate exponentiation with integers
    * 
    * @param base     - base of exponentiation
    * @param exponent - exponent of exponentiation
    * 
    * @return result of exponentiation calculation
    */
   private int toPower ( int base, int exponent )
   {
      if ( exponent == 0 )
      {
         return 1;
      }
      return base * toPower ( base, exponent - 1 );
   }
}
