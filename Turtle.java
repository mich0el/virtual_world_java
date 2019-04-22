import java.awt.Color;
import java.util.Random;

public class Turtle extends Animal {
	public Turtle(int posX, int posY, World world) {
		this.myColor = new Color(76, 153, 0);
		this.whoIAm = 'T';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(2);
		setInitiative(1);
	}
	
	@Override
	public void action() {
		Random rnd = new Random();
		int chanceOfMove;
		chanceOfMove = rnd.nextInt(101);
		if (chanceOfMove < 25)
			super.action();
	}

	@Override
	public boolean defenced(Organism enemy) {
		if (enemy.getPower() < 5)
			return true;
		return false;
	}
}