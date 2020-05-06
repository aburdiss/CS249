package p8_package;

/**
 * Driver class for testing TwoThreeTreeClass
 * 
 * @author MichaelL
 *
 */
public class TwoThreeTreeMainClass
   {

    /**
     * Main/Driver method for testing components of TwoThreeTreeClass
     * 
     * @param args String arguments not used
     */
    public static void main(String[] args)
      {
       TwoThreeTreeClass tttc = new TwoThreeTreeClass();
       
       tttc.addItem( 45 );
       System.out.println( tttc.inOrderTraversal() );
       
       tttc.addItem( 42 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 39 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 36 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 33 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 30 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 27 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 24 );
       System.out.println( tttc.inOrderTraversal() );
       
       tttc.addItem( 21 );
       System.out.println( tttc.inOrderTraversal() );
       
       tttc.addItem( 18 );
       System.out.println( tttc.inOrderTraversal() );
       
       tttc.addItem( 15 );
       System.out.println( tttc.inOrderTraversal() );
       
       tttc.addItem( 12 );
       System.out.println( tttc.inOrderTraversal() );
       
       tttc.addItem( 9 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 6 );
       System.out.println( tttc.inOrderTraversal() );

       tttc.addItem( 3 );
       System.out.println( tttc.inOrderTraversal() );
       
       
       TwoThreeTreeClass tttc2 = new TwoThreeTreeClass(tttc);
       tttc2.addItem ( 10 );
       System.out.println(tttc2.inOrderTraversal ());
       System.out.println(tttc2.search ( 10 ));

      }
    /*
Expected Output:
C45 
L42 R45 
C39 C42 C45 
L36 R39 C42 C45 
C33 L36 C39 R42 C45 
L30 R33 L36 C39 R42 C45 
C27 C30 C33 C36 C39 C42 C45 
L24 R27 C30 C33 C36 C39 C42 C45 
C21 L24 C27 R30 C33 C36 C39 C42 C45 
L18 R21 L24 C27 R30 C33 C36 C39 C42 C45 
C15 C18 C21 L24 C27 C30 C33 R36 C39 C42 C45 
L12 R15 C18 C21 L24 C27 C30 C33 R36 C39 C42 C45 
C9 L12 C15 R18 C21 L24 C27 C30 C33 R36 C39 C42 C45 
L6 R9 L12 C15 R18 C21 L24 C27 C30 C33 R36 C39 C42 C45 
C3 C6 C9 C12 C15 C18 C21 C24 C27 C30 C33 C36 C39 C42 C45 
     */

   }
