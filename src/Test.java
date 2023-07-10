import datastructures.BinarySearchTree;

public class Test {
    public static void main(String[] args) {

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(8);
        tree.insert(4);
        tree.insert(3);
        tree.insert(9);
        tree.insert(0);
        tree.insert(10);

        System.out.println(tree.size());
        System.out.println(tree.height());

    }
}
