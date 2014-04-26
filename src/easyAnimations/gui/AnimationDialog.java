package easyAnimations.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import easyAnimations.Animation;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class AnimationDialog extends JDialog
{
	private JPanel contentPane;
	
	//Graphic elements
	private JButton addPoseButton;
	private JButton addAnimationButton;
	private JButton finishButton;
	private JButton cancelButton;
	private JTextArea log;
	private JCheckBox specifyFrame;
	private TreePanel treePanel;
	
	private String newLine = "\n";


	/**
	 * Create the frame.
	 */
	public AnimationDialog(Animation animation)
	{
		setModal(true);
		setResizable(false);
		setTitle("New Animation");
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);
		
		addPoseButton = new JButton("Add Pose");
		addPoseButton.setActionCommand("add pose");
		
		specifyFrame = new JCheckBox("Specify frame");
		buttonPanel.add(specifyFrame);
		buttonPanel.add(addPoseButton);
		
		addAnimationButton = new JButton("Add Animation");
		addAnimationButton.setActionCommand("add animation");
		buttonPanel.add(addAnimationButton);
		
		finishButton = new JButton("Finish");
		finishButton.setActionCommand("finish");
		buttonPanel.add(finishButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("cancel");
		buttonPanel.add(cancelButton);

		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{215, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane logPane = new JScrollPane();
		GridBagConstraints gbc_logPane = new GridBagConstraints();
		gbc_logPane.insets = new Insets(0, 0, 0, 5);
		gbc_logPane.fill = GridBagConstraints.BOTH;
		gbc_logPane.gridx = 0;
		gbc_logPane.gridy = 0;
		panel.add(logPane, gbc_logPane);
		
		log = new JTextArea();
		log.setEditable(false);
		logPane.setViewportView(log);
		
		treePanel = new TreePanel();
		GridBagConstraints gbc_treePane = new GridBagConstraints();
		gbc_treePane.fill = GridBagConstraints.BOTH;
		gbc_treePane.gridx = 1;
		gbc_treePane.gridy = 0;
		panel.add(treePanel, gbc_treePane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel);
		
		JLabel nameLabel = new JLabel(animation.getName());
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(nameLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Duration:");
		panel_1.add(lblNewLabel_2);
		
		JLabel durationLabel = new JLabel("" + animation.getDuration());
		panel_1.add(durationLabel);
		
		log.setBackground(Color.LIGHT_GRAY);
		displayTree(new DefaultMutableTreeNode(animation));
	}
	
	public void addActionListener(ActionListener listener)
	{
		addPoseButton.addActionListener(listener);
		addAnimationButton.addActionListener(listener);
		finishButton.addActionListener(listener);
		cancelButton.addActionListener(listener);
	}
	
	public void displayTree(DefaultMutableTreeNode root)
	{
		treePanel.setRoot(root);
	}
	
	public void log(String text)
	{
		log.append(text + newLine);
	}
	
	public void setLogColor(Color color)
	{
		log.setBackground(color);
	}
	
	public boolean specifyFrame()
	{
		return specifyFrame.isSelected();
	}
	
	public TreePanel getTreePanel()
	{
		return treePanel;
	}

}
