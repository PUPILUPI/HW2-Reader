package ru.belov.readers;

import ru.belov.reactors.Reactor;

import java.util.Map;

public interface Reader {
    public abstract Map<String, Reactor> readFile(String fileName);
}
