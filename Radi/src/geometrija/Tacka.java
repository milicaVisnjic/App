package geometrija;

import java.awt.Graphics;

public class Tacka extends Oblik {
	
	private int x;
	private int y;
	
	public Tacka()
	{
		
	}
	
	public Tacka(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public Tacka (int x, int y, String boja)
	{
		this(x,y);
		setBoja(boja);
	}
	
	public void pomeriNa(int novoX, int novoY)
	{
		x=novoX;
		y=novoY;
		
	}
	
	public void pomeriZa(int pomeriX, int pomeriY)
	{
		x=x+pomeriX;
		y=y+pomeriY;
		
	}
	public double udaljenost(Tacka t2)
	{
		double dx=x-t2.getX();
		double dy=y-t2.getY();
		double rezultat=Math.sqrt(dx*dx+dy*dy);
		return rezultat;
	}
	
	//Tacka (x,y)
	
	public String toString ()
	{
		return "Tacka (" + x + "," + y + ")";
	}
	public boolean equals(Object obj)
	{
		if (obj instanceof Tacka)
		{
			Tacka pom= (Tacka) obj;
			
			if (x==pom.x && y==pom.y)
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	
	public boolean sadrzi(int x, int y)
	{
		Tacka mestoKlika = new Tacka (x,y);
		if (mestoKlika.udaljenost(this)<=2)
			return true;
		else
			return false;
		
	}
	
	public void selektovan(Graphics g)
	{
		g.setColor(pronadjiBoju("plava"));
		g.drawRect(x-3, y-3, 6, 6);
	}
	
	public void crtajSe(Graphics g)
	{
		g.setColor(pronadjiBoju(getBoja())); //zasto ovde ne mogu da idem samo g.setColor(Color.BLUE);
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);
		 if (isSelektovan())//sta je ovo?
			 selektovan(g);
	}
	
	//I dalje ne razumem ovaj compareTo
	
	public int compareTo(Object o)
	{
		if (o instanceof Tacka)
		{
			Tacka pom= (Tacka) o;
			Tacka nula = new Tacka (0,0);
			return (int) (this.udaljenost(nula) - pom.udaljenost(nula));
		}
		else
			return 0;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}