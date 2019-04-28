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


        tree.insert(14,"forteen");
        tree.insert(12,"twelve");
        tree.insert(11,"eleven");
        tree.insert(9,"nine");
        tree.insert(16,"sixtieen");
        tree.insert(21,"twentyone");
        tree.insert(8,"eight");
        tree.insert(18,"eighteen");
        tree.insert(10,"ten");
        tree.insert(17,"seventeen");


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

//        printTree(tree.root);
    }

    static void printTree(AVLTree.AVLNode root) {
        if(root == null)
            return;
        System.out.println("Key:" + root.key);
        printTree(root.left);

        printTree(root.right);

    }


}
