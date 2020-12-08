package game.tictactoe;

import java.util.Scanner;

public final class Game {

    private final Arbiter arbiter;
    private Board board;
    private Player currentPlayer;

    public Game(final Board board, final Arbiter arbiter, final Player firstPlayer) {
        this.board = board;
        this.arbiter = arbiter;
        this.currentPlayer = firstPlayer;
    }

    public Player play() {
        Scanner scanner = new Scanner(System.in);
        Move move;

        do {
            System.out.println("Player" + currentPlayer + " row <1;3>: ");
            var first = scanner.nextInt();
            System.out.println("Player" + currentPlayer + " column <1;3>: ");
            var second = scanner.nextInt();

            move = currentPlayer.makeMove(first - 1, second - 1);

            if (!board.isValid(move)) {
                System.out.println("Invalid input - try again!");
                continue;
            }

            board = board.playAt(move);
            System.out.println(board);
            currentPlayer = currentPlayer.nextPlayer();
        } while (!arbiter.judge(board) || board.isAnyCellEmpty());

        if (arbiter.judge(board)){
            System.out.println(currentPlayer + " wins");
        } else {
            System.out.println("It is draw");
        }
        return currentPlayer;
    }
}
