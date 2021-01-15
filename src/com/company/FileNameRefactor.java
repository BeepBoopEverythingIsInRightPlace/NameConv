package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileNameRefactor {
    private String filePath;
    private File folder;

    public FileNameRefactor(String filePath) throws FileNotFoundException, IllegalArgumentException, NullPointerException {
        folder = new File(filePath);
        exeptionsIfBad(folder);
        this.filePath = filePath;
    }

    public List<String> getSortedFilenames() {
        List<String> fileNames = Arrays.asList(folder.list().clone());
        fileNames.sort(String::compareTo);
        return fileNames;
    }

    private void exeptionsIfBad(File folder) throws FileNotFoundException {
        if (!folder.exists())
            throw new NullPointerException("No such directory");

        if (!folder.isDirectory())
            throw new IllegalArgumentException("Path is leading to file, not to directory");

        if (!folder.getName().matches("^\\d{13}$") || !isISBN13(folder.getName()))
            throw new IllegalArgumentException("Folder Name is not an ISBN");

        File[] filesInFolder = folder.listFiles();
        if (filesInFolder == null || filesInFolder.length < 1)
            throw new FileNotFoundException("No files in folder");
    }

    private boolean isISBN13(String number) {
        int sum = 0;
        int multiple;
        char ch;
        int digit;

        // add digits
        for (int i = 1; i <= 13; i++) {

            if (i % 2 == 0)
                multiple = 3;
            else multiple = 1;

            ch = number.charAt(i - 1);
            digit = Character.getNumericValue(ch);
            sum += (multiple * digit);
        }
        // check sum
        return sum % 10 == 0;
    }

    public List<String> getBookBeatNamesFrom(List<String> fileNames) {
        return null;
    }
}
