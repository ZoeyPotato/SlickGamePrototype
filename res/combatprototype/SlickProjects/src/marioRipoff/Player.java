package marioRipoff;

public class Player {
	protected float playerX;
	protected float playerY;
	protected float playerOldX;
	protected float playerOldY;

	public Player() {
		this(100, 100);
	}

	public Player(int startX, int startY) {
		playerX = startX;
		playerY = startY;
		playerOldX = playerX;
		playerOldY = playerY;
	}

	public void moveX(float delta, int[][] levelData, float worldX, int tileSize) {
		playerX += delta;
		
		float dx = playerX + worldX;
		
		// check left corners for collision. move back just as far as needed, if needed
		if(checkCollision(dx, playerY, levelData, tileSize) ||
		   checkCollision(dx, playerY+tileSize-1, levelData, tileSize)) {
			playerX = (int) (((int) (playerX/tileSize) + 1) * tileSize + (worldX % tileSize));
			dx = playerX + worldX; // update this since playerX changed
		}
		// check right corners for collision. move back just as far as needed, if needed
		if(checkCollision(dx+tileSize, playerY, levelData, tileSize) ||
		   checkCollision(dx+tileSize, playerY+tileSize-1, levelData, tileSize)) {
			playerX = ((int) ((playerX - (worldX % tileSize))/tileSize)) * tileSize;
		}
	}
	
	public void moveY(float delta, int[][] levelData, float worldX, int tileSize) {
		playerY += delta;

		float dx = playerX + worldX;
		
		// check bottom corners for collision. move back just as far as needed, if neededdddwd
		if(checkCollision(dx+tileSize-1, playerY+tileSize, levelData, tileSize) ||
		   checkCollision(dx, playerY+tileSize, levelData, tileSize)) {
			playerY = ((int) (playerY/tileSize)) * tileSize;
		}
		// check top corners for collision. move back just as far as needed, if needed
		if(checkCollision(dx+tileSize-1, playerY, levelData, tileSize) ||
		   checkCollision(dx, playerY, levelData, tileSize)) {
			playerY = ((int) (playerY/tileSize) + 1) * tileSize;
		}
	}
	
	// returns true if a collision is occurring at the given x,y
	public boolean checkCollision(float x, float y, int[][] levelData, int tileSize) {
		if(x < 0 || x > (levelData[0].length - 1) * tileSize)
			return true;
		
		int tileX = (int) (x / tileSize);
		int tileY = (int) (y / tileSize);
		
		return levelData[tileY][tileX] != 0;
	}
	
	public void tick() {
		playerOldX = playerX;
		playerOldY = playerY;
	}
	
	public float posX() {
		return playerX;
	}
	
	public float posY() {
		return playerY;
	}
}