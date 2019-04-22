import java.awt.Color;
import java.util.Random;

public class Fox extends Animal {
	public Fox(int posX, int posY, World world) {
		this.myColor = new Color(255, 128, 0);
		this.whoIAm = 'F';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(3);
		setInitiative(7);
	}
	
	@Override
	public void newCoordinates() {
		int moveTo;
		int newPosX, newPosY;
		Random rnd = new Random();
		
		newPosX = this.getPosX();
		newPosY = this.getPosY();
		
		moveTo = rnd.nextInt(4);
		switch (moveTo) {
			case 0: //up
				if (isItSafeForMe(newPosX, newPosY - 1) == true) {
					newPosY--;
				} else if (isItSafeForMe(newPosX, newPosY + 1) == true) {
					newPosY++;
				} else if (isItSafeForMe(newPosX - 1, newPosY) == true) {
					newPosX--;
				} else if (isItSafeForMe(newPosX + 1, newPosY) == true) {
					newPosX++;
				}
				break;
			case 1: //down
				if (isItSafeForMe(newPosX, newPosY + 1) == true) {
					newPosY++;
				} else if (isItSafeForMe(newPosX, newPosY - 1) == true) {
					newPosY--;
				} else if (isItSafeForMe(newPosX - 1, newPosY) == true) {
					newPosX--;
				} else if (isItSafeForMe(newPosX + 1, newPosY) == true) {
					newPosX++;
				}
				break;
			case 2: //left
				if (isItSafeForMe(newPosX - 1, newPosY) == true) {
					newPosX--;
				} else if (isItSafeForMe(newPosX + 1, newPosY) == true) {
					newPosX++;
				} else if (isItSafeForMe(newPosX, newPosY - 1) == true) {
					newPosY--;
				} else if (isItSafeForMe(newPosX, newPosY + 1) == true) {
					newPosY++;
				}
				break;
			case 3: //right
				if (isItSafeForMe(newPosX + 1, newPosY) == true) {
					newPosX++;
				} else if (isItSafeForMe(newPosX - 1, newPosY) == true) {
					newPosX--;
				} else if (isItSafeForMe(newPosX, newPosY - 1) == true) {
					newPosY--;
				} else if (isItSafeForMe(newPosX, newPosY + 1) == true) {
					newPosY++;
				}
				break;
			}
		
		this.setPosX(newPosX);
		this.setPosY(newPosY);
	}

	public boolean isItSafeForMe(int possibleX, int possibleY) {
		if (possibleX < 0 || possibleY < 0 || possibleX >= this.world.getSizeX() || possibleY >= this.world.getSizeY()) {
			return false;
		} else if (this.world.getBoard()[possibleY][possibleX] != null) {
			if (this.world.getBoard()[possibleY][possibleX].getPower() > this.getPower())
				return false;
		}
		return true;
	}
}