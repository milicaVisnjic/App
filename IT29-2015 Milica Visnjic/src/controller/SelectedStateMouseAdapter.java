package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.GuiCrtanje;
import view.State;

public class SelectedStateMouseAdapter extends MouseAdapter{
			
			private GuiCrtanje gui;
			private State odabraniOblik;
			
			public SelectedStateMouseAdapter(GuiCrtanje gui, State odabraniOblik ) {
				super();
				this.gui = gui;
				this.odabraniOblik = odabraniOblik;
			}
			
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				switch(odabraniOblik) {
					case POINT :  JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta tacka"); break;
					case LINE :  JOptionPane.showMessageDialog(null, "Kliknite na dva mesta na ekranu izmedju koji zelite da se nacrta linija"); break;
					case SQUARE :  JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta kvadrat"); break;
					case RECTANGLE :  JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta pravougaonik"); break;
					case CIRCLE :  JOptionPane.showMessageDialog(null, "Kliknite na mesto gde zelite da se nacrta krug"); break;
					case HEXAGON :  JOptionPane.showMessageDialog(null, "Kliknite na mesto gde zelite da se nacrta sestougao"); break;
					case SELECT : break;
				
				}
				
				gui.setState(odabraniOblik);
							
			}
}
