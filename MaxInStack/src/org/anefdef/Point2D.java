package org.anefdef;

import java.util.Objects;

public class Point2D implements Comparable<Point2D>{

    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getR() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point2D point) {
        return this.getR() == point.getR() ? 0 : this.getR() > point.getR() ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point2D)) return false;
        Point2D point2D = (Point2D) o;
        return Double.compare(point2D.x, x) == 0 &&
                Double.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
