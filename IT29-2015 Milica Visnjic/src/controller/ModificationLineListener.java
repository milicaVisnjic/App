package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Line;
import model.Point;
import view.DijalogLinija;

public class ModificationLineListener implements ActionListener {
	private DijalogLinija dl;
	
	
	public ModificationLineListener(DijalogLinija dl) {
		super();
		this.dl = dl;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {

		try{
			int x1=Integer.parseInt(dl.getx1());
			int y1=Integer.parseInt(dl.gety1());
			int x2=Integer.parseInt(dl.getx2());
			int y2=Integer.parseInt(dl.gety2());
			
			if (x1<=0 || y1<=0 || x2<=0 || y2<=0)
			{
				System.out.println("Greska pri unosu, negativan broj");
				JOptionPane.showMessageDialog(null, "Greska, broj je negativan");
			}
			else
			{
				Line line=new Line (new Point (x1,y1), new Point (x2,y2), dl.getBtnBojaLinije().getBackground());
				dl.setLine(line);
				dl.setVisible(false);
			}
			
			
			
			
		} catch (Exception e1) {
			
			System.out.println("greska pri unosu, nije unet broj");
			JOptionPane.showMessageDialog(null, "Greska, nije unet broj!!");
		}
	}
		
}
