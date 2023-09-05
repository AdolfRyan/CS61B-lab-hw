import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayDeque;

public class TestArrayDequeGold {
    @Test
    public void randomTest() {
        StudentArrayDeque<Integer> studentarray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solarray = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 500; i++) {
            int numberToadd = StdRandom.uniform(1000);
            if(solarray.isEmpty()) {
                int firstORlast = StdRandom.uniform(2);
                if(firstORlast == 0) {
                    log = log + "addFirst(" + numberToadd + ")\n";
                    studentarray.addFirst(numberToadd);
                    solarray.addFirst(numberToadd);
                }
                else {
                    log = log + "addLast(" + numberToadd + ")\n";
                    studentarray.addLast(numberToadd);
                    solarray.addLast(numberToadd);
                }
            }
            else {
                int choice = StdRandom.uniform(4);
                Integer solremoval = 0;
                Integer studentremoval = 0;
                switch (choice) {
                    case 0:
                        studentarray.addFirst(numberToadd);
                        solarray.addFirst(numberToadd);
                        log = log + "addFirst(" + numberToadd + ")\n";
                        break;
                    case 1:
                        studentarray.addLast(numberToadd);
                        solarray.addLast(numberToadd);
                        log = log + "addFirst(" + numberToadd + ")\n";
                        break;
                    case 2:
                        studentremoval = studentarray.removeFirst();
                        solremoval = solarray.removeFirst();
                        log = log + "removeFirst()\n";
                        break;
                    case 3:
                        studentremoval = studentarray.removeLast();
                        solremoval = solarray.removeLast();
                        log = log + "removeLast()\n";
                    default:
                }
                assertEquals(log,studentremoval,solremoval);
            }
        }

    }
}
