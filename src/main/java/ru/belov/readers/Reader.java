package ru.belov.readers;

import ru.belov.reactors.Reactor;

import java.util.Map;

public abstract class Reader {
    public abstract Map<String, Reactor> readFile(String fileName);
}
