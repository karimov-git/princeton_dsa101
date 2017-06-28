import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by lxuser on 6/14/17.
 */
public class PercolationStats {

    private int trials;
    private double[] results;
    private Percolation pr;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        this.trials = trials;
        results = new double[trials];

        for (int i = 0; i < trials; i++) {
            pr = new Percolation(n);

            while (!pr.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;

                if (!pr.isOpen(row, col)) {
                    pr.open(row, col);
                }
            }

            results[i] = (double) pr.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(results);
    }

    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev() / Math.sqrt(trials));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(trials));
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(n, trials);

        System.out.println("mean = " + ps.mean());
        System.out.println("stddev = " + ps.stddev());
        System.out.println("95% confidence interval = " +
                ps.confidenceLo() + ", " +
                ps.confidenceHi());
    }
}
