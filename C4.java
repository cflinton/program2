/*
 * Author: Carl Linton
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */


import java.util.Arrays;

public class C4 extends Game {

public Game c4Game = new Game("Connect 4", 2);
private final int ROWS = 6;
private final int COLS = 7;
private int[][] board = new int[ROWS][COLS];

public C4(){
	super("Connect 4", 2);
	for (int[] row: board){ //loops through each row in board
		Arrays.fill(row, 0); //fills each row with zeroes
		}
	}

public void clearBoard(){
	for (int[] row: board){ //loops through each row in board
		Arrays.fill(row, 0);
	}
	}
public int getPiece(int row, int col){
	int i = 3;
	if((0 < row) && (row <= ROWS) && (col <= COLS) && (col > 0)){ //checks to see if paramaters are in bounds (assumes that the first row and column are numbered 1 instead of 0)
		i = board[row - 1][col - 1];
		} else{
		System.out.println("Value out of bounds, returning three.");
		}
	return i;
	}

public int getTurn(){
	int i = c4Game.currentTurn();
	return i;
	}

public boolean isColFull(int col){
	boolean isFull = false; //says wheather or not the column is full
	int row = 1; //keeps track of row number
	int num = 3; //holds the number in the last checked space in the column
	int rsFull = 0; //says how many rows in the column are full
	while((row <= ROWS) && (num != 0)){
		num = this.getPiece(row, col);
		if(num != 0){
			rsFull++;
			}
		row++;
		}
	if(rsFull == ROWS){
		isFull = true;
		}
	return isFull;
	}

public boolean isDiagWinner(){
	boolean isWin = false; //determines if there is a win
	int r = 1; //row counter
	int c = 1; //column counter
	int n = 0; //number of matches in a diagonal line
	int tr, tc, p, tp; //temp row counter, temp column counter, what number is in certain place, and teporary marker of what is in a certain place
	while((r <= ROWS) && (!isWin)){ //loop runs through each row, stops if win is found
		while((c <= COLS) && (!isWin)) { //loop runs through each column for each row, stops if win is found
			n = 0;
			p = this.getPiece(r, c);
			if (p != 0) { //if a player has placed a piece in the checked spot, the search for a win begins
				tc = c;
				tr = r;
				tp = p;
				while((tp == p) && (tr > 0) && (tc <= COLS) && (!isWin)) { //loop stops if win is found, non matching spot is found, or the search tries to go out of bounds
					tp = this.getPiece(tr, tc); //gets the value of the searched piece
					if(tp == p){ //if the piece was placed by the same player then the length of the line is increased by one
						n++;
					}
					if(n == 4){ //if the line is four long then a win has been found
						isWin = true;
					}
					tc++; // moves column for searching to the right
					tr--; // moves row for searching down
				}
				n = 0; //resets values to search for a diagonal win a different way
				tc = c;
				tr = r;
				tp = p;
				while((tp == p) && (tr <= ROWS) && (tc <= COLS) && (!isWin)) { //loop stops for win, non-match, or out of bounds
					tp = this.getPiece(tr, tc);
					if(tp == p){ //length is one longer if match
						n++;
					}
					if(n == 4){ //four long means a win
						isWin = true;
				}
					tc++; //moves search right
					tr++; //moves search up

				}
				}
			c++;
			}
		c = 1; //resets column value
		r++;
		}
	return isWin;
	}

public boolean isFull(){
	boolean full = true;
	int r = 1;
	int c = 1;
	int p;
	while((r <= ROWS) && (full)){
		while((c <= COLS) && (full)){
			p = this.getPiece(r, c);
			if(p == 0){
				full = false;
				}
			c++;
			}
		c = 1;
		r++;
		}
	return full;
	}

public boolean isHorizWinner(){
	boolean isWin = false; //determines if there is a win
	int r = 1; //row counter
	int c = 1; //column counter
	int n = 0; //number of matches in a horizontal line
	int tr, tc, p, tp; //temp row counter, temp column counter, what number is in certain place, and teporary marker of what is in a certain place
	while((r <= ROWS) && (!isWin)){ //loop runs through each row, stops if win is found
		while((c <= COLS) && (!isWin)) { //loop runs through each column for each row, stops if win is found
			n = 0;
			p = this.getPiece(r, c);
			if (p != 0) { //if a player has placed a piece in the checked spot, the search for a win begins
				tc = c;
				tp = p;
				while((tp == p) && (r > 0) && (tc <= COLS) && (!isWin)) { //loop stops if win is found, non matching spot is found, or the search tries to go out of bounds
					tp = this.getPiece(r, tc); //gets the value of the searched piece
					if(tp == p){ //if the piece was placed by the same player then the length of the line is increased by one
						n++;
					}
					if(n == 4){ //if the line is four long then a win has been found
						isWin = true;
					}
					tc++; // moves column for searching to the right
				}
			}
			c++;
		}
		c = 1; //resets column value
		r++;
	}
	return isWin;
	}

public boolean isVertWinner(){
	boolean isWin = false; //determines if there is a win
	int r = 1; //row counter
	int c = 1; //column counter
	int n = 0; //number of matches in a diagonal line
	int tr, tc, p, tp; //temp row counter, temp column counter, what number is in certain place, and teporary marker of what is in a certain place
	while((r <= ROWS) && (!isWin)){ //loop runs through each row, stops if win is found
		while((c <= COLS) && (!isWin)) { //loop runs through each column for each row, stops if win is found
			n = 0;
			p = this.getPiece(r, c);
			if (p != 0) { //if a player has placed a piece in the checked spot, the search for a win begins
				tr = r;
				tp = p;
				while((tp == p) && (tr > 0) && (c <= COLS) && (!isWin)) { //loop stops if win is found, non matching spot is found, or the search tries to go out of bounds
					tp = this.getPiece(tr, c); //gets the value of the searched piece
					if(tp == p){ //if the piece was placed by the same player then the length of the line is increased by one
						n++;
					}
					if(n == 4){ //if the line is four long then a win has been found
						isWin = true;
					}
					tr--; // moves row for searching down
				}
			}
			c++;
		}
		c = 1; //resets column value
		r++;
	}
	return isWin;
	}

public boolean isWinner(){
	boolean win = false;

	if(this.isDiagWinner() || this.isHorizWinner() || this.isVertWinner()) {
		win = true;
	}

	return win;
	}

public void nextTurn(){
	c4Game.next();
	}

public boolean playPiece(int col){ //outputs whether or not the piece has been placed
	boolean placed = false; //says whether or not the piece was placed
	int r = ROWS; //counter keeps track of rows
	int p; //place holder for what piece is being checked
	if((col > COLS) || (col <= 0)){ //checks to see if col is out of bounds
		System.out.println("Column number out of range, insert new number: "); //says why the piece couldn't be placed, defers to MyGame logic for new input
	} else if(0 != getPiece(1, col)){ //checks to see if the top row of that column has a piece, and therefore is full
		System.out.println("Column is full, select a different Column");
	} else while((r > 0) && (!placed)){
		p = getPiece(r, col);
		if(p == 0){
			board[r - 1][col - 1] = c4Game.currentTurn();
			placed = true;
		}
		r--;
	}
	return placed;
	}

public void printBoard(){
	int r = 1;
	int c = 1;
	int p;
	System.out.print("      ");

	while(c <= COLS){
		System.out.print("" + c + " ");
		c++;
	}

	System.out.print("\n");

	c = 1;
	
	System.out.print("      ");

	while(c <= COLS){
		System.out.print("--");
		c++;
	}

	System.out.print("\n");


	c = 1;
	
	while(r <= ROWS){
		System.out.print("" + r + "  " + "|  ");
		while(c <= COLS){
			p = getPiece(r, c);
			System.out.print("" + p + " ");
			c++;
			}
		System.out.print("  |" + "\n");
		c = 1;
		r++;
		}

	System.out.print("      ");

	while(c <= COLS){
		System.out.print("--");
		c++;
	}

	System.out.print("\n");
	}

}
