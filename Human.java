import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Human extends Animal {
	private int specialAbilityMoves = 0;
	private int direction;
	
	public Human(int posX, int posY, World world) {
		this.myColor = Color.MAGENTA;
		this.whoIAm = 'H';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(5);
		setInitiative(4);
	}
	
	@Override
	public void action() {
		int prevPosX, prevPosY;
		
		prevPosX = this.getPosX();
		prevPosY = this.getPosY();
		
		newCoordinates();
		if(collision(prevPosX, prevPosY) == collisionResult.DEAD)
			this.world.setPlayerIsActive(false);
	}

	@Override
	public void newCoordinates() {
		int newPosX, newPosY, newSpareX, newSpareY, worldSizeX, worldSizeY;
		
		worldSizeX = world.getSizeX() - 1;
		worldSizeY = world.getSizeY() - 1;
		newPosX = this.getPosX();
		newPosY = this.getPosY();
		newSpareX = newPosX;
		newSpareY = newPosY;
				
		direction = this.world.getInput();
		
		if (specialAbilityIsActive() == true)
			this.moveLength = 2;
		else
			this.moveLength = 1;
		
		switch (this.direction) {
			case KeyEvent.VK_UP:
				newPosY -= this.moveLength;
				newSpareY--;
				break;
			case KeyEvent.VK_DOWN:
				newPosY += this.moveLength;
				newSpareY++;
				break;
			case KeyEvent.VK_LEFT:
				newPosX -= this.moveLength;
				newSpareX--;
				break;
			case KeyEvent.VK_RIGHT:
				newPosX += this.moveLength;
				newSpareX++;
				break;
		}
		if (newPosX >= 0 && newPosX <= worldSizeX && newPosY >= 0 && newPosY <= worldSizeY) {
			this.setPosX(newPosX);
			this.setPosY(newPosY);
		} else if (newSpareX >= 0 && newSpareX <= worldSizeX && newSpareY >= 0 && newSpareY <= worldSizeY) {
			this.setPosX(newSpareX);
			this.setPosY(newSpareY);
		}
		decreaseSpecialAbilityMoves();
	}
	
	@Override
	public String organismInfo() {
		return super.organismInfo() + " " + this.getSpecialAbilityMoves();
	}
	
	public boolean specialAbilityIsActive() {
		if (getSpecialAbilityMoves() >= 8)
			return true;
		else if (getSpecialAbilityMoves() >= 6) {
			Random rnd = new Random();
			int val = rnd.nextInt(101);
			if (val <= 50)
				return true;
		}
		return false;
	}
	
	public boolean turnOnAbility() {
		if (this.specialAbilityMoves == 0) {
			this.specialAbilityMoves = 10;
			return true;
		}
		return false;
	}
	
	public void decreaseSpecialAbilityMoves() {
		if (this.specialAbilityMoves > 0)
			this.specialAbilityMoves--;
	}
	
	public int getSpecialAbilityMoves() {
		return this.specialAbilityMoves;
	}
	public void setSpecialAbilityMoves(int val) {
		this.specialAbilityMoves = val;
	}
}