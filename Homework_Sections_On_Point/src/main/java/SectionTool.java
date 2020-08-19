import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SectionTool {
    /**
     * Method that determines maximum covered point in given List
     * and returns the value of covers
     *
     * @param points   a List of (Double) points
     * @param sections a List of Sections
     * @return int max covers value
     */
    public int getMaxPointCovers(List<Double> points, List<Section> sections) {

        if (points.isEmpty() || sections.isEmpty())
            throw new EmptySourceException();

        Map<Double, Integer> dict = getPointsWithCoverValues(points,sections);

        int max = 0;
        for (int value:dict.values()) {
            if (value > max)
                max = value;
        }

        return max;
    }


    /**
     * Method that determines point's cover values from given List
     * and returns HashMap of points with values of covers
     *
     * @param points   a List of (Double) points
     * @param sections a List of Sections
     * @return a HashMap with keys Point and values CoverValue
     */
    public Map<Double, Integer> getPointsWithCoverValues(List<Double> points, List<Section> sections) {

        Map<Double, Integer> dict = new HashMap<>();

        for (Double p : points) {
            int value = 0;
            for (Section s : sections) {
                if (s.left <= p && s.right >= p)
                    value++;
            }
            dict.put(p,value);
        }

        return dict;
    }

}
