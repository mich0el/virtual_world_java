import java.awt.Color;

public class Wolf extends Animal {
	public Wolf(int posX, int posY, World world) {
		this.myColor = new Color(95, 95, 95);
		this.whoIAm = 'W';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(9);
		setInitiative(5);
	}
}