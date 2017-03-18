/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terserah.yugi.Entities;

import java.lang.Math;

public class Point {
	double x;
	double y;

	// membuat titik dengan koordinat (0,0)
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	// membuat titik dengan koordinat yang diberikan (x,y)
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	//setter
	public void setX (double x){
		this.x = x;
	}
	
	public void setY (double y){
		this.y = y;
	}
	
	//getter
	public double getX (){
		return this.x;
	}
	
	public double getY (){
		return this.y;
	}
	
	// Menggeser Point sejauh x dan y
	public void move(double x, double y) { 
		this.x = this.x + x;
		this.y = this.y + y;
	}

	
	public double distanceTo(Point p){
		double dx = this.x - p.getX();
		double dy = this.y - p.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}
}
