public class OffByN implements CharacterComparator{
    private int off;
    public OffByN(int i) {
        off = i;
    }
    @Override
    public  boolean equalChars(char x, char y) {
        return Math.abs(x - y) == off;
    }
}
