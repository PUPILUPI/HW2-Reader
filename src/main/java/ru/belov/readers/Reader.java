package ru.belov.readers;

import ru.belov.reactors.Reactor;

import java.io.IOException;
import java.util.Map;

public interface Reader {
    Map<String, Reactor> readFile(String fileName) throws IOException;
}
