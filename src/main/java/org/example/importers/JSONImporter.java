package org.example.importers;

import org.example.reactors.Reactor;
import org.example.readers.JSONReader;

import java.util.Map;

public class JSONImporter extends Importer {
    public JSONImporter() {
        setReader(new JSONReader());
    }

    @Override
    public Map<String, Reactor> readFile(String path) {
        if (path.endsWith(".json")) {
            return this.getReader().readFile(path);
        }
        return this.getNeighbour().readFile(path);
    }
}
