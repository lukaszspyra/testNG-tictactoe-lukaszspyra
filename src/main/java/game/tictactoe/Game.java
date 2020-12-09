package game.tictactoe;

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
        Move move;

        do {
            move = currentPlayer.makeMove(board);
            board = board.playAt(move);
            System.out.println(board);
            currentPlayer = currentPlayer.nextPlayer();
        } while (!arbiter.judge(board).endsGame());

        System.out.println(arbiter.judge(board).message());
        return currentPlayer;
    }
}
