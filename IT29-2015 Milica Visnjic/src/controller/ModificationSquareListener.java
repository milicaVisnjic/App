package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Point;
import model.Square;
import view.DijalogKvadratModifikacija;

public class ModificationSquareListener implements ActionListener{
	private DijalogKvadratModifikacija dkm;
	
	
	public ModificationSquareListener(DijalogKvadratModifikacija dkm) {
		super();
		this.dkm = dkm;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			
			int x=Integer.parseInt(dkm.getx());
			int y=Integer.parseInt(dkm.gety());
			int duzinaStranice=Integer.parseInt(dkm.getDuzinaStranice());
			
			if (x<=0 || y<=0 || duzinaStranice<=0 )
			{
				System.out.println("greska pri unosu, negativni brojevi!!");
				JOptionPane.showMessageDialog(null, "Greska, brojevi moraju biti pozitivni!!");
			}
			else
			{
				dkm.setVisible(false);
				Square square= new Square(new Point(x,y), duzinaStranice, dkm.getBtnBojaKonture().getBackground(), dkm.getBtnBojaUnutrasnjosti().getBackground());
				dkm.setSquare(square);
			}
			
		} catch (Exception ee) {
			
			System.out.println("greska pri unosu, nije unet broj");
			JOptionPane.showMessageDialog(null, "Greska, nije unet broj");
		}
		
	}
	
}
