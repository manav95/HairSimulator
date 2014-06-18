package com.example.hairsimulator.model;

public class Holder {
	private int startAge;
    private int midAge;
    private int age;
    /**
     * Constructs a holder object
     * 
     */
    public Holder(int s, int m, int a) {
        System.out.println("Enter starting age of graying");
        startAge = s;
        midAge = m;
        age = a;
    }
    /**
     * Returns the starting age
     * @return the starting age
     */
    public int getStartAge() {
        return this.startAge;
    }
    /**
     * Returns the middle age
     * @return middle age
     */
    public int getMidAge() {
        return this.midAge;
    }
    /**
     * Returns the ending age
     * @return ending age
     */
    public int getAge() {
        return this.age;
    }
    public void setAge(int a) {
    	this.age = a;
    }
    public void setStartAge(int s) {
    	this.startAge = s;
    }
    public void setMidAge(int m) {
    	this.midAge = m;
    }
}
