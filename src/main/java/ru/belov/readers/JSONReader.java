package ru.belov.readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.belov.reactors.Reactor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSONReader extends Reader {
    @Override
    public Map<String, Reactor> readFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Reactor> map;
        try {map = objectMapper.readValue(new File(fileName), new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
