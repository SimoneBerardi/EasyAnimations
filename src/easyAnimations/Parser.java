package easyAnimations;

import java.io.InputStream;


import parser.EasyAnimParser;
import parser.ParseException;
import poseParser.PoseParser;

public class Parser
{
	
	private static EasyAnimParser easyAnimParser;
	private static PoseParser poseParser;
	
	private static void generateAnimationParser(InputStream stream)
	{
		if(easyAnimParser == null)
			easyAnimParser = new EasyAnimParser(stream);
		else
			easyAnimParser.ReInit(stream);
	}
	
	private static void generatePoseParser(InputStream stream)
	{
		if(poseParser == null)
			poseParser = new PoseParser(stream);
		else
			poseParser.ReInit(stream);
	}
	
	public static parser.syntaxtree.Animation parseAnimation(InputStream stream) throws ParseException
	{
		generateAnimationParser(stream);
		return EasyAnimParser.Animation();
	}
	
	public static poseParser.syntaxtree.Pose parsePose(InputStream stream) throws poseParser.ParseException
	{
		generatePoseParser(stream);
		return PoseParser.Pose();
	}

}
