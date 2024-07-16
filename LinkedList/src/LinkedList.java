public class LinkedList<T> {
    private class Node{
        public T e;
        public Node next;

        public Node(T e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(T e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T e){
        head = new Node(e, head);
        size++;
    }

    public void add(int index, T e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        if (index == 0)
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0; i < index - 1; i ++)
                prev = prev.next;

            prev.next = new Node(e, prev.next);
            size ++;
        }
    }

    public void addLast(T e){
        add(size, e);
    }

}
