package ru.belov.readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import ru.belov.reactors.Reactor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component("JSONReader")
public class JSONReader implements Reader {
    @Override
    public Map<String, Reactor> readFile(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Reactor> map;
        map = objectMapper.readValue(new File(fileName), new TypeReference<>() {
        });

        return map;
    }
}
