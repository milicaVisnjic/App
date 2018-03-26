package aplikacija.wb;

import java.awt.EventQueue;

import view.GuiCrtanje;

public class AppMain {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCrtanje frame = new GuiCrtanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
