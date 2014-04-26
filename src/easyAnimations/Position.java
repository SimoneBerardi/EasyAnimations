package easyAnimations;

import java.io.PrintWriter;

public class Position
{
	private float x;
	private float y;
	private float z;
	
	public Position(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
	
	public float getZ()
	{
		return z;
	}
	
	public boolean equals(Position position)
	{
		if(x != position.getX())
			return false;
		if(y != position.getY())
			return false;
		if(z != position.getZ())
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "( " + x + "," + y + "," + z + " )";
	}
}
