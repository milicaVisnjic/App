package geometrija;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Crtez extends JPanel{
	int x;
	int y;
	public Crtez() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}
	
	public static void main(String[] args){
		JFrame prozor = new JFrame("Crtanje");
		prozor.setSize(800, 600);
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		Tacka t1 = new Tacka(x,y);
		t1.crtajSe(g);
		repaint();
	
	}
}
