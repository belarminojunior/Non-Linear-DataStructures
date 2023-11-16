package BinarySearch;

import VisualizerBST.TreeVisualizer;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TreeVisualizer visualizer = new TreeVisualizer();
            visualizer.setSize(800, 600);
            visualizer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            visualizer.setVisible(true);
        });

    }
}
