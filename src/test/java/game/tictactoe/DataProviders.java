package game.tictactoe;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataProviders {

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

    @DataProvider
    public static Object[][] cellNumbersIn3x3(){
        Integer[][] cellNumbers = new Integer[][]{
                {0,0},
                {0,1},
                {0,2},
                {1,0},
                {1,1},
                {1,2},
                {2,0},
                {2,1},
                {2,2}
        };
        return cellNumbers;
    }

}
