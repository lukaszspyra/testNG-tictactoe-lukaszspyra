package game.tictactoe;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "Board")
public class BoardTest {

    @Test(dataProvider = "cellNumbersIn3x3", dataProviderClass = BoardDataProviders.class)
    public void shallReturnTrueIfCellIsNotPlayedYet(int row, int column) {
        //given
        Board board = new Board(new Player[3][3]);
        Move move = new Move(row, column, Player.X);

        //when
        var result = board.isAvailable(move);

        //then
        assertTrue(result, "Shall return that cell is not played yet, but does not");
    }

    @Test(dataProvider = "cellNumbersIn3x3", dataProviderClass = BoardDataProviders.class)
    public void shallReturnFalseIfCellIsIsPlayedAlready(int row, int column) {
        //given
        Board board = new Board(new Player[][]{
                {Player.O, Player.O, Player.X},
                {Player.X, Player.O, Player.O},
                {Player.O, Player.X, Player.X}
        });
        Move move = new Move(row, column, Player.X);

        //when
        var result = board.isAvailable(move);

        //then
        assertFalse(result, "Shall return that cell is played, but does not");
    }

    @Test
    public void shallBeInBoardLimits3x3() {
        //given
        Board board = new Board(new Player[3][3]);

        //when
        var result1 = board.inBoardLimits(0);
        var result2 = board.inBoardLimits(1);
        var result3 = board.inBoardLimits(2);

        //then
        assertTrue(result1, "Shall return that number is in board array limit, but does not");
        assertTrue(result2, "Shall return that number is in board array limit, but does not");
        assertTrue(result3, "Shall return that number is in board array limit, but does not");
    }

    @Test
    public void shallBeOutOfBoardLimits3x3() {
        //given
        Board board = new Board(new Player[3][3]);

        //when
        var result1 = board.inBoardLimits(-1);
        var result2 = board.inBoardLimits(5);
        var result3 = board.inBoardLimits(3);

        //then
        assertFalse(result1, "Shall return that number is in board array limit, but does not");
        assertFalse(result2, "Shall return that number is in board array limit, but does not");
        assertFalse(result3, "Shall return that number is in board array limit, but does not");
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

    @Test(dataProvider = "cellNumbersIn3x3", dataProviderClass = BoardDataProviders.class)
    public void shallReturnCorrectlyModifiedBoardWhenMoveExecuted(int row, int column) {
        //given
        Board board = new Board(new Player[3][3]);
        Move move = new Move(row, column, Player.O);

        //when
        var result = board.playAt(move).getGameBoard()[row][column];

        //then
        assertEquals(result, Player.O, "Cell shall be played by PlayerO, but was not");
    }
}