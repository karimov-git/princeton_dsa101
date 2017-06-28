import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by lxuser on 6/13/17.
 */
public class Percolation {

    private WeightedQuickUnionUF wqu;
    private boolean[] grid;
    private int size;
    private int openedSites = 0;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.size = n;
        wqu = new WeightedQuickUnionUF(n * n + 2);
        grid = new boolean[n * n + 2];
    }

//    find site number in grid
    private int getSiteByIndex(int row, int col) {
        return size * (row - 1) + col;
    }

//    row & col should be in [1..size]
    private void testSize(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IndexOutOfBoundsException();
        }
        if (row > size || col > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void open(int row, int col) {

        testSize(row, col);
        int currentSite = getSiteByIndex(row, col);
        if (isOpen(row, col)) {
            return;
        } else {
            grid[currentSite] = true;
            openedSites++;
        }

//      union currentSite with top cell
        if (row == 1) {
            wqu.union(currentSite, 0);
        }
//      union currentSite with bottom
        if (row == size) {
            wqu.union(currentSite, size * size + 1);
        }
//      union currentSite with left site;
        if (col > 1 && isOpen(row, col - 1)) {
            wqu.union(currentSite, getSiteByIndex(row, col - 1));
        }
//      union currentSite with right site
        if (col < size && isOpen(row, col + 1)) {
            wqu.union(currentSite, getSiteByIndex(row, col + 1));
        }
//      union currentSite with upper site
        if (row < size && isOpen(row + 1, col)) {
            wqu.union(currentSite, getSiteByIndex(row + 1, col));
        }
//      union currentSite with bottom site
        if (row > 1 && isOpen(row - 1, col)) {
            wqu.union(currentSite, getSiteByIndex(row - 1, col));
        }

    }

    public boolean isOpen(int row, int col) {
        testSize(row, col);
        int currentSite = getSiteByIndex(row, col);
        return grid[currentSite];
    }

    public boolean isFull(int row, int col) {
        testSize(row, col);
        int currentSite = getSiteByIndex(row, col);
        return wqu.connected(currentSite, 0);
    }

    public int numberOfOpenSites() {
        return openedSites;
    }

    public boolean percolates() {
        return wqu.connected(0, size * size + 1);
    }
}
