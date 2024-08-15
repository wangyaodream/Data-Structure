public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        add(0, e);
    }

    public void add(int index, E e) {
        if(size == data.length) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.index need et 0.");
        }

        for (int i = size - 1; i >= index; i--) {
            // 后一个索引位置的元素变成前一个
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index){
        // 通过这种方式可以防止用户访问size以外的元素
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Array is full.");
        return data[index];
    }

    public void set(int index, E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Array is full.");
        data[index] = e;
    }

    public boolean contains(E e){
        return find(e) != -1;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++){
            if (e.equals(data[i]))
                return i;
        }
        return -1;

    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("index error.");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // data[size] = null;
        if (size == data.length / 2)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void swap(int i, int j){
        if (i < 0 || i >= size || j < 0 || j >= size)
            throw new IllegalArgumentException("Index is illegal.");

        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i=0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
