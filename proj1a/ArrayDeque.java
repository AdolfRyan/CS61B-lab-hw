public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int front;
    public ArrayDeque() {
        items =(T[]) new Object[8];
        size = 0;
        front = 0;
    }

    private void doubleSize() {
        T[] tmp = (T[]) new Object[items.length * 2];
        System.arraycopy(items,front,tmp,0,size);
        items = tmp;
        front = 0;
    }

    private void shrinksize() {
        T[] tmp = (T[]) new Object[items.length / 4];
        System.arraycopy(items,front,tmp,0,size);
        items = tmp;
        front = 0;
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        return items[index];
    }

    public int size() {
        return size;
    }

    public void addLast(T x) {
        if(size == items.length) {
            doubleSize();
        }
        items[size] = x;
        size += 1;
    }

    public void addFirst(T x) {

        if(size ==items.length) {
            doubleSize();
        }
        System.arraycopy(items,0,items,1,size);
        items[0] = x;
        size += 1;
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T x = items[front];
        size -= 1;
        front += 1;

        if (size <= items.length / 4 && items.length / 4 >= 1) {
            shrinksize();
        }
        items = tmp;
        return x;
    }

    public T removeLast() {
        if(size == 0) {
            return null;
        }
        T x = items[size- 1];
        items[size - 1] = null;
        size -= 1;
        if (size <= items.length / 4 && items.length / 4 >= 1) {
            shrinksize();
        }
        return x;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
