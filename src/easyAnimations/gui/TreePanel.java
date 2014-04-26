package easyAnimations.gui;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import easyAnimations.Animation;
import easyAnimations.Pose;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Hashtable;

public class TreePanel extends JPanel
{
	private DefaultMutableTreeNode root;
	private JTree tree;
	private JScrollPane treeScrollPane;
	private DefaultTreeModel model;
	
	private JPopupMenu rootPopup;
	private JPopupMenu popup;
	private JPopupMenu leafPopup;
    private JMenuItem menuItem;
	
	public TreePanel()
	{
		setLayout(new BorderLayout(0, 0));
		treeScrollPane = new JScrollPane();
		add(treeScrollPane);
	}
	
	public void clear()
	{
		root = null;
		treeScrollPane.setViewportView(null);
	}
	
	public JTree getTree()
	{
		return tree;
	}
	
	public DefaultMutableTreeNode getRoot()
	{
		return root;
	}
	
	public void setRoot(DefaultMutableTreeNode root, TreeSelectionListener listener)
	{
		setRoot(root);
		tree.addTreeSelectionListener(listener);
	}
	
	public void setRoot(DefaultMutableTreeNode root)
	{
		this.root = root;
		tree = new JTree(root);
		tree.getSelectionModel().setSelectionMode
        (TreeSelectionModel.SINGLE_TREE_SELECTION);
		treeScrollPane.setViewportView(tree);
		model = (DefaultTreeModel) tree.getModel();
	}
	
	public void addPopUp(ActionListener listener)
	{
		//Define the popup
        popup = new JPopupMenu();
       
        menuItem = new JMenuItem("Insert animation");
        menuItem.addActionListener(listener);
        menuItem.setActionCommand("insert animation");
        popup.add(menuItem);
        
        menuItem = new JMenuItem("Insert pose");
        menuItem.addActionListener(listener);
        menuItem.setActionCommand("insert pose");
        popup.add(menuItem);
        
        menuItem = new JMenuItem("Remove");
        menuItem.addActionListener(listener);
        menuItem.setActionCommand("remove");
        popup.add(menuItem);
        
        popup.setOpaque(true);
        popup.setLightWeightPopupEnabled(true);
        
        //Define the rootPopup
        rootPopup = new JPopupMenu();
        menuItem = new JMenuItem("Insert animation");
        menuItem.addActionListener(listener);
        menuItem.setActionCommand("insert animation");
        rootPopup.add(menuItem);
        
        menuItem = new JMenuItem("Insert pose");
        menuItem.addActionListener(listener);
        menuItem.setActionCommand("insert pose");
        rootPopup.add(menuItem);
        
        rootPopup.setOpaque(true);
        rootPopup.setLightWeightPopupEnabled(true);
        
        //Define the leafPopup
        leafPopup = new JPopupMenu();
        
        menuItem = new JMenuItem("Remove");
        menuItem.addActionListener(listener);
        menuItem.setActionCommand("remove");
        leafPopup.add(menuItem);
        
        leafPopup.setOpaque(true);
        leafPopup.setLightWeightPopupEnabled(true);
        
        
        
        tree.addMouseListener
        (
        		new MouseAdapter()
        		{
        			public void mouseReleased( MouseEvent e )
        			{
        				if ( e.isPopupTrigger())
        				{
        					int row = tree.getClosestRowForLocation(e.getX(), e.getY());  
        					tree.setSelectionRow(row);
        					if(getSelectedNode().isRoot())
        						rootPopup.show((JComponent)e.getSource(), e.getX(), e.getY() );
        					if(getSelectedNode().isLeaf())
        						leafPopup.show((JComponent)e.getSource(), e.getX(), e.getY() );
        					if(!getSelectedNode().isLeaf() && !getSelectedNode().isRoot())
        						popup.show( (JComponent)e.getSource(), e.getX(), e.getY() );
        					
        				}  
        			}

        		}
        );
	}
	
	public void addAnimation(Animation animation, DefaultMutableTreeNode parent)
	{
		DefaultMutableTreeNode animationNode = new DefaultMutableTreeNode(animation);
		insertAnimation(animationNode, parent);
		if(animation.hasSubAnimations())
			for(int i=0; i<animation.getSubAnimations().size(); i++)
				addAnimation(animation.getSubAnimations().get(i), animationNode);
		for(int i=0; i<animation.getPoses().size(); i++)
			addPose(animation.getPoses().get(i), animationNode);
	}
	
	private void insertAnimation(DefaultMutableTreeNode animation, DefaultMutableTreeNode parent)
	{
		if(tree != null)
		{
			int index = 0;
			if(parent.getLeafCount() > 0)
				for(int i=0; i<parent.getChildCount(); i++)
				{
					if(!parent.getChildAt(i).isLeaf())
						index++;
				}
			model.insertNodeInto(animation, parent, index);
		}
	}
	
	public void addPose(Pose pose, DefaultMutableTreeNode parent)
	{
		addPose(new DefaultMutableTreeNode(pose), parent);
	}
	
	private void addPose(DefaultMutableTreeNode pose, DefaultMutableTreeNode parent)
	{
		if(tree != null)
			model.insertNodeInto(pose, parent, parent.getChildCount());
	}
	
	private void addNode(DefaultMutableTreeNode node, DefaultMutableTreeNode parent, int index)
	{
		if(tree != null)
			model.insertNodeInto(node, parent, index);
	}
	
	public void removeNode(DefaultMutableTreeNode node)
	{
		if(tree != null)
			model.removeNodeFromParent(node);
	}
	
	public void modifyNode(DefaultMutableTreeNode newNode, DefaultMutableTreeNode oldNode)
	{
		removeNode(oldNode);
		addNode(newNode, (DefaultMutableTreeNode) oldNode.getParent(), oldNode.getParent().getIndex(oldNode));
	}
	
	public void addTreeSelectionListener(TreeSelectionListener listener)
	{
		tree.addTreeSelectionListener(listener);
	}

	public DefaultMutableTreeNode getSelectedNode()
	{
		return (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
	}
	
}
