package readers;

import reactors.Reactor;

import java.io.IOException;
import java.util.Map;

public abstract class Reader {
    public abstract Map<String, Reactor> readFile(String fileName);
}
