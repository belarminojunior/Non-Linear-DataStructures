package VisualizerBST;

import AVL.AVLTree;
import BinarySearch.BSTNode;
import BinarySearch.BinarySearchTree;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {

    private static final int NODE_RADIUS = 20; // Radius of the tree nodes
    private static final int HORIZONTAL_SPACING = 50; // Horizontal spacing between nodes
    private static final int VERTICAL_SPACING = 50; // Vertical spacing between levels

    private BinarySearchTree<Integer> binarySearchTree;
    private AVLTree<Integer> avlTree;

    public TreePanel(BinarySearchTree<Integer> binarySearchTree, AVLTree<Integer> avlTree) {
        this.binarySearchTree = binarySearchTree;
        this.avlTree = avlTree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the tree starting from the root
        if (binarySearchTree.getRoot() != null) {
            drawNode(g, getWidth() / 2, 50, binarySearchTree.getRoot(), true);
        }

        if (avlTree.getRoot() != null) {
            drawNode(g, getWidth() / 2, getHeight() / 2 + 100, avlTree.getRoot(), true);
        }
    }

    private void drawNode(Graphics g, int x, int y, BSTNode<Integer> node, boolean isBST) {
        // Draw the node
        g.setColor(Color.BLACK);
        g.drawOval(x - NODE_RADIUS, y - NODE_RADIUS, NODE_RADIUS * 2, NODE_RADIUS * 2);
        g.drawString(node.getKey().toString(), x - 5, y + 5);

        // Draw lines to left and right children, if they exist
        if (node.getLeft() != null) {
            int xLeft = x - HORIZONTAL_SPACING / 2;
            int yLeft = y + VERTICAL_SPACING;
            g.drawLine(x, y, xLeft, yLeft);
            drawNode(g, xLeft, yLeft, node.getLeft(), isBST);
        }

        if (node.getRight() != null) {
            int xRight = x + HORIZONTAL_SPACING / 2;
            int yRight = y + VERTICAL_SPACING;
            g.drawLine(x, y, xRight, yRight);
            drawNode(g, xRight, yRight, node.getRight(), isBST);
        }

        // If it's an AVL tree, draw the balance factor
        if (!isBST) {
            g.drawString("Balance: " + avlTree.balanceFactor(node), x - 20, y - 20);
        }
    }

}
