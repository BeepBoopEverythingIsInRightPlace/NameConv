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
            System.err.println("Path missing");
        }

        try {
            changeFilenamesToBookBeat();

            System.out.println("Files names has been changed.");
        } catch (FileNotFoundException e) {
            System.err.println("No files in folder.");
        } catch (IOException e) {
            System.err.println("Something went wrong during saving files names");
            System.err.println(e.getMessage());
        } catch (IllegalArgumentException ee){
            System.err.println("The path leads fo file, not to folder.");
        } catch (NullPointerException eee) {
            System.err.println("No such folder.");
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
            throw new MissingFormatArgumentException("Path missing");
        path = args[0];
    }
}
