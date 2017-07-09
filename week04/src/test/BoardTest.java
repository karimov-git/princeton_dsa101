import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by R.Karimov on 7/9/17.
 */
public class BoardTest {
    private int[][] blocks;
    private Board board;
    
    @Before
    public void setUp(){
        // Hamming: 5
        // Manhattan: 10
        blocks = new int[][]{
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}};
        board = new Board(blocks);
    }

    /*
    // TODO: How to test private method?
    @Test
    public void placeNumByRowAndCol() throws Exception {
        int row = 2;
        int col = 1;

        Board board = new Board(blocks);
        assertEquals(8, board.getPlaceNum(row, col));
    }
    */

    @Test
    public void getHamming() throws Exception {
        assertEquals(5, board.hamming());
    }

    @Test
    public void getManhattan() throws Exception {
        assertEquals(10, board.manhattan());
    }

    @Test
    public void boardIsGoalTrue() throws Exception {
        blocks = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}};
        board = new Board(blocks);
        assertTrue(board.isGoal());
    }

    @Test
    public void boardIsGoalFalse() throws Exception {
        blocks = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 8}};
        board = new Board(blocks);
        assertFalse(board.isGoal());
    }

    /*
    // TODO: How to test equality 2d arrays?
    @Test
    public void getTwin() throws Exception {
        int[][] blocks2 = new int[][]{
                {1, 8, 3},
                {4, 0, 2},
                {7, 6, 5}};
        Board board2 = new Board(blocks2);
        assertArrayEquals(board2, board);

    }
    */
}