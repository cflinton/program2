/*
 * Author: Carl Linton
 * Program 2 - MyGame
 * CSC230-02 Spring 2016
 */
package mygame;

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

public static void clearBoard(){
	for (int[] row: board){ //loops through each row in board
		for (int i: row){ //loops through each int in each row
			i = 0; //sets the int to zero
			}
		}
	}

public static int getPiece(int row, int col){
	int i = 3;
	if((row <= ROWS) && (col <= COLS) && (row > 0) && (col > 0)){ //checks to see if paramaters are in bounds (assumes that the first row and column are numbered 1 instead of 0)
		i = board[row - 1][col - 1];
		} else{
		System.out.println("Value out of bounds, returning three.");
		}
	return i;
	}

public static int getTurn(){
	int i = c4Game.currentTurn();
	return i;
	}

public static boolean isColFull(int col){
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

public static boolean isDiagWinner(){
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
				n = 1; //if a player has placed a piece in the checked spot then it is the first in a line of unknown length
				tc = c;
				tr = r;
				tp = p;
				while((tp == p) && (tr > 0) && (tc <= COLS) && (!isWin)) { //loop stops if win is found, non matching spot is found, or the search tries to go out of bounds
					tc++; // moves column for searching to the right
					tr--; // moves row for searching down
					tp = this.getPiece(tr, tc); //gets the value of the searched piece
					if(tp == p){ //if the piece was placed by the same player then the length of the line is increased by one
						n++;
						}
					if(n == 4){ //if the line is four long then a win has been found
						isWin = true;
						}
					}
				n = 1; //resets values to search for a diagonal win a different way
				tc = c;
				tr = r;
				tp = p;
				while((tp == p) && (tr <= ROWS) && (tc <= COLS) && (!isWin) { //loop stops for win, non-match, or out of bounds
					tc++; //moves search right
					tr++; //moves search up
					tp = this.getPiece(tr, tc);
					if(tp == p){ //length is one longer if match
						n++;
						}
					if(n == 4){ //four long means a win
						isWin = true;
						}
					}
				}
			c++;
			}
		c = 1; //resets column value
		r++;
		}
	return isWin;
	}

public static boolean isFull(){
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

public static boolean isHorizWinner(){
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
				n = 1; //if a player has placed a piece in the checked spot then it is the first in a line of unknown length
				tc = c;
				tp = p;
				while((tp == p) && (r > 0) && (tc <= COLS) && (!isWin)) { //loop stops if win is found, non matching spot is found, or the search tries to go out of bounds
					tc++; // moves column for searching to the right
					tp = this.getPiece(r, tc); //gets the value of the searched piece
					if(tp == p){ //if the piece was placed by the same player then the length of the line is increased by one
						n++;
						}
					if(n == 4){ //if the line is four long then a win has been found
						isWin = true;
						}
					}
				}
			c++;
			}
		c = 1; //resets column value
		r++;
		}
	return isWin;
	}

	}

public static boolean isVertWinner(){
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
				n = 1; //if a player has placed a piece in the checked spot then it is the first in a line of unknown length
				tr = r;
				tp = p;
				while((tp == p) && (tr > 0) && (c <= COLS) && (!isWin)) { //loop stops if win is found, non matching spot is found, or the search tries to go out of bounds
					tr--; // moves ro for searching down
					tp = this.getPiece(tr, c); //gets the value of the searched piece
					if(tp == p){ //if the piece was placed by the same player then the length of the line is increased by one
						n++;
						}
					if(n == 4){ //if the line is four long then a win has been found
						isWin = true;
						}
					}
				}
			c++;
			}
		c = 1; //resets column value
		r++;
		}
	return isWin;
	}

	}

public static void nextTurn(){
	c4Game.next();
	}

public static boolean playPiece(int col){ //outputs whether or not the piece has been placed
	boolean placed = false; //says whether or not the piece was placed
	int r = ROWS; //counter keeps track of rows
	int p; //place holder for what piece is being checked
	if((col > COLS) || (col <= 0)){ //checks to see if col is out of bounds
		System.out.print("Column number out of range, insert new number: "); //says why the piece couldn't be placed, defers to MyGame logic for new input
		} else if(0 != getPiece(1, col)){ //checks to see if the top row of that column has a piece, and therefore is full
			System.out.print("Column is full, select a different Column");
			} else while((r > 0) && (!placed)){
				p = getPiece(r, col);
				if(p == 0){
					board[r - 1][col - 1] = c4game.currentTurn();
					placed = true;
					}
				r--;
				}
	return placed;
	}

public static void printBoard(){
	int r = 1;
	int c = 1;

	System.out.print("     ");

	while(c <= COLS){
		System.out.print("" + c + " ");
		}

	System.out.print("\n");

	c = 1;
	
	System.out.print("     ");

	while(c <= COLS){
		System.out.print("--");
		}

	System.out.print("\n");


	c = 1;
	
	while(r <= ROWS){
		System.out.print("" + r + "   " + "|  ");
		while(c <= COLS){
			p = getPiece(r, c);
			System.out.print("" + p + " ");
			c++;
			}
		System.out.print("   |" + "\n");
		c = 1;
		r++;
		}

	System.out.print("     ");

	while(c <= COLS){
		System.out.print("--");
		}

	System.out.print("\n");
	}

}
