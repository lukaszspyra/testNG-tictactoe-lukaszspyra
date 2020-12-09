package game.tictactoe;

import java.io.PrintStream;
import java.util.Scanner;

public final class UI {

    private final Scanner scanner;
    private final PrintStream printer;
    private final int boardOffset;

    UI() {
        scanner = new Scanner(System.in);
        printer = System.out;
        boardOffset = 1;
    }

    public Move readMove(Board board, Player player) {
        do {
            int row = readPlayerNumber(board, "row") - boardOffset;
            int column = readPlayerNumber(board, "column") - boardOffset;
            Move plannedMove = new Move(row, column, player);
            if (board.isAvailable(plannedMove)) {
                return plannedMove;
            }
            System.out.println("Cell is already played");
        } while (true);
    }


    private int readPlayerNumber(Board board, String cell) {
        do {
            printInputMessage(cell, board);
            int number = scanner.nextInt();
            if (board.inBoardLimits(number)) {
                return number;
            }
            System.out.println("Input number outside the board limits");
        } while (true);
    }

    private void printInputMessage(String cell, Board board) {
        String userPrompt = String.format("Enter a %s number in range <1 ; %d>: ", cell, board.getGameBoard().length);
        System.out.println(userPrompt);
    }


    public void printBoard(final Board board) {
        String upperDelimiter = "-";
        String sideDelimiter = " | ";
        System.out.println("      1   " + "  2   " + "  3   ");
        System.out.println("   " + upperDelimiter.repeat(19));
        int columnNumber = 0;
        for (var rows : board.getGameBoard()) {
            columnNumber++;
            System.out.print(columnNumber + " ");
            System.out.print(sideDelimiter);
            for (int i = 0; i < rows.length; i++) {
                printCell(rows[i]);
                System.out.print(sideDelimiter);
            }
            System.out.println();
            System.out.println("   " + upperDelimiter.repeat(19));
        }
        System.out.println();
    }

    private void printCell(Player player) {
        if (player == null) {
            System.out.print("   ");
            return;
        }
        switch (player) {
            case X -> System.out.print(" X ");
            case O -> System.out.print(" O ");
        }
    }
}
