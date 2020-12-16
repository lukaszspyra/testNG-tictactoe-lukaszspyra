package spyra.lukasz.game.tictactoe.tictactoe;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "Arbiter")
public class ArbiterTest {

    public static final String WIN_MESSAGE = "Congratulations you win";
    public static final String TIE_MESSAGE = "End of game - tie";
    public static final String GAME_IN_PROGRESS = "Game in progress";
    private Arbiter arbiter;


    @BeforeMethod
    public void setUp() {
        arbiter = new Arbiter();
    }

    @Test(dataProvider = "rowXWinningBoards", dataProviderClass = DataProviders.class, groups = "beforeJudge")
    public void shallReturnTrueForXMarksInARow(Player[][] gameBoard) {
        //given

        //when
        var result = arbiter.checkRows(gameBoard);

        //then
        assertTrue(result, "Shall assess row as win but does not");
    }

    @Test(dataProvider = "rowOWinningBoards", dataProviderClass = DataProviders.class, groups = "beforeJudge")
    public void shallReturnTrueForOMarksInARow(Player[][] gameBoard) {
        //given

        //when
        var result = arbiter.checkRows(gameBoard);

        //then
        assertTrue(result, "Shall assess row as win but does not");
    }

    @Test(dataProvider = "columnXWinningBoards", dataProviderClass = DataProviders.class, groups = "beforeJudge")
    public void shallReturnTrueForXMarksInAColumn(Player[][] gameBoard) {
        //given

        //when
        var result = arbiter.checkColumns(gameBoard);

        //then
        assertTrue(result, "Shall assess column as win but does not");
    }

    @Test(dataProvider = "columnOWinningBoards", dataProviderClass = DataProviders.class, groups = "beforeJudge")
    public void shallReturnTrueForOMarksInAColumn(Player[][] gameBoard) {
        //given
        

        //when
        var result = arbiter.checkColumns(gameBoard);

        //then
        assertTrue(result, "Shall assess column as win but does not");
    }

    @Test(dataProvider = "diagonalXWinningBoards", dataProviderClass = DataProviders.class, groups = "beforeJudge")
    public void shallReturnTrueForXMarksDiagonal(Player[][] gameBoard) {
        //given
        

        //when
        var result = arbiter.checkDiagonals(gameBoard);

        //then
        assertTrue(result, "Shall assess diagonal as win but does not");
    }

    @Test(dataProvider = "diagonalOWinningBoards", dataProviderClass = DataProviders.class, groups = "beforeJudge")
    public void shallReturnTrueForOMarksDiagonal(Player[][] gameBoard) {
        //given
        

        //when
        var result = arbiter.checkDiagonals(gameBoard);

        //then
        assertTrue(result, "Shall assess diagonal as win but does not");
    }

    @Test(dataProvider = "allWinningBoards", dataProviderClass = DataProviders.class, dependsOnGroups = "beforeJudge")
    public void shallReturnWinAnswer(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        
        var expected = new Answer(true, WIN_MESSAGE, true);

        //when
        var result = arbiter.judge(board);

        //then
        assertEquals(result, expected, "Shall return win answer but does not");

    }

    @Test(dataProvider = "tieBoards", dataProviderClass = DataProviders.class, dependsOnGroups = "beforeJudge")
    public void shallReturnTieAnswer(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        
        var expected = new Answer(true, TIE_MESSAGE, false);

        //when
        var result = arbiter.judge(board);

        //then
        assertEquals(result, expected, "Shall return tie answer but does not");
    }

    @Test(dataProvider = "gameInProgressBoards", dataProviderClass = DataProviders.class, dependsOnGroups = "beforeJudge")
    public void shallReturnInProgressAnswer(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        
        var expected = new Answer(false, GAME_IN_PROGRESS, false);

        //when
        var result = arbiter.judge(board);

        //then
        assertEquals(result, expected, "Shall return game in progress answer but does not");
    }

    @Test(dataProvider = "tieBoards", dataProviderClass = DataProviders.class, dependsOnGroups = "beforeJudge")
    public void shallNotReturnWinAnswerForTieBoards(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        
        var expected = new Answer(true, WIN_MESSAGE, true);

        //when
        var result = arbiter.judge(board);

        //then
        assertNotEquals(result, expected, "Shall not return win answer for tie boards, but it does");
    }

    @Test(dataProvider = "gameInProgressBoards", dataProviderClass = DataProviders.class, dependsOnGroups = "beforeJudge")
    public void shallNotReturnWinAnswerForInProgressBoards(Player[][] gameBoard) {
        //given
        Board board = new Board(gameBoard);
        
        var expected = new Answer(true, WIN_MESSAGE, true);

        //when
        var result = arbiter.judge(board);

        //then
        assertNotEquals(result, expected, "Shall not return win answer for game in progress, but it does");
    }

}

