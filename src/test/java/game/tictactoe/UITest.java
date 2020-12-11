package game.tictactoe;

import org.testng.annotations.Test;
import java.util.Scanner;

import static org.testng.Assert.*;

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

}