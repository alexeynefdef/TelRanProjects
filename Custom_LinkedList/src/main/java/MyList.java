import java.util.Comparator;

/**
 * Standard list data structure
 *
 * @param <T>
 */

public interface MyList<T> extends Iterable<T> {

    void add(T element);

    int size();

    /**
     *
     * @param index
     * @return element to be removed
     */
    T remove(int index);

    /**
     *
     * @param element
     * @return true if element found and removed
     */
    boolean remove(T element);

    void set(int index, T element);

    T get(int index);

    boolean contains(T element);

    void sort(Comparator<T> comparator);
}