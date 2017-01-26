package aplikacija.wb;

import java.awt.BorderLayout;
import geometrija.Kvadrat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Arrays;

import geometrija.Kvadrat;


import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.awt.event.ActionEvent;

public class GuiSortiranje extends JFrame {

	private JPanel pnlGlavni;
	List lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiSortiranje frame = new GuiSortiranje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiSortiranje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		
		JPanel panel = new JPanel();
		pnlGlavni.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		List listNesortirana = new List();
		GridBagConstraints gbc_listNesortirana = new GridBagConstraints();
		gbc_listNesortirana.fill = GridBagConstraints.BOTH;
		gbc_listNesortirana.insets = new Insets(0, 0, 0, 5);
		gbc_listNesortirana.gridx = 0;
		gbc_listNesortirana.gridy = 1;
		panel.add(listNesortirana, gbc_listNesortirana);
		
		List listSortirana = new List();
		GridBagConstraints gbc_listSortirana = new GridBagConstraints();
		gbc_listSortirana.fill = GridBagConstraints.BOTH;
		gbc_listSortirana.gridx = 1;
		gbc_listSortirana.gridy = 1;
		panel.add(listSortirana, gbc_listSortirana);
		
		ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();
		
		JButton btnDodajUListu = new JButton("Dodaj u listu");
		btnDodajUListu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DijalogKvadrat dk = new DijalogKvadrat();
				dk.setVisible(true);
				Kvadrat k = dk.getPodaci();
				if (k != null)
				{
				listNesortirana.add(k.toString());
				}
				
				lista.add(dk.getPodaci());
				lista.sort(null);
				
				listSortirana.removeAll();
				
				for(Kvadrat k1 : lista){
					listSortirana.add(k1.toString());
				}
				
			}
		});
		
		
	
		
		GridBagConstraints gbc_btnDodajUListu = new GridBagConstraints();
		gbc_btnDodajUListu.gridwidth = 2;
		gbc_btnDodajUListu.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajUListu.gridx = 0;
		gbc_btnDodajUListu.gridy = 0;
		panel.add(btnDodajUListu, gbc_btnDodajUListu);
		
		
		
		
	}

}