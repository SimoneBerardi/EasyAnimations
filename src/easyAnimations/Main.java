package easyAnimations;

import java.awt.EventQueue;
import easyAnimations.gui.*;

public class Main
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Model model = new Model();
					MainWindow window = new MainWindow();
					MainWindowListener listener = new MainWindowListener(model, window);
					TreeListener treeListener = new TreeListener(model, window);
					
					window.addActionListener(listener);
					window.addTreeSelectionListener(treeListener);
					window.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}
