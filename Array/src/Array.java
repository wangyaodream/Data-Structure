public class Array {

    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
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

    public void addLast(int e){
        add(size, e);
    }

    public void addFirst(int e){
        add(0, e);
    }

    public void add(int index, int e) {
        if(size == data.length) {
            throw new IllegalArgumentException("Add failed.Array is full.");
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

    public int get(int index){
        // 通过这种方式可以防止用户访问size以外的元素
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed.Array is full.");
        return data[index];
    }

    public void set(int index, int e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed.Array is full.");
        data[index] = e;
    }

    public boolean contains(int e){
        int f = find(e);
        return f != -1;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++){
            if (e == data[i])
                return i;
        }
        return -1;

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
