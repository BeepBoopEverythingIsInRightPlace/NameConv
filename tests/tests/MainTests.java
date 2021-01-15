package tests;

import com.company.FileNameRefactor;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTests {

    FileNameRefactor fileNameRefactor;

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

        List<String> accualNames = null;
        try {
            fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\AudiobooksToTest\\9788366155749");
            accualNames = fileNameRefactor.getSortedFilenames();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assertEquals(expectedFileNames, accualNames);
    }



    @Test (expected = FileNotFoundException.class)
    public void throwExeptionIfNoFiles() throws FileNotFoundException {
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\9788366155749");
        fileNameRefactor.getSortedFilenames();
    }

    @Test (expected = IllegalArgumentException.class)
    public void throwExeptionIfNotADriedcotry() {
        try {
            FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\README");
            fileNameRefactor.getSortedFilenames();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test (expected = NullPointerException.class)
    public void throwExceptionIfNoDirectoryFound() throws NullPointerException {
        try {
            FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\NotADirectory");
            fileNameRefactor.getSortedFilenames();
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
    public void getBookBeatNamesFromNamesTest() throws FileNotFoundException {
        FileNameRefactor fileNameRefactor = new FileNameRefactor("C:\\Users\\artak\\Exercism\\java\\NameConv\\9788366155749");
        List<String> fileNames;
        fileNames = fileNameRefactor.getSortedFilenames();
        List<String> newFileNames = fileNameRefactor.getBookBeatNamesFrom(fileNames);

        List<String> expectedFileNames = new ArrayList<>();
        expectedFileNames.add("9788366155749_001_009");
        expectedFileNames.add("9788366155749_002_009");
        expectedFileNames.add("9788366155749_003_009");
        expectedFileNames.add("9788366155749_004_009");
        expectedFileNames.add("9788366155749_005_009");
        expectedFileNames.add("9788366155749_006_009");
        expectedFileNames.add("9788366155749_007_009");
        expectedFileNames.add("9788366155749_008_009");
        expectedFileNames.add("9788366155749_009_009");

        assertEquals(expectedFileNames, newFileNames);
    }
}
