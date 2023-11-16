package VisualizerBST;

import AVL.AVLTree;
import BinarySearch.BinarySearchTree;

import javax.swing.*;
import java.awt.*;

public class TreeVisualizer extends JFrame {

    private BinarySearchTree<Integer> binarySearchTree;
    private AVLTree<Integer> avlTree;

    private JButton addButton;
    private JButton removeButton;
    private JButton searchButton;
    private JButton balanceButton;
    private TreePanel treePanel;

    public TreeVisualizer() {
        setTitle("Binary Search Visualizer DEMO");

        binarySearchTree = new BinarySearchTree<>();
        avlTree = new AVLTree<>();

        // Initialize buttons and other components
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");
        searchButton = new JButton("Search");
        balanceButton = new JButton("Balance");

        treePanel = new TreePanel(binarySearchTree, avlTree);

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(balanceButton);

        add(treePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);

        // Add action listeners to buttons
        addButton.addActionListener(e -> handleAdd());
        removeButton.addActionListener(e -> handleRemove());
        searchButton.addActionListener(e -> handleSearch());
        balanceButton.addActionListener(e -> handleBalance());

    }

    private void handleAdd() {
        // Implement logic to add a node to the tree
        // Update the drawing panel

        String inputValue = JOptionPane.showInputDialog("Enter the value to add:");
        if (inputValue != null && !inputValue.isEmpty()) {
            int value = Integer.parseInt(inputValue);

            binarySearchTree.insert(value);
            avlTree.insert(value);

            // Update the drawing panel
            treePanel.repaint();
        }
    }

    private void handleRemove() {
        // Implement logic to remove a node from the tree
        // Update the drawing panel

        String inputValue = JOptionPane.showInputDialog("Enter the value to remove:");
        if (inputValue != null && !inputValue.isEmpty()) {
            int value = Integer.parseInt(inputValue);

            binarySearchTree.delete(value);
            avlTree.delete(value);

            // Update the drawing panel
            treePanel.repaint();
        }
    }

    private void handleSearch() {
        // Implement logic to search for a node in the tree
        // Highlight the node on the drawing panel

        String inputValue = JOptionPane.showInputDialog("Enter the value to search:");
        if (inputValue != null && !inputValue.isEmpty()) {
            int value = Integer.parseInt(inputValue);

            boolean isFoundBST = binarySearchTree.search(value);
            boolean isFoundAVL = avlTree.search(value);

            if (isFoundBST) {
                JOptionPane.showMessageDialog(this, "Value found in Binary Search Tree");
            } else {
                JOptionPane.showMessageDialog(this, "Value not found in Binary Search Tree");
            }

            if (isFoundAVL) {
                JOptionPane.showMessageDialog(this, "Value found in AVL Tree");
            } else {
                JOptionPane.showMessageDialog(this, "Value not found in AVL Tree");
            }

            // Highlight the node on the drawing panel (you need to implement this)
            treePanel.repaint();
        }
    }

    private void handleBalance() {
        // Implement logic to balance the tree (for AVL tree)
        // Update the drawing panel

        // Balance the AVL tree
        // Note: Your AVL tree implementation might automatically balance itself
        // without the need for a separate balance operation.

        // Update the drawing panel
        treePanel.repaint();
    }

}
