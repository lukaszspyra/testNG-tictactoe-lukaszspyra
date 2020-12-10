package game.tictactoe;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "Answer")
public class AnswerTest {


    @Test
    public void testEquals() {
        //given
        Answer answer1 = new Answer(true, "", false);
        Answer answer2 = new Answer(true, "", false);
        Object answer3 = new Answer(true, "", false);

        Answer answer4 = new Answer(false, "", false);
        Answer answer5 = new Answer(false, " ", false);
        Answer answer6 = new Answer(false, "", true);
        Answer answer7 = new Answer(true, "", true);
        Answer answer8 = null;

        //when
        var result = answer1.equals(answer1);
        var result1 = answer1.equals(answer2);
        var result2 = answer1.equals(answer3);
        var result3 = answer1.equals(answer4);
        var result4 = answer1.equals(answer5);
        var result5 = answer1.equals(answer6);
        var result6 = answer1.equals(answer7);
        var result7 = answer1.equals(answer8);


        //then
        assertTrue(result, "Shall be equal, but it is not");
        assertTrue(result1, "Shall be equal, but it is not");
        assertTrue(result2, "Shall be equal, but it is not");

        assertFalse(result3, "Shall not be equal, but it is");
        assertFalse(result4, "Shall not be equal, but it is");
        assertFalse(result5, "Shall not be equal, but it is");
        assertFalse(result6, "Shall not be equal, but it is");
        assertFalse(result7, "Shall not be equal, but it is");
    }

    @Test
    public void testHashCode() {
        //given
        Answer answer1 = new Answer(true, "", false);
        Answer answer2 = new Answer(true, "", false);
        Object answer3 = new Answer(true, "", false);

        //when
        var result1 = answer1.hashCode();
        var result2 = answer2.hashCode();
        var result3 = answer3.hashCode();
        var result4 = answer1.hashCode();

        //then
        assertEquals(result1, result2, "Hash code shall be the same for equal answers, but it's not");
        assertEquals(result1, result3, "Hash code shall be the same for equal answers, but it's not");
        assertEquals(result1, result4, "Hash code shall be the same for equal answers, but it's not");
    }
}