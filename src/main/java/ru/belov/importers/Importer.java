package ru.belov.importers;

import ru.belov.reactors.Reactor;
import ru.belov.readers.Reader;

import java.io.IOException;
import java.util.Map;

public abstract class Importer {
    private Importer neighbour;
    private Reader reader;

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Importer getNeighbour() {
        return neighbour;
    }

    public void setNeighbour(Importer neighbour) {
        this.neighbour = neighbour;
    }

    public abstract Map<String, Reactor> readFile(String path) throws IOException;
}
