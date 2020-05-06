 package p4_package;

/**
 * Main driver method for testing recursive backtracking operations
 * 
 * @author Michael Leverington
 *
 */
public class ContainerBoxClassMain
   {

      /**
       * Driver main method
       * 
       * @param args String arguments unused for this operation
       * 
       */
      public static void main(String[] args)
         {
          ContainerBoxClass testContainer = new ContainerBoxClass( 15, 12 );
          boolean displayFlagSet = true;
          
          testContainer.setDisplayFlag( displayFlagSet );
          
        // Small data set for 10 x 10 container box
//          testContainer.addBoxToList( 4, 4 );
//          testContainer.addBoxToList( 6, 7 );
//          testContainer.addBoxToList( 4, 6 );
//          testContainer.addBoxToList( 3, 6 );
          
        // data set  
//          testContainer.addBoxToList( 4, 5 );
//          testContainer.addBoxToList( 2, 3 );
//          testContainer.addBoxToList( 2, 4 );
//          testContainer.addBoxToList( 5, 7 );
//          testContainer.addBoxToList( 7, 6 );
//          testContainer.addBoxToList( 5, 5 );
//          testContainer.addBoxToList( 5, 3 );
//          testContainer.addBoxToList( 3, 3 );
//          testContainer.addBoxToList( 4, 3 );
//          testContainer.addBoxToList( 4, 2 );


          
        // data set
          testContainer.addBoxToList( 3, 3 );
          testContainer.addBoxToList( 4, 3 );
          testContainer.addBoxToList( 4, 2 );
          testContainer.addBoxToList( 4, 5 );
          testContainer.addBoxToList( 2, 3 );
          testContainer.addBoxToList( 2, 4 );
          testContainer.addBoxToList( 5, 7 );
          testContainer.addBoxToList( 7, 6 );
          testContainer.addBoxToList( 5, 5 );
          testContainer.addBoxToList( 5, 3 );

//          testContainer.addBoxToList( 7, 6 );
//          testContainer.addBoxToList( 5, 5 );
//          testContainer.addBoxToList( 5, 3 );
//          testContainer.addBoxToList( 3, 3 );
//          testContainer.addBoxToList( 4, 3 );
//          testContainer.addBoxToList( 4, 2 );
//          testContainer.addBoxToList( 4, 5 );
//          testContainer.addBoxToList( 2, 3 );
//          testContainer.addBoxToList( 2, 4 );
//          testContainer.addBoxToList( 5, 7 );
          
          if( testContainer.fillContainerBox() )
             {
              System.out.println( "Packing solution found." );
             }
          
          else
             {
              System.out.println( "Packing solution not found" );
             }
          

         }

   }
