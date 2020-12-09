package game.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ArbiterTest {

    @Test(description = "Shall assess row as win but does not", dataProvider = "rowXWinningBoards")
    public void shallReturnTrueForXMarksInARow(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkRows(gameBoard);

        //then
        assertTrue(result, "Shall assess row as win but does not");
    }

    @Test(description = "Shall assess row as win but does not", dataProvider = "rowOWinningBoards")
    public void shallReturnTrueForOMarksInARow(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkRows(gameBoard);

        //then
        assertTrue(result, "Shall assess row as win but does not");
    }

    @Test(description = "Shall assess column as win but does not", dataProvider = "columnXWinningBoards")
    public void shallReturnTrueForXMarksInAColumn(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkColumns(gameBoard);

        //then
        assertTrue(result, "Shall assess column as win but does not");
    }

    @Test(description = "Shall column row as win but does not", dataProvider = "columnOWinningBoards")
    public void shallReturnTrueForOMarksInAColumn(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkColumns(gameBoard);

        //then
        assertTrue(result, "Shall assess column as win but does not");
    }

    @Test(description = "Shall assess diagonal as win but does not", dataProvider = "diagonalXWinningBoards")
    public void shallReturnTrueForXMarksDiagonal(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkDiagonals(gameBoard);

        //then
        assertTrue(result, "Shall assess diagonal as win but does not");
    }

    @Test(description = "Shall assess diagonal as win but does not", dataProvider = "diagonalOWinningBoards")
    public void shallReturnTrueForOMarksDiagonal(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkDiagonals(gameBoard);

        //then
        assertTrue(result, "Shall assess diagonal as win but does not");
    }

    @DataProvider()
    public static Object[] rowXWinningBoards() {
        Player[][] board1 = new Player[][]{
                {Player.X, Player.X, Player.X},
                {null, Player.X, Player.O},
                {Player.X, null, Player.O}
        };
        Player[][] board2 = new Player[][]{
                {Player.O, Player.X, Player.O},
                {Player.X, Player.X, Player.X},
                {Player.X, null, Player.O}
        };
        Player[][] board3 = new Player[][]{
                {Player.O, Player.X, Player.O},
                {Player.X, null, Player.O},
                {Player.X, Player.X, Player.X}
        };
        Player[][] board4 = new Player[][]{
                {Player.X, Player.X, Player.X},
                {Player.X, Player.X, Player.X},
                {Player.X, Player.X, Player.X}
        };
        return new Object[]{board1, board2, board3, board4};
    }

    @DataProvider()
    public static Object[] rowOWinningBoards() {
        Player[][] board1 = new Player[][]{
                {Player.O, Player.O, Player.O},
                {null, Player.X, Player.O},
                {Player.X, Player.O, Player.O}
        };
        Player[][] board2 = new Player[][]{
                {null, null, null},
                {Player.O, Player.O, Player.O},
                {Player.X, Player.O, Player.O}
        };
        Player[][] board3 = new Player[][]{
                {Player.X, Player.X, Player.O},
                {Player.X, Player.O, Player.X},
                {Player.O, Player.O, Player.O}
        };
        Player[][] board4 = new Player[][]{
                {Player.O, Player.O, Player.O},
                {Player.O, Player.O, Player.O},
                {Player.O, Player.O, Player.O}
        };
        return new Object[]{board1, board2, board3, board4};
    }

    @DataProvider()
    public static Object[] columnXWinningBoards() {
        Player[][] board1 = new Player[][]{
                {Player.X, null, Player.O},
                {Player.X, Player.X, Player.O},
                {Player.X, Player.O, null}
        };
        Player[][] board2 = new Player[][]{
                {null, Player.X, null},
                {Player.O, Player.X, Player.O},
                {Player.X, Player.X, Player.O}
        };
        Player[][] board3 = new Player[][]{
                {Player.X, null, Player.X},
                {Player.X, null, Player.X},
                {Player.O, null, Player.X}
        };
        Player[][] board4 = new Player[][]{
                {Player.X, Player.X, Player.X},
                {Player.X, Player.X, Player.X},
                {Player.X, Player.X, Player.X}
        };
        return new Object[]{board1, board2, board3, board4};
    }

    @DataProvider()
    public static Object[] columnOWinningBoards() {
        Player[][] board1 = new Player[][]{
                {Player.O, null, Player.O},
                {Player.O, Player.X, Player.O},
                {Player.O, Player.O, null}
        };
        Player[][] board2 = new Player[][]{
                {null, Player.O, null},
                {Player.O, Player.O, Player.O},
                {Player.X, Player.O, Player.O}
        };
        Player[][] board3 = new Player[][]{
                {Player.X, null, Player.O},
                {Player.X, null, Player.O},
                {Player.O, null, Player.O}
        };
        Player[][] board4 = new Player[][]{
                {Player.O, Player.O, Player.O},
                {Player.O, Player.O, Player.O},
                {Player.O, Player.O, Player.O}
        };
        return new Object[]{board1, board2, board3, board4};
    }

    @DataProvider()
    public static Object[] diagonalXWinningBoards() {
        Player[][] board1 = new Player[][]{
                {Player.X, null, Player.X},
                {null, Player.X, Player.O},
                {null, null, Player.X}
        };
        Player[][] board2 = new Player[][]{
                {Player.O, Player.X, Player.X},
                {Player.O, Player.X, Player.X},
                {Player.X, null, Player.O}
        };
        Player[][] board3 = new Player[][]{
                {Player.X, Player.X, Player.X},
                {Player.X, Player.X, Player.X},
                {Player.X, Player.X, Player.X}
        };
        return new Object[]{board1, board2, board3};
    }

    @DataProvider()
    public static Object[] diagonalOWinningBoards() {
        Player[][] board1 = new Player[][]{
                {Player.O, null, Player.X},
                {null, Player.O, Player.O},
                {null, null, Player.O}
        };
        Player[][] board2 = new Player[][]{
                {Player.O, Player.X, Player.O},
                {Player.O, Player.O, Player.X},
                {Player.O, null, Player.X}
        };
        Player[][] board3 = new Player[][]{
                {Player.O, Player.O, Player.O},
                {Player.O, Player.O, Player.O},
                {Player.O, Player.O, Player.O}
        };
        return new Object[]{board1, board2, board3};
    }
}

