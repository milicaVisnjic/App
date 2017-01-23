package geometrija;


import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{

	private int visina;
	
	public Pravougaonik()
	{
		
	}
	
	public Pravougaonik (Tacka goreLevo, int sirina, int visina)
	{
		super(goreLevo, sirina);
		this.visina=visina;
		
	}
	public Pravougaonik (Tacka goreLevo, int sirina, int visina, String boja)
	{
		this(goreLevo,sirina,visina);
		setBoja(boja);
	}
	
	// Tacka gore levo=(xGoreLevo,yGoreLevo), sirina=sirina, visina=visina
	
	public String toString ()
	{
		return "Tacka gore levo= " + goreLevo + "sirina=" + duzinaStranice + ", visina= " + visina;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Pravougaonik )
		{
			Pravougaonik pom = (Pravougaonik) obj;
			if(goreLevo.equals(pom.goreLevo) && duzinaStranice==pom.duzinaStranice && visina==pom.visina)
			{
				return true;
			}
			else
				return false;
		}
		
		else
			return false;
	}
	
	public Linija dijagonala()
	{
		return new Linija (goreLevo, new Tacka (goreLevo.getX()+duzinaStranice, goreLevo.getY()+visina));
	}
	
	
	public Tacka centar()
	{
		return dijagonala().sredinaLinije();
	}
	public int obim()
	{
		
		return 2*duzinaStranice+2*visina;
	}
	
	public int povrsina()
	{
		return duzinaStranice*visina;
	}
	
	public boolean sadrzi (int x, int y)
	{
		if(this.goreLevo.getX()<=x && x<=(this.goreLevo.getX()+duzinaStranice) &&
				
				this.goreLevo.getY()<=y && y<=(this.goreLevo.getY()+visina))
		{
			return true;
		}
		
		else
			return false;
	}
	
	public void selektovan(Graphics g)
	{
		new Linija(goreLevo, new Tacka (goreLevo.getX()+duzinaStranice, goreLevo.getY())).selektovan(g);
		new Linija(goreLevo, new Tacka(goreLevo.getX(), goreLevo.getY()+visina)).selektovan(g);
		new Linija (new Tacka (goreLevo.getX(), goreLevo.getY()+visina), dijagonala().getKrajnjaTacka()).selektovan(g);
		new Linija (new Tacka (goreLevo.getX()+duzinaStranice, goreLevo.getY()), dijagonala().getKrajnjaTacka()).selektovan(g);
	}
	
	public void crtajSe(Graphics g)
	{
		g.setColor(pronadjiBoju(getBoja()));
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, visina);
		if(isSelektovan())
			selektovan(g);
	}
	
	public void popuni(Graphics g)
	{
		g.setColor(pronadjiBoju(getBojaUnutrasnjosti()));
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, visina-1);
	}
	

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}
	
}

