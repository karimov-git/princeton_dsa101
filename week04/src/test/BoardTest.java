import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by lxuser on 7/9/17.
 */
public class BoardTest {
    private int[][] blocks;
    private Board board;
    
    @Before
    public void setUp(){
        blocks = new int[3][3];
    }

    @Test
    public void placeNumByRowAndCol() throws Exception {
        int row = 2;
        int col = 1;

        Board board = new Board(blocks);
        assertEquals(8, board.getPlaceNum(row, col));
    }

    @Test
    public void getBlockInPlace() throws Exception {
        blocks = new int[][]{
                {1, 0, 3}, // 2
                {4, 6, 5}, // 1
                {2, 8, 7}}; // 1; Total: 4
        board = new Board(blocks);
        assertEquals(4, board.getBlocksInPlace());
    }
}