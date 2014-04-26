package easyAnimations.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFileChooser;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import parser.visitor.EasyAnimVisitor;
import poseParser.visitor.MyPoseVisitor;

import easyAnimations.Animation;
import easyAnimations.Model;
import easyAnimations.Parser;
import easyAnimations.Pose;
import exceptions.SemanticException;

public class TreeListener implements TreeSelectionListener, ActionListener
{
	private Model model;
	private MainWindow window;
	private TreePanel treePanel;
	
	private Pose readPose;
	private Animation readAnimation;
	
	private JFileChooser poseChooser = new JFileChooser(".\\poses\\");
	private JFileChooser animationChooser = new JFileChooser(".\\animations\\");
	
	public TreeListener(Model model, MainWindow window)
	{
		this.model = model;
		this.window = window;
		treePanel = window.getTreePanel();
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e)
	{
			TreePath path = e.getNewLeadSelectionPath();
			
			if(path == null)
				return;
			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
			
		    if (node == null)
			    return;
		    else
		    {
		    	
		    	Object nodeInfo = node.getUserObject();
		    	if(nodeInfo.getClass() == easyAnimations.Pose.class)
		    	{
		    		window.log("Selected: " + nodeInfo.toString());
		    		window.displayPose((Pose) nodeInfo);
		    	}
		    }
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		DefaultMutableTreeNode selectedNode = treePanel.getSelectedNode();
		Object nodeInfo = treePanel.getSelectedNode().getUserObject();
    	
		//TODO controllare perché non funziona a dovere se aggiungo ai sotto elementi
		if (e.getActionCommand().equals("insert animation"))
		{
			window.log("Inserting animation to " + treePanel.getSelectedNode() + "...");
			try
			{
				int value = animationChooser.showOpenDialog(window);
				if (value == JFileChooser.APPROVE_OPTION)
				{
					File file = animationChooser.getSelectedFile();
					FileInputStream stream = new FileInputStream(file);

					window.log("Opening: " + file.getName() + ".");

					parser.syntaxtree.Animation animation = Parser.parseAnimation(stream);
					EasyAnimVisitor animationVisitor = new EasyAnimVisitor();
					readAnimation = animationVisitor.getEvaluation(animation);

					stream.close();

					window.log("Adding Animation: " + readAnimation.getName() + " to Animation...");
					Animation selectedAnimation = (Animation) nodeInfo;
					selectedAnimation.addSubAnimation(readAnimation);
					
					treePanel.addAnimation(readAnimation, selectedNode);
					
					window.setLogColor(Color.GREEN);
					window.log("Animation correclty added.");
					window.log(model.getAnimation().print());

				}
				else
				{
					window.log("Open command cancelled by user.");
				}

			}
			catch(SemanticException ex)
			{
				window.setLogColor(Color.YELLOW);
				window.log(ex.getMessage());
			}
			catch(Exception ex)
			{
				window.setLogColor(Color.RED);
				window.log(ex.getMessage());
				ex.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("insert pose"))
		{
			window.log("Inserting pose to " + treePanel.getSelectedNode() + "...");
			try
			{
				Animation animation = (Animation) nodeInfo;
				int value = poseChooser.showOpenDialog(window);
				if (value == JFileChooser.APPROVE_OPTION)
				{
					File file = poseChooser.getSelectedFile();
					FileInputStream stream = new FileInputStream(file);

					window.log("Opening: " + file.getName() + ".");

					poseParser.syntaxtree.Pose pose = Parser.parsePose(stream);

					MyPoseVisitor poseVisitor = new MyPoseVisitor();
					readPose = poseVisitor.getEvaluation(pose);

					stream.close();

					window.log("Adding Pose: " + readPose.getName() + " to Animation...");

					animation.addPose(readPose);

					treePanel.addPose(readPose, selectedNode);

					window.setLogColor(Color.GREEN);
					window.log("Pose correclty added.");
					window.log(model.getAnimation().print());

				}
				else
				{
					window.log("Open command cancelled by user.");
				}

			}
			catch(SemanticException ex)
			{
				window.setLogColor(Color.YELLOW);
				window.log(ex.getMessage());
			}
			catch(Exception ex)
			{
				window.setLogColor(Color.RED);
				window.log(ex.getMessage());
			}
		}
		if (e.getActionCommand().equals("remove"))
		{
			if(nodeInfo.getClass() == Animation.class)
			{
				Animation animation = (Animation) nodeInfo;
				Animation parent = animation.getParent();
				parent.removeAnimation(animation);
				treePanel.removeNode(selectedNode);

				window.setLogColor(Color.GREEN);
				window.log("Removed pose.");
				window.log(model.getAnimation().print());
			}

			if(nodeInfo.getClass() == Pose.class)
			{
				Pose pose = (Pose) nodeInfo;
				Animation parent = pose.getParentAnimation();
				if(parent.removePose(pose))
				{
					treePanel.removeNode(selectedNode);
					window.log("Removed pose.");
					window.log(model.getAnimation().print());
				}
				else
				{
					window.setLogColor(Color.RED);
					window.log("Animations needs to have at least one pose.");
				}
			}			
		}
	}
}
