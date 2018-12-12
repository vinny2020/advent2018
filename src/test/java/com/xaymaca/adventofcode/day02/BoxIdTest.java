package com.xaymaca.adventofcode.day02;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class BoxIdTest {

    @Test
    public void testChecksum() throws IOException {


        int twoList = 0;
        int threeList = 0;

        BufferedReader read = new BufferedReader(new InputStreamReader(loadInputs()));
        String line;
        while ((line = read.readLine()) != null) {

            if (hasXChars(2, line)) {
                twoList++;
            }

        }
        BufferedReader read2 = new BufferedReader(new InputStreamReader(loadInputs()));
        String line2;
        int lines = 0;
        while ((line2 = read2.readLine()) != null) {

            if (hasXChars(3, line2)) {
                threeList++;
            }

            lines++;
        }
        int checksum = twoList * threeList;
        System.out.println("twos: " + twoList + " * threes: " + threeList);
        Assert.assertEquals("we found ", 5904, checksum);
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
        //real work goes here
        boolean has = false;

        char[] letters = line.toCharArray();

        Map<Character, Integer> chars = new HashMap<>();
        for (char currentLetter : letters) {
            if (null == chars.get(currentLetter)) {
                chars.put(currentLetter, 1);
            } else {
                int count = chars.get(currentLetter);
                chars.put(currentLetter, count + 1);
            }
        }
        // System.out.println(chars);

        for (Integer value : chars.values()) {
            // System.out.println("Value = " + value);
            if (value == howManyToCheckFor) {
                return true;
            }
        }
        return has;
    }


}
