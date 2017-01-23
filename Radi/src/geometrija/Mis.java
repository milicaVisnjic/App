package geometrija;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;;

public class Mis extends Applet implements MouseListener,MouseMotionListener {

	int x=0;
	int y=0;
	String str="";
	
	public void init()
	{
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint (Graphics g)
	{
		g.drawString(str + "x:" + x +  "  y:" + y,100,100);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		str="mise je dra";
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		str="mis se pomera";
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		//showStatus("mis je usao");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	//	showStatus("mis je izasao");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//setBackground(Color.YELLOW);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//setBackground(Color.red);
	}

	
	
}
