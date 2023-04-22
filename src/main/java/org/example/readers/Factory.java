package org.example.readers;

import org.example.exceptions.WrongFormatException;

import javax.swing.*;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Factory {
    public Reader createReader(String fileName) throws WrongFormatException {
        Reader reader = null;
        if (fileName.endsWith(".json")) {
            reader = new JSONReader();
        } else if (fileName.endsWith(".xml")) {
            reader = new XMLReader();
        } else if (fileName.endsWith(".yaml")) {
            reader = new YAMLReader();
        } else {
//            throw new WrongFormatException();

        }
        return reader;
    }
}
