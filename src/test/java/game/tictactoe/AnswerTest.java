package game.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test(groups = "Answer")
public class AnswerTest {


    @Test(dataProvider = "equalAnswers")
    public void testEqualAnswers(Answer answer1, Answer answer2) {
        //given


        //when
        var result = answer1.equals(answer2);

        //then
        assertTrue(result, "Shall be equal, but it is not");
    }

    @Test(dataProvider = "notEqualAnswers")
    public void testNotEqualAnswers(Answer answer1, Answer answer2) {
        //given


        //when
        var result = answer1.equals(answer2);

        //then
        assertFalse(result, "Shall not be equal, but it is");
    }

    @Test(dataProvider = "equalAnswers")
    public void testTheSameHashCode(Answer answer1, Answer answer2) {
        //given


        //when
        var result1 = answer1.hashCode();
        var result2 = answer2.hashCode();

        //then
        assertEquals(result1, result2, "Hash code shall be the same for equal answers, but it's not");
    }

    @DataProvider
    public static Object[][] equalAnswers() {
        Answer answer1 = new Answer(true, "", false);
        Answer answer2 = new Answer(true, "", false);
        Object answer3 = new Answer(true, "", false);

        return new Object[][]{
                {answer1, answer2},
                {answer2, answer3},
                {answer1, answer3},
                {answer1, answer1}
        };
    }

    @DataProvider
    public static Object[][] notEqualAnswers() {
        Answer answer1 = new Answer(true, "", false);
        Answer answer2 = new Answer(false, "", false);
        Answer answer3 = new Answer(false, " ", false);
        Answer answer4 = new Answer(false, "", true);
        Answer answer5 = new Answer(true, "", true);
        Answer answer6 = null;

        return new Object[][]{
                {answer1, answer2},
                {answer2, answer3},
                {answer3, answer4},
                {answer4, answer5},
                {answer5, answer6},
        };
    }


}