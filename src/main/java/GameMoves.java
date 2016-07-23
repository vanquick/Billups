


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMoves {
	Move rock = new Move("Rock");
    Move paper = new Move("Paper");
    Move scissor = new Move("Scissor");
    Move lizard = new Move("Lizard");
    Move spock = new Move("Spock");

    @SuppressWarnings("resource")
	public void startGame() {
        
    	Game game = setupGame();

		Scanner inputScanner = new Scanner(System.in);
		
        System.out.print("Make your choice\n(R)ock\n(P)aper\n(S)cissor\n(L)izard\n(SP)ock\nor type Exit to quit: ");
        
        while (inputScanner.hasNextLine()) {
            Move computerMove = game.getComputerMove();
            String input = inputScanner.nextLine();
            if (input.toUpperCase().equals("EXIT")) {
                System.exit(0);
            }
            Move yourChoice;
            try {
                yourChoice = getMove(input.toUpperCase());
            } catch (IllegalArgumentException ex) {
                System.out.print("Not a valid move:\nPlease chose (R)ock, (P)aper, (S)cissors, (L)izard, or (SP)ock: ");
                continue;
            }

            System.out.println("Your choice " + yourChoice.name);
            System.out.println("Computer chose: " + computerMove.name);

            int outcome = game.getWinner(yourChoice, computerMove);

            if (outcome == MakeMove.DRAW) {
                System.out.println("Thats a draw\nscore is = " + game.getScore());
            } else if (outcome == MakeMove.WINNER) {
                game.updatePlayerScore();
                System.out.println("Good job you win!\nscore is = " + game.getScore());
            } else if (outcome == MakeMove.LOSER) {
                game.updateComputerScore();
                System.out.println("You lost\nscore is = " + game.getScore());

            }

            System.out.println("");
            System.out.println("Try again or type exit:  ");
        }
    }

    //Array list to hold winners for each element
    private Game setupGame() {
    	Game game = new Game();

        List<Move> rockBeats = new ArrayList<Move>();
        rockBeats.add(scissor);
        rockBeats.add(lizard);
        game.addMove(new MakeMove(rock, rockBeats));

        List<Move> paperBeats = new ArrayList<Move>();
        paperBeats.add(rock);
        paperBeats.add(spock);
        game.addMove(new MakeMove(paper, paperBeats));

        List<Move> scissorBeats = new ArrayList<Move>();
        scissorBeats.add(paper);
        scissorBeats.add(lizard);
        game.addMove(new MakeMove(scissor, scissorBeats));

        List<Move> lizardBeats = new ArrayList<Move>();
        lizardBeats.add(spock);
        lizardBeats.add(paper);
        game.addMove(new MakeMove(lizard, lizardBeats));

        List<Move> spockBeats = new ArrayList<Move>();
        lizardBeats.add(rock);
        lizardBeats.add(scissor);
        game.addMove(new MakeMove(spock, spockBeats));

        return game;
    }
	

	//takes user input and maps to object to be compared later
    public Move getMove(String input) {
        if (input.equals("R")) {
            return rock;
        } else if (input.equals("P")) {
            return paper;
        } else if (input.equals("S")) {
            return scissor;
        } else if (input.equals("L")) {
            return lizard;
        } else if (input.equals("SP")) {
            return spock;
        }

        throw new IllegalArgumentException();
    }

    
    
}
