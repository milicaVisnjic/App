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

			int visina=Integer.parseInt(dpc.getHeightText());
			int sirina=Integer.parseInt(dpc.getWidthText());
	

		if ( visina <= 0 || sirina <=0 )
				
		{
			JOptionPane.showMessageDialog(null, "Error! Numbers must be greater than 0!");
		}
		else
		{
			
			dpc.setHeightRectangle(visina);
			dpc.setWidthRectangle(sirina);
			dpc.setVisible(false);
		}
		
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error! You must enter the numbers!");
		}
	
	}

}
