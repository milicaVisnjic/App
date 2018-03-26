package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.DijalogKvadrataCrtanje;

public class SquareConfirmationListener implements ActionListener {
	private DijalogKvadrataCrtanje dkc;
	
	public SquareConfirmationListener(DijalogKvadrataCrtanje dkc) {
		super();
		this.dkc = dkc;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int duzinaStranice=Integer.parseInt(dkc.getDuzinaText());
			if (duzinaStranice <= 0)
			{
				System.out.println("Duzina stranice mora biti pozitivna!!");
				JOptionPane.showMessageDialog(null, "Duzina stranice mora biti pozitivna");
			}
			else
			{
				dkc.setDuzinaStranice(duzinaStranice);
				dkc.setVisible(false);
				
			}
			
		} catch (Exception e1) {
			
			System.out.println("Nije unet broj");
			JOptionPane.showMessageDialog(null, "Mora broj da se unese");
			
			
		}
	}

}
