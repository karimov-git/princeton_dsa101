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
        // Hamming: 5
        // Manhattan: 10
        blocks = new int[][]{
                {8, 1, 3},
                {4, 0, 2},
                {7, 6, 5}};
                            //
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
    public void getManhatten() throws Exception {
        assertEquals(10, board.manhattan());
    }
}