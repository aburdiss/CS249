package p6_package;

/**
 * Queue used for managing BoxClass objects, inherits LinkedListClass
 * 
 * @author Alexander Burdiss
 */
public class QueueClass extends LinkedListClass
   {
      /**
       * private constant for use in accessing front of queue
       */
      private static final int QUEUE_FRONT_INDEX = 0;

      /**
       * space constant for supporting display operations
       */
      private static final char SPACE = 32;

      /**
       * Default constructor for QueueClass
       */
      public QueueClass ()
         {
            super ();
         }

      /**
       * Copy constructor for QueueClass
       * 
       * @param copied - QueueClass object to be duplicated
       */
      public QueueClass ( QueueClass copied )
         {
            super ( copied );
         }

      /**
       * Dequeue operation
       * 
       * @return BoxClass object removed from the front of the queue
       */
      public BoxClass dequeue ()
         {
            return removeItemAt ( QUEUE_FRONT_INDEX );
         }

      /**
       * Displays queue from rear or back to front
       */
      public void displayQueue ()
         {
            int counter;
            int size = getCurrentSize ();
            System.out.println ( "Tail of Queue:" );

            for (counter = 1; counter <= size; counter++)
               {
                  displaySpaces ( counter );
                  System.out.println ( accessItemAt ( size - counter ) );
               }
            displaySpaces ( counter + 1 );
            System.out.println ( "Head of Queue" );
         }

      /**
       * Recursive method displays spaces for displayQueue
       * 
       * @param numSpaces - integer value specifying number of spaces to display
       */
      private void displaySpaces ( int numSpaces )
         {
            if ( numSpaces > 0 )
               {
                  System.out.print ( SPACE );
                  System.out.print ( SPACE );
                  displaySpaces ( numSpaces - 1 );
               }
         }

      /**
       * Enqueue operation
       * 
       * @param newItem - BoxClass object to be enqueued
       */
      public void enqueue ( BoxClass newItem )
         {
            appendItem ( newItem );
         }

      /**
       * Peek front operation, returns value at front without removing it
       * 
       * @return BoxClass object found at front of queue
       */
      public BoxClass peekFront ()
         {
            return accessItemAt ( QUEUE_FRONT_INDEX );
         }
   }
