import java.awt.Color;

public class Grass extends Plant{
	public Grass(int posX, int posY, World world) {
		this.myColor = new Color(91, 255, 91);
		this.whoIAm = 'g';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(0);
	}
}
