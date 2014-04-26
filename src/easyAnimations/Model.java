package easyAnimations;

import javax.swing.tree.DefaultMutableTreeNode;

public class Model
{
	private static Animation rootAnimation;
	private static DefaultMutableTreeNode rootNode;
	
	public Model()
	{
		
	}
	
	public void setAnimation(Animation animation)
	{
		if(animation != null)
			rootAnimation = animation;
	}
	
	public Animation getAnimation()
	{
		return rootAnimation;
	}
	
	public void setNode(DefaultMutableTreeNode node)
	{
		if(node != null && rootAnimation != null)
			rootNode = node;
	}
	
	public DefaultMutableTreeNode getNode()
	{
		return rootNode;
	}
	
	public boolean hasAnimation()
	{
		if(rootAnimation != null)
			return true;
		return false;
	}
	
	public void clear()
	{
		rootAnimation = null;
		rootNode = null;
	}
}
