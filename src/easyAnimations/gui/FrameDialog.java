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

public class FrameDialog extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField frameField;
	private Animation animation;
	private int duration;
	private int frame;
	private boolean approved = false;
	
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public FrameDialog(Animation animation)
	{
		this.animation = animation;
		duration = animation.getDuration();
		setModal(true);
		setTitle("Frame selection");
		setBounds(100, 100, 320, 170);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Select Frame");
			lblNewLabel.setBounds(18, 21, 141, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			frameField = new JTextField();
			frameField.setBounds(169, 21, 110, 20);
			contentPanel.add(frameField);
			frameField.setColumns(10);
		}
		
		JLabel durationLabel = new JLabel("Animation duration: " + duration);
		durationLabel.setBounds(18, 52, 191, 20);
		contentPanel.add(durationLabel);
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
	
	public int getFrame()
	{
		return frame;
	}
	
	public boolean isApproved()
	{
		return approved;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == okButton)
		{
			int tempFrame = Integer.parseInt(frameField.getText());
			if(!checkFrame(tempFrame))
			{
				JOptionPane.showMessageDialog(this, "Frame out of bounds.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			
			if(!animation.checkFrame(tempFrame))
			{
				JOptionPane.showMessageDialog(this, "Frame already in use.", "Error!", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
		
			frame = Integer.parseInt(frameField.getText());
			approved = true;
			this.dispose();
		}
		
		if(e.getSource() == cancelButton)
		{
			this.dispose();
		}
	}

	private boolean checkFrame(int frame)
	{
		if(frame < 0 || frame > (duration-1))
			return false;
		return true;
	}
}
