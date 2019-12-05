package aula8.Ex1;

import static java.lang.System.*;

public class Tabuleiro {

	 public static final char vazio = '\0';
	  
	  private static char[][] board;
	  private int lastLin, lastLine;
	 
	 public final char jog1;
	  public final char jog2;

	  private char lastPlayer;
	  public int countPlay;

	  public Tabuleiro(char j1, char j2) {

		    board = new char[3][3];
		    for(int l = 0; l < 3; l++)
		      for(int c = 0; c < 3; c++)
		        board[l][c] = vazio;
		    jog1 = j1;
		    jog2 = j2;
		    lastPlayer = vazio;
		    lastLin = lastLine = -1;
		    countPlay=0;
		  }
	  
	  public char lastPlayer() { return lastPlayer; }
	  
	  public static boolean coordValid(int lin, int col) {
	    return 1<=lin && lin<=3 && 1<=col && col<=3;
	  }
	  
	  public static boolean emptySpace(int lin, int col) {
	    if( coordValid(lin, col))
	    	return board[lin-1][col-1] == vazio;
	    return false;
	  }
	  
	  boolean end() {
	    return lastPlayer != vazio && lastPlayerWon() || countPlay == 3*3;
	  }

	  public boolean validPlay(int lin, int col) {
	    return coordValid(lin, col) && emptySpace(lin, col) && !end();
	  }
	  
	  public void jogada(int lin, int col) {
	    if( validPlay(lin, col)) {
		    lastPlayer = (lastPlayer != jog1) ? jog1 : jog2;
		    lastLin = lin-1;
		    lastLine = col-1;
		    board[lastLin][lastLine] = lastPlayer;
		    countPlay++;
		 }
	  }
	  
	  public void mostraTabuleiro() {
	    out.println();
	    out.println("    1   2   3");
	    for (int lin=1; lin<=3; lin++) {
	      out.printf("%2d ",lin);
	      for (int col=1; col<=3; col++) {
	        char c = board[lin-1][col-1];
	        out.printf("%2c ", (c==vazio)? ' ' : c);
	        out.printf("%c", (col<3)? '|' : '\n');
	      }
	      if (lin<3)
	        out.printf("   ---+---+---\n");
	    }
	    out.println();
	  }

	  private int contaIgual(int lin, int col, int dlin, int dcol) {
	    int result = 0;

	    int l = lin+dlin;
	    int c = col+dcol;
	    if (l >= 0 && l < 3 && c >= 0 && c < 3 && board[l][c] == lastPlayer)
	      result = 1 + contaIgual(l, c, dlin, dcol);

	    return result;
	  }
	  
	  boolean lastPlayerWon() {
		 

	    if( lastPlayer() != vazio) {
	    	
	      // Check By Line
	      if	  (board[0][0]==board[0][1] && board[0][0]==board[0][2] && noneNull(board[0][0],board[0][1],board[0][2])) return true;
	      else if (board[1][0]==board[1][1] && board[1][0]==board[1][2] && noneNull(board[1][0],board[1][1],board[1][2])) return true;
	      else if (board[2][0]==board[2][1] && board[2][0]==board[2][2] && noneNull(board[2][0],board[2][1],board[2][2])) return true;
	   
	      // Check By Column
	      else if (board[0][0]==board[1][0] && board[0][0]==board[2][0] && noneNull(board[0][0],board[1][0],board[2][0])) return true;   
	      else if (board[0][1]==board[1][1] && board[0][1]==board[2][1] && noneNull(board[0][1],board[1][1],board[2][1])) return true;
	      else if (board[0][2]==board[1][2] && board[0][2]==board[2][2] && noneNull(board[0][2],board[1][2],board[0][2]))  return true;
	     
	      // Check Diagonal
	      else if (board[0][0]==board[1][1] && board[0][0]==board[2][2] && noneNull(board[0][0],board[1][1],board[2][2])) return true;
	      else if (board[2][0]==board[1][1] && board[2][0]==board[0][2] && noneNull(board[2][0],board[1][1],board[0][2])) return true;
	   
	      else return false;
	  }
	   
	    return false;


	}
	  
	  
	  boolean noneNull(char a, char b, char c) {
		  if (a!='\0' && b!='\0' && c!='\0') return true;
		  else return false;
	  }
	  
}