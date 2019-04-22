import java.awt.Color;
import java.util.Random;

public class Antelope extends Animal {	
	public Antelope(int posX, int posY, World world) {
		this.myColor = new Color(255, 204, 153);
		this.whoIAm = 'A';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(4);
		setInitiative(4);
		this.moveLength = 2;
	}
	
	@Override
	public boolean defenced(Organism enemy) {
		Random rnd = new Random();
		int chance = rnd.nextInt(101);
		if (chance <= 50)
			return true;
		return false;
	}
}