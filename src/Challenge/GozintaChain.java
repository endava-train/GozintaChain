package Challenge;

import java.util.*;

public class GozintaChain {

    private List<Long> generateDivisors(final long n) {
        List<Long> divisor = new ArrayList<>();
        final long limit = (long)Math.sqrt(n);
        for (long i = 1; i <= limit; i++) {
            if (n % i == 0) {
                divisor.add(i);
                if (n / i != i) {
                    divisor.add(n / i);
                }
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
                if (divisor.get(j) % divisor.get(i) == 0) {
                    graph.get(divisor.get(i)).add(divisor.get(j));
                }
            }
        }
        return graph;
    }


    private List<List<Long>> buildPaths(final Map<Long, List<Long>> graph, final List<Long> currentPath, final long currentNode) {
        List<List<Long>> solutions = new LinkedList<>();
        if (graph.get(currentNode).isEmpty()) {
            solutions.add(currentPath);
        }

        for (long neighbor: graph.get(currentNode)) {
            final List<Long> currentPathTmp = new LinkedList<>(currentPath);
            currentPathTmp.add(neighbor);
            solutions.addAll(buildPaths(graph, currentPathTmp, neighbor));
        }
        return solutions;
    }

    public List<List<Long>> solve(final long n) {
        List<Long> divisors = generateDivisors(n);
        Map<Long, List<Long>> graph = generateGraph(divisors);
        List<Long> currentPath = new LinkedList<>();
        currentPath.add(1L);
        return buildPaths(graph, currentPath, 1L);
    }
}
