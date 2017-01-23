package geometrija;

import java.awt.Color;

import java.awt.Graphics;

public abstract class Oblik{

	private String boja="crna";
	private boolean selektovan;
	
	//Ove abstraktne klase mi ovde bas i nisu jasne 
	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);
	
	public Oblik ()
	{
		
	}
	public static Color pronadjiBoju(String boja)
	{
		if(boja.equalsIgnoreCase("crna"))
			return Color.BLACK;
		else if(boja.equalsIgnoreCase("bela"))
			return Color.WHITE;
		else if(boja.equalsIgnoreCase("plava"))
			return Color.BLUE;
		else if(boja.equalsIgnoreCase("crvena"))
			return Color.RED;
		else if(boja.equalsIgnoreCase("zelena"))
			return Color.GREEN;
		else if(boja.equalsIgnoreCase("zuta"))
			return Color.YELLOW;
		else if(boja.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;
		
	}
	
	public Oblik(String boja)
	{
		this.boja=boja;
	}

	public String getBoja() {
		return boja;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}
	
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	
	
}