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


        tree.insert(14,"mil");
        tree.insert(12,"bla");
        tree.insert(11,"mak");
        tree.insert(9,"cak");
        tree.insert(16,"for");
        tree.insert(21,"mor");
        tree.insert(8,"mof");
        tree.insert(18,"bax");
        tree.insert(10,"asd");
        tree.insert(17,"opa");


//        String val = tree.search(181);
//        System.out.println(val);

//
//        String min = tree.min();
//        System.out.println("Min:" + min);

        //
//        String max = tree.max();
//        System.out.println("Max:" + max);


        int arr[] = tree.keysToArray();




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
