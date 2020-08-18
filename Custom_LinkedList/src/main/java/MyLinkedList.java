
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private int size;
    Node<T> first;
    Node<T> last;

    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        public Node(T element, Node<T> next, Node<T> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> getNode(int index) {
        if (index > size - 1 || index < 0)
            throw new IndexOutOfBoundsException();
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element, null, last);
        if (size == 0) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    /**
     * Method that returns the Node corresponding to the element
     * @param element to find the Node
     * @return Node if found or null otherwise
     */
    private Node<T> findNode(T element) {
        Node<T> current = first;
        while (current != null) {
            if (element.equals(current.element))
                return current;
            current = current.next;
        }
        return null;
    }

    private void removeByNode(Node<T> toRemove) {
        Node<T> left = toRemove.prev;
        Node<T> right = toRemove.next;

        toRemove.prev = toRemove.next  = null;
        toRemove.element = null;

        if (size == 1) {
            first = last = null;
        } if (first == toRemove) {
            right.prev = null;
            first = right;
        } else if (last == toRemove) {
            left.next = null;
        } else {
            right.prev = left;
            left.next = right;
        }
        size--;
    }

    public T removeByIndex(int index) {
        Node<T> toRemove = getNode(index);
        T result = toRemove.element;
        removeByNode(toRemove);
        return result;
    }

    public boolean removeByElement(T element) {
        Node<T> toRemove = findNode(element);
        if (toRemove == null)
            return false;
        removeByNode(toRemove);
        return true;
    }

    public T remove(int index) {
        if (size == 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> removedNode = first;
        if (index == 0) {
            first = first.next;
            if (first != null)
                first.prev = null;
            size--;
            return removedNode.element;
        } else if (index == size - 1) {
            removedNode = last;
            last = last.prev;
            if (last != null)
                last.next = null;
            size--;
            return removedNode.element;
        }
        removedNode = getNode(index);
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
        size--;
        return removedNode.element;
    }

    public boolean remove(T element) {
        if (size == 0)
            throw new IndexOutOfBoundsException();
        if (element.equals(first.element)) {
            first = first.next;
            size--;
            return true;
        } else if (element.equals(last.element)) {
            last = last.prev;
            last.next = null;
            size--;
            return true;
        } else {
            for (int i = 1; i < size - 1; i++) {
                Node<T> node = getNode(i);
                if (element.equals(node.element)) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    public void set(int index, T element) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        Node<T> toChange = getNode(index);
        toChange.element = element;
    }

    /**
     * @param index of the element to return
     * @return element at index
     * @throws IndexOutOfBoundsException if 0 > index > size - 1
     */
    public T get(int index) {
        return getNode(index).element;
    }

    public boolean contains(T element) {
        return findNode(element) != null;
    }

    public void sort(Comparator<T> comparator) {
        T[] toSort = (T[]) new Object[size];
        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext())
            toSort[i++] = it.next();
        if(comparator == null)
            Arrays.sort(toSort,null);
        Arrays.sort(toSort, comparator);
        first = last = null;
        size = 0;
        for (T o : toSort) {
            this.add(o);
        }
    }

    public Iterator<T> iterator() {

        return new Iterator<>() {

            Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                var toReturn = current.element;
                current = current.next;
                return toReturn;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof MyLinkedList)) {
            return false;
        } else {
            Iterator<T> e1 = this.iterator();
            Iterator<T> e2 = ((MyLinkedList) o).iterator();

            while (true) {
                if (e1.hasNext() && e2.hasNext()) {
                    T o1 = e1.next();
                    T o2 = e2.next();
                    if (o1 == null) {
                        if (o2 == null) {
                            continue;
                        }
                    } else if (o1.equals(o2)) {
                        continue;
                    }

                    return false;
                }

                return !e1.hasNext() && !e2.hasNext();
            }
        }
    }
}
