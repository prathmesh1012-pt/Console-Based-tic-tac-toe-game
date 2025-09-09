import java.util.*;

public class Game{
	static String [] Board;
	static String turn;
	
	
	static void printBoard(){
		System.out.println("|---|---|---|");
		System.out.println("| " + Board[0] + " | " +Board[1]+ " | " +Board[2]+ " | ");
		System.out.println("|---|---|---|");
		System.out.println("| " + Board[3] + " | " +Board[4]+ " | " +Board[5]+ " | ");
		System.out.println("|---|---|---|");
		System.out.println("| " + Board[6] + " | " +Board[7]+ " | " +Board[8]+ " | ");
		System.out.println("|---|---|---|");
		
	}
	static String checkWinner(){
		for(int i = 0; i<8; i++ ){
			String line = null;
			switch(i){
				case 0 : line = Board[0]+Board[1]+Board[2];
						break;
				case 1 : line = Board[3]+Board[4]+Board[5];
						break;
				case 2 : line = Board[6]+Board[7]+Board[8];
						break;		
				case 3 : line = Board[0]+Board[3]+Board[6];
						break;
				case 4 : line = Board[1]+Board[4]+Board[7];
						break;
				case 5 : line = Board[2]+Board[5]+Board[8];
						break;
				case 6 : line = Board[0]+Board[4]+Board[8];
						break;
				case 7 : line = Board[2]+Board[4]+Board[6];
						break;
			}
			if(line.equals("XXX")){
				return "X";
			}
			else if(line.equals("OOO")){
				return "O";
			}
		}
		
		for(int a = 0; a<9; a++ ){
			if(Arrays.asList(Board).contains(String.valueOf(a+1))){
			break;
			}
			else if(a == 8){
				return "Draw";
			}
		}
		System.out.print(turn + "'s turn; enter a slot number to place "+ turn + " in:");
		return null;
		
		
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		Board = new String[9];
		turn = "X";
		String winner  = null;
		for(int i = 0; i<9; i++){
		Board[i] = String.valueOf(i+1);
		}
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
		printBoard();
		 System.out.println(
            "X will play first. Enter a slot number to place X in:");
		
		while(winner == null){
			int numInput;
			
			try{
				numInput = sc.nextInt();
				if(!(numInput>0 && numInput<=9) ){
					System.out.print("Invalid input; re-enter slot number:");
					continue;
				}
			}
			catch(InputMismatchException e){
				System.out.print("Invalid input; re-enter slot number:");
				continue;
			}
			
			if(Board[numInput-1].equals(String.valueOf(numInput))){
				Board[numInput-1] = turn;
				if(turn.equals("X")){
					turn = "O";
				}
				else {
					turn = "X";
				}
				printBoard();
                winner = checkWinner();
			}
			else {
                System.out.println(
                    "Slot already taken; re-enter slot number:");
            }
		}
		if (winner.equals("draw")) {
            System.out.println(
                "It's a draw! Thanks for playing.");
        }
      
        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                "Congratulations! " + winner
                + "'s have won! Thanks for playing.");
        }
      sc.close();
		
			
			
	
		
		
		
	}
}