public class OrganismFactory {
	public Organism createNewOrganism(int code, int posX, int posY, World world) {
		switch (code) {
			case 0:
				return new Fox(posX, posY, world);
			case 1:
				return new Wolf(posX, posY, world);
			case 2:
				return new Human(posX, posY, world);
			case 3:
				return new Antelope(posX, posY, world);
			case 4:
				return new Sheep(posX, posY, world);
			case 5:
				return new Turtle(posX, posY, world);
			case 6:
				return new Belladonna(posX, posY, world);
			case 7:
				return new HeracleumSosnowkyi(posX, posY, world);
			case 8:
				return new Sonchus(posX, posY, world);
			case 9:
				return new Guarana(posX, posY, world);
			case 10:
				return new Grass(posX, posY, world);
		}
		return null;
	}
}