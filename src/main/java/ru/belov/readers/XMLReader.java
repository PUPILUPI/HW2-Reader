package ru.belov.readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.belov.reactors.Reactor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class XMLReader extends Reader {
    @Override
    public Map<String, Reactor> readFile(String fileName) {
        Map<String, Reactor> map;
        XmlMapper mapper = new XmlMapper();
        try {
            map = mapper.readValue(new File(fileName), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}