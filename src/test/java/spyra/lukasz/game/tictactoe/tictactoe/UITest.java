package spyra.lukasz.game.tictactoe.tictactoe;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

@Test(groups = "UI")
public class UITest {

    @Test(dataProvider = "cellNumbersIn3x3", dataProviderClass = DataProviders.class)
    public void shallReturnMoveForCorrectPlayerInput(int row, int column) {
        //given
        int arrayBeginOffset = 1;
        String input = (row + arrayBeginOffset) + "\n" + (column + arrayBeginOffset) + "\n";

        UI ui = new UI(new Scanner(input), System.out);
        Board board = new Board(new Player[3][3]);
        Player player = Player.X;

        var expected = new Move(row, column, player);

        //when
        var result = ui.readMove(board, player);

        //then
        assertEquals(result, expected, "Shall return correctly created move, but it did not");
    }

    @Test(dataProvider = "notValidIntegerInputs", dataProviderClass = DataProviders.class)
    public void shallPrintErrorForIncorrectPlayerInput(String input1, String input2, String input3) throws FileNotFoundException {
        //given
        String input = input1 + "\n" + input2 + "\n" + input3;
        ByteArrayOutputStream outputError = new ByteArrayOutputStream();

        UI ui = new UI(new Scanner(input), System.out);
        Board board = new Board(new Player[3][3]);
        Player player = Player.X;

        //when
        System.setErr(new PrintStream(outputError));
        var result = ui.readMove(board, player);

        //then
        assertEquals(outputError.toString().trim(), "Input number is not valid integral", "Shall return with error message, but it did not");
    }
}