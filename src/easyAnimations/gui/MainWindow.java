package easyAnimations.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import javax.swing.event.TreeSelectionListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import easyAnimations.Pose;
import javax.swing.JButton;

public class MainWindow extends JFrame
{

	private JPanel contentPane;
	
	//Menu Items
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	private JMenuItem closeItem;
	private JMenuItem exitItem;
	private JMenuItem evaluateItem;
	private JMenuItem animationGrammar;
	private JMenuItem poseGrammar;
	private JMenuItem aboutItem;
	
	//Buttons
	private JButton newButton;
	private JButton openButton;
	private JButton saveButton;
	private JButton closeButton;
	private JButton evaluateButton;
	
	//Graphics elements
	private JTextArea fileTextArea;
	private PosePanel posePanel;
	private JTextArea log;
	private TreePanel treePanel = new TreePanel();
	
	//Variables
	private TreeSelectionListener treeListener;
	private String newLine = "\n";
	
	
	public MainWindow()
	{
		
		setResizable(false);
		setTitle("EasyAnimations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		newItem = new JMenuItem("New");
		newItem.setActionCommand("new");
		mnFile.add(newItem);
		
		openItem = new JMenuItem("Open");	
		openItem.setActionCommand("open");
		mnFile.add(openItem);
		
		saveItem = new JMenuItem("Save");
		saveItem.setActionCommand("save");
		mnFile.add(saveItem);
		
		saveAsItem = new JMenuItem("Save As...");
		saveAsItem.setActionCommand("saveAs");
		mnFile.add(saveAsItem);
		
		closeItem = new JMenuItem("Close");
		closeItem.setActionCommand("close");
		mnFile.add(closeItem);
		
		exitItem = new JMenuItem("Exit");
		exitItem.setActionCommand("exit");
		mnFile.add(exitItem);
		
		JMenu mnAction = new JMenu("Action");
		menuBar.add(mnAction);
		
		evaluateItem = new JMenuItem("Evaluate");
		evaluateItem.setActionCommand("evaluate");
		mnAction.add(evaluateItem);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		animationGrammar = new JMenuItem("Animation Grammar");
		animationGrammar.setActionCommand("animationGrammar");
		mnHelp.add(animationGrammar);
		
		poseGrammar = new JMenuItem("Pose Grammar");
		poseGrammar.setActionCommand("poseGrammar");
		mnHelp.add(poseGrammar);
		
		aboutItem = new JMenuItem("About");
		aboutItem.setActionCommand("about");
		mnHelp.add(aboutItem);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
			
			
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{735, 187, 0};
		gbl_contentPane.rowHeights = new int[]{380, 50, 106, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JScrollPane filePane = new JScrollPane();
		filePane.setBounds(0, 0, 353, 359);
		panel.add(filePane);
		
		fileTextArea = new JTextArea();
		fileTextArea.setEditable(false);
		filePane.setViewportView(fileTextArea);
		
		posePanel = new PosePanel();
		posePanel.setBounds(363, 0, 367, 359);
		panel.add(posePanel);
			
		treePanel = new TreePanel();
		GridBagConstraints gbc_treeScrollPane = new GridBagConstraints();
		gbc_treeScrollPane.gridheight = 3;
		gbc_treeScrollPane.fill = GridBagConstraints.BOTH;
		gbc_treeScrollPane.gridx = 1;
		gbc_treeScrollPane.gridy = 0;
		contentPane.add(treePanel, gbc_treeScrollPane);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(null);
		GridBagConstraints gbc_buttonsPanel = new GridBagConstraints();
		gbc_buttonsPanel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonsPanel.fill = GridBagConstraints.BOTH;
		gbc_buttonsPanel.gridx = 0;
		gbc_buttonsPanel.gridy = 1;
		contentPane.add(buttonsPanel, gbc_buttonsPanel);
		
		newButton = new JButton("New");
		newButton.setBounds(39, 8, 103, 31);
		newButton.setActionCommand("new");
		buttonsPanel.add(newButton);
		
		openButton = new JButton("Open");
		openButton.setBounds(186, 8, 103, 31);
		openButton.setActionCommand("open");
		buttonsPanel.add(openButton);
		
		saveButton = new JButton("Save");
		saveButton.setBounds(330, 8, 103, 31);
		saveButton.setActionCommand("save");
		buttonsPanel.add(saveButton);
		
		evaluateButton = new JButton("Evaluate");
		evaluateButton.setBounds(477, 8, 103, 31);
		evaluateButton.setActionCommand("evaluate");
		buttonsPanel.add(evaluateButton);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(621, 8, 103, 31);
		closeButton.setActionCommand("close");
		buttonsPanel.add(closeButton);
		
		JScrollPane logScrollPane = new JScrollPane();
		GridBagConstraints gbc_logScrollPane = new GridBagConstraints();
		gbc_logScrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_logScrollPane.fill = GridBagConstraints.BOTH;
		gbc_logScrollPane.gridx = 0;
		gbc_logScrollPane.gridy = 2;
		contentPane.add(logScrollPane, gbc_logScrollPane);
		
		log = new JTextArea();
		log.setForeground(Color.BLACK);
		log.setBackground(Color.LIGHT_GRAY);
		logScrollPane.setViewportView(log);
		
		disableAllButtons();
	}
	
	public void addActionListener(ActionListener listener)
	{
		newItem.addActionListener(listener);
		openItem.addActionListener(listener);
		saveItem.addActionListener(listener);
		saveAsItem.addActionListener(listener);
		closeItem.addActionListener(listener);
		exitItem.addActionListener(listener);
		evaluateItem.addActionListener(listener);
		animationGrammar.addActionListener(listener);
		poseGrammar.addActionListener(listener);
		aboutItem.addActionListener(listener);
		newButton.addActionListener(listener);
		openButton.addActionListener(listener);
		saveButton.addActionListener(listener);
		evaluateButton.addActionListener(listener);
		closeButton.addActionListener(listener);
	}
	
	public void addTreeSelectionListener(TreeSelectionListener treeListener)
	{
		this.treeListener = treeListener;
	}
	
	public TreePanel getTreePanel()
	{
		return treePanel;
	}
	
	public void log(String text)
	{
		log.append(text + newLine);
	}
	
	public void setLogColor(Color color)
	{
		log.setBackground(color);
	}
	
	public void displayFile(File file) throws IOException
	{
		FileReader reader = new FileReader(file);
		BufferedReader br = new BufferedReader(reader);

		clearAll();
		
		String currentLine;
		
		while((currentLine = br.readLine()) != null)
		{
			fileTextArea.append(currentLine + newLine);
		}

		br.close();
		reader.close();
	}
	
	public void displayPose(Pose pose)
	{
		posePanel.setPose(pose);
	}
	
	public void displayTree(DefaultMutableTreeNode rootNode)
	{
		log.append("Loading animation tree..." + newLine);
		treePanel.setRoot(rootNode, treeListener);
		
		//Adding the popup to the treePanel
		treePanel.addPopUp((ActionListener)treeListener);
		
		log.append("Load complete." + newLine);
	}
	
	public void clearAll()
	{
		fileTextArea.setText("");
		treePanel.clear();
		posePanel.setPose(null);
	}
	
	public void enableEvaluateButtons()
	{
		evaluateItem.setEnabled(true);
		evaluateButton.setEnabled(true);
		closeItem.setEnabled(true);
		closeButton.setEnabled(true);
	}
	
	public void enableSaveButtons()
	{
		saveItem.setEnabled(true);
		saveButton.setEnabled(true);
		saveAsItem.setEnabled(true);
	}
	
	public void disableEvaluateButtons()
	{
		evaluateItem.setEnabled(false);
		evaluateButton.setEnabled(false);
	}
	
	public void disableAllButtons()
	{
		saveItem.setEnabled(false);
		saveButton.setEnabled(false);
		saveAsItem.setEnabled(false);
		evaluateItem.setEnabled(false);
		evaluateButton.setEnabled(false);
		closeItem.setEnabled(false);
		closeButton.setEnabled(false);
	}

}
