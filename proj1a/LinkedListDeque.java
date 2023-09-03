public class LinkedListDeque<T> {
    public static class ItemNode<T> {
        public T item;
        public ItemNode<T> next;
        public ItemNode<T> pre;

        public ItemNode(T item) {
            this.item = item;
        }
    }

    private int size;
    private ItemNode<T> sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ItemNode<T>(null);
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if(index >= size) {
            return null;
        }

        ItemNode<T> tmp = this.sentinel.next;
        for(int i = 0;i < index;i++) {
            tmp = tmp.next;
        }
        return tmp.item;
    }

    public void addFirst(T x) {
        ItemNode<T> tmp = new ItemNode<T>(x);
        size += 1;
        if (this.size == 0) {
            this.sentinel.next = tmp;
            tmp.pre = this.sentinel;
            this.sentinel.pre = tmp;
            tmp.next = this.sentinel;
        }
        else {
            tmp.next = this.sentinel.next;
            this.sentinel.next.pre = tmp;
            this.sentinel.next = tmp;
            tmp.pre = this.sentinel;
        }
    }

    public void addLast(T x) {
        size += 1;
        ItemNode<T> tmp = new ItemNode<T>(x);
        if (this.size == 0) {
            this.sentinel.next = tmp;
            tmp.pre = this.sentinel;
            this.sentinel.pre = tmp;
            tmp.next = this.sentinel;
        }
        else {
            tmp.pre = this.sentinel.pre;;
            tmp.next = this.sentinel;
            this.sentinel.pre.next = tmp;
            this.sentinel.pre = tmp;
        }
    }

    public T removeFirst() {
        size -= 1;
        if(this.size == 0) {
            return null;
        }
        else {
            T itemTmp = this.sentinel.next.item;
            this.sentinel.next = this.sentinel.next.next;
            this.sentinel.next.pre = this.sentinel;
            return itemTmp;
        }
    }

    public T removeLast() {
        size -= 1;
        if(this.size == 0) {
            return null;
        }
        else {
            T itemTmp = this.sentinel.pre.item;
            this.sentinel.pre.pre.next = this.sentinel;
            this.sentinel.pre = this.sentinel.pre.pre;
            return itemTmp;
        }
    }

    public T getRecursive(int index) {
        if(index >= this.size) {
            return null;
        }
        else {
            return getRecursive(this.sentinel.next,index,0);
        }
    }

    public T getRecursive(ItemNode<T> start,int index,int count) {
        if(count == index) {
            return start.item;
        }
        else {
            return getRecursive(start.next,index,count+1);
        }
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }
}
