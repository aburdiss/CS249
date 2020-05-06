package p8_package;

/**
 * 2-3 Tree class that stores integers
 * 
 * @author Alexander Burdiss
 */
public class TwoThreeTreeClass
{
   /**
    * constant used for identifying one data item stored
    */
   private final int ONE_DATA_ITEM = 1;

   /**
    * constant used for identifying two data items stored
    */
   private final int TWO_DATA_ITEMS = 2;

   /**
    * constant used for identifying three data items stored
    */
   private final int THREE_DATA_ITEMS = 3;

   /**
    * Used for acquiring ordered tree visitations in String form
    */
   private String outputString;

   /**
    * root of tree
    */
   private TwoThreeNodeClass root;

   /**
    * Default 2-3 tree constructor
    */
   public TwoThreeTreeClass ()
   {
      root = null;
      outputString = null;
   }

   /**
    * Copy 2-3 tree constructor
    * 
    * @param copied - TwoThreeTreeClass object to be duplicated; data is copied,
    *               but new nodes and references must be created
    */
   public TwoThreeTreeClass ( TwoThreeTreeClass copied )
   {
      root = copyConstructorHelper ( copied.root );
      outputString = null;
   }

   /**
    * Implements tree duplication effort with recursive method; copies data into
    * newly created nodes and creates all new references to child nodes
    * 
    * @param workingCopiedRef - TwoThreeNodeClass reference that is updated to
    *                         lower level children with each recursive call
    * 
    * @return TwoThreeNodeClass reference to next higher level node; last return
    *         is to root node of THIS object
    */
   private TwoThreeNodeClass
         copyConstructorHelper ( TwoThreeNodeClass workingCopiedRef )
   {
      if ( workingCopiedRef == null )
      {
         return null;
      }

      TwoThreeNodeClass thisNode =
            new TwoThreeNodeClass ( workingCopiedRef.centerData );

      thisNode.leftChildRef =
            copyConstructorHelper ( workingCopiedRef.leftChildRef );
      if ( thisNode.leftChildRef != null )
      {
         thisNode.leftChildRef.parentRef = thisNode;
      }

      if ( workingCopiedRef.numItems == TWO_DATA_ITEMS )
      {
         thisNode.numItems = TWO_DATA_ITEMS;
         thisNode.leftData = workingCopiedRef.leftData;
         thisNode.rightData = workingCopiedRef.rightData;
         thisNode.centerChildRef =
               copyConstructorHelper ( workingCopiedRef.centerChildRef );
         if ( thisNode.centerChildRef != null )
         {
            thisNode.centerChildRef.parentRef = thisNode;
         }
      }

      thisNode.rightChildRef =
            copyConstructorHelper ( workingCopiedRef.rightChildRef );
      if ( thisNode.rightChildRef != null )
      {
         thisNode.rightChildRef.parentRef = thisNode;
      }

      return thisNode;
   }

   /**
    * Method is called when addItemHelper arrives at the bottom of the 2-3
    * search tree (i.e., all node's children are null);
    * <p>
    * Assumes one- or two- value nodes and adds one more to the appropriate one
    * resulting in a two- or three- value node
    * 
    * @param localRef - TwoThreeNodeClass reference has original node data and
    *                 contains added value when method completes; method does
    *                 not manage any node links
    * @param itemVal  - integer value to be added to 2-3 node
    */
   private void addAndOrganizeData ( TwoThreeNodeClass localRef, int itemVal )
   {
      if ( localRef.numItems == ONE_DATA_ITEM )
      {
         if ( itemVal < localRef.centerData )
         {
            // Move center to right, put item in left
            localRef.rightData = localRef.centerData;
            localRef.leftData = itemVal;
         }

         else
         {
            // Move center to left, put item in right
            localRef.leftData = localRef.centerData;
            localRef.rightData = itemVal;
         }
         localRef.numItems = TWO_DATA_ITEMS;
      }
      // Assumed two data items
      else
      {
         if ( itemVal < localRef.leftData )
         {
            // move left to center, add itemval to left
            localRef.centerData = localRef.leftData;
            localRef.leftData = itemVal;
         }

         else if ( itemVal > localRef.rightData )
         {
            // move right to center, add itemval to right
            localRef.centerData = localRef.rightData;
            localRef.rightData = itemVal;
         }

         else
         {
            localRef.centerData = itemVal;
         }
         localRef.numItems = THREE_DATA_ITEMS;
      }
   }

   /**
    * Adds item to 2-3 tree using addItemHelper as needed
    * 
    * @param itemVal - integer value to be added to the tree
    */
   public void addItem ( int itemVal )
   {
      if ( root == null )
      {
         root = new TwoThreeNodeClass ( itemVal );
      }

      else
      {
         addItemHelper ( root, itemVal );
      }
   }

   /**
    * Helper method searches from top of tree to bottom using divide and conquer
    * strategy to find correct location (node) for new added value; once
    * location is found, item is added to node using addAndOrganizeData and then
    * fixUpInsert is called in case the updated node has become a three-value
    * node
    * 
    * @param localRef - TwoThreeNodeClass reference to the current item at the
    *                 same given point in the recursion process
    * @param itemVal  - integer value to be added to the tree
    */
   private void addItemHelper ( TwoThreeNodeClass localRef, int itemVal )
   {

      boolean isLeaf =
            localRef.leftChildRef == null && localRef.centerChildRef == null
                  && localRef.rightChildRef == null;

      if ( localRef.numItems == ONE_DATA_ITEM && !isLeaf )
      {
         if ( itemVal < localRef.centerData )
         {
            addItemHelper ( localRef.leftChildRef, itemVal );
         }

         else
         {
            addItemHelper ( localRef.rightChildRef, itemVal );
         }
      }

      else if ( localRef.numItems == TWO_DATA_ITEMS && !isLeaf )
      {
         if ( itemVal < localRef.leftData )
         {
            addItemHelper ( localRef.leftChildRef, itemVal );
         }

         else if ( itemVal > localRef.rightData )
         {
            addItemHelper ( localRef.rightChildRef, itemVal );
         }

         // Assumed goes in the center
         else
         {
            addItemHelper ( localRef.centerChildRef, itemVal );
         }
      }

      else
      {
         addAndOrganizeData ( localRef, itemVal );
         fixUpInsert ( localRef );
      }
   }

   /**
    * Method clears tree so that new items can be added again
    */
   public void clear ()
   {
      root = null;
   }

   /**
    * Method used to fix tree any time a three-value node has been added to the
    * bottom of the tree; it is always called but decides to act only if it
    * finds a three-value node
    * <p>
    * Resolves current three-value node which may add a value to the node above;
    * if the node above becomes a three-value node, then this is resolved with
    * the next recursive call
    * <p>
    * Recursively climbs from bottom to top of tree resolving any three-value
    * nodes found
    * 
    * @param localRef - TwoThreeNodeClas reference initially given the currently
    *                 updated node, then is given parent node recursively each
    *                 time a three-value node was resolved
    */
   private void fixUpInsert ( TwoThreeNodeClass localRef )
   {
      if ( localRef.numItems == THREE_DATA_ITEMS )
      {
         if ( localRef.parentRef == null )
         {
            localRef.parentRef = new TwoThreeNodeClass ( localRef.centerData );
            root = localRef.parentRef;

            localRef.parentRef.leftChildRef = new TwoThreeNodeClass (
                  TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
            localRef.parentRef.rightChildRef = new TwoThreeNodeClass (
                  TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
         }

         else
         {
            if ( localRef.parentRef.numItems == ONE_DATA_ITEM )
            {
               localRef.parentRef.numItems = TWO_DATA_ITEMS;

               if ( localRef == localRef.parentRef.rightChildRef )
               {
                  localRef.parentRef.rightData = localRef.centerData;
                  localRef.parentRef.leftData = localRef.parentRef.centerData;

                  localRef.parentRef.centerChildRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
                  localRef.parentRef.rightChildRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
               }
               // assume left child
               else
               {
                  localRef.parentRef.leftData = localRef.centerData;
                  localRef.parentRef.rightData = localRef.parentRef.centerData;

                  localRef.parentRef.centerChildRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                  localRef.parentRef.leftChildRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
               }
            }

            // Parent ref has two items
            else
            {
               localRef.parentRef.numItems = THREE_DATA_ITEMS;

               if ( localRef == localRef.parentRef.leftChildRef )
               {
                  localRef.parentRef.centerData = localRef.parentRef.leftData;
                  localRef.parentRef.leftData = localRef.centerData;

                  localRef.parentRef.auxRightRef =
                        localRef.parentRef.centerChildRef;
                  localRef.parentRef.auxLeftRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                  localRef.parentRef.leftChildRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
               }

               else if ( localRef == localRef.parentRef.centerChildRef )
               {
                  localRef.parentRef.centerData = localRef.centerData;

                  localRef.parentRef.auxRightRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
                  localRef.parentRef.auxLeftRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );
               }
               // assume i am the right child
               else
               {
                  localRef.parentRef.centerData = localRef.parentRef.rightData;
                  localRef.parentRef.rightData = localRef.centerData;

                  localRef.parentRef.auxLeftRef =
                        localRef.parentRef.centerChildRef;

                  localRef.parentRef.auxRightRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.LEFT_CHILD_SELECT, localRef );

                  localRef.parentRef.rightChildRef = new TwoThreeNodeClass (
                        TwoThreeNodeClass.RIGHT_CHILD_SELECT, localRef );
               }

               fixUpInsert ( localRef.parentRef );
            }
         }
      }
   }

   /**
    * Tests center value if single node, tests left and right values if
    * two-value node; returns true if specified data is found in any given node
    * <p>
    * Note: Method does not use any branching operations such as if/else/etc.
    * 
    * @param localRef  - TwoThreeNodeClass reference to node with one or two
    *                  data items in it
    * @param searchVal - integer value to be found in given node
    * 
    * @return boolean result of test
    */
   private boolean foundInNode ( TwoThreeNodeClass localRef, int searchVal )
   {
      boolean oneItem = localRef.numItems == ONE_DATA_ITEM;
      boolean twoItems = localRef.numItems == TWO_DATA_ITEMS;

      boolean centerCheck = searchVal == localRef.centerData && oneItem;
      boolean leftCheck = searchVal == localRef.leftData && twoItems;
      boolean rightCheck = searchVal == localRef.rightData && twoItems;

      boolean leftOrRightCheck = leftCheck || rightCheck;

      return leftOrRightCheck || centerCheck;
   }

   /**
    * Public method called by user to display data in order
    * 
    * @return String result to be displayed and/or analyzed
    */
   public String inOrderTraversal ()
   {
      outputString = "";
      inOrderTraversalHelper ( root );
      return outputString;
   }

   /**
    * Helper method conducts in order traversal with 2-3 tree
    * <p>
    * Shows location of each value in a node: "C" at center of single node "L"
    * or "R" at left or right of two-value node
    * 
    * @param localRef - TwoThreeNodeClass reference to current location at any
    *                 given point in the recursion process
    */
   private void inOrderTraversalHelper ( TwoThreeNodeClass localRef )
   {
      if ( localRef != null )
      {
         if ( localRef.numItems == TWO_DATA_ITEMS )
         {
            inOrderTraversalHelper ( localRef.leftChildRef );
            outputString += "L" + localRef.leftData + " ";
            inOrderTraversalHelper ( localRef.centerChildRef );
            outputString += "R" + localRef.rightData + " ";
            inOrderTraversalHelper ( localRef.rightChildRef );
         }

         else
         {
            inOrderTraversalHelper ( localRef.leftChildRef );
            outputString += "C" + localRef.centerData + " ";
            inOrderTraversalHelper ( localRef.rightChildRef );
         }

      }
   }

   /**
    * Search method used by programmer to find specified item in 2-3 tree
    * 
    * @param searchVal - integer value to be found
    * 
    * @return boolean result of search effort
    */
   public boolean search ( int searchVal )
   {
      return searchHelper ( root, searchVal );
   }

   /**
    * Search helper method that traverses through tree in a recursive divide and
    * conquer search fashion to find given integer in 2-3 tree
    * 
    * @param localRef  - TwoThreeNodeClass reference to given node at any point
    *                  during the recursive process
    * @param searchVal - integer value to be found in tree
    * 
    * @return boolean result of search effort
    */
   private boolean searchHelper ( TwoThreeNodeClass localRef, int searchVal )
   {
      if ( localRef != null )
      {
         if ( foundInNode ( localRef, searchVal ) )
         {
            return true;
         }

         if ( localRef.numItems == TWO_DATA_ITEMS )
         {
            if ( searchVal < localRef.leftData )
            {
               return searchHelper ( localRef.leftChildRef, searchVal );
            }

            else if ( searchVal > localRef.rightData )
            {
               return searchHelper ( localRef.rightChildRef, searchVal );
            }

            else
            {
               return searchHelper ( localRef.centerChildRef, searchVal );
            }
         }

         // Assumed there is one data item.
         if ( searchVal < localRef.centerData )
         {
            return searchHelper ( localRef.leftChildRef, searchVal );
         }

         else
         {
            return searchHelper ( localRef.rightChildRef, searchVal );
         }
      }
      return false;
   }
}
