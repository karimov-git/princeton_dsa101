
/**
 * Created by lxuser on 7/9/17.
 */
public class Board {
    private int[][] blocks;

    public int getPlaceNum(int row, int col) {
        return this.dimension() * row + col + 1;
    }

    public Board(int[][] blocks) {
        this.blocks = blocks;
    }

    public int dimension() {
        return blocks.length;
    }

    public int getBlocksInPlace() {
        int count = 0;
        for (int row = 0; row < this.dimension(); row++) {
            for (int col = 0; col < this.dimension(); col++) {
                if (getPlaceNum(row, col) == blocks[row][col]) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
