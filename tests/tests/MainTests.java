package tests;

import com.company.FileNameRefactor;
import com.company.Main;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTests {

    FileNameRefactor fileNameRefactor;

    @Test
    public void runTest() {
        Main.main(new String[]{"C:\\Users\\artak\\Exercism\\java\\NameConv\\AudioBoksChangeNames\\9788366155800"});
    }

    //@Ignore
    @Test
    public void readingRealAudiobooks() {
        List<String> expectedFileNames = new ArrayList<>();
        expectedFileNames.add("1   Cz4 Jak się masz Cukierku  Gwiazda reklamy.mp3");
        expectedFileNames.add("2   Cz4 Jak się masz Cukierku  Postrzyzyny.mp3");
        expectedFileNames.add("3   Cz4 Jak się masz Cukierku  Operacja Dzien Matki.mp3");
        expectedFileNames.add("4   Cz4 Jak się masz Cukierku  Bajka o zarlocznym kocie.mp3");
        expectedFileNames.add("5   Cz4 Jak się masz Cukierku  Wszystkiego najmialczniejszego.mp3");
        expectedFileNames.add("6   Cz4 Jak się masz Cukierku  Kot do wynajecia.mp3");
        expectedFileNames.add("7   Cz4 Jak się masz Cukierku  Przybleda.mp3");
        expectedFileNames.add("8   Cz4 Jak się masz Cukierku  Tradycja.mp3");
        expectedFileNames.add("9   Cz4 Jak się masz Cukierku  Nieoczekiwane skutki czatowania.mp3");

        List<String> actualNames = null;
        try {
            fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudiobooksToTest\\9788366155749");
            actualNames = fileNameRefactor.getSortedFilenames();
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
        }

        assertEquals(expectedFileNames, actualNames);
    }



    @Test (expected = FileNotFoundException.class)
    public void throwExeptionIfNoFiles() throws FileNotFoundException {
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudiobooksEmpytFolder\\9788366155800");
        try {
            fileNameRefactor.getSortedFilenames();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwExeptionIfNotADriedcotry() {
        try {
            FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\README");
            try {
                fileNameRefactor.getSortedFilenames();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = NullPointerException.class)
    public void throwExceptionIfNoDirectoryFound() throws NullPointerException {
        try {
            FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\NotADirectory");
            try {
                fileNameRefactor.getSortedFilenames();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test (expected = IllegalArgumentException.class)
    public void throwExeptionIfFolderDoedNotHaveIsbnInName() throws IllegalArgumentException {
        try {
            FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudiobooksToTest");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test (expected = IllegalArgumentException.class)
    public void throwExeptionIfFolderDoedNotHaveValidIsbnInName() throws IllegalArgumentException {
        try {
            FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\9999999999999");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getBookBeatNamesFromNamesCukierekTest() throws FileNotFoundException {
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\9788366155749");
        List<String> fileNames = null;
        try {
            fileNames = fileNameRefactor.getSortedFilenames();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> newFileNames = fileNameRefactor.getBookBeatNamesFrom(fileNames);

        List<String> expectedFileNames = new ArrayList<>();
        expectedFileNames.add("9788366155749_1_9.mp3");
        expectedFileNames.add("9788366155749_2_9.mp3");
        expectedFileNames.add("9788366155749_3_9.mp3");
        expectedFileNames.add("9788366155749_4_9.mp3");
        expectedFileNames.add("9788366155749_5_9.mp3");
        expectedFileNames.add("9788366155749_6_9.mp3");
        expectedFileNames.add("9788366155749_7_9.mp3");
        expectedFileNames.add("9788366155749_8_9.mp3");
        expectedFileNames.add("9788366155749_9_9.mp3");

        assertEquals(expectedFileNames, newFileNames);
    }

    @Test
    public void getBookBeatNamesFromNiewinniNamesTest() throws FileNotFoundException {
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\9788366155800");
        List<String> fileNames = null;
        try {
            fileNames = fileNameRefactor.getSortedFilenames();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> newFileNames = fileNameRefactor.getBookBeatNamesFrom(fileNames);

        List<String> expectedFileNames = new ArrayList<>();
        expectedFileNames.add("9788366155800_01_15.mp3");
        expectedFileNames.add("9788366155800_02_15.mp3");
        expectedFileNames.add("9788366155800_03_15.mp3");
        expectedFileNames.add("9788366155800_04_15.mp3");
        expectedFileNames.add("9788366155800_05_15.mp3");
        expectedFileNames.add("9788366155800_06_15.mp3");
        expectedFileNames.add("9788366155800_07_15.mp3");
        expectedFileNames.add("9788366155800_08_15.mp3");
        expectedFileNames.add("9788366155800_09_15.mp3");
        expectedFileNames.add("9788366155800_10_15.mp3");
        expectedFileNames.add("9788366155800_11_15.mp3");
        expectedFileNames.add("9788366155800_12_15.mp3");
        expectedFileNames.add("9788366155800_13_15.mp3");
        expectedFileNames.add("9788366155800_14_15.mp3");
        expectedFileNames.add("9788366155800_15_15.mp3");

        assertEquals(expectedFileNames, newFileNames);
    }

    @Ignore
    @Test
    public void changeNamesInFolderTest() throws IOException {
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudioBoksChangeNames\\9788366155800");
        List<String> fileNames;
        fileNames = fileNameRefactor.getSortedFilenames();
        List<String> expectedFileNames = fileNameRefactor.getBookBeatNamesFrom(fileNames);
        fileNameRefactor.changeNamesInFolder(expectedFileNames);

        List<String> accualFileNames = new ArrayList<>();
        File folder = new File("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudioBoksChangeNames\\9788366155800");
        for (File file : folder.listFiles()) {
            accualFileNames.add(file.getName());
        }
        assertEquals(expectedFileNames, accualFileNames);
    }

    @Ignore
    @Test (expected = IOException.class)
    public void changeNamesInFolderExceptionsTest() throws IOException {
        try {
            changeNamesInFolderTest();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudioBoksChangeNames\\9788366155800");
        List<String> fileNames;
        fileNames = fileNameRefactor.getSortedFilenames();
        List<String> expectedFileNames = fileNameRefactor.getBookBeatNamesFrom(fileNames);
        fileNameRefactor.changeNamesInFolder(expectedFileNames);
    }
}
