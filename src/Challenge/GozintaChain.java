package Challenge;

import java.util.*;

public class GozintaChain {

    private List<List<Long>> solutions;

    private List<Long> generateDivisors(final long n) {
        List<Long> divisor = new ArrayList<>();
        final long limit = (long)Math.sqrt(n);
        for (long i = 1; i <= limit; i++) {
            if (n % i == 0) {
                divisor.add(i);
                if (n / i != i)
                    divisor.add(n / i);
            }
        }
        Collections.sort(divisor);
        return divisor;
    }

    private Map<Long, List<Long>> generateGraph(final List<Long> divisor) {
        Map<Long, List<Long>> graph = new TreeMap<>();
        for (int i = 0; i < divisor.size(); i++) {
            graph.put(divisor.get(i), new LinkedList<>());
            for (int j = i + 1; j < divisor.size(); j++) {
                if (divisor.get(j) % divisor.get(i) == 0)
                    graph.get(divisor.get(i)).add(divisor.get(j));
            }
        }
        return graph;
    }


    private void buildPaths(final Map<Long, List<Long>> graph, final LinkedList<Long> currentPath, final long currentNode) {
        if (graph.get(currentNode).size() == 0)
            solutions.add(new LinkedList<>(currentPath));

        for (long neighbor: graph.get(currentNode)) {
            currentPath.add(neighbor);
            buildPaths(graph, currentPath, neighbor);
            currentPath.removeLast();
        }
    }

    public List<List<Long>> solve(final long n) {
        List<Long> divisors = generateDivisors(n);
        Map<Long, List<Long>> graph = generateGraph(divisors);
        LinkedList<Long> currentPath = new LinkedList<>();
        currentPath.add(1L);
        solutions = new LinkedList<>();
        buildPaths(graph, currentPath, 1L);
        return solutions;
    }
}
