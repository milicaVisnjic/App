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
			int duzinaStranice=Integer.parseInt(dkc.getLengthText());
			if (duzinaStranice <= 0)
			{
				JOptionPane.showMessageDialog(null, "Error! Side length must be greater than 0!");
			}
			else
			{
				dkc.setSideLength(duzinaStranice);
				dkc.setVisible(false);
				
			}
			
		} catch (Exception e1) {
		
			JOptionPane.showMessageDialog(null, "Error! You must enter the number!");
				
		}
	}

}
