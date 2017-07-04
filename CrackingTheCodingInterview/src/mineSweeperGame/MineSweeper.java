package mineSweeperGame;

import java.util.ArrayList;
import java.util.Random;

public class MineSweeper {
	int problemSize;
	int noOfBombs;
	Grid[][] gameBoard;	
	
	public MineSweeper(int n, int b) {
		problemSize = n;
		this.noOfBombs=b;
		gameBoard = new Grid[problemSize][problemSize];
		initializeBoard();
		setBombs(noOfBombs);
	}
	
	private void initializeBoard(){
		for(int i=0;i<problemSize;i++){
			for(int j=0;j<problemSize;j++){
				Grid loc = new Grid();
				gameBoard[i][j]= loc;
			}
		}
	}
	private void setBombs(int noOfBombs){
		for(int i=0;i<noOfBombs;i++){
			Random rand = new Random();
		
			int xBomb = rand.nextInt(problemSize);
			int yBomb = rand.nextInt(problemSize);
			if(gameBoard[xBomb][yBomb].getNumber()==-1){
				i--;
				continue;
			}
			gameBoard[xBomb][yBomb].setNumber(-1);
			buildGame(xBomb,yBomb);
		}
	}
	private void buildGame(int xBomb, int yBomb){
		if(xBomb>0 && yBomb>0 && xBomb<problemSize-1 && yBomb<problemSize-1){
			gameBoard[xBomb-1][yBomb-1].incrementNumber();
			gameBoard[xBomb-1][yBomb].incrementNumber();
			gameBoard[xBomb-1][yBomb+1].incrementNumber();
			gameBoard[xBomb][yBomb-1].incrementNumber();
			gameBoard[xBomb][yBomb+1].incrementNumber();
			gameBoard[xBomb+1][yBomb-1].incrementNumber();
			gameBoard[xBomb+1][yBomb].incrementNumber();
			gameBoard[xBomb+1][yBomb+1].incrementNumber();
		}
		else if(xBomb==0 && yBomb==problemSize-1){
			gameBoard[xBomb][yBomb-1].incrementNumber();
			gameBoard[xBomb+1][yBomb-1].incrementNumber();
			gameBoard[xBomb+1][yBomb].incrementNumber();
		}
		else if(xBomb==problemSize-1 && yBomb==0){
			gameBoard[xBomb-1][yBomb].incrementNumber();
			gameBoard[xBomb-1][yBomb+1].incrementNumber();
			gameBoard[xBomb][yBomb+1].incrementNumber();
		}
		else if(xBomb==0 && yBomb==0){
			gameBoard[xBomb][yBomb+1].incrementNumber();
			gameBoard[xBomb+1][yBomb].incrementNumber();
			gameBoard[xBomb+1][yBomb+1].incrementNumber();
		}
		else if(xBomb==problemSize-1 && yBomb==problemSize-1){
			gameBoard[xBomb-1][yBomb-1].incrementNumber();
			gameBoard[xBomb-1][yBomb].incrementNumber();
			gameBoard[xBomb][yBomb-1].incrementNumber();
		}
		else if(xBomb==0 && yBomb>0 && yBomb<problemSize-1){
			gameBoard[xBomb][yBomb-1].incrementNumber();
			gameBoard[xBomb][yBomb+1].incrementNumber();
			gameBoard[xBomb+1][yBomb-1].incrementNumber();
			gameBoard[xBomb+1][yBomb].incrementNumber();
			gameBoard[xBomb+1][yBomb+1].incrementNumber();
		}
		else if(yBomb>0 && xBomb==problemSize-1 && yBomb<problemSize-1){
			gameBoard[xBomb-1][yBomb-1].incrementNumber();
			gameBoard[xBomb-1][yBomb].incrementNumber();
			gameBoard[xBomb-1][yBomb+1].incrementNumber();
			gameBoard[xBomb][yBomb-1].incrementNumber();
			gameBoard[xBomb][yBomb+1].incrementNumber();
		}
		else if(xBomb>0 && yBomb==0 && xBomb<problemSize-1){
			gameBoard[xBomb-1][yBomb].incrementNumber();
			gameBoard[xBomb-1][yBomb+1].incrementNumber();
			gameBoard[xBomb][yBomb+1].incrementNumber();
			gameBoard[xBomb+1][yBomb].incrementNumber();
			gameBoard[xBomb+1][yBomb+1].incrementNumber();
		}
		else if(xBomb>0 && xBomb<problemSize-1 && yBomb==problemSize-1){
			gameBoard[xBomb-1][yBomb-1].incrementNumber();
			gameBoard[xBomb-1][yBomb].incrementNumber();
			gameBoard[xBomb][yBomb-1].incrementNumber();
			gameBoard[xBomb+1][yBomb-1].incrementNumber();
			gameBoard[xBomb+1][yBomb].incrementNumber();
		}
	}
	
	public void adminDisplayGameBoard(){
		for(int i=0;i<problemSize;i++){
			for(int j=0;j<problemSize;j++){
				System.out.print(gameBoard[i][j].getNumber()+"|");
			}
			System.out.println();
		}
	}
	
	public void displayGameBoard(){
		for(int i=0;i<problemSize;i++){
			for(int j=0;j<problemSize;j++){
				if(gameBoard[i][j].isRevealed()){
					if(gameBoard[i][j].getNumber()== 0)
						System.out.print(" |");
					else if(gameBoard[i][j].getNumber()== -1)
						System.out.print("X|");
					else
						System.out.print(gameBoard[i][j].getNumber()+"|");
				}
				else{
					if(gameBoard[i][j].isBombFlag())
						System.out.print("^|");
					else
						System.out.print("?|");
				}
			}
			System.out.println();
		}
	}

	public boolean executeMove(int xMove, int yMove, int flag) {
		if(flag==1)
			gameBoard[xMove][yMove].setBombFlag(true);
		else if(flag==-1)
			gameBoard[xMove][yMove].setBombFlag(false);
		else{
			gameBoard[xMove][yMove].setRevealed(true);
			if(gameBoard[xMove][yMove].isBombFlag()== true)
				return false;
			else{
				if(gameBoard[xMove][yMove].getNumber()== -1)
					return true;
				else{
					if(gameBoard[xMove][yMove].getNumber()== 0){
						chainExposeGridByDFS(xMove,yMove);
					}
				}
			}
		}
		return false;
	}

	private void chainExposeGridByDFS(int xMove, int yMove) {
		if(xMove>0 && yMove>0 && xMove<problemSize-1 && yMove<problemSize-1){
			if(!gameBoard[xMove-1][yMove-1].isRevealed()){
				gameBoard[xMove-1][yMove-1].setRevealed(true);
				if(gameBoard[xMove-1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove-1);
			}
			if(!gameBoard[xMove-1][yMove].isRevealed()){
				gameBoard[xMove-1][yMove].setRevealed(true);
				if(gameBoard[xMove-1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove);
			}
			if(!gameBoard[xMove-1][yMove+1].isRevealed()){
				gameBoard[xMove-1][yMove+1].setRevealed(true);
				if(gameBoard[xMove-1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove+1);
			}
			if(!gameBoard[xMove][yMove-1].isRevealed()){
				gameBoard[xMove][yMove-1].setRevealed(true);
				if(gameBoard[xMove][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove-1);
			}
			if(!gameBoard[xMove][yMove+1].isRevealed()){
				gameBoard[xMove][yMove+1].setRevealed(true);
				if(gameBoard[xMove][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove+1);
			}
			if(!gameBoard[xMove+1][yMove-1].isRevealed()){
				gameBoard[xMove+1][yMove-1].setRevealed(true);
				if(gameBoard[xMove+1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove-1);
			}
			if(!gameBoard[xMove+1][yMove].isRevealed()){
				gameBoard[xMove+1][yMove].setRevealed(true);
				if(gameBoard[xMove+1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove);
			}
			if(!gameBoard[xMove+1][yMove+1].isRevealed()){
				gameBoard[xMove+1][yMove+1].setRevealed(true);
				if(gameBoard[xMove+1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove+1);
			}
		}
		else if(xMove==0 && yMove==problemSize-1){
			if(!gameBoard[xMove][yMove-1].isRevealed()){
				gameBoard[xMove][yMove-1].setRevealed(true);
				if(gameBoard[xMove][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove-1);
			}
			if(!gameBoard[xMove+1][yMove-1].isRevealed()){
				gameBoard[xMove+1][yMove-1].setRevealed(true);
				if(gameBoard[xMove+1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove-1);
			}
			if(!gameBoard[xMove+1][yMove].isRevealed()){
				gameBoard[xMove+1][yMove].setRevealed(true);
				if(gameBoard[xMove+1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove);
			}
		}
		else if(xMove==problemSize-1 && yMove==0){
			if(!gameBoard[xMove-1][yMove].isRevealed()){
				gameBoard[xMove-1][yMove].setRevealed(true);
				if(gameBoard[xMove-1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove);
			}
			if(!gameBoard[xMove-1][yMove+1].isRevealed()){
				gameBoard[xMove-1][yMove+1].setRevealed(true);
				if(gameBoard[xMove-1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove+1);
			}
			if(!gameBoard[xMove][yMove+1].isRevealed()){
				gameBoard[xMove][yMove+1].setRevealed(true);
				if(gameBoard[xMove][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove+1);
			}
		}
		else if(xMove==0 && yMove==0){
			if(!gameBoard[xMove][yMove+1].isRevealed()){
				gameBoard[xMove][yMove+1].setRevealed(true);
				if(gameBoard[xMove][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove+1);
			}
			if(!gameBoard[xMove+1][yMove].isRevealed()){
				gameBoard[xMove+1][yMove].setRevealed(true);
				if(gameBoard[xMove+1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove);
			}
			if(!gameBoard[xMove+1][yMove+1].isRevealed()){
				gameBoard[xMove+1][yMove+1].setRevealed(true);
				if(gameBoard[xMove+1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove+1);
			}
		}
		else if(xMove==problemSize-1 && yMove==problemSize-1){
			if(!gameBoard[xMove-1][yMove-1].isRevealed()){
				gameBoard[xMove-1][yMove-1].setRevealed(true);
				if(gameBoard[xMove-1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove-1);
			}
			if(!gameBoard[xMove-1][yMove].isRevealed()){
				gameBoard[xMove-1][yMove].setRevealed(true);
				if(gameBoard[xMove-1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove);
			}
			if(!gameBoard[xMove][yMove-1].isRevealed()){
				gameBoard[xMove][yMove-1].setRevealed(true);
				if(gameBoard[xMove][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove-1);
			}
		}
		else if(xMove==0 && yMove>0 && yMove<problemSize-1){
			if(!gameBoard[xMove][yMove-1].isRevealed()){
				gameBoard[xMove][yMove-1].setRevealed(true);
				if(gameBoard[xMove][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove-1);
			}
			if(!gameBoard[xMove][yMove+1].isRevealed()){
				gameBoard[xMove][yMove+1].setRevealed(true);
				if(gameBoard[xMove][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove+1);
			}
			if(!gameBoard[xMove+1][yMove-1].isRevealed()){
				gameBoard[xMove+1][yMove-1].setRevealed(true);
				if(gameBoard[xMove+1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove-1);
			}
			if(!gameBoard[xMove+1][yMove].isRevealed()){
				gameBoard[xMove+1][yMove].setRevealed(true);
				if(gameBoard[xMove+1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove);
			}
			if(!gameBoard[xMove+1][yMove+1].isRevealed()){
				gameBoard[xMove+1][yMove+1].setRevealed(true);
				if(gameBoard[xMove+1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove+1);
			}
		}
		else if(yMove>0 && xMove==problemSize-1 && yMove<problemSize-1){
			if(!gameBoard[xMove-1][yMove-1].isRevealed()){
				gameBoard[xMove-1][yMove-1].setRevealed(true);
				if(gameBoard[xMove-1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove-1);
			}
			if(!gameBoard[xMove-1][yMove].isRevealed()){
				gameBoard[xMove-1][yMove].setRevealed(true);
				if(gameBoard[xMove-1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove);
			}
			if(!gameBoard[xMove-1][yMove+1].isRevealed()){
				gameBoard[xMove-1][yMove+1].setRevealed(true);
				if(gameBoard[xMove-1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove+1);
			}
			if(!gameBoard[xMove][yMove-1].isRevealed()){
				gameBoard[xMove][yMove-1].setRevealed(true);
				if(gameBoard[xMove][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove-1);
			}
			if(!gameBoard[xMove][yMove+1].isRevealed()){
				gameBoard[xMove][yMove+1].setRevealed(true);
				if(gameBoard[xMove][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove+1);
			}
		}
		else if(xMove>0 && yMove==0 && xMove<problemSize-1){
			if(!gameBoard[xMove-1][yMove].isRevealed()){
				gameBoard[xMove-1][yMove].setRevealed(true);
				if(gameBoard[xMove-1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove);
			}
			if(!gameBoard[xMove-1][yMove+1].isRevealed()){
				gameBoard[xMove-1][yMove+1].setRevealed(true);
				if(gameBoard[xMove-1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove+1);
			}
			if(!gameBoard[xMove][yMove+1].isRevealed()){
				gameBoard[xMove][yMove+1].setRevealed(true);
				if(gameBoard[xMove][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove+1);
			}
			if(!gameBoard[xMove+1][yMove].isRevealed()){
				gameBoard[xMove+1][yMove].setRevealed(true);
				if(gameBoard[xMove+1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove);
			}
			if(!gameBoard[xMove+1][yMove+1].isRevealed()){
				gameBoard[xMove+1][yMove+1].setRevealed(true);
				if(gameBoard[xMove+1][yMove+1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove+1);
			}
		}
		else if(xMove>0 && xMove<problemSize-1 && yMove==problemSize-1){
			if(!gameBoard[xMove-1][yMove-1].isRevealed()){
				gameBoard[xMove-1][yMove-1].setRevealed(true);
				if(gameBoard[xMove-1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove-1);
			}
			if(!gameBoard[xMove-1][yMove].isRevealed()){
				gameBoard[xMove-1][yMove].setRevealed(true);
				if(gameBoard[xMove-1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove-1,yMove);
			}
			if(!gameBoard[xMove][yMove-1].isRevealed()){
				gameBoard[xMove][yMove-1].setRevealed(true);
				if(gameBoard[xMove][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove,yMove-1);
			}
			if(!gameBoard[xMove+1][yMove-1].isRevealed()){
				gameBoard[xMove+1][yMove-1].setRevealed(true);
				if(gameBoard[xMove+1][yMove-1].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove-1);
			}
			if(!gameBoard[xMove+1][yMove].isRevealed()){
				gameBoard[xMove+1][yMove].setRevealed(true);
				if(gameBoard[xMove+1][yMove].getNumber()==0)
					chainExposeGridByDFS(xMove+1,yMove);
			}
		}
	}

}
