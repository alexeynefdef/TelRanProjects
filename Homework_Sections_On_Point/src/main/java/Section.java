import java.util.Objects;

public class Section {
    double left;
    double right;

    public Section(double left, double right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section section = (Section) o;
        return Double.compare(section.left, left) == 0 &&
                Double.compare(section.right, right) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
