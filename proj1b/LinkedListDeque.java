public class LinkedListDeque<T> implements Deque<T>{

    public static class ItemNode<T> {
        public T item;
        private ItemNode<T> next;
        private ItemNode<T> pre;

        public ItemNode(T item,ItemNode nnext,ItemNode ppre) {
            this.item = item;
            next = nnext;
            pre = ppre;
        }
    }

    private int size;
    private ItemNode<T> sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new ItemNode<T>(null,null,null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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

    @Override
    public void addFirst(T x) {
        ItemNode<T> tmp = new ItemNode<T>(x,sentinel.next,sentinel);
        size += 1;
        this.sentinel.next.pre = tmp;
        this.sentinel.next = tmp;
    }

    @Override
    public void addLast(T x) {
        size += 1;
        ItemNode<T> tmp = new ItemNode<T>(x,sentinel,sentinel.pre);
        this.sentinel.pre.next = tmp;
        this.sentinel.pre = tmp;
    }

    public T removeFirst() {
        if(this.size == 0) {
            return null;
        }
        T itemTmp = this.sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.pre = this.sentinel;
        size--;
        return itemTmp;
    }

    @Override
    public T removeLast() {
        if(this.size == 0) {
            return null;
        }
        else {
            T itemTmp = this.sentinel.pre.item;
            this.sentinel.pre.pre.next = this.sentinel;
            this.sentinel.pre = this.sentinel.pre.pre;
            size -= 1;
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

    private T getRecursive(ItemNode<T> start,int index,int count) {
        if(count == index) {
            return start.item;
        }
        else {
            return getRecursive(start.next,index,count+1);
        }
    }

    @Override
    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void printDeque() {
        ItemNode<T> tmp = sentinel.next;
        while(tmp != null) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
    }
}
