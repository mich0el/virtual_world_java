import java.awt.Color;

public class Sonchus extends Plant {
	public Sonchus(int posX, int posY, World world) {
		this.myColor = new Color(255, 255, 51);
		this.whoIAm = 'o';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(0);
	}
	
	@Override
	public void action() {
		for (int i = 0; i < 3; i++)
			super.action();
	}	
}