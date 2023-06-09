package ru.belov.importers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.belov.exceptions.WrongFormatException;
import ru.belov.reactors.Reactor;
import ru.belov.readers.Reader;

import java.io.IOException;
import java.util.Map;
@Component("YAMLImporter")
public class YAMLImporter extends Importer {
    public YAMLImporter(@Qualifier("YAMLReader")Reader reader) {
        this.setReader(reader);
    }

    @Override
    public Map<String, Reactor> readFile(String path) throws IOException {
        if (path.endsWith(".yaml")) {
            return this.getReader().readFile(path);
        } else {
            String[] splitPath= path.split("\\.");
            throw new WrongFormatException(splitPath[splitPath.length-1]);
        }
    }

}
