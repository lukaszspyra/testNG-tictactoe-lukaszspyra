package spyra.lukasz.game.tictactoe.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "Move")
public class MoveTest {


    @Test(dataProvider = "equalMoves", groups = "beforeHashCode")
    public void theSameMovesShallBeEqual(Move move1, Move move2) {
        //given


        //when
        var result = move1.equals(move2);

        //then
        assertTrue(result, "The same moves shall be equal, but are not");
    }

    @Test(dataProvider = "notEqualMoves", groups = "beforeHashCode")
    public void differentMovesShallNotBeEqual(Move move1, Move move2) {
        //given


        //when
        var result = move1.equals(move2);

        //then
        assertFalse(result, "Different moves shall not be equal, but they are");
    }

    @Test(dataProvider = "equalMoves", dependsOnGroups = "beforeHashCode")
    public void equalMovesShallHaveTheSameHashCode(Move move1, Move move2) {
        //given


        //when
        var result1 = move1.hashCode();
        var result2 = move2.hashCode();

        //then
        assertEquals(result1, result2, "Hash code shall be the same for equal moves, but it's not");
    }

    @DataProvider
    public static Object[][] equalMoves() {
        Move move1 = new Move(1, 1, Player.O);
        Move move2 = new Move(1, 1, Player.O);
        Object move3 = new Move(1, 1, Player.O);

        return new Object[][]{
                {move1, move2},
                {move2, move3},
                {move1, move3},
                {move1, move1}
        };
    }

    @DataProvider
    public static Object[][] notEqualMoves() {
        Move move1 = new Move(0, 1, Player.O);
        Move move2 = new Move(1, 0, Player.O);
        Move move3 = new Move(1, 1, Player.X);
        Move move4 = null;

        return new Object[][]{
                {move1, move2},
                {move2, move3},
                {move3, move4}
        };
    }
}
