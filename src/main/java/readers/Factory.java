package readers;

import exceptions.WrongFormatException;
import reactors.ReactorLibrary;

public class Factory {
    public Reader createReader(String fileName) throws WrongFormatException {
        Reader reader = null;
        if (fileName.endsWith(".json")){
            reader = new JSONReader();
        }else if (fileName.endsWith(".xml")){
            reader = new XMLReader();
        }else if(fileName.endsWith(".yaml")){
            reader = new YAMLReader();
        }else{
            throw new WrongFormatException();
        }
        return reader;
    }
}
