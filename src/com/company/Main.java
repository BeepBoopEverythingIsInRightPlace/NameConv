package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> filenames = new ArrayList<>();
        FileNameRefactor fileNameRefactor;
        try {
            fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudiobooksToTest\\9788366155749");
            filenames = fileNameRefactor.getSortedFilenames();
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("Brak plików w folderze.");
        } catch (IllegalArgumentException ee){
            System.err.println("Podana ścieżka prowadzi do pliku, nie do folderu");
        } catch (NullPointerException eee) {
            System.err.println("Nie ma takiego folderu");
        }

        System.out.println(filenames);
    }
}
