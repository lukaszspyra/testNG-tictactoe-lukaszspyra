package game.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public final class UI {

    private final Scanner scanner;
    private final PrintStream printer;
    private final int arrayBeginOffset;

    UI() {
        scanner = new Scanner(System.in);
        printer = System.out;
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
            printer.println("Cell is already played");
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
        printer.println(userPrompt);
    }


    public void printBoard(final Board board) {
        String upperDelimiter = "-";
        String sideDelimiter = " | ";
        printer.println("      1   " + "  2   " + "  3   ");
        printer.println("   " + upperDelimiter.repeat(19));
        int columnNumber = 0;
        for (var rows : board.getGameBoard()) {
            columnNumber++;
            printer.print(columnNumber + " ");
            printer.print(sideDelimiter);
            for (int i = 0; i < rows.length; i++) {
                printCell(rows[i]);
                printer.print(sideDelimiter);
            }
            printer.println();
            printer.println("   " + upperDelimiter.repeat(19));
        }
        printer.println();
    }

    private void printCell(Player player) {
        if (player == null) {
            printer.print("   ");
            return;
        }
        switch (player) {
            case X -> printer.print(" X ");
            case O -> printer.print(" O ");
        }
    }
}
