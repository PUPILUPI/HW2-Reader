package org.example;

import org.example.exceptions.WrongFormatException;
import org.example.reactors.Reactor;
import org.example.reactors.ReactorLibrary;
import org.example.readers.Factory;
import org.example.readers.Reader;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class GUI extends JFrame implements ActionListener {
    private JPanel panelTop;
    private JButton chooseFile;
    private JButton renderTree;
    private JTextField fileName;
    private JScrollPane scrollPanel;
    private JTree tree;
    private DefaultTreeModel rootTree;
    private String selectedFileName;

    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        panelTop = new JPanel();
        panelTop.setPreferredSize(new Dimension(this.getWidth(), 50));
        panelTop.setLayout(new BorderLayout());

        chooseFile = new JButton("Choose file");
        renderTree = new JButton("Render tree");
        fileName = new JTextField();
        fileName.setEditable(false);
        fileName.setText("\\здесь будет выбранный файл\\");

        panelTop.add(chooseFile, BorderLayout.WEST);
        panelTop.add(renderTree, BorderLayout.EAST);
        panelTop.add(fileName, BorderLayout.CENTER);

        this.add(panelTop, BorderLayout.NORTH);
        this.tree = new JTree(rootTree);
        this.scrollPanel = new JScrollPane(tree);
        this.add(scrollPanel, BorderLayout.CENTER);

        chooseFile.addActionListener(this);
        renderTree.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooseFile) {
            chooseFileAction();
        } else if (e.getSource() == renderTree) {
            renderTreeAction();
        }
    }

    private void renderTreeAction() {
        ReactorLibrary reactorLibrary = null;
        try {
            Factory factory = new Factory();
            Reader reader = factory.createReader(selectedFileName);
            reactorLibrary = new ReactorLibrary(selectedFileName);
            reactorLibrary.setMap(reader.readFile(reactorLibrary.getSource()));
            for (Map.Entry<String, Reactor> entry : reactorLibrary.getMap().entrySet()) {
                System.out.println(entry.getValue());
            }
        }catch (NullPointerException e){
            JOptionPane.showMessageDialog(null,"Вы не выбрали файл!","Я понял", ERROR_MESSAGE);
        }catch (WrongFormatException e) {
            JOptionPane.showMessageDialog(null,"Вы выбрали некорректный формат","Я понял", ERROR_MESSAGE);
        }catch (RuntimeException e){
            JOptionPane.showMessageDialog(null,"Внутри файла бардак","Я понял", ERROR_MESSAGE);
        }

        rootTree = new DefaultTreeModel(addInfoToGUI(reactorLibrary));
        tree = new JTree();
        tree.setModel(rootTree);
        scrollPanel.setViewportView(tree);
    }

    private TreeNode addInfoToGUI(ReactorLibrary reactorLibrary) {
        DefaultMutableTreeNode main = new DefaultMutableTreeNode("Реакторы");
        for (Map.Entry<String, Reactor> entry : reactorLibrary.getMap().entrySet()) {
            main.add(entry.getValue().getNode());
        }
        return main;
    }

    private void chooseFileAction() {
        JFileChooser fileChooser =
                new JFileChooser("C:\\Users\\Xiaomi\\Desktop\\ReactorLibrary");

        int ret = fileChooser.showDialog(null, "Choose file");
        if (ret != JFileChooser.APPROVE_OPTION) {
            return;
        }
        selectedFileName = fileChooser.getSelectedFile().getAbsolutePath();
        System.out.println(selectedFileName);
        fileName.setText(selectedFileName);
    }
}
