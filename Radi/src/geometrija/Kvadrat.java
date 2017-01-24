package geometrija;

import java.awt.Graphics;


public class Kvadrat extends PovrsinskiOblik implements Pomerljiv {

	protected Tacka goreLevo;
	protected int duzinaStranice;
	
	public Kvadrat ()
	{
		
	}
	
	public Kvadrat (Tacka goreLevo, int duzinaStranice)
	{
		this.goreLevo=goreLevo;
		this.duzinaStranice=duzinaStranice;
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice, String boja)
	{
		this(goreLevo,duzinaStranice);
		setBoja(boja);
	}
	
	
	public void pomeriNa(int x, int y) {
		
		goreLevo.setX(x);
		goreLevo.setY(y);
		
	}

	
	public void pomeriZa(int x, int y) {
		
		goreLevo.setX(goreLevo.getX()+x);
		goreLevo.setY(goreLevo.getY()+y);
		
	}
	

	public int obim()
	{
		return 4*duzinaStranice;
	}

	public int povrsina()
	{
		return duzinaStranice*duzinaStranice;
	}
	//Tacka gore levo=(xGoreLevo,yGoreLevo), duzina stranice=duzinaStranice
	
	public String toString ()
	{
		return "Tacka gore levo= " + goreLevo + ", duzina stranice je = "  + duzinaStranice;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Kvadrat pomocni=(Kvadrat) obj;
			if(this.goreLevo.equals(pomocni.goreLevo) && this.duzinaStranice==pomocni.duzinaStranice)
				return true;
			else
				return false;
		}
		else 
			return false;
	}
	
	
	public Linija dijagonala()
		{
		 return new Linija (goreLevo, new Tacka (goreLevo.getX()+duzinaStranice, goreLevo.getY()+duzinaStranice));
		}
		
		public Tacka centar ()
		{
			return dijagonala().sredinaLinije();
		}
	
		
	public boolean sadrzi(int x, int y) {
			
			if(this.goreLevo.getX()<=x && x<=(this.goreLevo.getX()+duzinaStranice) && this.goreLevo.getY()<=y && y<=(this.goreLevo.getY()+duzinaStranice))
				
				return true;
			
			else 
		     	return false;
		}
		
		
	public void selektovan(Graphics g) {
			
			g.setColor(pronadjiBoju("Plava"));
		    new Linija(getGoreLevo(), new Tacka (getGoreLevo().getX()+duzinaStranice, goreLevo.getY())).selektovan(g);
		    new Linija (getGoreLevo(), new Tacka (getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		    new Linija(new Tacka (getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()),dijagonala().getKrajnjaTacka()).selektovan(g);
		    new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().getKrajnjaTacka()).selektovan(g);
		   
			
		}
		
	
	public void crtajSe(Graphics g) {
	
			g.setColor(pronadjiBoju(getBoja()));
			g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
			if(isSelektovan()==false)
				selektovan(g);
		
		}

		
		
	public void popuni(Graphics g) {
			g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
			g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);	
			
		}
	
	public int compareTo(Object o)
	{
		if (o instanceof Kvadrat)
		{
			//komentar
			Kvadrat pom = (Kvadrat) o;
			return (int)(this.povrsina()-pom.povrsina());
		}
		
		else
			return 0;
	}

	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}


}