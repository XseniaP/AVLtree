import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AVLTree
 * <p>
 * An implementation of a AVL Tree with
 * distinct integer keys and info
 */

public class AVLTree {

    AVLNode root;

    public AVLTree() {
        root = null;
    }


    public boolean empty() {

        return root == null;
    }

    /**
     * public String search(int k)
     * <p>
     * returns the info of an item with key k if it exists in the tree
     * otherwise, returns null
     */
    public String search(int k) {
        AVLNode temp = this.root;

        AVLNode where = findWhereToInsert(temp,k);
        if(where.right != null && where.right.key == k)
            return where.right.info;


        if(where.left != null && where.left.key == k)
            return where.left.info;

        if(where != null && where.key == k)
            return where.info;
        return null;
    }

    /**
     * public int insert(int k, String i)
     * <p>
     * inserts an item with key k and info i to the AVL tree.
     * the tree must remain valid (keep its invariants).
     * returns the number of rebalancing operations, or 0 if no rebalancing operations were necessary.
     * returns -1 if an item with key k already exists in the tree.
     */

    private AVLNode findWhereToInsert(AVLNode root, int k) {
        if (root == null)
            return root;

        if (k > root.key) {
            if (root.right != null)
                root = root.right;
            else
                return root;

            return findWhereToInsert(root, k);
        }

        if (k < root.key) {
            if (root.left != null)
                root = root.left;
            else
                return root;

            return findWhereToInsert(root, k);
        } else
            return root;
    }

    public int insert(int k, String i) {
        if (root == null) {
            root = new AVLNode(k, i);
            root.height = 1;
            return 0;
        } else {
            AVLNode toInsert = findWhereToInsert(root, k);

            if (k > toInsert.key) {
                AVLNode temp = new AVLNode(k, i);
                temp.setParent(toInsert);
                toInsert.right = temp;
            }

            if (k < toInsert.key) {
                AVLNode temp = new AVLNode(k, i);
                temp.setParent(toInsert);

                toInsert.left = temp;
            }
        }
        System.out.println();
        updateHeight(root);
        rebalance(root);
        return 0;
    }


    //node height = Height of its left subtree – Height of its right subtree

    void updateHeight(AVLNode root) {
        if (root == null)
            return;

        updateHeight(root.left);
        updateHeight(root.right);


        if (root.left == null && root.right == null)//leafs
            root.height = 1;

        if (root.left == null && root.right != null) { //right and not left

            root.height = root.right.height + 1;


            //do else
        }
        if (root.left != null && root.right == null) { //left and not right
            root.height = root.left.height + 1;

            //do else
        }
        if (root.left != null && root.right != null) {

            root.height = root.left.height > root.right.height ? root.left.height + 1 : root.right.height + 1;
        }
        System.out.println("Key: " + root.key + " - Height: " + root.height);
    }


    public int countBalanceFactor(AVLNode root){
        int balanceFactor = 0;
        if(root == null)
            return balanceFactor;
        if (root.left != null && root.right != null) {
            balanceFactor = root.left.height - root.right.height;

        }
        if (root.left == null && root.right != null) {
            balanceFactor = 0 - root.right.height;

        }

        if (root.left != null && root.right == null) {
            balanceFactor = root.left.height;

        }

        if (root.left == null && root.right == null) {
            balanceFactor = 0;

        }




        return balanceFactor;
    }

    public int rebalance(AVLNode root) {
        List factors = new ArrayList();
        factors.add(1);
        factors.add(-1);
        factors.add(0);


        if (root == null) {
            return 0;
        }

        int i = rebalance(root.left) + rebalance(root.right);

        int balanceFactor = countBalanceFactor(root);

        if (factors.contains(balanceFactor)) {
            //do nothing
        } else {


            switch (balanceFactor){
                case 2:{       //right rotation
                    System.out.println();
                    int balanceFactorOfRight = 0,balanceFactorOfLeft = 0;
                    balanceFactorOfLeft = countBalanceFactor(root.left);
                    balanceFactorOfRight = countBalanceFactor(root.right);
                    if(balanceFactorOfLeft == 1) //simple right rotation
                    {
                        rightRotation(root);
                    }
                    else
                    {

                        System.out.println("Left-Right rotation");
                        AVLNode tempA = root.left;
                        AVLNode tempB = root.left.right;

                        root.left = tempB;
                        tempB.parent = root;

                        tempA.parent = tempB;
                        tempB.left = tempA;
                        tempA.right = null;
                        updateHeight(this.root);
                        rightRotation(root);
                    }

                    break;
                }
                case -2:{       //left rotation
                    System.out.println();
                    int balanceFactorOfRight = 0,balanceFactorOfLeft = 0;
                    balanceFactorOfLeft = countBalanceFactor(root.left);
                    balanceFactorOfRight = countBalanceFactor(root.right);
                    if(balanceFactorOfRight == -1) //simple left
                    {
                        System.out.println("Left rotation");
                        leftRotation(root);
                    }
                    else {
                        System.out.println("Right-Left- Rotation");
                        AVLNode tempC = root.right;
                        AVLNode tempB = root.right.left;
                        root.right = tempB;
                        tempB.setParent(root);
                        tempB.right = tempC;
                        tempC.setParent(tempB);
                        tempC.setLeft(null);




                        updateHeight(this.root);
                        leftRotation(root);



                    }

                    System.out.println();



                    break;
                }
            }




//            if (root.left == null && root.right != null & root.right.right != null) //left rotation
//            {
//
//                leftRotation(root);
//                return 1;
//            }
//            if (root.right == null && root.left != null & root.left.left != null) //Right rotation
//            {
//                rightRotation(root);
//                return 1;
//            }
//            if (root.left != null && root.right == null && root.left.right != null && root.left.left == null) { //Left-Right Rotation
//
//                System.out.println("Left-Right rotation");
//                AVLNode tempA = root.left;
//                AVLNode tempB = root.left.right;
//                root.left = tempB;
//                tempB.parent = root;
//                tempA.parent = tempB;
//                tempB.left = tempA;
//                tempA.right = null;
//                updateHeight(this.root);
//                rightRotation(root);
//            }
//            if (root.left == null && root.right == null && root.left.right != null && root.left.left == null) { //Right-Left- Rotation
//
//                System.out.println("Right-Left- Rotation");
//                AVLNode tempA = root.left;
//                AVLNode tempB = root.left.right;
//                root.left = tempB;
//                tempB.parent = root;
//                tempA.parent = tempB;
//                tempB.left = tempA;
//                tempA.right = null;
//                updateHeight(this.root);
//                rightRotation(root);
//            }


        }


        return i + 1;
    }


    void leftRotation(AVLNode root) {
        System.out.println("Left rotation");
        boolean left = false;
        AVLNode parentOfRoot = root.parent;

        if(parentOfRoot != null) {
            if (parentOfRoot.right == root)
                left = false;
            else
                left = true;
        }

        AVLNode newRoot = root.right;
        newRoot.setParent(root.parent);
        root.setRight(null);
        newRoot.setLeft(root);
        root.setParent(newRoot);
        root = newRoot;

        if(parentOfRoot != null) {
            if (left)
                parentOfRoot.left = root;
            else
                parentOfRoot.right = root;
        }

        while (root.parent != null)
            root = root.parent;

        this.root = root;
        updateHeight(this.root);

    }

    void rightRotation(AVLNode root) {
        System.out.println("Right rotation");
//                    AVLNode temp = root;

        boolean left = false;
        AVLNode parentOfRoot = root.parent;
        if(parentOfRoot != null) {
            if (parentOfRoot.right == root)
                left = false;
            else
                left = true;
        }




        AVLNode newRoot = root.left;
        newRoot.setParent(root.parent);
        root.setLeft(null);
        newRoot.setRight(root);
        root.setParent(newRoot);
        root = newRoot;


        if(parentOfRoot != null) {
            if (left)
                parentOfRoot.left = root;
            else
                parentOfRoot.right = root;

        }


        while (root.parent != null)
            root = root.parent;

        this.root = root;
        updateHeight(this.root);
    }


    /**
     * public int delete(int k)
     * <p>
     * deletes an item with key k from the binary tree, if it is there;
     * the tree must remain valid (keep its invariants).
     * returns the number of rebalancing operations, or 0 if no rebalancing operations were needed.
     * returns -1 if an item with key k was not found in the tree.
     */
    public int delete(int k) {
        return 42;    // to be replaced by student code
    }

    /**
     * public String min()
     * <p>
     * Returns the info of the item with the smallest key in the tree,
     * or null if the tree is empty
     */
    public String min() {
        return "42"; // to be replaced by student code
    }

    /**
     * public String max()
     * <p>
     * Returns the info of the item with the largest key in the tree,
     * or null if the tree is empty
     */
    public String max() {
        return "42"; // to be replaced by student code
    }

    /**
     * public int[] keysToArray()
     * <p>
     * Returns a sorted array which contains all keys in the tree,
     * or an empty array if the tree is empty.
     */
    public int[] keysToArray() {
        int[] arr = new int[42]; // to be replaced by student code
        return arr;              // to be replaced by student code
    }

    /**
     * public String[] infoToArray()
     * <p>
     * Returns an array which contains all info in the tree,
     * sorted by their respective keys,
     * or an empty array if the tree is empty.
     */
    public String[] infoToArray() {
        String[] arr = new String[42]; // to be replaced by student code
        return arr;                    // to be replaced by student code
    }

    /**
     * public int size()
     * <p>
     * Returns the number of nodes in the tree.
     * <p>
     * precondition: none
     * postcondition: none
     */
    public int size() {

        return 0;
    }

    /**
     * public int getRoot()
     * <p>
     * Returns the root AVL node, or null if the tree is empty
     * <p>
     * precondition: none
     * postcondition: none
     */
    public IAVLNode getRoot() {
        if (root != null)
            return root;
        else
            return null;
    }

    /**
     * public string select(int i)
     * <p>
     * Returns the value of the i'th smallest key (return null if tree is empty)
     * Example 1: select(1) returns the value of the node with minimal key
     * Example 2: select(size()) returns the value of the node with maximal key
     * Example 3: select(2) returns the value 2nd smallest minimal node, i.e the value of the node minimal node's successor
     * <p>
     * precondition: size() >= i > 0
     * postcondition: none
     */
    public String select(int i) {
        return null;
    }

    /**
     * public int less(int i)
     * <p>
     * Returns the sum of all keys which are less or equal to i
     * i is not neccessarily a key in the tree
     * <p>
     * precondition: none
     * postcondition: none
     */
    public int less(int i) {
        return 0;
    }

    /**
     * public interface IAVLNode
     * ! Do not delete or modify this - otherwise all tests will fail !
     */
    public interface IAVLNode {
        public int getKey(); //returns node's key (for virtuval node return -1)

        public String getValue(); //returns node's value [info] (for virtuval node return null)

        public void setLeft(IAVLNode node); //sets left child

        public IAVLNode getLeft(); //returns left child (if there is no left child return null)

        public void setRight(IAVLNode node); //sets right child

        public IAVLNode getRight(); //returns right child (if there is no right child return null)

        public void setParent(IAVLNode node); //sets parent

        public IAVLNode getParent(); //returns the parent (if there is no parent return null)

        public boolean isRealNode(); // Returns True if this is a non-virtual AVL node

        public void setSubtreeSize(); // sets the number of real nodes in this node's subtree

        public int getSubtreeSize(); // Returns the number of real nodes in this node's subtree (Should be implemented in O(1))
    }

    /**
     * public class AVLNode
     * <p>
     * If you wish to implement classes other than AVLTree
     * (for example AVLNode), do it in this file, not in
     * another file.
     * This class can and must be modified.
     * (It must implement IAVLNode)
     */
    public class AVLNode implements IAVLNode {
        String info;
        int key;
        int height;
        AVLNode left, right, parent;

        public AVLNode(int _key) {
            key = _key;
            height = 0;
            info = "";
            left = null;
            right = null;
            parent = null;
        }

        public AVLNode(int _key, String _info) {
            key = _key;
            height = 0;
            info = _info;
            left = null;
            right = null;
            parent = null;
        }

        public AVLNode() {
            key = 0;
            height = 0;
            info = "";
            left = null;
            right = null;
            parent = null;
        }


        public int getKey() {
            return key; // to be replaced by student code
        }

        public String getValue() {
            return info; // to be replaced by student code
        }

        @Override
        public void setLeft(IAVLNode node) {
            left = (AVLNode) node;
        }

        public IAVLNode getLeft() {
            return left; // to be replaced by student code
        }

        @Override
        public void setRight(IAVLNode node) {
            right = (AVLNode) node;
        }

        public IAVLNode getRight() {
            return right;
        }

        @Override
        public void setParent(IAVLNode node) {
            parent = (AVLNode) node;
        }

        public IAVLNode getParent() {
            return parent; // to be replaced by student code
        }

        // Returns True if this is a non-virtual AVL node
        public boolean isRealNode() {
            return true; // to be replaced by student code
        }

        public void setSubtreeSize() {
//            return null; // to be replaced by student code
        }

        public int getSubtreeSize() {
            return 42; // to be replaced by student code
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int _height) {
            height = _height;
        }
    }

}


