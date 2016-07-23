

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
	 private List<MakeMove> moveList = new ArrayList<MakeMove>();

	    private Random random = new Random();

	    private int pScore = 0;
	    private int cScore = 0;

	    //adds move to list
	    public void addMove(MakeMove setting) {
	        moveList.add(setting);
	    }

	    //returns winning move
	    public int getWinner(Move moveOne, Move moveTwo) {
	        for (MakeMove move : moveList) {
	            if (move.getMove().equals(moveOne)) {
	                return move.getOutcome(moveTwo);
	            }
	        }
	        
	        return -1;
	    }

	   //this function make a random move for the computer
	    public Move getComputerMove() {
	        int randomMove = random.nextInt(moveList.size());
	        return moveList.get(randomMove).getMove();
	    }

	    //increment player score
	    public void updatePlayerScore() {
	        pScore++;
	    }

	    //increment computer score
	    public void updateComputerScore() {
	        cScore++;
	    }

	   //returns score for computer and player
	    public String getScore() {
	        return pScore + " - " + cScore;
	    }
}
