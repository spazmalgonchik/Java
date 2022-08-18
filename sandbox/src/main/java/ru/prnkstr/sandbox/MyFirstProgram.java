package ru.prnkstr.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        int x = 99;
        int y = 32;
        int x0 = 888;
        int y0 = 14;

        Point p1 = new Point(x0, y0);
        Point p2 = new Point(x, y);
        Point points = new Point(x, y, x0, y0);

        System.out.println("Расстояние между двумя точками = " + distance(p1, p2));
        System.out.println("Расстояние между двумя точками = " + points.distance_test());

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

}
