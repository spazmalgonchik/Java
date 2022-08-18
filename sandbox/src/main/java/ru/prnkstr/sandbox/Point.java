package ru.prnkstr.sandbox;

public class Point {
    public double x;
    public double y;
    public double x0;
    public double y0;

    public Point (double x,double y){
        this.x = x;
        this.y = y;
    }

    public Point (double x,double y, double x0,double y0){
        this.x = x;
        this.y = y;
        this.x0 = x0;
        this.y0 = y0;
    }

    public double distance_test(){
        return Math.sqrt((this.x - this.x0)*(this.x - this.x0) + (this.y - this.y0)*(this.y - this.y0));
    }

}
