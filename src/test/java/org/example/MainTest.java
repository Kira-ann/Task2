package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void first() throws IOException {
        Main.main("-z -out outputFile inputFile".split(" "));
        String text = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("outputFile"));
        String line = bufferedReader.readLine();
        while (line != null){
            text += line;
            line = bufferedReader.readLine();
        }
        assertEquals("3t3r", text);
    }
    @Test
    public void second() throws IOException {
        Main.main("-u -out outputFile inputFile".split(" "));
        String text = "";
        BufferedReader bufferedReader = new BufferedReader(new FileReader("outputFile"));
        String line = bufferedReader.readLine();
        while (line != null){
            text += line;
            line = bufferedReader.readLine();
        }
        assertEquals("rrrttt", text);
    }

}