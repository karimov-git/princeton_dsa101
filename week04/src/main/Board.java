
/**
 * Created by lxuser on 7/9/17.
 */
public class Board {
    private int[][] blocks;

    /**
     * Return right place number by given row and column
     * @param row
     * @param col
     * @return
     */
    private int getPlaceNum(int row, int col) {
        return this.dimension() * row + col + 1;
    }

    /**
     * Return goal row number for given block
     * @param block
     * @return
     */
    private int getGoalRow(int block) {
        return block / dimension();
    }

    /**
     * Return goal column number for given block
     * @param block
     * @return
     */
    private int getGoalColumn(int block) {
        return block % dimension() - 1;
    }

    public Board(int[][] blocks) {
        this.blocks = blocks;
    }

    /**
     * Return dimension of the board
     * @return
     */
    public int dimension() {
        return blocks.length;
    }

    /**
     * Return Hamming priority function
     * @return
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
     * @return
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

    public static void main(String[] args) {
        int[][] blocks = new int[4][4];
        Board board = new Board(blocks);
        int row = board.getGoalRow(0);
        int col = board.getGoalColumn(0);
        System.out.println("Dim: " + board.dimension());
        System.out.println("Col: " + col);
        System.out.println("Row: " + row);
    }
}
