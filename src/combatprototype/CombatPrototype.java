package combatprototype;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class CombatPrototype extends BasicGame
{
	public static final int tileSize = 32;
	public static final int screenW = 1280; public static final int screenH = 720;
	protected Map initialMap;
	protected Player player;
	
	
	/**********************************************
	 * Main method for slick, doesn't do all that much. Lists project name, initializes fields.
	 */
	public CombatPrototype()
	{
		super ("A minecraft, minicraft, zelda ripoff (sorry mojang/nintendo plz no sue)");
	}

	
	/**********************************************
	 * Initialization method for Slick. Allocates memory, creates objects.
	 * Run at the launch of the game and when manually called in the game.
	 */
	public void init (GameContainer container) throws SlickException
	{
		initialMap = new Map ("res/combatprototype/testLevel.tmx");
		
		player = new Player (initialMap.getMapWidth() / 2, initialMap.getMapHeight() / 2);
	
		player.setAnimation ("res/combatprototype/link/link_normal_noshield/link_left.png", "left");
		player.setAnimation ("res/combatprototype/link/link_normal_noshield/link_right.png", "right");
		player.setAnimation ("res/combatprototype/link/link_normal_noshield/link_down.png", "down");
		player.setAnimation ("res/combatprototype/link/link_normal_noshield/link_up.png", "up");
	}
	
	
	/**********************************************
	 * Update method for Slick. Runs every frame.
	 * Listens for keypresses; Runs these internal methods.
	 */
	public void update (GameContainer container, int delta) throws SlickException
	{
		player.movementHandler (container, delta, initialMap);
	}
	
	
	/**********************************************
	 * Render method for Slick. Runs every frame.
	 * Displays images, the map, and other information to the game window
	 */
	public void render (GameContainer container, Graphics g) throws SlickException
	{
		initialMap.mapRender (container, g, player.getCameraX(), player.getCameraY());
		
		player.playerAniRender (container, g);
		
		g.drawString ("ZeldaCraft v.CHoDE", 10, 30);
		g.drawString ("playerX: " + player.getX(), 10, 50); 
		g.drawString ("playerY: " + player.getY(), 10, 70);
		g.drawString ("cameraX: " + player.getCameraX(), 10, 100);
		g.drawString ("cameraY: " + player.getCameraY(), 10, 120);
	}
	
	
	/**********************************************
	 * Main method for the game. Logistical use, executes main slick method.
	 */
	public static void main(String[] args) throws SlickException 
	{
		AppGameContainer app = new AppGameContainer (new CombatPrototype());
		app.setDisplayMode (screenW, screenH, false);
		app.start();
	}

}
