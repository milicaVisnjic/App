
package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{

	private Tacka pocetnaTacka;
	private Tacka krajnjaTacka;
	
	public Linija ()
	{
		
	}
	
	public Linija  (Tacka pocetnaTacka, Tacka krajnjaTacka)
	{
		this.pocetnaTacka=pocetnaTacka;
		this.krajnjaTacka=krajnjaTacka;
		
	}
	
	public Linija(Tacka pocetnaTacka, Tacka krajnjaTacka, String boja)
	{
		this(pocetnaTacka,krajnjaTacka);
		setBoja(boja);
	}
	
	public void pomeriZa(int x , int y)
	{
		pocetnaTacka.setX(pocetnaTacka.getX()+x);
		pocetnaTacka.setY(pocetnaTacka.getY()+y);
		krajnjaTacka.setX(krajnjaTacka.getX()+x);
		krajnjaTacka.setY(krajnjaTacka.getY()+y);
	}
	
	public double duzina()
	{
		return pocetnaTacka.udaljenost(krajnjaTacka);
	}
	
	// (xPocetne,yPocetne)-->(xKrajnje,yKrajnje)
	
	public String toString()
	{
		return "Koordinate pocetne su:" + pocetnaTacka + "-->" +"Koordinate krajnje tacke su:" +  krajnjaTacka ;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Linija)
		{
			Linija pom= (Linija) obj;
			if (pocetnaTacka.equals(pom.pocetnaTacka) && krajnjaTacka.equals(pom.krajnjaTacka))
			{
				return true;
			}
			else
				return false;
			
		}
		else
			return false;
	}
	
	public Tacka sredinaLinije()
	{
		int sredinaX=(pocetnaTacka.getX()+krajnjaTacka.getX())/2;
		int sredinaY=(pocetnaTacka.getY()+krajnjaTacka.getY())/2;
		return new Tacka(sredinaX,sredinaY);
	}
	
	@Override
	public boolean sadrzi(int x, int y) {
		Tacka mestoKlika= new Tacka (x,y);
		if (mestoKlika.udaljenost(pocetnaTacka)+mestoKlika.udaljenost(krajnjaTacka)- this.duzina()<=0.5)
		{
			return true;
		}
		else
			
			return false;
	}
	
	@Override
	public void selektovan(Graphics g) {
	
		g.setColor(Color.BLUE);
		pocetnaTacka.selektovan(g);
		krajnjaTacka.selektovan(g);
		sredinaLinije().selektovan(g);
		
	}

	
	
	@Override
	public void crtajSe(Graphics g) {
	
	g.setColor(pronadjiBoju(getBoja()));
	g.drawLine(pocetnaTacka.getX(),pocetnaTacka.getY(), krajnjaTacka.getX(), krajnjaTacka.getY());
	
	//ne kapiram ovo, pa isSelektovan==false, onda selektuj g
	if(isSelektovan())
		selektovan(g);
		
	}

	public int compareTo(Object o)
	{
		if (o instanceof Linija)
		{
			Linija pom= (Linija) o;
			return (int) (this.duzina()-pom.duzina());
		}
		else
			return 0;
	}
	
	public Tacka getPocetnaTacka() {
		return pocetnaTacka;
	}

	public Tacka getKrajnjaTacka() {
		return krajnjaTacka;
	}

	public void setPocetnaTacka(Tacka pocetnaTacka) {
		this.pocetnaTacka = pocetnaTacka;
	}

	public void setKrajnjaTacka(Tacka krajnjaTacka) {
		this.krajnjaTacka = krajnjaTacka;
	}

	
	
}