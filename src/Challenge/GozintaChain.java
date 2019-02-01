package Challenge;

import java.util.*;

public class GozintaChain {

    private List<List<Integer>> solutions;

    private List<Integer> generateDivisors(final int n) {
        List<Integer> divisor = new ArrayList<Integer>();
        final int limit = (int)Math.sqrt(n);
        for (int i = 1; i <= limit; i++) {
            if (n % i == 0) {
                divisor.add(i);
                if (n / i != i)
                    divisor.add(n / i);
            }
        }
        Collections.sort(divisor);
        return divisor;
    }

    private Map<Integer, List<Integer>> generateGraph(final List<Integer> divisor) {
        Map<Integer, List<Integer>> graph = new TreeMap<>();
        for (int i = 0; i < divisor.size(); i++) {
            graph.put(divisor.get(i), new LinkedList<>());
            for (int j = i + 1; j < divisor.size(); j++) {
                if (divisor.get(j) % divisor.get(i) == 0)
                    graph.get(divisor.get(i)).add(divisor.get(j));
            }
        }
        return graph;
    }


    private void buildPaths(final Map<Integer, List<Integer>> graph, final LinkedList<Integer> currentPath, int currentNode) {
        if (graph.get(currentNode).size() == 0)
            solutions.add(new LinkedList<>(currentPath));

        for (int neighbor: graph.get(currentNode)) {
            currentPath.add(neighbor);
            buildPaths(graph, currentPath, neighbor);
            currentPath.removeLast();
        }
    }

    public List<List<Integer>> solve(final int n) {
        List<Integer> divisors = generateDivisors(n);
        Map<Integer, List<Integer>> graph = generateGraph(divisors);
        LinkedList<Integer> currentPath = new LinkedList<>();
        currentPath.add(1);
        solutions = new LinkedList<>();
        buildPaths(graph, currentPath, 1);
        return solutions;
    }
}
