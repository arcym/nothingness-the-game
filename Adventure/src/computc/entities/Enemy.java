package computc.entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import computc.cameras.Camera;
import computc.worlds.dungeons.Dungeon;
import computc.worlds.rooms.Room;

public abstract class Enemy extends Entity
{
	protected int surroundingAreaRadius;
	protected Circle surroundingArea;

	public Enemy(Dungeon dungeon, Room room, float x, float y)
	{
		super(dungeon, room, x, y);
		//Arbitrarily create a circle in a place. this actual location will be set during first update loop.
		this.surroundingArea = new Circle(0,0, 50);
	}

	protected int health;
	protected int maxHealth;
	protected boolean dead;
	protected int damage;
	protected int mood; 

	
	protected boolean blinkTimer;
	protected int blinkCooldown;
	
	protected boolean left;
    protected boolean right;
    protected boolean up;
    protected boolean down;
    
    protected boolean attacking;
    
    public enum State 
    {
    	PATROL, ACTIVE
    }
    protected State aiState;
	
	public boolean isDead()
	{
		return dead;
	}
	
	
	public void render(Graphics graphics, Camera camera)
	{
		super.render(graphics, camera);
	}
	
	public int getDamage() 
	{
		return damage;
	}
	
	public void hit(int damage)
	{
		if(dead || blinking)
		{
			return;
		}
		
		health -= damage;
		if(health <= 0)
		{
			dead = true;
		}
		
		blinking = true;
		blinkCooldown = 50;
	}
	
	public int getHealth()
	{
		return health;
	}
}