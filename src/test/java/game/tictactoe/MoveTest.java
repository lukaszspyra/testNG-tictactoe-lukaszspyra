package game.tictactoe;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

@Test(groups = "Move")
public class MoveTest {

    @Test
    public void testEquals() {
        //given
        Move move1 = new Move(1, 1, Player.O);
        Move move2 = new Move(1, 1, Player.O);
        Object move3 = new Move(1, 1, Player.O);

        Move move4 = new Move(0, 1, Player.O);
        Move move5 = new Move(1, 0, Player.O);
        Move move6 = new Move(1, 1, Player.X);
        Move move7 = null;

        //when
        var result = move1.equals(move1);
        var result1 = move1.equals(move2);
        var result2 = move1.equals(move3);
        var result3 = move1.equals(move4);
        var result4 = move1.equals(move5);
        var result5 = move1.equals(move6);
        var result6 = move1.equals(move7);


        //then
        assertTrue(result, "Shall be equal, but it is not");
        assertTrue(result1, "Shall be equal, but it is not");
        assertTrue(result2, "Shall be equal, but it is not");

        assertFalse(result3, "Shall not be equal, but it is");
        assertFalse(result4, "Shall not be equal, but it is");
        assertFalse(result5, "Shall not be equal, but it is");
        assertFalse(result6, "Shall not be equal, but it is");
    }

    @Test
    public void testHashCode() {
        //given
        Move move1 = new Move(1,1, Player.X);
        Move move2 = new Move(1,1, Player.X);
        Object move3 = new Move(1,1, Player.X);

        //when
        var result1 = move1.hashCode();
        var result2 = move2.hashCode();
        var result3 = move3.hashCode();
        var result4 = move1.hashCode();

        //then
        assertEquals(result1, result2, "Hash code shall be the same for equal moves, but it's not");
        assertEquals(result1, result3, "Hash code shall be the same for equal moves, but it's not");
        assertEquals(result1, result4, "Hash code shall be the same for equal moves, but it's not");
    }
}
