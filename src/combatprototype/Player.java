package combatprototype;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class Player extends Entity
{
	private float cameraX; private float cameraY;
	

	public Player (int playerX, int playerY, int playerWidth, int playerHeight, int playerHealth, int playerDamage) 
	{
		super (playerX, playerY, playerWidth, playerHeight, playerHealth, playerDamage); //Sets all superclass fields
		
		cameraX = screenW / 2; cameraY = screenH / 2;
		setSpeed ((float) .2);
	}
	
	
	/*
	 * General update method for the player. Will call all important functions pertaining to
	 * and affecting the player.
	 */
	public void playerUpdate (GameContainer container, int delta, Map curMap, Entity mob) throws SlickException 
	{
		playerMovement (container, delta, curMap, mob); //player should move first in update (for collision)
		entityMapCollision(curMap);
		entityToEntityCollision(mob);
		playerAttacked (mob);
	}
	
	
	/*
	 * This method handles all player movements, inputs and adjusts the camera
	 */
	public void playerMovement (GameContainer container, int delta, Map curMap, Entity mob) throws SlickException 
	{
		Input input = container.getInput();
		
		if (input.isKeyDown (Input.KEY_A)) //Move Left
		{
			setX (getX() - (getSpeed() * delta));
			getAniLeft().update(delta);
			setLastDirection ("left");
		}
		if (input.isKeyDown (Input.KEY_D)) //Move Right
		{
			setX (getX() + (getSpeed() * delta));
			getAniRight().update(delta);
			setLastDirection ("right");
		}
		if (input.isKeyDown (Input.KEY_S)) //Move down
		{
			setY (getY() + (getSpeed() * delta));
			getAniDown().update(delta);
			setLastDirection ("down");
		}
		if (input.isKeyDown (Input.KEY_W)) //Move up
		{
			setY (getY() - (getSpeed() * delta));
			getAniUp().update(delta);
			setLastDirection ("up");
		}
		if (input.isKeyDown (Input.KEY_ESCAPE))
			System.exit(0);
		
		setCameraX (screenW / 2 - getX());
		setCameraY (screenH / 2 - getY());
	}
	
	
	//player needs to take damage when colliding with a mob
	//player needs to 'jump' away from entity when hit
	//player needs a moment of invulnerability after hit
	private void playerAttacked (Entity mob)
	{
		/*
		//take damage when 'hit' by mob if hitboxes intersect
		if (getHitBox().intersects (mob.getHitBox()))
		{
			setHealth (getHealth() - mob.getDamage());
			
			
		}
		*/
		
		//knock back a bit when hit by the mob
	}
	
	
	public float getCameraX()
	{
		return cameraX;
	}
	public void setCameraX (float newCameraX)
	{
		cameraX = newCameraX;
	}
	public float getCameraY()
	{
		return cameraY;
	}
	public void setCameraY (float newCameraY)
	{
		cameraY = newCameraY;
	}
	
}
