package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.GuiCrtanje;
import view.State;

public class SelectedStateMouseAdapter extends MouseAdapter{
			
		private GuiCrtanje gui;
		private State choosenShape;
			
		public SelectedStateMouseAdapter(GuiCrtanje gui, State odabraniOblik ) {
			super();
			this.gui = gui;
			this.choosenShape = odabraniOblik;
		}
			
			
		@Override
		public void mouseClicked(MouseEvent arg0) {
				
			switch(choosenShape) {
				case POINT :  break;//gui.setState(choosenShape);//JOptionPane.showMessageDialog(null, "Click where you want to draw a point!"); break;
				case LINE :  break; //JOptionPane.showMessageDialog(null, "Click on the two spots between which you want the line to be drawn!"); break;
				case SQUARE :  break; //JOptionPane.showMessageDialog(null, "Click where you want to draw a square!"); break;
				case RECTANGLE :  break; //JOptionPane.showMessageDialog(null, "Click where you want to draw a rectangle!"); break;
				case CIRCLE :  break;//JOptionPane.showMessageDialog(null, "Click where you want to draw a circle!"); break;
				case HEXAGON :  break; //JOptionPane.showMessageDialog(null, "Click where you want to draw a hexagon!"); break;
				case SELECT : break;
				
			}
				
			gui.setState(choosenShape);
							
		}
}

