package parser;

import java.io.*;
import java.util.*;

import parser.syntaxtree.*;
import parser.visitor.*;

public class MyMain
{
	private static List<Animation> animations = new ArrayList<Animation>();
	private static List<Pose> poses = new ArrayList<Pose>();
	
	public static void main(String args [])
	  {
		
		System.out.println("Reading Animation...");
		try
		{
			FileInputStream fin = new FileInputStream(".\\animations\\testCompletePoses.txt");
			EasyAnimParser parser =  new EasyAnimParser(fin);
			Animation animation = EasyAnimParser.Animation();

			EasyAnimVisitor easy = new EasyAnimVisitor();
			
			easyAnimations.Animation rootAnimation = easy.getEvaluation(animation);
			
			System.out.println(rootAnimation.print());
			
//			PrintWriter writer = new PrintWriter(".\\animations\\testSave.txt");
//			rootAnimation.save(writer, "");
//			writer.close();
			
//			printAnimation(rootAnimation, "");
//			printFrames(rootAnimation);
			
		}
		catch (Exception e)
		{
			System.out.println("Oops.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	  }
	
	private static void printFrames(easyAnimations.Animation animation)
	{
		Hashtable frames = animation.getFrames();
		for(int i=0; i<frames.size(); i++)
		{
			System.out.println("Frame " + i + "Value " + frames.get(i) + "\n");
		}
	}
	
	private static void printAnimation(easyAnimations.Animation animation, String modifier)
	{
		final String mod = "" + modifier;
		System.out.println(mod + animation);
		if(animation.hasSubAnimations())
			{
				System.out.println(mod + "SubAnimations");
				for(int i = 0; i<animation.getSubAnimations().size(); i++)
				{
					printAnimation(animation.getSubAnimations().get(i), mod + "\t");
				}
			}
			printPoses(animation, mod);
	}
	
	private static void printPoses(easyAnimations.Animation animation, String modifier)
	{
		final String mod = "" + modifier;
		System.out.println(mod + "Poses");
		for(int i = 0; i<animation.getPoses().size(); i++)
		{
			easyAnimations.Pose pose = animation.getPoses().get(i);
			System.out.println(mod + pose);
		}
	}
}
