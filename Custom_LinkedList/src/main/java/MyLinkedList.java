
import java.util.*;

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
        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
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

    public T remove(int index) {
        if (size == 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            Node<T> removedNode = first;
            if (index == 0) {
                first = first.next;
                size--;
                return removedNode.element;
            } else if (index == size - 1) {
                removedNode = last;
                last = last.prev;
                size--;
                return removedNode.element;
            }
            removedNode = getNode(index);
            removedNode.prev.next = removedNode.next;
            removedNode.next.prev = removedNode.prev;
            size--;
            return removedNode.element;
        }
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
        if (index > size-1 || index < 0)
            throw new IndexOutOfBoundsException();
        return getNode(index).element;
    }

    public boolean contains(T element) {
        if (size <= 0)
            throw new IndexOutOfBoundsException();
        for (int i = 0; i < size; i++) {
            if (getNode(i).element.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        T[] toSort = (T[]) new Object[size];
        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext())
            toSort[i++] = it.next();
        Arrays.sort(toSort);
        first = last = null;
        size = 0;
        for (T o:toSort) {
            this.add(o);
        }
    }

    public void sort(Comparator<T> comparator) {
        T[] toSort = (T[]) new Object[size];
        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext())
            toSort[i++] = it.next();
        Arrays.sort(toSort,comparator);
        first = last = null;
        size = 0;
        for (T o:toSort) {
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
            Iterator<T> e2 = ((MyLinkedList)o).iterator();

            while(true) {
                if (e1.hasNext() && e2.hasNext()) {
                    T o1 = e1.next();
                    Object o2 = e2.next();
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
