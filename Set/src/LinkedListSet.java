import java.util.ArrayList;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> lst;

    public LinkedListSet() {
        lst = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return lst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    @Override
    public boolean contains(E e) {
        return lst.contains(e);
    }

    @Override
    public void add(E e) {
        if (!lst.contains(e)) {
            lst.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        lst.removeElement(e);
    }

    public static void main(String[] args) {

        LinkedListSet<String> s = new LinkedListSet<>();
        s.add("1");
        s.add("2");
        s.add("2");
        s.add("3");

        s.remove("1");

        System.out.println(s.getSize());

    }

}

