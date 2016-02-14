/*
 * Author: Carl Linton
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */
import java.util.Scanner;

public class MyGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        C4 mg = new C4();
	boolean win = false;
	boolean full = false;
	boolean place;
	Scanner scan = new Scanner(System.in);
	int c;
	String q;
	
	scan.next();	
	
	System.out.println("Hello there!");
	
	while((!win) && (!full)){
		mg.printBoard();
		q = "n";
		place = false;
		
		System.out.println("Welcome to Connect 4!");
		
		while(!place) {
			System.out.println("Player " + mg.getTurn() + " pick a column to place your piece: ");
			c = scan.nextInt();
			place = mg.playPiece(c);
		}
		
		full = mg.isFull();
		
		win = mg.isWinner();

		if(win) {
			mg.c4Game.winner();
			System.out.println("Would you like to play again? Y/N: ");
			q = scan.next();
		} else if(full) {
			System.out.println("The board is full and there are no matches, the game is a draw.");
			System.out.print("Would you like to play again? Y/N: ");
			q = scan.next();
		}
		
		mg.nextTurn();
		
		q = q.toUpperCase();
		
		if(q.equals("Y")){
			System.out.println("Reseting Connect Four");
			mg.clearBoard();
			win = false;
			full = false;
			mg.c4Game.reset();
			
		}
    }
		System.out.println("Goodbye!");
    }
}
