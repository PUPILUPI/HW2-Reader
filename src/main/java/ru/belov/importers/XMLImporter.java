package ru.belov.importers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.belov.reactors.Reactor;
import ru.belov.readers.Reader;
import ru.belov.readers.XMLReader;

import java.util.Map;
@Component("XMLImporter")
public class XMLImporter extends Importer {
    public XMLImporter(@Qualifier("XMLReader") Reader reader) {
        this.setReader(reader);
    }

    @Override
    public Map<String, Reactor> readFile(String path) {
        if (path.endsWith(".xml")) {
            return this.getReader().readFile(path);
        }
        return this.getNeighbour().readFile(path);
    }
}
