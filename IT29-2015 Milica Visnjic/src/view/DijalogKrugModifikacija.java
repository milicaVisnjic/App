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

	
	private final JPanel pnlModification = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private int x;
	private int y;
	private int radius;
	private JButton btnContourColor;
	private JButton btnAreaColor;
	private Shape shape;
	 

	/**
	 * Create the dialog.
	 */
	public DijalogKrugModifikacija(Shape selectedShape) {
		setModal(true);
		
		setBounds(100, 100, 450, 300);
		
		getContentPane().setLayout(new BorderLayout());
		pnlModification.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnlModification, BorderLayout.CENTER);
		
		{
			JLabel lblX = new JLabel("X coordinate:");
			pnlModification.add(lblX);
		}
		{
			txtX = new JTextField();
			pnlModification.add(txtX);
			txtX.setColumns(5);
			if(selectedShape instanceof Circle) {
				txtX.setText(""+ ((Circle)selectedShape).getCentar().getX());
			}else {
				txtX.setText(""+ ((HexagonAdapter)selectedShape).getX());
			}
		}
		{
			JLabel lblY = new JLabel("Y coordinate:");
			pnlModification.add(lblY);
		}
		{
			txtY = new JTextField();
			pnlModification.add(txtY);
			txtY.setColumns(5);
			if(selectedShape instanceof Circle) {
				txtY.setText("" + ((Circle)selectedShape).getCentar().getY());
			}else {
				txtY.setText("" + ((HexagonAdapter)selectedShape).getY());
			}
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			pnlModification.add(lblRadius);
		}
		{
			txtRadius = new JTextField();
			pnlModification.add(txtRadius);
			txtRadius.setColumns(5);
			if(selectedShape instanceof Circle) {
			
				txtRadius.setText("" + ((Circle)selectedShape).getR());
		
			}else {
				txtRadius.setText("" + ((HexagonAdapter)selectedShape).getR());
			}
		}
		{
			JLabel lblContourColor = new JLabel("Contour color:");
			pnlModification.add(lblContourColor);
		}
		{
			 btnContourColor = new JButton("");
			 btnContourColor.setBackground(((SurfaceShape)selectedShape).getColor());
			 btnContourColor.addMouseListener(new SelectColorMouseAdapter());
			
			pnlModification.add(btnContourColor);
		}
		{
			JLabel lblAreaColor = new JLabel("Area color:");
			pnlModification.add(lblAreaColor);
		}
		{
			 btnAreaColor = new JButton("");
			 btnAreaColor.setBackground(((SurfaceShape)selectedShape).getInsideColor());
			 btnAreaColor.addMouseListener(new SelectColorMouseAdapter());
			pnlModification.add(btnAreaColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
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

	public JButton getBtnContourColor() {
		return btnContourColor;
	}
	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}
	
	public String getx() {
		return txtX.getText();
	}
	public String gety() {
		return txtY.getText();
	}
	public String getRadiusText() {
		return txtRadius.getText();
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	
}
