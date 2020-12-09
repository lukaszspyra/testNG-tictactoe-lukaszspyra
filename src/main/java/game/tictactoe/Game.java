package game.tictactoe;

public final class Game {

    private final Arbiter arbiter;
    private final UI ui;
    private Board board;
    private Player currentPlayer;


    public Game(final Board board, final UI ui, final Arbiter arbiter, final Player firstPlayer) {
        this.board = board;
        this.ui = ui;
        this.arbiter = arbiter;
        this.currentPlayer = firstPlayer;
    }

    public Player play() {
        do {
            ui.printBoard(board);
            Move move = currentPlayer.makeMove(board);
            board = board.playAt(move);
            currentPlayer = currentPlayer.nextPlayer();
        } while (arbiter.judge(board).endsGame());

        System.out.println(arbiter.judge(board).message());
        return currentPlayer;
    }
}
