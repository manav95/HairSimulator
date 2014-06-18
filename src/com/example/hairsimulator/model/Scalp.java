package com.example.hairsimulator.model;
import java.util.Random;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
/**
 * This class constructs the actual scalp object.
 * @author Manav Dutta
 * @version 2.0
 */
public class Scalp
{
    private ArrayList<HairFollicle> hairFollicles;
    private int step;
    /**
     * Constructs a scalp
     */
    public Scalp()
    {
        this.hairFollicles = new ArrayList<HairFollicle>();
        step = 0;
    }
    /**
     * This method fills the scalp with hairs
     * @param max- the maximum hair follicles
     * @param holder- the holder object
     */
    public void fillWithHairs(int max, Holder holder) {
        hairFollicles.clear();
        Rand ranch = new Rand(holder.getStartAge(), holder.getMidAge()); 
        for (int i = 0; i < max; i++) {
            hairFollicles.add(new HairFollicle(ranch));
        }
    }
    /**
     * This method fills an existing hair with graying starting at age 40.
     * @param max- the amount of hair follicles
     */
    public void fillWithHairs(int max) {
        Rand ranch = new Rand(40,60);
        for (int i = 0; i < max; i++) {
            hairFollicles.add(new HairFollicle(ranch));
        }
    }  
    /**
     * This method steps the scalp forward in time. Agig them well.
     */
    public void step() {
       for (HairFollicle follicle : hairFollicles) {
           follicle.step();
       }
       step = step + 1;
    }
    /**
     * This returns the hair follicles as a list.
     * @return the list of hair follicles
     */
    public ArrayList<HairFollicle> getHairFollicles() {
        return this.hairFollicles;
    }
    /**
     * This returns the follicles as a list.
     * @return the list of hair follicles
     */
    public ArrayList<ArrayList<HairFollicle>> getHairFolliclesAsList() {
        ArrayList<ArrayList<HairFollicle>> list = new ArrayList<ArrayList<HairFollicle>>();
        list.add(new ArrayList<HairFollicle>());
        list.add(new ArrayList<HairFollicle>());
        list.add(new ArrayList<HairFollicle>());
        list.add(new ArrayList<HairFollicle>());
        for (int i = 0; i < hairFollicles.size(); i++) {
            if (i < hairFollicles.size() / 4) {
                list.get(0).add(hairFollicles.get(i));
            }
            else if (i < hairFollicles.size() / 2) {
                list.get(1).add(hairFollicles.get(i));
            }
            else if (i < ((3 * hairFollicles.size()) / 4)) {
                list.get(2).add(hairFollicles.get(i));
            }
            else {
                list.get(3).add(hairFollicles.get(i));
            }
        }
        return list;
    }
    /**
     * This returns the step
     * @return the step itself
     */
    public int getSteps() {
        return step;
    }
}