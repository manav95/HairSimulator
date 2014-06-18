package com.example.hairsimulator.model;
import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;
public class Melanocyte
{
    private String melaninPhase;
    private int cycle;
    private int shutDownPhase;
    private int grayLength;
    private RandomDataGenerator gen;
    public Melanocyte() {
         melaninPhase = "producing";
         cycle = 1;
         gen = new RandomDataGenerator();
         shutDownPhase = (new Random().nextInt(9)) + 7;
         grayLength = -1;
    }
    public String getMelaninPhase() {
        return melaninPhase;
    }
    public int getCycle() {
        return cycle;
    }
    public int getShutDownPhase() {
        return shutDownPhase;
    }
    public int getGrayLength() {
        return grayLength;
    }
    public void changeStatus() {
        if (cycle == shutDownPhase && grayLength == -1) {
            grayLength = (new Random().nextInt(3));
            if (grayLength == 0) {
                melaninPhase = "shutdown";
                cycle = cycle + 1;
            }
            else {
                melaninPhase = "failing";
                cycle = cycle + 1;
            }
        }
        else if (cycle > shutDownPhase && grayLength > 0) {
             cycle = cycle + 1;
             grayLength = grayLength - 1;
        }
        else if (cycle > shutDownPhase && grayLength == 0) {
             grayLength = -1;
             melaninPhase = "shutdown";
             cycle = cycle + 1;
        }
        else {
              cycle = cycle + 1;
        }
    }
}
