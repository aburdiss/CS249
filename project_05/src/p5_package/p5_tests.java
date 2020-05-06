package p5_package;

public class p5_tests
   {

      public static void main ( String[] args )
         {
            IteratorClass i1 = new IteratorClass();
            i1.addItem ( 3 );
            i1.addItem ( 51 );
            i1.addItem ( 1 );
            i1.addItem ( 314 );
            i1.returnNext ();
            i1.displayIteratorList ();
            i1.returnNext();
            i1.displayIteratorList ();
            i1.removeCurrent ();
            i1.displayIteratorList ();
            i1.removeCurrent ();
            i1.removeCurrent ();
            i1.displayIteratorList ();
            i1.removeCurrent ();
            System.out.println("Current: " + i1.returnCurrent ());
            
            IteratorClass i2 = new IteratorClass(12);
            i2.setToFirstItem ();
            System.out.print ( "\nNew Random " );
            i2.displayIteratorList ();
            System.out.println("Has previous? " + i2.hasPrevious ());
            System.out.println("Has next? " + i2.hasNext ());
            i2.setToLastItem ();
            i2.displayIteratorList ();
            i2.removeItemAt ( 11 );
            i2.displayIteratorList ();
            i2.returnPrevious ();
            i2.displayIteratorList ();
            
            IteratorClass i3 = new IteratorClass(i2);
            System.out.print ( "\nCopied " );
            i3.displayIteratorList ();
            System.out.println( "At End? " + i3.isAtLastItem ());
            System.out.println( "At Front? " + i3.isAtFirstItem ());
            i3.setToFirstItem ();
            i3.displayIteratorList ();
            System.out.println( "At End? " + i3.isAtLastItem ());
            System.out.println( "At Front? " + i3.isAtFirstItem ());
            i3.removeCurrent ();
            i3.displayIteratorList ();
            
            StackClass s1 = new StackClass(20);
            System.out.println ();
            for (int i = 1; i < 13; i++)
               {
                  s1.push(i);
               }
            s1.displayStack ();
            s1.pop ();
            s1.displayStack ();
            System.out.println("Top: " + s1.peek());
            
            StackClass s2 = new StackClass(s1);
            System.out.print ("\nCopied ");
            s2.displayStack ();
            s2.push ( 13 );
            s2.push(14);
            s2.displayStack ();
            
            StackClass s3 = new StackClass();
            System.out.println ();
            s3.displayStack ();
            System.out.println("Full? " + s3.isFull());
            System.out.println("Empty? " + s3.isEmpty ());
            for (int i = 1; i< 11; i++)
               {
                  s3.push ( i );
               }
            s3.displayStack ();
            System.out.println("Full? " + s3.isFull());
            System.out.println("Empty? " + s3.isEmpty ());
         }
   }
