package com.xaymaca.adventofcode.day01;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class FrequencyTest {


    @Test
    public void testForDuplicate() throws IOException {

        Set<Integer> seenValues = new HashSet<>();
        seenValues.add(0);
        int total = 0;
        outerloop:
        for (int i = 0; i < 900; i++) {

            InputStream inputs = loadInputs();


            BufferedReader read = new BufferedReader(new InputStreamReader(inputs));
            String line;
            while ((line = read.readLine()) != null) {

                int nnum = Integer.parseInt(line);
                total += nnum;

                if (seenValues.contains(total)) {
                    break outerloop;
                } else {
                    seenValues.add(total);
                }
                //    System.out.println("total is now " + total + " seen values # " + seenValues.size());
            }

        }

        Assert.assertEquals("found the duplicate " , 621, total);
    }


    @Test
    public void testForFinalFrequency() {

        InputStream inputs = loadInputs();

        try (BufferedReader read = new BufferedReader(new InputStreamReader(inputs))) {

            String line = null;
            int total = 0;
            while ((line = read.readLine()) != null) {
                int nnum = Integer.valueOf(line);
             //   System.out.println("new operation is " + total + " + " + nnum);
                total += nnum;
             //   System.out.println("total is now " + total);

            }
            Assert.assertEquals("final frequency ", 543, total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream loadInputs()  {
        URL url = this.getClass().getResource("/inputs.txt");
        try {
            return url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}



