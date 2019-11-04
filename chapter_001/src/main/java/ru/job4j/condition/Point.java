package ru.job4j.condition;

/**
 * CalculateTest
 * @author Oleg Chudnovskij (oleg.chudnovskiy@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class Point {
    private final int x;
    private final int y;
    private int z;

    public  Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    public double distance3d(Point that) {
        double result = Math.pow((that.x - this.x), 2) + Math.pow((that.y - this.y), 2) + Math.pow((that.z - this.z), 2);
        return Math.sqrt(result);
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s, %s]", this.x, this.y, this.z));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 6);
        double dist = a.distance(b);
        System.out.println(dist);
    }
}
