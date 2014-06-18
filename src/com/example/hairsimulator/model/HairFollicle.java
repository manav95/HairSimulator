package com.example.hairsimulator.model;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.RandomDataGenerator;
public class HairFollicle
{
    private String phase;
    private String color;
    private Melanocyte melanocyte;
    private int currAnagenLength;
    private int currCatagenLength;
    private int currTelogenLength;
    private int currLength;
    private int cycle;
    public HairFollicle(Rand ranch) {
          phase = "anagen";
          color = "black";
          int lasic = (int)ranch.returnGrayingDate();
          melanocyte = new Melanocyte();
          int phas = melanocyte.getShutDownPhase();
          RandomDataGenerator gen = ranch.returnGen();
          currTelogenLength = gen.nextInt(2,5);
          currCatagenLength = gen.nextInt(1,3);
          currAnagenLength = ((lasic - (phas * currTelogenLength) - (phas * currCatagenLength))/(phas));
          currLength = 1;
          cycle = 1;
    } 
    public String getPhase() {
        return phase;
    }
    public String getColor() {
        return color;
    }
    public Melanocyte getMelanocyte() {
        return melanocyte;
    }
    public int getCurrAnagenLength() {
        return currAnagenLength;
    }
    public int getCurrCatagenLength() {
        return currCatagenLength;
    }
    public int getCurrTelogenLength() {
        return currTelogenLength;
    }
    public int getCurrLength() {
        return currLength;
    }
    public String toString() {
        return phase + " " + color;
    }
    public void step() {
        if (phase.equals("anagen") && currLength >= currAnagenLength) {
            phase = "catagen";
            currLength = 1;
        }
        else if (phase.equals("catagen") && currLength >= currCatagenLength) {
            phase = "telogen";
            currLength = 1;
        }
        else if (phase.equals("telogen") && currLength >= currTelogenLength) {
            phase = "anagen";
            currLength = 1;
            cycle = cycle + 1;
            melanocyte.changeStatus();
            if (melanocyte.getMelaninPhase().equals("failing")) {
                color = "gray";
            }
            if (melanocyte.getMelaninPhase().equals("shutdown")) {
                color = "white";
            }
        }
        else {
            currLength = currLength + 1;
        }
    }
}

