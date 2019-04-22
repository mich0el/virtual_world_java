import java.awt.Color;

public class Sheep extends Animal {	
	public Sheep(int posX, int posY, World world) {
		this.myColor = new Color(204, 153, 255);
		this.whoIAm = 'S';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(4);
		setInitiative(4);
	}
}