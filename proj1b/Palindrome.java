import java.util.ArrayDeque;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        int count = word.length();
        Deque<Character> deque = new LinkedListDeque<>();
        for(int i = 0; i < count; i++) {
            Character tmp = word.charAt(i);
            deque.addLast(tmp);
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        return true;
    }
}
