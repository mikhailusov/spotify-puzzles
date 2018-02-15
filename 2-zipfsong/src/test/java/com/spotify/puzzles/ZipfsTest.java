package com.spotify.puzzles;

import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class ZipfsTest {

    @Test
    public void zipfsSort() throws FileNotFoundException {
        assertEqualSongs(readOut("songs1_out"), Zipfs.zipfsSort(readIn("songs1"), 2));
        assertEqualSongs(readOut("songs2_out"), Zipfs.zipfsSort(readIn("songs2"), 3));
    }

    private List<Song> readIn(String filename) throws FileNotFoundException {
        File file = new File(getClass().getClassLoader().getResource(filename).getFile());
        return Zipfs.getAlbumFromInput(new Scanner(file)).getSongs();
    }

    private List<Song> readOut(String filename) {
        File file = new File(getClass().getClassLoader().getResource(filename).getFile());
        List<Song> songs = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                songs.add(new Song(scanner.nextLine()));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return songs;
    }

    private void assertEqualSongs(List<Song> expected, List<Song> actual) {
        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(actual.get(i).getTitle(), expected.get(i).getTitle());
        }
    }
}