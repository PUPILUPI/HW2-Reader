package ru.belov.importers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.belov.reactors.Reactor;

import java.util.Map;
@Component
public class ImporterBuilder {
    private final Importer xml;
    private final Importer yaml;
    private final Importer json;
    @Autowired
    public ImporterBuilder(@Qualifier("xMLImporter") Importer xml, @Qualifier("yAMLImporter") Importer yaml, @Qualifier("jSONImporter") Importer json) {
        this.xml = xml;
        this.yaml = yaml;
        this.json = json;
        this.json.setNeighbour(xml);
        this.xml.setNeighbour(yaml);
        this.yaml.setNeighbour(null);
    }
    public void setParam() {

    }

    public Map<String, Reactor> getData(String path) {
        return json.readFile(path);
    }
}
