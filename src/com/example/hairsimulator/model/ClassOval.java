package com.example.hairsimulator.model;

import com.example.hairsimulator.ClassPointHolder;

public class ClassOval {
	   private int[][] points;
       public ClassOval(ClassPointHolder[] holders) {
    	   points = new int[4][2];
    	   points[0][0] = holders[0].getX();
    	   points[0][1] = holders[0].getY();
    	   points[1][0] = holders[2].getX();
    	   points[1][1] = holders[2].getY();
    	   points[2][0] = holders[4].getX();
    	   points[2][1] = holders[4].getY();
    	   points[3][0] = holders[6].getX();
    	   points[3][1] = holders[6].getY();
       }
       public int[][] getPoints() {
    	   return points;
       }
       }
