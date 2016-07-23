

import java.util.List;

public class MakeMove {
	 public static int DRAW = 0;
	    public static int WINNER = 1;
	    public static int LOSER = 2;

	    private Move move;
	    private List<Move> winningMove;

	    //creates move that maps to object to be compared to
	    public MakeMove(Move move, List<Move> winningMove) {
	        this.move = move;
	        this.winningMove = winningMove;
	    }

	   //returns the current move
	    public Move getMove() {
	        return this.move;
	    }

	    //checks to see if the move can be beaten
	    public int getOutcome(Move move) {
	        if (this.move.equals(move)) {
	            return DRAW;
	        }

	        if (winningMove.contains(move)) {
	            return WINNER;
	        }

	        return LOSER;
	    }
}
