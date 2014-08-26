package computc;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Hero extends Entity
{
	public Hero(TiledWorld world, int tx, int ty) throws SlickException
	{
		super(world, tx, ty);
		
		this.image = new Image("res/hero.png");
	}
	
	public void update(Input input, int delta)
	{
		float step = this.speed * delta;
		
		if(input.isKeyDown(Input.KEY_UP))
		{
			if(this.y - step > 0)
			{
				this.y -= step;
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN))
		{
			if(this.y + step < this.world.getPixelHeight())
			{
				this.y += step;
			}
		}
		
		if(input.isKeyDown(Input.KEY_LEFT))
		{
			if(this.x - step > 0)
			{
				this.x -= step;
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT))
		{
			if(this.x + step < this.world.getPixelWidth())
			{
				this.x += step;
			}
		}
	}
	
	private float speed = 0.15f;
}