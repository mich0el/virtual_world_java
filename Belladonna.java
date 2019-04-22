import java.awt.Color;

public class Belladonna extends Plant {
	public Belladonna(int posX, int posY, World world) {
		this.myColor = Color.BLACK;
		this.myTextColor = Color.RED;
		this.whoIAm = 'b';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(99);
	}
}