package mineSweeperGame;

public class Grid {
	boolean revealed;
	boolean bombFlag;
	int number;
	
	public Grid() {
		revealed = false;
		bombFlag = false;
		number = 0;
	}
	public boolean isRevealed() {
		return revealed;
	}
	public void setRevealed(boolean revealed) {
		this.revealed = revealed;
	}
	public boolean isBombFlag() {
		return bombFlag;
	}
	public void setBombFlag(boolean bombFlag) {
		this.bombFlag = bombFlag;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void incrementNumber() {
		if(number!=-1)
			number++;
	}
	
}
