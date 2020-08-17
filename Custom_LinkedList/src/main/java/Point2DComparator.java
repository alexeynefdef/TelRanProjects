import java.util.Comparator;

public class Point2DComparator implements Comparator<Point2D> {
    @Override
    public int compare(Point2D pointA, Point2D pointB) {
        double hypA = Math.sqrt(Math.pow(pointA.x,2) + Math.pow(pointA.y,2));
        double hypB = Math.sqrt(Math.pow(pointB.x,2) + Math.pow(pointB.y,2));

        return hypA == hypB ? 0 : hypA > hypB ? 1 : -1;
    }
}
