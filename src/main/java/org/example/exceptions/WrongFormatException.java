package org.example.exceptions;

public class WrongFormatException extends ReactorLibraryException {
    public WrongFormatException(String format) {
        super("ВЫ выбрали неверный формат: " + format);
    }
}
