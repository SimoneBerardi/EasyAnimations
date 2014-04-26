package easyAnimations.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class AboutDialog extends JDialog implements ActionListener
{

	private final JPanel contentPanel = new JPanel();
	private JButton okButton;

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setResizable(false);
		setTitle("About");
		setBounds(100, 100, 320, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new ImagePanel();
		panel.setBounds(10, 21, 83, 91);
		contentPanel.add(panel);
		
		JLabel lblNewLabel = new JLabel("EasyAnimations 2.0");
		lblNewLabel.setBounds(103, 31, 157, 26);
		contentPanel.add(lblNewLabel);
		
		JLabel lblAuthorSimoneBerardi = new JLabel("Author: Simone Berardi");
		lblAuthorSimoneBerardi.setBounds(103, 58, 157, 26);
		contentPanel.add(lblAuthorSimoneBerardi);
		
		JLabel lblSimoneberardistudiouniboit = new JLabel("simone.berardi2@studio.unibo.it");
		lblSimoneberardistudiouniboit.setBounds(103, 86, 211, 26);
		contentPanel.add(lblSimoneberardistudiouniboit);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
	
	public class ImagePanel extends JPanel{

	    private BufferedImage image;
	    private BufferedImage after;

		public ImagePanel() {
	       try
	       {                
	          image = ImageIO.read(new File(".\\images\\ninja.jpg"));
	          int w = image.getWidth();
	          int h = image.getHeight();
	          after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	          AffineTransform at = new AffineTransform();
	          at.scale(0.2,0.2);
	          AffineTransformOp scaleOp = 
	             new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
	          after = scaleOp.filter(image, after);
	       }
	       catch (IOException e)
	       {
	            e.printStackTrace();
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(after, 0, 0, null);            
	    }

	}

}