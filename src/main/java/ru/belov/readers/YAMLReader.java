package ru.belov.readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.stereotype.Component;
import ru.belov.reactors.Reactor;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component("YAMLReader")
public class YAMLReader implements Reader {
    @Override
    public Map<String, Reactor> readFile(String fileName) throws IOException {

        Map<String, Reactor> map;
        YAMLMapper mapper = new YAMLMapper();
        map = mapper.readValue(new File(fileName), new TypeReference<>() {
        });
        return map;
    }
}
