import Challenge.GozintaChain;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
        GozintaChain loadProblem = new GozintaChain();

        System.out.println("Enter the number:\t");
        int n = is.nextInt();
        List<List<Integer>> chains = loadProblem.solve(n);
        System.out.println("The number g(n) is:" + chains.size());
        System.out.println("The chains are:");
        for (List<Integer> chain: chains)
            System.out.println(chain);
    }
}
