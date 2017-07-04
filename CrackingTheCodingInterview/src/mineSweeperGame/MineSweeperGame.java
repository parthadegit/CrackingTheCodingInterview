package mineSweeperGame;

import java.util.Scanner;

public class MineSweeperGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MineSweeper myGame;
		if(args.length==0){
			System.out.println("Please enter the size of the board: ");
			int gameSize = Integer.parseInt(sc.nextLine());
			System.out.println("Please enter the number of bombs: ");
			int noOfBombs = Integer.parseInt(sc.nextLine());
			myGame = new MineSweeper(gameSize,noOfBombs);
		}
		else
			myGame = new MineSweeper(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
		
		myGame.displayGameBoard();
		int xMove, yMove, flag;
		boolean blastStatus=false;
		
		while(true){
			System.out.println("Please enter your click location. Example: 2 5. \nIf you want to place a flag give you location followed by a \'*\'. Example: 5 3 * ");
			String s = sc.nextLine();
			String op[]=s.split(" ");
			xMove = Integer.parseInt(op[0]);
			yMove = Integer.parseInt(op[1]);
			if(op.length>2 && op[2].equals("*"))
				flag = 1;
			else if(op.length>2 && op[2].equals("#"))
				flag = -1;
			else 
				flag = 0;
			blastStatus = myGame.executeMove(xMove,yMove,flag);
			if(blastStatus){
				myGame.adminDisplayGameBoard();
				break;
			}
			else{
				System.out.println();
				myGame.displayGameBoard();
			}
				
		
		}
		
		
		
	}

}
