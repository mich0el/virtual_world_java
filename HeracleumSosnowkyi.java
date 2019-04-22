import java.awt.Color;

public class HeracleumSosnowkyi extends Plant {
	public HeracleumSosnowkyi(int posX, int posY, World world) {
		this.myColor = new Color(255, 255, 255);
		this.myTextColor = Color.RED;
		this.whoIAm = 's';
		setPosX(posX);
		setPosY(posY);
		this.world = world;
		setPower(10);
	}
	
	@Override
	public void action() {
		super.action();
		killNeighbours();
	}
	
	boolean targetIsHere(int x, int y) {
		int boardSizeX = world.getSizeX() - 1;
		int boardSizeY = world.getSizeY() - 1;
		if (x < 0 || x > boardSizeX || y < 0 || y > boardSizeY)
			return false;
		if (world.getBoard()[y][x] == null)
			return false;
		if (world.getBoard()[y][x].whoIAm == 's' || world.getBoard()[y][x].whoIAm == 'g' || 
				world.getBoard()[y][x].whoIAm == 'u' || world.getBoard()[y][x].whoIAm == 'o' || 
				world.getBoard()[y][x].whoIAm == 'b')
			return false;
		return true;
	}
	
	public void killNeighbours() {
		String tmp;
		int posX, posY;
		posX = this.getPosX();
		posY = this.getPosY();
		for (int i = 0; i < 4; i++) {
			if (targetIsHere(posX + 1, posY) == true) {
				this.world.getBoard()[posY][posX + 1].setIsDead(true);
				tmp = "one more defenseless " + this.world.getBoard()[posY][posX + 1].whoIAm + " killed by cruel s";
				
				if (this.world.getBoard()[posY][posX + 1].whoIAm == 'H')
					this.world.setPlayerIsActive(false);
				
				this.world.commentList.add(tmp);
				this.world.getBoard()[posY][posX + 1] = null;
				
			} else if (targetIsHere(posX - 1, posY) == true) {
				this.world.getBoard()[posY][posX - 1].setIsDead(true);
				tmp = "one more defenseless " + this.world.getBoard()[posY][posX - 1].whoIAm + " killed by cruel s";
				
				if (this.world.getBoard()[posY][posX - 1].whoIAm == 'H')
					this.world.setPlayerIsActive(false);
				
				this.world.commentList.add(tmp);
				this.world.getBoard()[posY][posX - 1] = null;
				
			} else if (targetIsHere(posX, posY + 1) == true) {
				this.world.getBoard()[posY + 1][posX].setIsDead(true);
				tmp = "one more defenseless " + this.world.getBoard()[posY + 1][posX].whoIAm + " killed by cruel s";
				
				if (this.world.getBoard()[posY + 1][posX].whoIAm == 'H')
					this.world.setPlayerIsActive(false);
				
				this.world.commentList.add(tmp);
				this.world.getBoard()[posY + 1][posX] = null;
				
			} else if (targetIsHere(posX, posY - 1) == true) {
				this.world.getBoard()[posY - 1][posX].setIsDead(true);
				tmp = "one more defenseless " + this.world.getBoard()[posY - 1][posX].whoIAm + " killed by cruel s";
				
				if (this.world.getBoard()[posY - 1][posX].whoIAm == 'H')
					this.world.setPlayerIsActive(false);
				
				this.world.commentList.add(tmp);
				this.world.getBoard()[posY - 1][posX] = null;
				
			}
		}
	}
}