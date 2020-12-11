package game.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public final class UI {

    private final Scanner scanner;
    private final PrintStream out;
    private final int arrayBeginOffset;

    UI(final Scanner scanner, final PrintStream out) {
        this.scanner = scanner;
        this.out = out;
        arrayBeginOffset = 1;
    }

    public Move readMove(Board board, Player player) {
        do {
            int row = readPlayerNumber(board, "row", player);
            int column = readPlayerNumber(board, "column", player);
            Move plannedMove = new Move(row, column, player);
            if (board.isAvailable(plannedMove)) {
                return plannedMove;
            }
            System.err.println("Cell is already played");
        } while (true);
    }


    private int readPlayerNumber(Board board, String cell, Player player) {
        do {
            printInputMessage(cell, board, player);
            int number = scanner.nextInt() - arrayBeginOffset;
            if (board.inBoardLimits(number)) {
                return number;
            }
            System.err.println("Input number outside the board limits");
        } while (true);
    }

    private void printInputMessage(String cell, Board board, Player player) {
        String userPrompt = String.format("Player%s - Enter a %s number in range <1 ; %d>: ",player, cell, board.getGameBoard().length);
        out.println(userPrompt);
    }


    public void printBoard(final Board board) {
        String upperDelimiter = "-";
        String sideDelimiter = " | ";
        out.println("      1   " + "  2   " + "  3   ");
        out.println("   " + upperDelimiter.repeat(19));
        int columnNumber = 0;
        for (var rows : board.getGameBoard()) {
            columnNumber++;
            out.print(columnNumber + " ");
            out.print(sideDelimiter);
            for (int i = 0; i < rows.length; i++) {
                printCell(rows[i]);
                out.print(sideDelimiter);
            }
            out.println();
            out.println("   " + upperDelimiter.repeat(19));
        }
        out.println();
    }

    private void printCell(Player player) {
        if (player == null) {
            out.print("   ");
            return;
        }
        switch (player) {
            case X -> out.print(" X ");
            case O -> out.print(" O ");
        }
    }

    public void showMessage(Object object){
        out.println(object);
    }
}
