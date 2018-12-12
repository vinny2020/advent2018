package com.xaymaca.adventofcode.day02;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BoxIdTest {

    @Test
    public void testChecksum() throws IOException {

        InputStream inputs = loadInputs();

        int twoList = 0;
        int threeList = 0;

        BufferedReader read = new BufferedReader(new InputStreamReader(inputs));
        String line;
        while ((line = read.readLine()) != null) {

            if (hasXChars(2, line)) {
                twoList++;
            }
            if (hasXChars(3, line)) {
                threeList++;
            }
        }
        int checksum = twoList * threeList ;
        Assert.assertEquals("we found ", 85, checksum);
    }


    private InputStream loadInputs() {
        URL url = this.getClass().getResource("/boxIdInput.txt");
        try {
            return url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private boolean hasXChars(int howManyToCheckFor, String line) {
        //real work here
        return false;
    }


}
