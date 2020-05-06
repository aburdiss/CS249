package p6_package;

public class p6_tests
   {

      public static void main ( String[] args )
         {
            LinkedListClass l1 = new LinkedListClass ();
            l1.appendItem ( new BoxClass () );
            l1.insertItemAt ( 0, new BoxClass () );
            l1.dump ();

            l1.clear ();
            l1.appendItem ( new BoxClass () );
            l1.appendItem ( new BoxClass () );
            l1.appendItem ( new BoxClass () );
            l1.dump ();

            LinkedListClass l2 = new LinkedListClass ( 7, new BoxClass () );
            l2.dump ();

            LinkedListClass l3 = new LinkedListClass ( l1 );
            System.out.println ( l3.getCurrentSize () );
            l3.dump ();
            BoxClass test = l3.accessItemAt ( 2 );
            System.out.println ( test );
            System.out.println ( l3.isInLinkedList ( test ) );
            System.out.println ( "" );
            l3.removeItemAt ( 2 );
            l3.dump ();

            System.out.println (
                  "=====================================================" );
            
            QueueClass q1 = new QueueClass();
            q1.enqueue ( new BoxClass() );
            q1.enqueue ( new BoxClass() );
            q1.enqueue ( new BoxClass() );
            q1.enqueue ( new BoxClass() );
            q1.enqueue ( new BoxClass() );
            q1.displayQueue ();

            QueueClass q2 = new QueueClass(q1);
            q2.dequeue ();
            q2.displayQueue ();
            q2.enqueue ( new BoxClass() );
            q2.displayQueue ();
            
         }

   }
