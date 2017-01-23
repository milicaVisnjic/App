package geometrija;

import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik {
//PovrsinskiOblik extends Oblik, znaci da povrsObl nasledjuje sve osobine Oblika
	private String bojaUnutrasnjosti="bela";
	
	public abstract void popuni(Graphics g);

	
	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	
	
}
