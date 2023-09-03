public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int start; // 新增：用于跟踪头部元素的索引
    private int end;   // 新增：用于跟踪尾部元素的索引

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        start = 0;
        end = 0;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[end] = item;
        end = (end + 1) % items.length; // 使用循环数组来避免溢出
        size++;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        start = (start - 1 + items.length) % items.length; // 使用循环数组来避免溢出
        items[start] = item;
        size++;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T removed = items[(end - 1 + items.length) % items.length];
        end = (end - 1 + items.length) % items.length;
        size--;

        if (size < items.length / 4 && items.length > 16) {
            resize(items.length / 2);
        }

        return removed;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T removed = items[start];
        start = (start + 1) % items.length;
        size--;

        if (size < items.length / 4 && items.length > 16) {
            resize(items.length / 2);
        }

        return removed;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return items[(start + index) % items.length];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        items = newArray;
        start = 0;
        end = size;
    }
}
