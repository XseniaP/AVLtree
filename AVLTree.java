/**
 *
 * AVLTree
 *
 * An implementation of a AVL Tree with
 * distinct integer keys and info
 *
 */

public class AVLTree {

    /**
     * public boolean empty()
     *
     * returns true if and only if the tree is empty
     *
     */
    public boolean empty() {
        return false; // to be replaced by student code
    }

    /**
     * public String search(int k)
     *
     * returns the info of an item with key k if it exists in the tree
     * otherwise, returns null
     */
    public String search(int k)
    {
        return "42";  // to be replaced by student code
    }

    /**
     * public int insert(int k, String i)
     *
     * inserts an item with key k and info i to the AVL tree.
     * the tree must remain valid (keep its invariants).
     * returns the number of rebalancing operations, or 0 if no rebalancing operations were necessary.
     * returns -1 if an item with key k already exists in the tree.
     */
    public int insert(int k, String i) {
        return 42;	// to be replaced by student code
    }

    /**
     * public int delete(int k)
     *
     * deletes an item with key k from the binary tree, if it is there;
     * the tree must remain valid (keep its invariants).
     * returns the number of rebalancing operations, or 0 if no rebalancing operations were needed.
     * returns -1 if an item with key k was not found in the tree.
     */
    public int delete(int k)
    {
        return 42;	// to be replaced by student code
    }

    /**
     * public String min()
     *
     * Returns the info of the item with the smallest key in the tree,
     * or null if the tree is empty
     */
    public String min()
    {
        return "42"; // to be replaced by student code
    }

    /**
     * public String max()
     *
     * Returns the info of the item with the largest key in the tree,
     * or null if the tree is empty
     */
    public String max()
    {
        return "42"; // to be replaced by student code
    }

    /**
     * public int[] keysToArray()
     *
     * Returns a sorted array which contains all keys in the tree,
     * or an empty array if the tree is empty.
     */
    public int[] keysToArray()
    {
        int[] arr = new int[42]; // to be replaced by student code
        return arr;              // to be replaced by student code
    }

    /**
     * public String[] infoToArray()
     *
     * Returns an array which contains all info in the tree,
     * sorted by their respective keys,
     * or an empty array if the tree is empty.
     */
    public String[] infoToArray()
    {
        String[] arr = new String[42]; // to be replaced by student code
        return arr;                    // to be replaced by student code
    }

    /**
     * public int size()
     *
     * Returns the number of nodes in the tree.
     *
     * precondition: none
     * postcondition: none
     */
    public int size()
    {
        return 42; // to be replaced by student code
    }

    /**
     * public int getRoot()
     *
     * Returns the root AVL node, or null if the tree is empty
     *
     * precondition: none
     * postcondition: none
     */
    public IAVLNode getRoot()
    {
        return null;
    }
    /**
     * public string select(int i)
     *
     * Returns the value of the i'th smallest key (return null if tree is empty)
     * Example 1: select(1) returns the value of the node with minimal key
     * Example 2: select(size()) returns the value of the node with maximal key
     * Example 3: select(2) returns the value 2nd smallest minimal node, i.e the value of the node minimal node's successor
     *
     * precondition: size() >= i > 0
     * postcondition: none
     */
    public String select(int i)
    {
        return null;
    }
    /**
     * public int less(int i)
     *
     * Returns the sum of all keys which are less or equal to i
     * i is not neccessarily a key in the tree
     *
     * precondition: none
     * postcondition: none
     */
    public int less(int i)
    {
        return 0;
    }

    /**
     * public interface IAVLNode
     * ! Do not delete or modify this - otherwise all tests will fail !
     */
    public interface IAVLNode{
        public int getKey(); //returns node's key (for virtuval node return -1)
        public String getValue(); //returns node's value [info] (for virtuval node return null)
        public void setLeft(IAVLNode); //sets left child
        public IAVLNode getLeft(); //returns left child (if there is no left child return null)
        public void setRight(IAVLNode); //sets right child
        public IAVLNode getRight(); //returns right child (if there is no right child return null)
        public void setParent(IAVLNode); //sets parent
        public IAVLNode getParent(); //returns the parent (if there is no parent return null)
        public boolean isRealNode(); // Returns True if this is a non-virtual AVL node
        public void setSubtreeSize(); // sets the number of real nodes in this node's subtree
        public int getSubtreeSize(); // Returns the number of real nodes in this node's subtree (Should be implemented in O(1))
    }

    /**
     * public class AVLNode
     *
     * If you wish to implement classes other than AVLTree
     * (for example AVLNode), do it in this file, not in
     * another file.
     * This class can and must be modified.
     * (It must implement IAVLNode)
     */
    public class AVLNode implements IAVLNode{
        public int getKey()
        {
            return 42; // to be replaced by student code
        }
        public String getValue()
        {
            return null; // to be replaced by student code
        }
        public void setLeft(IAVLNode node)
        {
//            return null; // to be replaced by student code
        }
        public IAVLNode getLeft()
        {
            return null; // to be replaced by student code
        }
        public void setRight(IAVLNode node)
        {
//            return null; // to be replaced by student code
        }
        public IAVLNode getRight()
        {
            return null; // to be replaced by student code
        }
        public void setParent(IAVLNode node)
        {
//            return null; // to be replaced by student code
        }
        public IAVLNode getParent()
        {
            return null; // to be replaced by student code
        }
        // Returns True if this is a non-virtual AVL node
        public boolean isRealNode()
        {
            return true; // to be replaced by student code
        }
        public void setSubtreeSize()
        {
//            return null; // to be replaced by student code
        }
        public int getSubtreeSize()
        {
            return 42; // to be replaced by student code
        }
    }

}

