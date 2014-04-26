package easyAnimations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

import exceptions.DuplicateBoneException;
import exceptions.MissingBoneException;

public class Pose
{
	private String name;
	private Animation parentAnimation;
	private int frame = -1;
	private List<Bone> bones = new ArrayList<Bone>();
	private List<String> checkList = new ArrayList<String>();
	private List<String> defaultBones = new ArrayList<String>();
	
	public Pose(String name)
	{
		this.name = name;
		setUpBones();
	}
	
	private void setUpBones()
	{
		defaultBones.add("HEAD:");
		defaultBones.add("CHEST:");
		defaultBones.add("R SHOULDER:");
		defaultBones.add("L SHOULDER:");
		defaultBones.add("UPPER R ARM:");
		defaultBones.add("LOWER R ARM:");
		defaultBones.add("UPPER L ARM:");
		defaultBones.add("LOWER L ARM:");
		defaultBones.add("R HIP:");
		defaultBones.add("L HIP:");
		defaultBones.add("UPPER R LEG:");
		defaultBones.add("LOWER R LEG:");
		defaultBones.add("UPPER L LEG:");
		defaultBones.add("LOWER L LEG:");
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Animation getParentAnimation()
	{
		return parentAnimation;
	}
	
	public void setParentAnimation(Animation animation)
	{
		this.parentAnimation = animation;
	}
	
	public int getFrame()
	{
		return frame;
	}
	
	public void setFrame(int frame)
	{
		this.frame = frame;
	}
	
	public List<Bone> getBones()
	{
		return bones;
	}
	
	public void addBone(Bone bone) throws DuplicateBoneException
	{
		for(int i=0; i<bones.size(); i++)
			if(bones.get(i).getName().equals(bone.getName()))
				throw new DuplicateBoneException("Bone: " + bone.getName() + " duplicated in pose: " + name);
		checkList.add(bone.getName());
		bones.add(bone);
	}
	
	public void checkBones() throws MissingBoneException
	{
		for(int i=0; i<defaultBones.size(); i++)
			if(!(checkList.contains(defaultBones.get(i))))
				throw new MissingBoneException("One or more bones are missing into pose: " + name);
	}
	
	public boolean equals(Pose pose)
	{
		if(!(name.equals(pose.getName())))
			return false;
		if(bones.size() != pose.getBones().size())
			return false;
		for(int i=0; i<bones.size(); i++)
			if(!((Bone)bones.get(i)).equals(pose.getBones().get(i)))
				return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		if(frame >= 0)
			return "Pose: " + name + " @ Frame: " + frame;
		else
			return "Pose: " + name;
	}
	
	public String print()
	{
		if(frame >= 0)
			return "Pose: " + name + " @ Frame: " + frame;
		else
			return "Pose: " + name;
	}
	
	public boolean save(String fileName)
	{
		boolean successfull = true;
		
		try
		{
			FileWriter writer = new FileWriter(fileName, true);
			BufferedWriter out = new BufferedWriter(writer);
			out.write("Pose: " + name + "\n");
			//Scrivo tutte le bones
			out.write("Bone HEAD: (x=1, y=1, z=2), (x=2, y=2, z=1");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			successfull = false;
		}
		
		return successfull;
	}
	
	public boolean load(String fileName)
	{
		boolean successfull = true;
		
		try
		{
			String line;
			StringTokenizer tokenizer;
			FileReader reader = new FileReader(fileName);
			BufferedReader in = new BufferedReader(reader);
			line = in.readLine();
			tokenizer = new StringTokenizer(line);
			tokenizer.nextToken();
			name = tokenizer.nextToken();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			successfull = false;
		}
		
		return successfull;
	}
	
	public void save(PrintWriter writer, String modifier)
	{
		writer.println(modifier + "Add Pose " + name + " at frame " + frame);
		writer.println(modifier + "{");
		for(int i=0; i<bones.size(); i++)
		{
			bones.get(i).save(writer, modifier + "\t");
		}
		writer.println(modifier + "}");
	}
}
