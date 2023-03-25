package xogame;

import java.util.*;

public class XO {

	static String[] board;
	static String turn;

	static String cheakwinner() {

		for (int a = 0; a < 8; a++) {
			String line = null;

			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;

			case 2:
				line = board[6] + board[7] + board[8];
				break;

			case 3:
				line = board[0] + board[3] + board[6];
				break;

			case 4:
				line = board[1] + board[4] + board[7];
				break;

			case 5:
				line = board[2] + board[5] + board[8];
				break;

			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;

			}
			// X winner
			if (line.equals("XXX")) {
				return "X";

			} else if (line.equals("OOO")) {
				return "O";
			}
		}

		for (int a = 0; a < 9; a++) {
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
				break;
			} else if (a == 9) {
				return "Draw";
			}
		}

		System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	static void printboard() {
		System.out.println("|---|---|---|");
		System.out.println("  |" + board[0] + " |" + board[1] + " |" + board[2] + "|");
		System.out.println("  |" + board[3] + " |" + board[4] + " |" + board[5] + "|");
		System.out.println("  |" + board[6] + " |" + board[7] + " |" + board[8] + "|");
	}

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in) ;
		board =new String[9];
		turn="X";
		String winner=null;
		
		for(int a=0;a<9;a++) {
			board[a]=String.valueOf(a +1);
			
		}
		System.out.println("Welcome to 3x3 X O Game");
		printboard();
		System.out.println("X will play first.Enter a slot number place  X");
		
		while(winner==null){
			int numinput;  //take input from the user 1 to 9
			
			
			try {
				numinput=in.nextInt();
				if(!(numinput>0&&numinput<=9)) {
					System.out.println("Invalid input.please...try again ");
					continue;
				}
						
			}
		     catch (InputMismatchException e) {
		    	 System.out.println("Invalid input.please..try again");
		    	 continue;
			
			}
			if(board[numinput-1].equals(String.valueOf(numinput))){
				
				board[numinput-1]=turn;
			
		
			if (turn.equals("X")) {
				turn="O";
			}
			else {
				turn="X";
			}
			
			printboard();
			winner=cheakwinner();
			
			}
			else {
				System.out.println("Value is already taken.re-enter the slot number");
			}	
		}
		
		if(winner.equalsIgnoreCase("Draw")) {
			System.out.println("The mache Draw..Thanks for playing");
		}
		
		else {
			System.out.println("Congratulations! " + winner+ "'s have won! Thanks for playing.");
		}
	in.close();	

	}

}

