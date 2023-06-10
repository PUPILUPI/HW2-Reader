package ru.belov.reactors;

import java.util.Map;

public class ReactorLibrary {
    private String source;
    private Map<String, Reactor> map;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, Reactor> getMap() {
        return map;
    }

    public void setMap(Map<String, Reactor> map) {
        this.map = map;
    }

    public ReactorLibrary(String source) {
        this.source = source;
    }
}
