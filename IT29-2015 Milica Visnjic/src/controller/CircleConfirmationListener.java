package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.DijalogKrug_HexagonCrtanje;


public class CircleConfirmationListener   implements ActionListener{

	
private DijalogKrug_HexagonCrtanje dkc;
	
	public CircleConfirmationListener(DijalogKrug_HexagonCrtanje dkc) {
		super();
		this.dkc = dkc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			
			int poluprecnik=Integer.parseInt(dkc.getRadiusText());
			System.out.println(poluprecnik);
			if (poluprecnik <= 0)
			{
				JOptionPane.showMessageDialog(null, "Error! Radius must be greater than 0!");
			}
			else
			{
				dkc.setRadius(poluprecnik);
				dkc.setVisible(false);
			}
			
		} catch (Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Error! You must enter the number!");
		
		}
	}

}
