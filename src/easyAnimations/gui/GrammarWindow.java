package easyAnimations.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GrammarWindow extends JFrame {

	private JPanel contentPane;
	private String fileName;
	private JEditorPane pane;
	private String newLine = "\n";


	/**
	 * Create the frame.
	 */
	public GrammarWindow(String fileName)
	{
		setTitle("BNF Grammar");
		this.fileName = fileName;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		try
		{
			URL url = new File(fileName).toURI().toURL();
			pane = new JEditorPane(url);
			pane.setEditable(false);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		scrollPane.setViewportView(pane);
		
	}

}
