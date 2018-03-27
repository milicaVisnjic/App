package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import hexagon.Hexagon;
import model.Circle;
import model.HexagonAdapter;
import model.Point;
import model.Shape;
import view.DijalogKrugModifikacija;

public class ModificationCircleListener implements ActionListener {
	
	private DijalogKrugModifikacija dkm ;
	private Shape selectedShape;
	
	public ModificationCircleListener(DijalogKrugModifikacija dkm, Shape shape) {
		super();
		this.dkm = dkm;
		this.selectedShape = shape;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			int x=Integer.parseInt(dkm.getx());
			int y=Integer.parseInt(dkm.gety());
			int poluprecnik=Integer.parseInt(dkm.getRadiusText());
			
			if (x <=0 || y<=0 || poluprecnik<=0)
			{
				JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
			}
			
			else{
				Shape newShape;
				if(selectedShape instanceof Circle) {
					newShape= new Circle(new Point (x,y), poluprecnik, dkm.getBtnContourColor().getBackground(), dkm.getBtnAreaColor().getBackground());
				}else {
					Hexagon hexagon= new Hexagon(x, y, poluprecnik);
					hexagon.setAreaColor( dkm.getBtnAreaColor().getBackground());
					hexagon.setBorderColor(dkm.getBtnContourColor().getBackground());
					newShape = new HexagonAdapter(hexagon);
				}
				dkm.setShape(newShape);
				dkm.setVisible(false);

			}
			
		} catch (Exception ee) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the number!");
		}
		
	}

}
