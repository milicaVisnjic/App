package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import controller.ModificationCircleListener;
import controller.SelectColorMouseAdapter;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.Circle;
import model.HexagonAdapter;
import model.Point;
import model.Shape;
import model.SurfaceShape;
public class DijalogKrugModifikacija extends JDialog {

	
	private final JPanel pnlKomande = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtPoluprecnik;
	private int x;
	private int y;
	private int poluprecnik;
	private JButton btnBojaKonture;
	private JButton btnBojaUnutrasnjosti;
	private Shape shape;
	 

	/**
	 * Create the dialog.
	 */
	public DijalogKrugModifikacija(Shape selectedShape) {
		setModal(true);
		
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		pnlKomande.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlKomande, BorderLayout.CENTER);
		pnlKomande.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][]"));
		{
			JLabel lblX = new JLabel("X koordinata centra:");
			pnlKomande.add(lblX, "cell 3 2,alignx left");
		}
		{
			txtX = new JTextField();
			pnlKomande.add(txtX, "cell 4 2,alignx center");
			txtX.setColumns(10);
			if(selectedShape instanceof Circle) {
				txtX.setText(""+ ((Circle)selectedShape).getCentar().getX());
			}else {
				txtX.setText(""+ ((HexagonAdapter)selectedShape).getX());
			}
		}
		{
			JLabel lblY = new JLabel("Y koordinata centra:");
			pnlKomande.add(lblY, "cell 3 3,alignx left");
		}
		{
			txtY = new JTextField();
			pnlKomande.add(txtY, "cell 4 3,alignx center");
			txtY.setColumns(10);
			if(selectedShape instanceof Circle) {
				txtY.setText("" + ((Circle)selectedShape).getCentar().getY());
			}else {
				txtY.setText("" + ((HexagonAdapter)selectedShape).getY());
			}
		}
		{
			JLabel lblPoluprecnik = new JLabel("Poluprecnik:");
			pnlKomande.add(lblPoluprecnik, "cell 3 4,alignx left");
		}
		{
			txtPoluprecnik = new JTextField();
			pnlKomande.add(txtPoluprecnik, "cell 4 4,alignx center");
			txtPoluprecnik.setColumns(10);
			if(selectedShape instanceof Circle) {
			
				txtPoluprecnik.setText("" + ((Circle)selectedShape).getR());
		
			}else {
				txtPoluprecnik.setText("" + ((HexagonAdapter)selectedShape).getR());
			}
		}
		{
			JLabel lblBojaKonture = new JLabel("Boja konture:");
			pnlKomande.add(lblBojaKonture, "cell 3 5");
		}
		{
			 btnBojaKonture = new JButton("");
			 btnBojaKonture.setBackground(((SurfaceShape)selectedShape).getColor());
			 btnBojaKonture.addMouseListener(new SelectColorMouseAdapter());
			//btnBojaKonture.setBackground(Color.BLACK);
			pnlKomande.add(btnBojaKonture, "cell 4 5,alignx center");
		}
		{
			JLabel lblBojaUnutrasnjosti = new JLabel("Boja unutrasnjosti:");
			pnlKomande.add(lblBojaUnutrasnjosti, "cell 3 6,alignx left");
		}
		{
			 btnBojaUnutrasnjosti = new JButton("");
			 btnBojaUnutrasnjosti.setBackground(((SurfaceShape)selectedShape).getInsideColor());
			 btnBojaUnutrasnjosti.addMouseListener(new SelectColorMouseAdapter());
			pnlKomande.add(btnBojaUnutrasnjosti, "cell 4 6,alignx center");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ModificationCircleListener(this, selectedShape));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	public Shape getPodaci()
	{
		return shape;
	}

	public JButton getBtnBojaKonture() {
		return btnBojaKonture;
	}
	public JButton getBtnBojaUnutrasnjosti() {
		return btnBojaUnutrasnjosti;
	}
	
	public String getx() {
		return txtX.getText();
	}
	public String gety() {
		return txtY.getText();
	}
	public String getPoluprecnikText() {
		return txtPoluprecnik.getText();
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	
}
