package ru.belov.importers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.belov.exceptions.WrongFormatException;
import ru.belov.reactors.Reactor;
import ru.belov.readers.Reader;

import java.util.Map;
@Component
public class YAMLImporter extends Importer {
    public YAMLImporter(@Qualifier("yAMLReader")Reader reader) {
        this.setReader(reader);
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
