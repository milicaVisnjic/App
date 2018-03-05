package model;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

public class Drawing extends JPanel{
	//public Stack<Shape> stek = new Stack<Shape>();
	int x;
	int y;
	int i;
	public Drawing() {
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
		Drawing c = new Drawing();
		prozor.getContentPane().add(c);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g){
		/*Point t1 = new Point(x,y);
		t1.crtajSe(g);
		repaint();*/
		/*super.paint(g);
		for (Shape o : stek)
		{
			o.crtajSe(g);
		}*/
	
	}
}
