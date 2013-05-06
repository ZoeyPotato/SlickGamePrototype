package combatprototype;


public class Mob extends Entity 
{
	private String mobType; //not used yet
	
	
	public Mob (int mobX, int mobY, int mobWidth, int mobHeight, int mobHealth, int mobDamage, String type) 
	{
		super (mobX, mobY, mobWidth, mobHeight, mobHealth, mobDamage); //Sets all superclass fields
		
		setSpeed ((float) .1);
		mobType = type;
	}

	
	/*
	 * General update method for mobs. Will call all important functions pertaining to
	 * and affecting the player.
	 */
	public void mobUpdate (Entity passedEntity, int delta, Map curMap)
	{
		entityMapCollision (curMap);
		mobMovement (passedEntity, delta);
	}
	
	
	/*
	 * Handles all mob movements. Determines when to chase player.
	 */
	private void mobMovement (Entity passedEntity, int delta)
	{
		if (distanceMethod (passedEntity) < 500)
		{
			if ( (int) passedEntity.getX() < (int) getX())
			{
				setX (getX() - (getSpeed() * delta));
				getAniLeft().update(delta);
				setLastDirection ("left");
			}
			else if ( (int) passedEntity.getX() > (int) getX())
			{
				setX (getX() + (getSpeed() * delta));
				getAniRight().update(delta);
				setLastDirection ("right");
			}
			if ( (int) passedEntity.getY() < (int) getY())
			{
				setY (getY() - (getSpeed() * delta));
				getAniUp().update(delta);
				setLastDirection ("up");
			}
			else if ( (int) passedEntity.getY() > (int) getY())
			{
				setY (getY() + (getSpeed() * delta));
				getAniDown().update(delta);
				setLastDirection ("down");
			}
		}
	}

}
