import Challenge.GozintaChain;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
        int n = is.nextInt();
        GozintaChain loadProblem = new GozintaChain();
        List<List<Integer>> chain = loadProblem.solve(n);
        System.out.println(chain.size());
        System.out.println(chain);
    }
}
