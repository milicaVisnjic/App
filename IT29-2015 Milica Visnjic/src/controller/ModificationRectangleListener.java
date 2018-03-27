package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Point;
import model.Rectangle;
import view.DijalogPravougaonikModifikacija;

public class ModificationRectangleListener implements ActionListener {
	
	private DijalogPravougaonikModifikacija dpm;
	
	public ModificationRectangleListener(DijalogPravougaonikModifikacija dpm) {
		super();
		this.dpm = dpm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			
			int x=Integer.parseInt(dpm.getx());
			int y=Integer.parseInt(dpm.gety());
			int visina=Integer.parseInt(dpm.getHeightText());
			int sirina=Integer.parseInt(dpm.getWidthText());
			
			if (x<=0 || y<=0 || visina<=0 || sirina<=0)
			{
				JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
			}
			
			else {
				dpm.setVisible(false);
				Rectangle rectangle= new Rectangle(new Point(x,y), sirina, visina,dpm.getBtnConturColor().getBackground(), dpm.getBtnAreaColor().getBackground());
				dpm.setRectangle(rectangle);
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
		}
	}
		

}
