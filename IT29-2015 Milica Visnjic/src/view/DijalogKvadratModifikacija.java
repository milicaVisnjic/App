package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ModificationSquareListener;
import controller.SelectColorMouseAdapter;
import model.Point;
import model.Shape;
import model.Square;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogKvadratModifikacija extends JDialog {

	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtDuzinaStranice;
	private int x;
	private int y;
	private int duzinaStranice;
	JButton btnBojaKonture;
	JButton btnBojaUnutrasnjosti;
	private Square k1=null;

	/**
	 * Create the dialog.
	 */
	public DijalogKvadratModifikacija(Shape selectedShape) {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		pnlKomande.setLayout(new MigLayout("", "[][][grow]", "[][][][][]"));
		{
			JLabel lblX = new JLabel("X koordinata tacke gore levo:");
			pnlKomande.add(lblX, "cell 1 0,alignx left");
		}
		{
			txtX = new JTextField();
			pnlKomande.add(txtX, "cell 2 0,alignx center");
			txtX.setColumns(10);
			txtX.setText("" + ((Square)selectedShape).getTopLeftPoint().getX());
		}
		{
			JLabel lblY = new JLabel("Y koordinata tacke gore levo:");
			pnlKomande.add(lblY, "cell 1 1,alignx left");
		}
		{
			txtY = new JTextField();
			pnlKomande.add(txtY, "cell 2 1,alignx center");
			txtY.setColumns(10);
			txtY.setText("" + ((Square)selectedShape).getTopLeftPoint().getY());
		}
		{
			JLabel lblDuzinaStranice = new JLabel("Duzina stranice:");
			pnlKomande.add(lblDuzinaStranice, "cell 1 2,alignx left");
		}
		{
			txtDuzinaStranice = new JTextField();
			pnlKomande.add(txtDuzinaStranice, "cell 2 2,alignx center");
			txtDuzinaStranice.setColumns(10);
			txtDuzinaStranice.setText(""+((Square)selectedShape).getSideLength());
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			pnlKomande.add(lblBojaKonture, "cell 1 3,alignx left");
		}
		{
			 btnBojaKonture = new JButton("");
			 btnBojaKonture.setBackground(((Square)selectedShape).getColor());
			 btnBojaKonture.addMouseListener(new SelectColorMouseAdapter());
			 pnlKomande.add(btnBojaKonture, "cell 2 3,alignx center");
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
			pnlKomande.add(lblBojaUnutrasnjosti, "cell 1 4,alignx left");
		}
		{
			 btnBojaUnutrasnjosti = new JButton("");
			 btnBojaUnutrasnjosti.setBackground(((Square)selectedShape).getInsideColor());
			 btnBojaUnutrasnjosti.addMouseListener(new SelectColorMouseAdapter());
			//btnBojaUnutrasnjosti.setBackground(Color.WHITE);
		//	btnBojaUnutrasnjosti.setForeground(Color.BLACK);
			pnlKomande.add(btnBojaUnutrasnjosti, "cell 2 4,alignx center");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ModificationSquareListener(this));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	
	public String getx() {
		return txtX.getText();
	}
	
	public String gety() {
		return txtY.getText();
	}
	
	public String getDuzinaStranice() {
		return txtDuzinaStranice.getText();
	}
	
	public void setSquare(Square square) {
		this.k1 = square;
	}
	
	public Square getPodaci()
	{
		return k1;
		
	}


	public JButton getBtnBojaKonture() {
	
		return btnBojaKonture;
	}


	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}

}
