package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ModificationPointListener;
import controller.SelectColorMouseAdapter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import model.Point;
import model.Shape;


public class DijalogTackaModifikacija extends JDialog {

	private final JPanel pnlDugmici = new JPanel();
	private JTextField txtX;
	private JTextField txtY;


	private int x;
	private int y;
	Color bojaKonture;
	private Point tacka ;
	private JButton btnBojaKonture;
	
	public String getx() {
		return txtX.getText();
	}
	public String gety() {
		return txtY.getText();
	}
	/**
	 * Create the dialog.
	 */
	public DijalogTackaModifikacija(Shape selectedShape) {
		
		setModal(true);
		
	
		
		setBounds(100, 100, 379, 226);
		getContentPane().setLayout(new BorderLayout());
		pnlDugmici.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlDugmici, BorderLayout.CENTER);
		pnlDugmici.setLayout(new MigLayout("", "[][][][103px][86px]", "[][][20px][20px][]"));
		{
			JLabel lblX = new JLabel("Unesite x koordinatu:");
			pnlDugmici.add(lblX, "cell 3 2,alignx right,growy");
		}
		{
			txtX = new JTextField();
			pnlDugmici.add(txtX, "cell 4 2,alignx left,aligny center");
			txtX.setColumns(10);
			
			txtX.setText("" + ((Point) selectedShape).getX());
		
			
		
		}
		{
			JLabel lblY = new JLabel("Unesite y koordinatu:");
			pnlDugmici.add(lblY, "cell 3 3,alignx right,aligny center");
		}
		{
			txtY = new JTextField();
			pnlDugmici.add(txtY, "cell 4 3,alignx left,aligny center");
			txtY.setColumns(10);
			txtY.setText("" + ((Point) selectedShape).getY());
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			pnlDugmici.add(lblBojaKonture, "cell 3 4");
		}
		{
			btnBojaKonture = new JButton("");
			System.out.println(((Point) selectedShape).getColor());
			btnBojaKonture.setBackground(((Point) selectedShape).getColor());
			btnBojaKonture.addMouseListener(new SelectColorMouseAdapter());
			//btnContourColor.setBackground(Color.BLACK);
			pnlDugmici.add(btnBojaKonture, "cell 4 4,alignx center");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ModificationPointListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public void setPoint(Point p) {
		tacka = p;
	}
	
	public Point getPodaci()
	{
		return tacka;
	}

	public JButton getBtnBojaKonture() {
		return btnBojaKonture;
	}

	


}
