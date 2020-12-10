package game.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "Arbiter")
public class ArbiterTest {

    public static final String WIN_MESSAGE = "Congratulations you win";
    public static final String TIE_MESSAGE = "End of game - tie";
    public static final String GAME_IN_PROGRESS = "Game in progress";


    @Test(description = "Row X checks", dataProvider = "rowXWinningBoards")
    public void shallReturnTrueForXMarksInARow(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkRows(gameBoard);

        //then
        assertTrue(result, "Shall assess row as win but does not");
    }

    @Test(description = "Row O checks", dataProvider = "rowOWinningBoards")
    public void shallReturnTrueForOMarksInARow(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkRows(gameBoard);

        //then
        assertTrue(result, "Shall assess row as win but does not");
    }

    @Test(description = "Column X checks", dataProvider = "columnXWinningBoards")
    public void shallReturnTrueForXMarksInAColumn(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkColumns(gameBoard);

        //then
        assertTrue(result, "Shall assess column as win but does not");
    }

    @Test(description = "Column O checks", dataProvider = "columnOWinningBoards")
    public void shallReturnTrueForOMarksInAColumn(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkColumns(gameBoard);

        //then
        assertTrue(result, "Shall assess column as win but does not");
    }

    @Test(description = "Diagonal X checks", dataProvider = "diagonalXWinningBoards")
    public void shallReturnTrueForXMarksDiagonal(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkDiagonals(gameBoard);

        //then
        assertTrue(result, "Shall assess diagonal as win but does not");
    }

    @Test(description = "Diagonal O checks", dataProvider = "diagonalOWinningBoards")
    public void shallReturnTrueForOMarksDiagonal(Player[][] gameBoard) {
        //given
        Arbiter arbiter = new Arbiter();

        //when
        var result = arbiter.checkDiagonals(gameBoard);

        //then
        assertTrue(result, "Shall assess diagonal as win but does not");
    }

    @Test(dataProvider = "allWinningBoards")
    public void shallReturnWinAnswer(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        Arbiter arbiter = new Arbiter();
        var expected = new Answer(true, WIN_MESSAGE, true);

        //when
        var result = arbiter.judge(board);

        //then
        assertEquals(result, expected, "Shall return win answer but does not");

    }

    @Test(dataProvider = "tieBoards")
    public void shallReturnTieAnswer(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        Arbiter arbiter = new Arbiter();
        var expected = new Answer(true, TIE_MESSAGE, false);

        //when
        var result = arbiter.judge(board);

        //then
        assertEquals(result, expected, "Shall return tie answer but does not");
    }

    @Test(dataProvider = "gameInProgressBoards")
    public void shallReturnInProgressAnswer(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        Arbiter arbiter = new Arbiter();
        var expected = new Answer(false, GAME_IN_PROGRESS, false);

        //when
        var result = arbiter.judge(board);

        //then
        assertEquals(result, expected, "Shall return game in progress answer but does not");
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

    @DataProvider(name = "allWinningBoards")
    public static Object[] mergeOfWinningBoards() {

        var mergedWinBoards = Stream.of(rowOWinningBoards(),
                rowOWinningBoards(),
                columnXWinningBoards(),
                columnOWinningBoards(),
                diagonalXWinningBoards(),
                diagonalOWinningBoards())
                .flatMap(Arrays::stream)
                .toArray(Object[]::new);

        return mergedWinBoards;
    }

    @DataProvider
    public static Object[] tieBoards() {
        Player[][] board1 = new Player[][]{
                {Player.O, Player.O, Player.X},
                {Player.X, Player.X, Player.O},
                {Player.O, Player.X, Player.O}
        };
        Player[][] board2 = new Player[][]{
                {Player.X, Player.O, Player.X},
                {Player.O, Player.X, Player.O},
                {Player.O, Player.X, Player.O}
        };
        Player[][] board3 = new Player[][]{
                {Player.O, Player.O, Player.X},
                {Player.X, Player.O, Player.O},
                {Player.O, Player.X, Player.X}
        };
        return new Object[]{board1, board2, board3};
    }

    @DataProvider
    public static Object[] gameInProgressBoards() {
        Player[][] board1 = new Player[][]{
                {null, null, null},
                {null, null, null},
                {null, null, null}
        };
        Player[][] board2 = new Player[][]{
                {Player.O, null, Player.O},
                {null, null, Player.X},
                {Player.O, null, Player.X}
        };
        Player[][] board3 = new Player[][]{
                {Player.X, Player.X, Player.O},
                {null, Player.O, Player.X},
                {Player.X, Player.X, Player.O}
        };
        return new Object[]{board1, board2, board3};
    }

}

