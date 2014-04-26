package easyAnimations.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import parser.visitor.EasyAnimVisitor;
import poseParser.visitor.MyPoseVisitor;

import easyAnimations.Animation;
import easyAnimations.Parser;
import exceptions.SemanticException;

public class AnimationDialogListener implements ActionListener
{
	//Model
	private easyAnimations.Animation rootAnimation;
	private easyAnimations.Animation newAnimation;
	
	//View
	private AnimationDialog dialog;
	
	//Variables
	private easyAnimations.Pose readPose;
	private easyAnimations.Animation readAnimation;
	private DefaultMutableTreeNode rootNode;
		
	private JFileChooser poseChooser = new JFileChooser(".\\poses\\");
	private JFileChooser animationChooser = new JFileChooser(".\\animations\\");
	
	private int frame = -1;
	
	public AnimationDialogListener(Animation animation)
	{
		newAnimation = animation;
	}
	
	public void setDialog(AnimationDialog dialog)
	{
		this.dialog = dialog;
		rootNode = dialog.getTreePanel().getRoot();
	}
	
	public Animation getAnimation()
	{
		return rootAnimation;
	}
	
	public DefaultMutableTreeNode getRootNode()
	{
		return rootNode;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand().equals("add pose"))
		{
			try
			{
				if(dialog.specifyFrame())
				{
					//Select the frame
					FrameDialog frameDialog = new FrameDialog(newAnimation);
					frameDialog.setLocationRelativeTo(dialog);
					frameDialog.setVisible(true);
					if(!frameDialog.isApproved())
					{
						dialog.log("Open command cancelled by user.");
						return;
					}
					
					frame = frameDialog.getFrame();
				}
				
				int value = poseChooser.showOpenDialog(dialog);
				if (value == JFileChooser.APPROVE_OPTION)
				{
					File file = poseChooser.getSelectedFile();
					FileInputStream stream = new FileInputStream(file);

					dialog.log("Opening: " + file.getName() + ".");

					poseParser.syntaxtree.Pose pose = Parser.parsePose(stream);

					MyPoseVisitor poseVisitor = new MyPoseVisitor();
					readPose = poseVisitor.getEvaluation(pose);

					stream.close();

					dialog.log("Adding Pose: " + readPose.getName() + " to Animation...");

					if (frame != -1)
					{
						newAnimation.addPose(readPose, frame);
						frame = -1;
					}
					else
						newAnimation.addPose(readPose);
					
					dialog.getTreePanel().addPose(readPose, rootNode);

					dialog.setLogColor(Color.GREEN);
					dialog.log(""+newAnimation.print());

				}
				else
				{
					dialog.log("Open command cancelled by user.");
				}

			}
			catch(SemanticException ex)
			{
				dialog.setLogColor(Color.YELLOW);
				dialog.log(ex.getMessage());
			}
			catch(Exception ex)
			{
				dialog.setLogColor(Color.RED);
				dialog.log(ex.getMessage());
			}
			
		}
		
		if(e.getActionCommand().equals("add animation"))
		{
			try
			{
				if(dialog.specifyFrame())
				{
					//Select the frame
					FrameDialog frameDialog = new FrameDialog(newAnimation);
					frameDialog.setLocationRelativeTo(dialog);
					frameDialog.setVisible(true);
					if(!frameDialog.isApproved())
					{
						dialog.log("Open command cancelled by user.");
						return;
					}
					frame = frameDialog.getFrame();
				}
				
				int value = animationChooser.showOpenDialog(dialog);
				if (value == JFileChooser.APPROVE_OPTION)
				{
					File file = animationChooser.getSelectedFile();
		            FileInputStream stream = new FileInputStream(file);
		            
		            dialog.log("Opening: " + file.getName() + ".");
		            
		            parser.syntaxtree.Animation animation = Parser.parseAnimation(stream);
		            EasyAnimVisitor animationVisitor = new EasyAnimVisitor();
		            readAnimation = animationVisitor.getEvaluation(animation);
		            
		            stream.close();
		            		            
		            dialog.log("Adding Animation: " + readAnimation.getName() + " to Animation...");
		            
		            if(frame != -1)
		            {
		            	newAnimation.addSubAnimation(readAnimation, frame);
		            	frame = -1;
		            }
		            else
		            	newAnimation.addSubAnimation(readAnimation);
		            
		            dialog.getTreePanel().addAnimation(readAnimation, rootNode);
		            
		            dialog.setLogColor(Color.GREEN);
		            dialog.log(""+newAnimation.print());
					
		        }
				else
				{
		            dialog.log("Open command cancelled by user.");
		        }
				
			}
			catch(SemanticException ex)
			{
				dialog.setLogColor(Color.YELLOW);
				dialog.log(ex.getMessage());
			}
			catch(Exception ex)
			{
				dialog.setLogColor(Color.RED);
				dialog.log(ex.getMessage());
			}
		}
		
		if(e.getActionCommand().equals("finish"))
		{
			if(newAnimation.getPoses().size() < 1)
			{
				JOptionPane.showMessageDialog(dialog, "An animation must contain at least one Pose.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			rootAnimation = newAnimation;
			rootNode = dialog.getTreePanel().getRoot();
			dialog.dispose();
		}
		
		if(e.getActionCommand().equals("cancel"))
		{
			dialog.dispose();
		}
	}

}
