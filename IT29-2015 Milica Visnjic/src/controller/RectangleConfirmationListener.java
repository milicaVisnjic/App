package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.DijalogPravougaonikCrtanje;

public class RectangleConfirmationListener implements ActionListener {
	
	private DijalogPravougaonikCrtanje dpc;
	
	public RectangleConfirmationListener(DijalogPravougaonikCrtanje dpc) {
		super();
		this.dpc = dpc;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{

			int visina=Integer.parseInt(dpc.getVisinaText());
			int sirina=Integer.parseInt(dpc.getSirinaText());
	

		if ( visina <= 0 || sirina <=0 )
				
		{
			System.out.println("greska br mora biti pozitivan!!");
			JOptionPane.showMessageDialog(null, "Greska u unosu, broj mora biti pozitivan!!");
		}
		else
		{
			
			dpc.setVisina(visina);
			dpc.setSirina(sirina);
			dpc.setVisible(false);
		}
		
			
		} catch (Exception e1) {
			
			System.out.println("greska pri unosu nije unet broj");
			JOptionPane.showMessageDialog(null, "Greska pri unosu nije unet broj");
		}
	
	}

}
