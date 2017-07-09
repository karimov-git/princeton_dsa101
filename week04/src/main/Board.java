
/**
 * Created by R.Karimov on 7/9/17.
 */
public class Board {
    private int[][] blocks;

    /**
     * Return right place number by given row and column
     */
    private int getPlaceNum(int row, int col) {
        return this.dimension() * row + col + 1;
    }

    /**
     * Return goal row number for given block
     */
    private int getGoalRow(int block) {
        return block / dimension();
    }

    /**
     * Return goal column number for given block
     */
    private int getGoalColumn(int block) {
        return block % dimension() - 1;
    }

    public Board(int[][] blocks) {
        this.blocks = blocks;
    }

    /**
     * Return dimension of the board
     */
    public int dimension() {
        return blocks.length;
    }

    /**
     * Return Hamming priority function
     */
    public int hamming() {
        int count = 0;
        for (int row = 0; row < this.dimension(); row++) {
            for (int col = 0; col < this.dimension(); col++) {
                if (getPlaceNum(row, col) != blocks[row][col]
                        && blocks[row][col] !=0) {
                    count += 1;
                }
            }
        }
        return count;
    }

    /**
     * Return Manhattan priority function
     */
    public int manhattan() {
        int count = 0;
        for (int row = 0; row < this.dimension(); row++) {
            for (int col = 0; col < this.dimension(); col++) {
                if (blocks[row][col] != getPlaceNum(row, col)
                        && blocks[row][col] != 0) {
                    int goalRow = getGoalRow(blocks[row][col]);
                    int goalCol = getGoalColumn(blocks[row][col]);
                    count += Math.abs(goalRow - row) + Math.abs(goalCol - col);
                }
            }
        }
        return count;
    }

    /**
     * Test: is this board the goal board?
     */
    public boolean isGoal() {
        for (int row = 0; row < this.dimension(); row++) {
            for (int col = 0; col < this.dimension(); col++) {
                if (blocks[row][col] != 0 &&
                        blocks[row][col] != getPlaceNum(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Return new board by exchanging any pair of blocks
     */
    public Board twin() {
        //copy initial array
        int[][] copy = new int[this.dimension()][this.dimension()];
        for (int row = 0; row < this.dimension(); row++) {
            System.arraycopy(blocks[row], 0, copy[row], 0, this.dimension());
        }
        // find no zero element
        for (int row = 0; row < this.dimension(); row++) {
            for (int col = 0; col < this.dimension() - 1; col++) {
                if (blocks[row][col] != 0 &&
                        blocks[row][col + 1] != 0) {
                    copy[row][col] = blocks[row][col + 1];
                    copy[row][col + 1] = blocks[row][col];
                    break;
                }
            }
        }
        return new Board(copy);
    }

    public static void main(String[] args) {

        int[][] blocks = new int[][]{
                {0, 1, 3},
                {4, 8, 2},
                {7, 6, 5}};
        Board board = new Board(blocks);
        Board copyBoard = board.twin();
    }
}
