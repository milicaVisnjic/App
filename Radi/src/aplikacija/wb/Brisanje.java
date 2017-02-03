package aplikacija.wb;

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
import aplikacija.wb.GuiCrtanje;


public class Brisanje extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private int n=0;
	JButton btnDa;
	JButton btnNe;
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
		setBounds(100, 100, 385, 217);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][][][][][][]", "[][][]"));
		{
			JLabel lblPoruka = new JLabel("Da li ste sigurni da zelite da se obrise selekotavni oblik?");
			contentPanel.add(lblPoruka, "cell 1 0 7 1,alignx left");
		}
		{
			btnDa = new JButton("Da");
			btnDa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					n=1;
					setVisible(false);
					
				}
			});
			
			contentPanel.add(btnDa, "cell 4 2,alignx left,aligny top");
		}
		{
			 btnNe = new JButton("Ne");
			btnNe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					n=2;
					setVisible(false);
				}
			});
			contentPanel.add(btnNe, "cell 6 2");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

	public int getOpcije()
	{
		return n;
	}
	public JButton getBtnDa() {
		return btnDa;
	}

	public JButton getBtnNe() {
		return btnNe;
	}

	public void setBtnDa(JButton btnDa) {
		this.btnDa = btnDa;
	}

	public void setBtnNe(JButton btnNe) {
		this.btnNe = btnNe;
	}

}
