package game.tictactoe;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Optional;
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
        var numberFormat = NumberFormat.getIntegerInstance();
        do {
            printInputMessage(cell, board, player);
            final Optional<Integer> validNumber = validateIntegerInput(board, numberFormat);
            if (validNumber.isPresent()) return validNumber.get();
        } while (true);
    }

    private Optional<Integer> validateIntegerInput(final Board board, final NumberFormat numberFormat) {
        String userInput = scanner.nextLine();
        try {
            int number = numberFormat.parse(userInput).intValue() - arrayBeginOffset;
            if (board.inBoardLimits(number)) {
                return Optional.of(number);
            }
            System.err.println("Input number outside the board limits");
        } catch (ParseException e) {
            System.err.println("Input number is not valid integral");
        }
        return Optional.empty();
    }

    private void printInputMessage(String cell, Board board, Player player) {
        String userPrompt = String.format("Player%s - Enter a %s number in range <1 ; %d>: ", player, cell, board.getGameBoard().length);
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

    public void showMessage(Object object) {
        out.println(object);
    }
}
