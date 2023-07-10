package datastructures;

import interfaces.BSTInterface;
import nodes.BSTNode;

public class BinarySearchTree<T extends Comparable> implements BSTInterface<T> {

    protected BSTNode<T> root;

    public BSTNode<T> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<T> root) {
        this.root = root;
    }


    /*
        Operations
    */

    private BSTNode<T> insert(BSTNode root, T element) {

        if (root == null)
            return new BSTNode<>(element);

        if (element.compareTo(root.getKey()) < 0)
            root.left = insert(root.getLeft(), element);

        if (element.compareTo(root.getKey()) > 0)
            root.right = insert(root.getRight(), element);

        return root;
    }

    private BSTNode<T> delete(BSTNode<T> root, T element) {
        if (root == null)
            return root;

        if (element.compareTo(root.getLeft()) < 0)
            root.left = delete(root.left, element);
        else if (element.compareTo(root.getRight()) > 0)
            root.right = delete(root.right, element);
        else {

            // No child, or single child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Two children
            BSTNode<T> successor = minimum(root.right);
            root.setKey(successor.getKey());
            root.right = delete(root.right, successor.getKey());
        }

        return root;
    }

    protected BSTNode<T> minimum(BSTNode<T> root) {
        while(root.left != null)
            root = root.left;

        return root;
    }

    private BSTNode<T> search(BSTNode<T> root, T element) {
        if (root == null || root.getKey().equals(element))
            return root;

        if (element.compareTo(root.getKey()) < 0)
            return search(root.left, element);

        return search(root.right, element);
    }

    public void printPreOrder(BSTNode<T> root) {
        if (root == null)
            return;

        System.out.println(root.getKey());
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    public void printInOrder(BSTNode<T> root) {
        if (root == null)
            return;

        printInOrder(root.left);
        System.out.println(root.getKey());
        printInOrder(root.right);
    }

    public void printPosOrder(BSTNode<T> root) {
        if (root == null)
            return;

        printInOrder(root.left);
        printInOrder(root.right);
        System.out.println(root.getKey());
    }

    private int countNodes(BSTNode<T> root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int treeHeight(BSTNode<T> root) {
        if (root == null)
            return 0;
        return 1 + Math.max(treeHeight(root.left), treeHeight(root.right));
    }

    @Override
    public void insert(T element) {
        root = insert(root, element);
    }

    @Override
    public void delete(T element) {
        root = delete(root, element);
    }

    @Override
    public int size() {
        return countNodes(root);
    }

    @Override
    public int height() {
        return treeHeight(root);
    }

    @Override
    public boolean search(T element) {
        return search(root, element) != null;
    }
}
