import Challenge.GozintaChain;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner is = new Scanner(System.in);
        GozintaChain loadProblem = new GozintaChain();

        System.out.print("Enter the number:\t");
        long n = is.nextLong();
        List<List<Long>> chains = loadProblem.solve(n);

        System.out.println("The chains are:");
        for (List<Long> chain: chains)
            System.out.println(chain);

        System.out.println("The number g(n) is: \t" + chains.size());
    }
}
