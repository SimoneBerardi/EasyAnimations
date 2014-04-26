package easyAnimations.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import parser.visitor.EasyAnimVisitor;

import easyAnimations.Animation;
import easyAnimations.Model;
import easyAnimations.Parser;
import exceptions.SemanticException;

public class MainWindowListener implements ActionListener
{
	//Model
	private Model model;
	
	//View
	private MainWindow window;
	
	//Variables
	private JFileChooser filechooser = new JFileChooser(".\\animations\\");
	private File file;
	private String animationGrammar = ".\\doc\\animationGrammar.html";
	private String poseGrammar = ".\\doc\\poseGrammar.html";
	
	public MainWindowListener(Model model, MainWindow window)
	{
		this.model = model;
		this.window = window;
	}
	
	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String action = e.getActionCommand();

		//New
		if(action.equals("new"))
		{
			newAnimation();
		}

		//Open
		if(action.equals("open"))
		{
			openAnimation();
		}

		//Save
		if(action.equals("save"))
		{
			saveAnimation();
		}

		//SaveAs
		if(action.equals("saveAs"))
		{
			saveAsAnimation();
		}

		//Close
		if(action.equals("close"))
		{
			closeAnimation();
		}

		//Exit
		if(action.equals("exit"))
		{
			int option;

			option = JOptionPane.showConfirmDialog(null, "Do you really want to exit?");
			if(option == 0)
			{
				System.exit(0);
			}
			else
			{
				return;
			}
		}

		//Evaluate
		if(action.equals("evaluate"))
		{
			evaluateAnimation();
		}	

		//Animation Grammar
		if(action.equals("animationGrammar"))
		{
			GrammarWindow grammar = new GrammarWindow(animationGrammar);
			grammar.setLocationRelativeTo(window);
			grammar.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
			grammar.setVisible(true);
		}
		
		//Pose Grammar
		if(action.equals("poseGrammar"))
		{
			GrammarWindow grammar = new GrammarWindow(poseGrammar);
			grammar.setLocationRelativeTo(window);
			grammar.setDefaultCloseOperation(window.DISPOSE_ON_CLOSE);
			grammar.setVisible(true);
		}

		//About
		if(action.equals("about"))
		{
			AboutDialog about = new AboutDialog();
			about.setLocationRelativeTo(window);
			about.setModal(true);
			about.setVisible(true);
		}
	}

	private void newAnimation()
	{
		window.log("Creating new animation...");

		AnimationPopup dialog = new AnimationPopup();
		dialog.setLocationRelativeTo(window);
		dialog.setVisible(true);
		Animation animation = dialog.getAnimation();

		if(animation == null)
		{
			window.log("Creation cancelled.");
			return;
		}

		window.log("Creating animation " + animation + "...");
		AnimationDialogListener listener = new AnimationDialogListener(animation);
		AnimationDialog animationDialog = new AnimationDialog(animation);
		animationDialog.addActionListener(listener);
		listener.setDialog(animationDialog);
		animationDialog.setLocationRelativeTo(window);
		animationDialog.setVisible(true);

		if(listener.getAnimation() == null)
		{
			window.log("Creation cancelled.");
			return;
		}

		model.setAnimation(listener.getAnimation());
		model.setNode(listener.getRootNode());

		window.log("Creation terminated.");
		window.clearAll();

		window.displayTree(model.getNode());
		window.disableEvaluateButtons();
		window.enableSaveButtons();
		window.setLogColor(Color.LIGHT_GRAY);

	}

	private void openAnimation()
	{
		window.log("Opening animation file...");
		int value = filechooser.showOpenDialog(window);
		if (value == JFileChooser.APPROVE_OPTION)
		{

			file = filechooser.getSelectedFile();
			loadFile();
			window.enableEvaluateButtons();
		}
		else
		{
			window.log("Open command cancelled.");
		}
	}

	private void loadFile()
	{
		try
		{
			window.log("Opening: " + file.getName() + ".");
			window.displayFile(file);
			window.log("File opened correctly.");
		}
		catch (Exception e)
		{
			window.log("Load cancelled.");
			window.log(e.getMessage());
		}
	}

	private void saveAnimation()
	{
		if(!model.hasAnimation())
		{
			window.log("Nothing to save!");
			return;
		}

		file = new File(".\\animations\\" + model.getAnimation().getName() + ".txt");	
		save();
		loadFile();
		window.setLogColor(Color.GREEN);
	}

	private void saveAsAnimation()
	{
		if(!model.hasAnimation())
		{
			window.log("Nothing to save!");
			return;
		}

		int value = filechooser.showSaveDialog(window);
		if (value == JFileChooser.APPROVE_OPTION)
		{

			file = filechooser.getSelectedFile();
			save();
			loadFile();
			window.setLogColor(Color.GREEN);
		}
		else
		{
			window.log("Save command cancelled.");
		}
	}

	private void save()
	{
		try
		{
			window.log("Saving file " + model.getAnimation().getName() + ".txt...");
			PrintWriter writer = new PrintWriter(file);
			model.getAnimation().save(writer, "");
			writer.close();
			window.log("File saved.");
			window.enableEvaluateButtons();
		}
		catch (Exception e)
		{
			window.log("Save cancelled.");
			window.log(e.getMessage());
		}
	}

	private void closeAnimation()
	{
		if(!model.hasAnimation())
		{
			window.log("No animation correctly loaded, clearing board...");
		}
		else
		{
			window.log("Closing Animation: " + model.getAnimation().getName() + ".");
			model.clear();
			file = null;
		}

		window.clearAll();
		window.setLogColor(Color.LIGHT_GRAY);
		window.disableAllButtons();
	}

	private void evaluateAnimation()
	{
		try
		{
			window.log("Evaluating animation...");
			FileInputStream stream = new FileInputStream(file);

			parser.syntaxtree.Animation animation = Parser.parseAnimation(stream);
			EasyAnimVisitor easy = new EasyAnimVisitor();

			model.setAnimation(easy.getEvaluation(animation));

			model.setNode(easy.getTreeRoot());

			stream.close();

			window.setLogColor(Color.GREEN);
			window.log("Load complete.");

			window.displayTree(model.getNode());
			window.enableSaveButtons();
			window.disableEvaluateButtons();
		}
		catch(SemanticException se)
		{
			window.setLogColor(Color.YELLOW);
			window.log("Load failed!");
			window.log(se.getMessage());
		}
		catch(Exception ex)
		{
			window.setLogColor(Color.RED);
			window.log("Load failed!");
			window.log("Syntax error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
}
