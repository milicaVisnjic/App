package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;

public class SelectColorMouseAdapter extends MouseAdapter {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		JButton button = (JButton)arg0.getComponent();//u mouse eventu se nalazi opis dogadjaja, a nama je bitno na koje je dugme kliknuto
		Color izborBoje= JColorChooser.showDialog(null, "izaberite boju za konturu", Color.black);
		button.setBackground(izborBoje);
	
	}
}
