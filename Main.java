public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");


        AVLTree tree = new AVLTree();


//        tree.insert(10, "bla");    //test for left rotation
//        tree.insert(15, "mla");
//        tree.insert(20, "wow");

//        tree.insert(10, "bla"); //test for right rotation
//        tree.insert(8,"bla");
//        tree.insert(6,"bla");


//        tree.insert(10, "bla"); //test for Left-Right  rotation
//        tree.insert(8,"wow");
//        tree.insert(9,"kak");

//        tree.insert(10, "bla"); //test for Right-Left  rotation
//        tree.insert(15,"mla");
//        tree.insert(14,"opa");


        tree.insert(14,"fourteen");
        tree.insert(12,"twelve");
        tree.insert(11,"eleven");
        tree.insert(9,"nine");
        tree.insert(16,"sixteen");
        tree.insert(21,"twenty one");
        tree.insert(8,"eight");
        tree.insert(18,"eighteen");
        tree.insert(10,"ten");
        tree.insert(17,"seventeen");

        tree.insert(13,"Thirteen");
        tree.insert(15,"Fifteen");


//        String val = tree.search(181);
//        System.out.println(val);

//
//        String min = tree.min();
//        System.out.println("Min:" + min);

        //
//        String max = tree.max();
//        System.out.println("Max:" + max);


        int arr[] = tree.keysToArray();


        String[] arrInfo = tree.infoToArray();

        System.out.println("Size:" + tree.size());


        AVLTree.IAVLNode temp = tree.getRoot();

//        String temp1 = tree.select(10);
//        System.out.println("Select 10 ->" + temp1);
//        temp1 = tree.select(1);
//        System.out.println("Select 1 ->" + temp1);

//        System.out.println(tree.less(9));

//        tree.delete(8); //delete leaf --- good
//        tree.delete(11);
//        tree.delete(16);
//          tree.delete(9);
//        tree.delete(12);
//         tree.delete(21);
        printTree(tree.root);

    }

    static void printTree(AVLTree.AVLNode root) {
        if(root == null)
            return;
        System.out.println("Key:" + root.key);
        printTree(root.left);

        printTree(root.right);

    }


}
