import datastructures.BinarySearchTree;

public class Test {
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(2);
        tree.insert(5);

        System.out.println(tree.getRoot());

    }
}
