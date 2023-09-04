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
        Deque<Character> deque = wordToDeque(word);
        if(deque.size() == 1 || deque.size() == 0) {
            return true;
        }
        while(deque.size() >= 2) {
            if(deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word,CharacterComparator ccc) {
        Deque<Character> deque = wordToDeque(word);
        if(deque.size() == 1 || deque.size() == 0) {
            return true;
        }
        while(deque.size() >= 2) {
            if(!ccc.equalChars(deque.removeFirst(),deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
