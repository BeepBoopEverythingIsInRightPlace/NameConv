package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.MissingFormatArgumentException;

public class Main {
    static String path;

    public static void main(String[] args) {

        try {
            checkPathArgument(args);

        } catch (MissingFormatArgumentException e) {
            System.err.println("Brak ścieżki");
        }

        try {
            changeFilenamesToBookBeat();

            System.out.println("Zmieniono nazwy plików.");
        } catch (FileNotFoundException e) {
            System.err.println("Brak plików w folderze.");
        } catch (IOException e) {
            System.err.println("Błąd przy zapisie nowych nazw plików");
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException ee){
            System.err.println("Podana ścieżka prowadzi do pliku, nie do folderu");
        } catch (NullPointerException eee) {
            System.err.println("Nie ma takiego folderu");
        }

    }

    private static void changeFilenamesToBookBeat() throws IOException {
        List<String> filenames;
        FileNameRefactor fileNameRefactor;

        fileNameRefactor = new FileNameRefactor(path);
        filenames = fileNameRefactor.getSortedFilenames();
        filenames = fileNameRefactor.getBookBeatNamesFrom(filenames);
        fileNameRefactor.changeNamesInFolder(filenames);
    }

    private static void checkPathArgument(String[] args) throws MissingFormatArgumentException {
        if (args.length < 1)
            throw new MissingFormatArgumentException("Brak ścieżki");
        path = args[0];
    }
}
