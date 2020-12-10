package game.tictactoe;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test(groups = "Board")
public class BoardTest {

    @Test
    public void testIsAvailable() {
        //given



        //when

        //then


    }

    @Test
    public void testInBoardLimits() {
    }

    @Test(dataProvider = "gameInProgressBoards", dataProviderClass = BoardDataProviders.class)
    public void shallReturnTrueForAnyCellEmptyInInProgressBoards(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);

        //when
        var result = board.isAnyCellEmpty();

        //then
        assertTrue(result, "Shall return that any cell in empty, but does not");
    }


    @Test(dataProvider = "tieBoards", dataProviderClass = BoardDataProviders.class)
    public void shallReturnFalseForNoEmptyCells(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);

        //when
        var result = board.isAnyCellEmpty();

        //then
        assertFalse(result, "Shall return that there is no empty cell, but does not");
    }

    @Test
    public void testPlayAt() {
    }
}