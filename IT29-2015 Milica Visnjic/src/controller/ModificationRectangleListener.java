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
			int visina=Integer.parseInt(dpm.getVisinaText());
			int sirina=Integer.parseInt(dpm.getSirinaText());
			
			if (x<=0 || y<=0 || visina<=0 || sirina<=0)
			{
				System.out.println("Greska, broj mora biti pozitivan");
				JOptionPane.showMessageDialog(null, "Greska pri unosu, broj mora biti pozitivan!");
			}
			
			else {
				dpm.setVisible(false);
				Rectangle rectangle= new Rectangle(new Point(x,y), sirina, visina,dpm.getBtnBojaKonture().getBackground(), dpm.getBtnBojaUnutrasnjosti().getBackground());
				dpm.setRectangle(rectangle);
			}
			
		} catch (Exception e1) {
			
			System.out.println("greska pri unosu, nije unet broj");
			JOptionPane.showMessageDialog(null, "Greska, nije unet broj");
		}
	}
		

}
