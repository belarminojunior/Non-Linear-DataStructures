package datastructures;

import nodes.BSTNode;

public class AVLTree<T extends Comparable> extends BinarySearchTree<T> {

    protected BSTNode<T> insert(BSTNode<T> root, T element) {

        if (root == null)
            return new BSTNode<>(element);

        if (element.compareTo(root.getKey()) < 0)
            root.left = insert(root.left, element);

        else if (element.compareTo(root.getKey()) > 0)
            root.right = insert(root.right, element);

        else
            return root;

        updateHeight(root);
        int balance = balanceFactor(root);

        // If the node becomes unbalanced, then there are 4 cases:

        // LL Case
        if (balance > 1 && element.compareTo(root.left.getKey()) < 0)
            return rotateRight(root);

        // RR Case
        if (balance < -1 && element.compareTo(root.right.getKey()) > 0)
            return rotateLeft(root);

        // LR Case
        if (balance > 1 && element.compareTo(root.left.getKey()) > 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // RL Case
        if (balance < -1 && element.compareTo(root.right.getKey()) < 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    protected BSTNode<T> delete(BSTNode<T> root, T element) {
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

        updateHeight(root);
        int balance = balanceFactor(root);

        // LL Case
        if (balance > 1 && balanceFactor(root.left) >= 0)
            return rotateRight(root);

        // LR Case
        if (balance > 1 && balanceFactor(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // RR Case
        if (balance < -1 && balanceFactor(root.right) <= 0)
            return rotateLeft(root);

        if (balance < -1 && balanceFactor(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    public int height() {
        return height(root);
    }

    private int height(BSTNode<T> node) {
        if (node == null)
            return 0;
        return node.getHeight();
    }

    private int balanceFactor(BSTNode<T> node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    private void updateHeight(BSTNode<T> node) {
        int height = 1 + Math.max(height(node.left), height(node.right));
        node.setHeight(height);
    }

    /*

             y                               x
            / \     Right Rotation          /  \
           x   T3   - - - - - - - >        T1   y
          / \       < - - - - - - -            / \
         T1  T2     Left Rotation            T2  T3

        Keys in both of the above trees follow the following order
        keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)
        So BST property is not violated anywhere.

     */

    public BSTNode<T> rotateLeft(BSTNode<T> x) {

        BSTNode<T> y = x.right;
        BSTNode<T> T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;

    }

    public BSTNode<T> rotateRight(BSTNode<T> y) {

        BSTNode<T> x = y.left;
        BSTNode<T> T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;

    }


}
