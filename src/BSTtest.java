/*
 * Main testing class for BST
 * @author: USFCACS 245
 */
public class BSTtest {
    public static void main(String[] args) {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        BST<Integer> tree = new BST<Integer>();
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(4);
//        tree.print();
//        System.out.println();
        System.out.println("Tree: " + tree.toString());
        System.out.println("Range Sum: " + tree.rangeSum(1, 4));
        tree.delete(4);
        System.out.println("Tree after removing 4: " + tree.toString());

    }
}