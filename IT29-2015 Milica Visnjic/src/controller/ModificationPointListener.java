package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Point;
import view.DijalogTackaModifikacija;

public class ModificationPointListener implements ActionListener {
	private DijalogTackaModifikacija dtm;

	
	public ModificationPointListener(DijalogTackaModifikacija dtm) {
		super();
		this.dtm = dtm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			int x=Integer.parseInt(dtm.getx());
			int y=Integer.parseInt(dtm.gety());
			
			
			
			if (x <= 0 || y<=0 )
			{
				JOptionPane.showMessageDialog(null, "Koordinate moraju da budu pozitivne");
				System.out.println("Pogresan unos, koordinate negativne");
			}
			
			else {
				Point point = new Point (x,y,dtm.getBtnBojaKonture().getBackground());
				dtm.setPoint(point);
				dtm.setVisible(false);
			}
		} catch (Exception e1) {
			
			System.out.println("greska pri unosu nije unet broj");
			JOptionPane.showMessageDialog(null, "Greska pri unosu nije unet broj");
			
			
		}
	
		
	}

}
