package p9_package;

public class OpCodeClassMain
{

   public static void main ( String[] args )
   {
      int index, maxItems = 20;
      OpCodeHeapClass ghc = new OpCodeHeapClass ();
      OpCodeClass newItem, removedItem;

      ghc.setDisplayFlag ( true );

      System.out.println ( "Adding Items to heap" );
      System.out.println (
            "Items are added by priority first, and entry item next." );

      for (index = 0; index < maxItems; index++)
      {
         newItem = new OpCodeClass ( index + 1 );

         ghc.addItem ( newItem );

         // ghc.showArray();
      }

      System.out.println ( "\nRemoving Items from heap" );

      while (!ghc.isEmpty ())
      {
         removedItem = ghc.removeItem ();

         System.out.println ( removedItem.toString () );
      }

   }

}
