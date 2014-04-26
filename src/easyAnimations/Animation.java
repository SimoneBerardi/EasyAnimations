package easyAnimations;

import java.io.PrintWriter;
import java.util.*;

import exceptions.*;

public class Animation
{
	private String name;
	private int duration;
	private Animation parentAnimation;
	private int nextFreeFrame = 0;
	private int frame = -1;
	private int actualDuration = 0;
	
	private List<Animation> animationsList = new ArrayList<Animation>();
	
	private Hashtable<Integer, Object> frames;
	private List<Animation> subAnimations = new ArrayList<Animation>();
	private List<Pose> poses = new ArrayList<Pose>();
	
	private String newLine = "\n";
	
	public Animation (String name, int duration)
	{
		this.name = name;
		this.duration = duration;
		frames = new Hashtable<Integer, Object>(duration);
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getDuration()
	{
		return duration;
	}
	
	public void setFrame(int frame)
	{
		this.frame = frame;
	}
	
	public int getFrame()
	{
		return frame;
	}
	
	public Animation getParent()
	{
		return parentAnimation;
	}
	
	public void setParent(Animation animation)
	{
		this.parentAnimation = animation;
	}
	
	public boolean hasParent()
	{
		if (parentAnimation != null)
			return true;
		return false;
	}
	
	public Hashtable<Integer, Object> getFrames()
	{
		return frames;
	}
	
	public void addSubAnimation(Animation animation) throws LowDurationException, DuplicateFrameElementException, FrameOutOfBoundsException, DuplicateNameException
	{
		if(getNewFreeFrame())
		{
			addSubAnimation(animation, nextFreeFrame);
		}
		else
			throw new LowDurationException("Animation: " + name + " can't contain animation: " + animation.getName());
	}
	
	public void addSubAnimation(Animation animation, int frame) throws LowDurationException, DuplicateFrameElementException, FrameOutOfBoundsException, DuplicateNameException
	{
		if(frames.get(frame) == null)
		{
			addAnimation(animation, frame);
			animation.setParent(this);
			subAnimations.add(animation);
		}
		else
			throw new DuplicateFrameElementException("Animation: " + name + ", Duplicated element at frame: " + frame);
	}
	
	private void addAnimation(Animation animation, int frame) throws LowDurationException, DuplicateFrameElementException, FrameOutOfBoundsException, DuplicateNameException
	{
		
		actualDuration += animation.getDuration();
		checkDuration(animation, frame);
		
		if(frame > (duration-1))
			throw new FrameOutOfBoundsException("Animation: " + animation.getName() + " is out of animation " + name + " frame bounds");
				
		for(int i=0; i<animation.getDuration(); i++)
		{
			if(frames.get(frame+i) != null)
				throw new DuplicateFrameElementException("Animation: " + name + ", Duplicated element at frame: " + (frame+i));
		}
		
		animation.setFrame(frame);
		for(int i=0; i<animation.getDuration(); i++)
		{
			frames.put(frame+i, animation);
		}
		
		//Se sono la root tengo traccia di tutte le animation
		if(!hasParent())
			animationsList.add(animation);
		
	}
	
	public void removeAnimation(Animation animation)
	{
		int frame = animation.getFrame();
		int duration = animation.getDuration();
		subAnimations.remove(animation);
		for(int i=frame; i<(frame + duration); i++)
		{
			frames.remove(i);
			actualDuration--;
		}
	}
	
	public boolean removePose(Pose pose)
	{
		if(poses.size() == 1)
			return false;
		poses.remove(pose);
		frames.remove(pose.getFrame());
		actualDuration--;
		
		return true;
	}

	private void checkDuration(Animation animation, int frame) throws LowDurationException
	{
		if(actualDuration > duration)
			throw new LowDurationException("Animation: " + name + " can't contain animation: " + animation.getName());
		if(frame + animation.getDuration() > duration)
			throw new LowDurationException("Animation: " + name + " can't contain animation: " + animation.getName());
	}
	
	private void checkDuration(Pose pose) throws LowDurationException
	{
		if(actualDuration > duration)
			throw new LowDurationException("Animation: " + name + " can't contain pose: " + pose.getName());
	}
	
	public List<Animation> getSubAnimations()
	{
		return subAnimations;
	}
	
	public void addPose(Pose pose) throws LowDurationException, DuplicateFrameElementException, FrameOutOfBoundsException, DuplicateNameException, MissingBoneException
	{
		if(getNewFreeFrame())
		{
			addPose(pose, nextFreeFrame);
			pose.setParentAnimation(this);
		}
		else
			throw new LowDurationException("Animation: " + name + " can't contain pose: " + pose.getName());
	}
	
	public void addPose(Pose pose, int frame) throws LowDurationException, DuplicateFrameElementException, FrameOutOfBoundsException, DuplicateNameException, MissingBoneException
	{
		actualDuration++;
		checkDuration(pose);
		
		if(frame > (duration-1))
			throw new FrameOutOfBoundsException("Pose: " + pose.getName() + " is out of animation " + name + " frame bounds");
		
		if(checkForDuplicates(pose))
			throw new DuplicateNameException("Pose: " + pose.getName() + " already defined.");
		
		if(frames.get(frame) == null)
		{
			pose.checkBones();
			pose.setFrame(frame);
			poses.add(pose);
			frames.put(frame, pose);
		}
		else
			throw new DuplicateFrameElementException("Animation: " + name + ", Duplicated element at frame: " + frame);
	}
	
	public List<Pose> getPoses()
	{
		return poses;
	}
	
	public boolean hasSubAnimations()
	{
		if(subAnimations.size() == 0)
			return false;
		else
			return true;
	}
	
	private boolean getNewFreeFrame()
	{
		nextFreeFrame = -1;
		for(int i=0; i<duration; i++)
		{
			if(frames.get(i) == null)
			{
				nextFreeFrame = i;
				break;
			}
		}
		if(nextFreeFrame != -1)
			return true;
		
		return false;
	}
	
	public void checkForDuplicates() throws DuplicateNameException
	{
		for(int i=0; i<animationsList.size(); i++)
		{
			Animation current = animationsList.get(i);
			for(int y=i; y<animationsList.size(); y++)
			{
				Animation temp = animationsList.get(y);
				if(current.getName().equals(temp.getName()))
					if(!current.equals(temp))
						throw new DuplicateNameException("Animation: " + current.getName() + " already defined.");
			}
		}
	}
	
	private boolean checkForDuplicates(Pose pose)
	{
		for(int i=0; i<poses.size(); i++)
		{
			Pose currentPose = poses.get(i);
			if(currentPose.getName().equals(pose.getName()))
				if(!currentPose.equals(pose))
					return true;
		}
		
		if(hasParent())
			getParent().checkForDuplicates(pose);
			
		return false;
	}
	
	public boolean equals(Animation animation)
	{
		if(!name.equals(animation.getName()))
			return false;
		if(duration != animation.getDuration())
			return false;
		if(hasSubAnimations())
			if(subAnimations.size() != animation.getSubAnimations().size())
				return false;
			else
			{
				for(int i=0; i<subAnimations.size(); i++)
					if(!subAnimations.get(i).equals(animation.getSubAnimations().get(i)))
						return false;
			}
		if(poses.size() != animation.getPoses().size())
			return false;
		for(int i=0; i<poses.size(); i++)
			if(!poses.get(i).equals(animation.getPoses().get(i)))
				return false;
		return true;
	}
	
	public boolean checkFrame(int frame)
	{
		if(frames.get(frame) != null)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		String value = "Name: " + name + " Duration: " + duration;
		if(frame != -1)
			value = value + " @Frame: " + frame;
		return value;
	}
	
	public String print()
	{
		String result = "Name: " + name + " Duration: " + duration;
		if(frame != -1)
			result = result + " @Frame: " + frame;
		
		result = result + newLine;
		
		if(hasSubAnimations())
		{
			result = result + "Subanimations" + newLine;
			for(int i=0; i<subAnimations.size(); i++)
			{
				result = result + subAnimations.get(i).print() + newLine;
			}
		}
		result = result + "Poses" + newLine;
		for(int i=0; i<poses.size(); i++)
		{
			result = result + poses.get(i).print() + newLine;
		}
		
		return result;
	}
	
	public void save(PrintWriter writer, String modifier)
	{
		try
		{
			if(parentAnimation == null)
			{
				writer.println(modifier + "Animation " + name);
				writer.println(modifier + "Duration: " + duration + " frames");
			}
			else
			{
				writer.println(modifier + "Add Animation " + name + " at frame " + (frame == -1 ? 0 : frame));
				writer.println(modifier + "Duration: " + duration + " frames");
			}
			
			if(hasSubAnimations())
			{
				writer.println(modifier + "SubAnimations");
				writer.println(modifier + "{");
				for(int i=0; i<subAnimations.size(); i++)
					subAnimations.get(i).save(writer, modifier + "\t");
				writer.println("}");
			}
			writer.println(modifier + "Poses");
			writer.println(modifier + "{");
			for(int i=0; i<poses.size(); i++)
				poses.get(i).save(writer, modifier + "\t");
			if(parentAnimation == null)
				writer.println(modifier + "}");
			else
				writer.println(modifier + "};");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
