package easyAnimations.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.*;

import javax.swing.JPanel;

import easyAnimations.Bone;
import easyAnimations.Pose;

public class PosePanel extends JPanel
{	
	private Pose pose;
	private List<Bone> bones = new ArrayList<Bone>();;
	

	public void paint (Graphics g)
	{
		super.paint(g);

		setBackground(Color.black);
		setForeground(Color.red);		
		
		if(pose != null)
		{
			drawName(pose, g);
			for(int i=0; i<bones.size(); i++)
			{
				drawBone(bones.get(i), g);
			}
		}
		
	}
	
	private void drawName(Pose pose, Graphics g)
	{
		g.drawString(""+pose, 10, 15);
	}
	
	private void drawBone(Bone bone, Graphics g)
	{
		int x1, x2, y1, y2;
		
		x1 = getActualWidth(bone.getStart().getX());
		x2 = getActualWidth(bone.getEnd().getX());
		y1 = getActualHeight(bone.getStart().getY());
		y2 = getActualHeight(bone.getEnd().getY());
		
		//Drawing the bones
		g.drawLine(x1,y1,x2,y2);
		//Drawing the joints
		Graphics2D g2d = (Graphics2D)g;
		Ellipse2D.Double circle = new Ellipse2D.Double(x1-2.5, y1-2.5, 5, 5);
		g2d.fill(circle);
		circle = new Ellipse2D.Double(x2-2.5, y2-2.5, 5, 5);
		g2d.fill(circle);
	}
	
	private int getActualWidth(float x)
	{
		return (int) (this.getWidth() * x);
	}
	
	private int getActualHeight(float y)
	{
		return (int) (this.getHeight() * y);
	}
	
	public void setPose(Pose pose)
	{
		this.pose = pose;
		if(pose != null)
			bones = pose.getBones();
		
		paint(this.getGraphics());
	}
}