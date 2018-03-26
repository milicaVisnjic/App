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
			
			int poluprecnik=Integer.parseInt(dkc.getPoluprecnikText());
			System.out.println(poluprecnik);
			if (poluprecnik <= 0)
			{
				System.out.println("Poluprecnik je negativan, greska");
				JOptionPane.showMessageDialog(null, "Poluprecnik ne moze da bude negativan!");
			}
			else
			{
				dkc.setPoluprecnik(poluprecnik);
				dkc.setVisible(false);
			}
			
		} catch (Exception e1) {
			
			System.out.println("nije unet broj!!!");
			JOptionPane.showMessageDialog(null, "Greska u unosu, nije unet broj!");
		
		}
	}

}
