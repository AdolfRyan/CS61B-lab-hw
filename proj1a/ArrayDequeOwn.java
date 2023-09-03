public class ArrayDequeOwn<T> {
    private T[] items;
    private int size;
    public ArrayDequeOwn() {
        items =(T[]) new Object[8];
        size = 0;
    }

    private void doubleSize() {
        T[] tmp = (T[]) new Object[size * 2];
        System.arraycopy(items,0,tmp,0,size);
        items = tmp;
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
            T[] tmp1 = (T[]) new Object[items.length * 2];
            doubleSize();
            System.arraycopy(items,0,tmp1,1,size);
            tmp1[0] = x;
            size += 1;
            items = tmp1;
            return;
        }
        else {
            T[] tmp = (T[]) new Object[items.length];
            System.arraycopy(items,0,tmp,1,size);
            tmp[0] = x;
            size += 1;
            items = tmp;
        }
    }

    public T removeFirst() {
        if(size == 0) {
            return null;
        }
        T x = items[0];
        T[] tmp = (T[]) new Object[items.length];
        size -= 1;
    }
}
