package easyAnimations.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import easyAnimations.Animation;

public class AnimationPopup extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private JTextField durationField;
	private JButton okButton;
	private JButton cancelButton;
	
	private Animation animation;

	/**
	 * Create the dialog.
	 */
	public AnimationPopup() {
		setModal(true);
		setResizable(false);
		setTitle("New Animation");
		setBounds(100, 100, 233, 147);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setBounds(25, 14, 62, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			nameField = new JTextField();
			nameField.setBounds(117, 11, 86, 20);
			contentPanel.add(nameField);
			nameField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Duration");
			lblNewLabel_1.setBounds(25, 39, 62, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			durationField = new JTextField();
			durationField.setBounds(117, 36, 86, 20);
			contentPanel.add(durationField);
			durationField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public Animation getAnimation()
	{
		return animation;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == okButton)
		{
			if(!(nameField.getText().equals("")) && !(durationField.getText().equals("")))
			{
				try
				{
					animation = new Animation(nameField.getText(), Integer.parseInt(durationField.getText()));
					this.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(this, "Insert a valid name and duration value.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				}
					
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Insert a valid name and duration value.", "Error!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if(e.getSource() == cancelButton)
		{
			this.dispose();
		}
		
	}

}
