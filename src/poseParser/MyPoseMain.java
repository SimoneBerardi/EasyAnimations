package poseParser;

import java.io.FileInputStream;

import poseParser.syntaxtree.Pose;
import poseParser.visitor.DepthFirstVoidVisitor;
import poseParser.visitor.MyPoseVisitor;

public class MyPoseMain
{
	private static easyAnimations.Pose readPose;
	
	public static void main(String args [])
	  {
	   try
	    {
	      FileInputStream fin = new FileInputStream(".\\poses\\standing.txt");
	      PoseParser parser =  new PoseParser(fin);
	      Pose pose = PoseParser.Pose();
	      MyPoseVisitor v = new MyPoseVisitor();
	      pose.accept(v);
	      readPose = v.getEvaluation(pose);
	      System.out.println(readPose);
	      
	    }
	    catch (Exception e)
	    {
	      System.out.println("Oops.");
	      e.printStackTrace();
	    }
	  }
}
