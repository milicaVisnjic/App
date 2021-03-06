package view;
 
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Brisanje extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private int n=0;
	JButton btnYes;
	JButton btnNo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Brisanje dialog = new Brisanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Brisanje() {
		setModal(true);
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	
		{
			JLabel lblMessage = new JLabel("Are you sure?");
			contentPanel.add(lblMessage);
		}
		{
			btnYes = new JButton("Yes");
			btnYes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					n=1;
					setVisible(false);
					
				}
			});
			
			contentPanel.add(btnYes);
		}
		{
			 btnNo = new JButton("No");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					n=2;
					setVisible(false);
				}
			});
			contentPanel.add(btnNo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	public int getOptions()
	{
		return n;
	}
	public JButton getBtnYes() {
		return btnYes;
	}

	public JButton getBtnNo() {
		return btnNo;
	}

	public void setBtnYes(JButton btnYes) {
		this.btnYes = btnYes;
	}

	public void setBtnNo(JButton btnNo) {
		this.btnNo = btnNo;
	}

}
