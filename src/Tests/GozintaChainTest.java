package Tests;
import Challenge.GozintaChain;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GozintaChainTest {

    @Test
    void numberOfGozintaChain() {
        final GozintaChain loadProblem = new GozintaChain();
        final Map<Long, Long> answer = new TreeMap<>();
        answer.put(12L, 8L);
        answer.put(48L, 48L);
        answer.put(120L, 132L);
        answer.put(17L, 1L);
        answer.put(199L, 1L);
        answer.put(7919L, 1L);

        for (Map.Entry<Long,Long> entry : answer.entrySet()) {
            long key = entry.getKey();
            long value = entry.getValue();
            assertEquals(value, loadProblem.solve(key).size());
        }
    }

    @Test
    void listOfGozintaChain() {
        final GozintaChain loadProblem = new GozintaChain();
        final Map<Long, List<List<Long>>> answer = new TreeMap<>();
        answer.put(12L, new LinkedList<>());
        answer.get(12L).add(Arrays.asList(1L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 2L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 2L, 4L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 2L, 6L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 3L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 3L, 6L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 4L, 12L));
        answer.get(12L).add(Arrays.asList(1L, 6L, 12L));
        answer.put(19L, new LinkedList<>());
        answer.get(19L).add(Arrays.asList(1L, 19L));

        final Comparator<List<Long>> lexicographicalComparator = (list1, list2) -> {
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                if (list1.get(i) - list2.get(i) != 0)
                    return (int) (list1.get(i) - list2.get(i));
            }
            return list1.size() - list2.size();
        };

        for (Map.Entry<Long,List<List<Long>>> entry : answer.entrySet()) {
            long key = entry.getKey();
            List<List<Long>> value = entry.getValue();

            List<List<Long>> solutions = loadProblem.solve(key);
            answer.get(key).sort(lexicographicalComparator);
            solutions.sort(lexicographicalComparator);
            assertEquals(value.toString(), solutions.toString());
        }

    }

}