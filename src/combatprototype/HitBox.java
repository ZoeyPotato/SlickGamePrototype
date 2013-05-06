package combatprototype;


public class HitBox
{
	protected float boxXCoord;
	protected float boxYCoord;
	protected float boxWidth;
	protected float boxHeight;
	
	
	public HitBox (float xCoord, float yCoord, float width, float height) 
	{
		boxXCoord = xCoord;
		boxYCoord = yCoord;
		boxWidth = width;
		boxHeight = height;
	}
	
	
	//Checks if two hit boxes are overlapping on the X axis
	private boolean XOverlap(HitBox otherBox)
	{
		if (boxXCoord >= otherBox.boxXCoord && boxXCoord + boxWidth <= otherBox.boxXCoord)
		{
			return true;
		} 
		else if (boxXCoord >= otherBox.boxXCoord + otherBox.boxWidth && 
			boxXCoord + boxWidth <= otherBox.boxXCoord + otherBox.boxWidth) 
		{
			return true;
		}
		else if (boxXCoord <= otherBox.boxXCoord && boxXCoord + boxWidth >= otherBox.boxXCoord + otherBox.boxWidth) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	//Checks if two hit boxes are overlapping on Y axis
	private boolean YOverlap(HitBox otherBox)
	{
		if (boxYCoord <= otherBox.boxYCoord && boxYCoord + boxHeight >= otherBox.boxYCoord)
		{
			return true;
		}
		else if (boxYCoord <= otherBox.boxYCoord + otherBox.boxHeight && 
				boxYCoord + boxHeight >= otherBox.boxYCoord + otherBox.boxHeight) 
		{
			return true;
		}
		else if (boxYCoord >= otherBox.boxYCoord && boxYCoord + boxHeight <= otherBox.boxYCoord + otherBox.boxHeight) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	
	
	//Utilizes X and Y Overlap functions to find if two hitboxes are touching
	public boolean isTouching(HitBox otherBox)
	{
		if (XOverlap(otherBox) && YOverlap(otherBox))
			return true;
		else
			return false;
	}
	
	
	public float getBoxX() 
	{
		return boxXCoord;
	}
	public void setBoxX (float newX) 
	{
		boxXCoord = newX;
	}
	public float getBoxY() 
	{
		return boxYCoord;
	}
	public void setBoxY (float newY) 
	{
		boxYCoord = newY;
	}
	
}
