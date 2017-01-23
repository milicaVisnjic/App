package geometrija;

import java.awt.Graphics;

public class Krug extends PovrsinskiOblik implements Pomerljiv{

	private Tacka centar;
	private int poluprecnik;
	public Krug()
	{
		
	}
	
	public Krug(Tacka centar, int poluprecnik)
	{
		this.centar=centar;
		this.poluprecnik=poluprecnik;
	}
	
	public Krug(Tacka centar, int poluprecnik, String boja)
	{
		this(centar, poluprecnik);
		setBoja(boja);
	}

	public void pomeriNa(int x, int y)
	{
		centar.pomeriNa(x, y);
	}
	
	public void pomeriZa(int x, int y)
	{
		centar.pomeriZa(x, y);
	}
	
	public double povrsina()
	{
		return poluprecnik*poluprecnik*Math.PI;
	}
	
	public double obim()
	{
		return 2*poluprecnik*Math.PI;
	}
	
	// Centar=centar, poluprecnik=r
	
	public String toString()
	{
		return "Centar= " + centar + ", poluprecnik= " + poluprecnik;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Krug)
		{
			Krug pom= (Krug) obj;
			if(centar.equals(pom.centar) && poluprecnik==pom.poluprecnik)
			{
				return true;
			}
			
			else
				return false;
		}
		
		return false;
	}
	
	public boolean sadrzi(int x, int y)
	{
		Tacka mestoKlika = new Tacka (x,y);
		if(mestoKlika.udaljenost(centar)<=poluprecnik)
		{
			return true;
		}
		else
			return false;
	}
	
	//nije mi jasno zasto selektocan oko kruga ne ide sa 4 linije, tj da se iscrta kvadrat oko kruga???
	public void selektovan(Graphics g)
	{
		new Linija(new Tacka (centar.getX(), centar.getY()-poluprecnik), new Tacka(centar.getX(), centar.getY()+poluprecnik)).selektovan(g);
		new Linija (new Tacka (centar.getX()-poluprecnik, centar.getY()), new Tacka (centar.getX()+poluprecnik, centar.getY())).selektovan(g);
	}
	
	public void crtajSe(Graphics g)
	{
		g.setColor(pronadjiBoju(getBoja()));
		g.drawOval(centar.getX()-poluprecnik, centar.getY()-poluprecnik, 2*poluprecnik , 2*poluprecnik);
		if(isSelektovan()==false)
			selektovan(g);
	}
	
	public void popuni(Graphics g)
	{
		g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.fillOval(centar.getX()-poluprecnik+1, centar.getY()-poluprecnik+1, 2*poluprecnik-2, 2*poluprecnik-2);
		
	}
	
	public int compareTo(Object o)
	{
		if (o instanceof Krug)
		{
			Krug pom=(Krug) o;
			return (int)(this.poluprecnik-pom.poluprecnik);
		}
		
		return 0;
		
	}
	public Tacka getCentar() {
		return centar;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setCentar(Tacka centar) {
		this.centar = centar;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}
	
}
