package ru.belov.importers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.belov.reactors.Reactor;
import ru.belov.readers.Reader;

import java.io.IOException;
import java.util.Map;
@Component("JSONImporter")
public class JSONImporter extends Importer {
    public JSONImporter(@Qualifier("JSONReader") Reader reader) {
        this.setReader(reader);
    }

    @Override
    public Map<String, Reactor> readFile(String path) throws IOException {
        if (path.endsWith(".json")) {
            return this.getReader().readFile(path);
        }
        return this.getNeighbour().readFile(path);
    }
}
