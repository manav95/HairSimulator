package com.example.hairsimulator.model;

import java.util.Random;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.RandomDataGenerator;
public class Rand
{
    private NormalDistribution dist;
    private RandomDataGenerator gen;
    /**
     * Constructs a new random object
     * @param f- the first parameter
     * @param m- the middle parameter
     */
    public Rand(int f, int m) {
        int first = f * 12;
        int middle = m * 12;
        double stDev = (first - middle) / -4;
        dist = new NormalDistribution(middle, stDev);
        gen = new RandomDataGenerator();
    }
    /**
     * Returns the graying month
     * @return the graying month
     */
    public double returnGrayingDate() {
        return gen.nextGaussian(dist.getMean(),dist.getStandardDeviation());
    }
    /**
     * Returns the data generator
     * @return data generator
     */
    public RandomDataGenerator returnGen() {
        return gen;
    }    
}