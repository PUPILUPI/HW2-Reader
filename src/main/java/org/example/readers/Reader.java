package org.example.readers;

import org.example.reactors.Reactor;

import java.util.Map;

public abstract class Reader {
    public abstract Map<String, Reactor> readFile(String fileName);
}
