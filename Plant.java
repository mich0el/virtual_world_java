import java.util.Random;

public class Plant extends Organism {
	public Plant() {
		setInitiative(0);
	}
	
	@Override
	public void action() {
		final int CHANCE_OF_SPREAD = 5;
		int chance;
		Random rnd = new Random();
		chance = rnd.nextInt(101);
		if (chance <= CHANCE_OF_SPREAD) {
			int spreadTo;
			spreadTo = rnd.nextInt(5);
			switch (spreadTo) {
				case 0: //up
					if (isItFreeSquare(this.getPosX(), this.getPosY() - 1) == true) {
						addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() - 1);
					} else {
						if (isItFreeSquare(this.getPosX(), this.getPosY() + 1) == true) {
							addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() + 1);
						} else {
							if (isItFreeSquare(this.getPosX() - 1, this.getPosY()) == true) {
								addNewPlant(this.whoIAm, this.getPosX() - 1, this.getPosY());
							} else {
								if (isItFreeSquare(this.getPosX() + 1, this.getPosY()) == true) {
									addNewPlant(this.whoIAm, this.getPosX() + 1, this.getPosY());
								}
							}
						}
					}
					break;
				case 1: // down
					if (isItFreeSquare(this.getPosX(), this.getPosY() + 1) == true) {
						addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() + 1);
					} else {
						if (isItFreeSquare(this.getPosX(), this.getPosY() - 1) == true) {
							addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() - 1);
						} else {
							if (isItFreeSquare(this.getPosX() - 1, this.getPosY()) == true) {
								addNewPlant(this.whoIAm, this.getPosX() - 1, this.getPosY());
							} else {
								if (isItFreeSquare(this.getPosX() + 1, this.getPosY()) == true) {
									addNewPlant(this.whoIAm, this.getPosX() + 1, this.getPosY());
								}
							}
						}
					}
					break;
				case 2: //left
					if (isItFreeSquare(this.getPosX() - 1, this.getPosY()) == true) {
						addNewPlant(this.whoIAm, this.getPosX() - 1, this.getPosY());
					} else {
						if (isItFreeSquare(this.getPosX() + 1, this.getPosY()) == true) {
							addNewPlant(this.whoIAm, this.getPosX() + 1, this.getPosY());
						} else {
							if (isItFreeSquare(this.getPosX(), this.getPosY() - 1) == true) {
								addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() - 1);
							} else {
								if (isItFreeSquare(this.getPosX(), this.getPosY() + 1) == true) {
									addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() + 1);
								}
							}
						}
					}
					break;
				case 3: //right
					if (isItFreeSquare(this.getPosX() + 1, this.getPosY()) == true) {
						addNewPlant(this.whoIAm, this.getPosX() + 1, this.getPosY());
					} else {
						if (isItFreeSquare(this.getPosX() - 1, this.getPosY()) == true) {
							addNewPlant(this.whoIAm, this.getPosX() - 1, this.getPosY());
						} else {
							if (isItFreeSquare(this.getPosX(), this.getPosY() + 1) == true) {
								addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() + 1);
							} else {
								if (isItFreeSquare(this.getPosX(), this.getPosY() - 1) == true) {
									addNewPlant(this.whoIAm, this.getPosX(), this.getPosY() - 1);
								}
							}
						}
					}
					break;
			}
		}
	}

	@Override
	public collisionResult collision(int pX, int pY) {
		return null;
	}
	@Override
	public boolean defenced(Organism enemy) {
		return false;
	}

	boolean isItFreeSquare(int x, int y) {
		int boardSizeX = world.getSizeX() - 1;
		int boardSizeY = world.getSizeY() - 1;
		if (x < 0 || x > boardSizeX || y < 0 || y > boardSizeY)
			return false;
		if (world.getBoard()[y][x] != null)
			return false;
		return true;
	}
	void addNewPlant(char type, int x, int y) {
		Plant newPlant;
		switch (type) {
			case 'u':
				newPlant = new Guarana(x, y, this.world);
				break;
			case 'o':
				newPlant = new Sonchus(x, y, this.world);
				break;
			case 's':
				newPlant = new HeracleumSosnowkyi(x, y, this.world);
				break;
			case 'b':
				newPlant = new Belladonna(x, y, this.world);
				break;
			default:
				newPlant = new Grass(x, y, this.world);
				break;
		}
		newPlant.setJustBorn(true);
		this.world.getBoard()[newPlant.getPosY()][newPlant.getPosX()] = newPlant;
		this.world.listOfOrganisms.add(newPlant);
	}
}
