package org.example.importers;

import org.example.exceptions.WrongFormatException;
import org.example.reactors.Reactor;
import org.example.readers.JSONReader;
import org.example.readers.YAMLReader;

import java.util.Map;

public class YAMLImporter extends Importer {
    public YAMLImporter() {
        setReader(new YAMLReader());
    }

    @Override
    public Map<String, Reactor> readFile(String path) {
        if (path.endsWith(".yaml")) {
            return this.getReader().readFile(path);
        } else {
            String[] split = path.split("\\.");
            throw new WrongFormatException(split[split.length - 1]);
        }

    }
}
