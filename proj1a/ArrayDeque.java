public class ArrayDeque<T> {
    private T[] items;
    private int size;
    public ArrayDeque() {
        items =(T[]) new Object[8];
        size = 0;
    }

    private void doubleSize() {
        T[] tmp = (T[]) new Object[items.length * 2];
        System.arraycopy(items,0,tmp,0,size);
        items = tmp;
    }

    private void shrinksize() {
        T[] tmp = (T[]) new Object[items.length / 4];
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
        T[] tmp = (T[]) new Object[items.length];
        T x = items[0];
        size -= 1;
        System.arraycopy(items,1,tmp,0,size);

        if (size <= items.length / 2) {
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
        if (size <= items.length / 4) {
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

    /*public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque1 = new ArrayDeque<>();
        ArrayDeque1.addFirst(0);
        ArrayDeque1.removeLast();
        ArrayDeque1.addFirst(2);
        ArrayDeque1.removeLast();
        ArrayDeque1.addFirst(4);
        ArrayDeque1.removeLast();
        ArrayDeque1.isEmpty();
        ArrayDeque1.addFirst(7);
        ArrayDeque1.removeLast();
        ArrayDeque1.addFirst(9);
    }*/
}
