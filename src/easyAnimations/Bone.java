package easyAnimations;

import java.io.PrintWriter;

public class Bone
{
	private String name;
	private Position start;
	private Position end;
	
	public Bone(String name, Position start, Position end)
	{
		this.name = name;
		this.start = start;
		this.end = end;
	}
	
	public Position getStart()
	{
		return start;
	}
	
	public Position getEnd()
	{
		return end;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void save(PrintWriter writer, String modifier)
	{
		writer.println(modifier + name + start + "," + end);
	}
	
	public boolean equals(Bone bone)
	{
		if(!(name == bone.getName()))
			return false;
		if(!(start.equals(bone.getStart())))
			return false;
		if(!(end.equals(bone.getEnd())))
			return false;
		return true;
	}
}
