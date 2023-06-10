package ru.belov.importers;

import ru.belov.exceptions.WrongFormatException;
import ru.belov.reactors.Reactor;
import ru.belov.readers.YAMLReader;

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
            throw new WrongFormatException("ld;d");
        }
    }

}
