package com.terserah.yugi.Entities;

public class Point {
	int  x;
	int y;

	// membuat titik dengan koordinat (0,0)
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	// membuat titik dengan koordinat yang diberikan (x,y)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//setter
	public void setX (int x){
		this.x = x;
	}
	
	public void setY (int y){
		this.y = y;
	}
	
	//getter
	public int getX (){
		return this.x;
	}
	
	public int getY (){
		return this.y;
	}
	
	// Menggeser Point sejauh x dan y
	public void move(int x, int y) { 
		this.x = this.x + x;
		this.y = this.y + y;
	}
}
