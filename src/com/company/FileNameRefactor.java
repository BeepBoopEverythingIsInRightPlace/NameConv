package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameRefactor {
    private final String filePath;
    private final File folder;
    private final String filesExtension;

    public FileNameRefactor(String filePath) throws FileNotFoundException, IllegalArgumentException, NullPointerException {
        folder = new File(filePath);
        exeptionsIfBad(folder);
        this.filePath = filePath;

        String extension = folder.list()[0];
        this.filesExtension = extension.substring(extension.length() - 4); //get .mp3 from first file
    }

    public List<String> getSortedFilenames() throws IOException {
        List<String> fileNames = Arrays.asList(folder.list().clone());
        if (alreadyExist(fileNames))
            throw new IOException("Those files already exist");

        fileNames.sort(String::compareTo);
        return fileNames;
    }


    public List<String> getBookBeatNamesFrom(List<String> fileNames) {
        List<String> fileNumbers = new ArrayList<>();
        getFileNumbers(fileNames, fileNumbers);

        List<String> newFileNames = new ArrayList<>();
        makeBookBeatFormatNames(fileNumbers, newFileNames);
        return newFileNames;
    }

    private void getFileNumbers(List<String> fileNames, List<String> fileNumbers) {
        Pattern pattern = Pattern.compile("^\\d{1,4}");
        for (String fileName : fileNames) {
            Matcher matcher = pattern.matcher(fileName);
            if (matcher.find())
                fileNumbers.add(matcher.group());
        }
    }

    private void makeBookBeatFormatNames(List<String> fileNumbers, List<String> newFileNames) {
        for (String fileNumber : fileNumbers) {
            String tmpName = folder.getName() +
                    "_" +
                    fileNumber +
                    "_" +
                    fileNumbers.size() +
                    filesExtension;
            newFileNames.add(tmpName);
        }
    }


    public void changeNamesInFolder(List<String> newFileNames) throws IOException {
        Iterator<String> fileName = newFileNames.iterator();
        for (File file : folder.listFiles()) {
            File newFile = new File(filePath.concat("\\").concat(fileName.next()));
            if (newFile.exists())
                throw new IOException("This files already exist");
            boolean success = file.renameTo(newFile);

            if (!success)
                throw new IOException("Something went wrong during file renaming");
        }
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

    private boolean alreadyExist(List<String> fileNames) {
        return fileNames.get(0).substring(0,13).equals(folder.getName());
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
}
