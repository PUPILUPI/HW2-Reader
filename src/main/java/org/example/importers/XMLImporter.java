package org.example.importers;

import org.example.reactors.Reactor;
import org.example.readers.XMLReader;

import java.util.Map;

public class XMLImporter extends Importer {
    public XMLImporter() {
        setReader(new XMLReader());
    }

    @Override
    public Map<String, Reactor> readFile(String path) {
        if (path.endsWith(".xml")) {
            return this.getReader().readFile(path);
        }
        return this.getNeighbour().readFile(path);
    }
}
