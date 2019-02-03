package Tests;
import Challenge.GozintaChain;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GozintaChainTest {

    @Test
    void numberOfGozintaChain() {
        GozintaChain loadProblem = new GozintaChain();
        Map<Long, Long> answer = new TreeMap<>();
        answer.put(12L, 8L);
        answer.put(48L, 48L);
        answer.put(120L, 132L);
        answer.put(17L, 1L);
        answer.put(199L, 1L);
        answer.put(7919L, 1L);
        for (long n: answer.keySet())
            assertEquals(answer.get(n), loadProblem.solve(n).size());
    }

    @Test
    void listOfGozintaChain() {
        GozintaChain loadProblem = new GozintaChain();
        Map<Long, List<List<Long>>> answer = new TreeMap<>();
        answer.put(12L, new LinkedList<>());
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(2L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(2L); add(4L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(2L); add(6L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(3L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(3L); add(6L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(4L); add(12L); }});
        answer.get(12L).add(new LinkedList<Long>(){{ add(1L); add(6L); add(12L); }});
        answer.put(19L, new LinkedList<>());
        answer.get(19L).add(new LinkedList<Long>(){{ add(1L); add(19L); }});

        Comparator<List<Long>> lexicographicalComparator = (list1, list2) -> {
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                if (list1.get(i) - list2.get(i) != 0)
                    return (int) (list1.get(i) - list2.get(i));
            }
            return list1.size() - list2.size();
        };

        answer.get(12L).sort(lexicographicalComparator);

        for (long n: answer.keySet()) {
            List<List<Long>> solutions = loadProblem.solve(n);
            answer.get(12L).sort(lexicographicalComparator);
            assertEquals(answer.get(n).toString(),solutions.toString());
        }

    }

}