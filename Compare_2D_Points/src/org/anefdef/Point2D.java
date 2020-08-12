package org.anefdef;

public class Point2D implements Comparable<Point2D>{
    double x;
    double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2D point) {
        double hypA = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        double hypB = Math.sqrt(Math.pow(point.x,2) + Math.pow(point.y,2));

        return hypA == hypB ? 0 : hypA > hypB ? 1 : -1;
    }
}
