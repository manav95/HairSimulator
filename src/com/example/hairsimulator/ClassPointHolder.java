package com.example.hairsimulator;

public class ClassPointHolder {
    private int x;
    private int y;
    public ClassPointHolder(int x, int y) {
    	  this.x = x;
    	  this.y = y;
    }
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y;
    }
    public String toString() {
    	return "This is sparta " + "x " + x + "y "+ y; 
    }
    
}
