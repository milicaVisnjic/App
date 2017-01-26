package aplikacija.wb;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import geometrija.Tacka;
import geometrija.Linija;
import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Pravougaonik;
import geometrija.Oblik;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.*;


public class GuiCrtanje extends JFrame {
	
	private int xTacka;
	private int yTacka;
	Tacka t1;
	Linija l1;
	Kvadrat kv1;
	Pravougaonik pr1;
	Krug krug;
	private JButton btnOdabranoDugme;
	private Oblik oblik=null;
	

	private JPanel pnlGlavni;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GuiCrtanje() {
		setTitle("Natasa Bosnjak IT7/15");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		
		JPanel pnlKomande = new JPanel();
		pnlGlavni.add(pnlKomande, BorderLayout.NORTH);
		GridBagLayout gbl_pnlKomande = new GridBagLayout();
		gbl_pnlKomande.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlKomande.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlKomande.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlKomande.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlKomande.setLayout(gbl_pnlKomande);
		
		
		JPanel pnlCrtez = new JPanel();
		
	
		
		
		pnlGlavni.add(pnlCrtez, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCrtez = new GridBagLayout();
		gbl_pnlCrtez.columnWidths = new int[]{0};
		gbl_pnlCrtez.rowHeights = new int[]{0};
		gbl_pnlCrtez.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnlCrtez.rowWeights = new double[]{Double.MIN_VALUE};
		pnlCrtez.setLayout(gbl_pnlCrtez);
		
		
		JLabel lblOblici = new JLabel("Oblici");
		GridBagConstraints gbc_lblOblici = new GridBagConstraints();
		gbc_lblOblici.gridwidth = 2;
		gbc_lblOblici.insets = new Insets(0, 0, 5, 5);
		gbc_lblOblici.gridx = 2;
		gbc_lblOblici.gridy = 0;
		pnlKomande.add(lblOblici, gbc_lblOblici);
		
		JLabel lblBoje = new JLabel("Boje");
		GridBagConstraints gbc_lblBoje = new GridBagConstraints();
		gbc_lblBoje.fill = GridBagConstraints.BOTH;
		gbc_lblBoje.insets = new Insets(0, 0, 5, 5);
		gbc_lblBoje.gridx = 7;
		gbc_lblBoje.gridy = 0;
		pnlKomande.add(lblBoje, gbc_lblBoje);
		
		JButton btnTacka = new JButton("Tacka");
		btnTacka.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta tacka");
				
			/*	xTacka=e.getX();
				yTacka=e.getY();
				
				t1 = new Tacka (xTacka, yTacka);
				t1.crtajSe(pnlCrtez.getGraphics());*/
				
				
				btnOdabranoDugme=btnTacka;
				
				
			}
		});
		GridBagConstraints gbc_btnTacka = new GridBagConstraints();
		gbc_btnTacka.fill = GridBagConstraints.BOTH;
		gbc_btnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_btnTacka.gridx = 2;
		gbc_btnTacka.gridy = 2;
		pnlKomande.add(btnTacka, gbc_btnTacka);
		
		JButton btnLinija = new JButton("Linija");
		btnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Kliknite na dva mesta na ekranu, izmedju kojih zelite da se nacrta linija");
				btnOdabranoDugme=btnLinija;
			}
		});
		GridBagConstraints gbc_btnLinija = new GridBagConstraints();
		gbc_btnLinija.fill = GridBagConstraints.BOTH;
		gbc_btnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_btnLinija.gridx = 3;
		gbc_btnLinija.gridy = 2;
		pnlKomande.add(btnLinija, gbc_btnLinija);
		
		JLabel lblBojaIvice = new JLabel("Kontura");
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaIvice.gridx = 6;
		gbc_lblBojaIvice.gridy = 2;
		pnlKomande.add(lblBojaIvice, gbc_lblBojaIvice);
		
		JButton btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOdabranoDugme=btnPravougaonik;
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta pravougaonik");
				
				
			}
		});
		
		JButton btnKontura = new JButton("New button");
		btnKontura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color izborBoje= jcc.showDialog(null, "izaberite boju za konturu", Color.black);
				btnKontura.setBackground(izborBoje);
			}
		});
		
		JButton btnUnutrasnjost = new JButton("New button");
		btnUnutrasnjost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color izborBoje= jcc.showDialog(null, "izaberite boju za unutrasnjost", Color.black);
				btnUnutrasnjost.setBackground(izborBoje);
				
				
			}
		});
		
		
		btnKontura.setBackground(Color.BLACK);
		btnKontura.setForeground(Color.BLACK);
		GridBagConstraints gbc_btnKontura = new GridBagConstraints();
		gbc_btnKontura.insets = new Insets(0, 0, 5, 5);
		gbc_btnKontura.gridx = 8;
		gbc_btnKontura.gridy = 2;
		pnlKomande.add(btnKontura, gbc_btnKontura);
		GridBagConstraints gbc_btnPravougaonik = new GridBagConstraints();
		gbc_btnPravougaonik.fill = GridBagConstraints.BOTH;
		gbc_btnPravougaonik.insets = new Insets(0, 0, 5, 5);
		gbc_btnPravougaonik.gridx = 2;
		gbc_btnPravougaonik.gridy = 4;
		pnlKomande.add(btnPravougaonik, gbc_btnPravougaonik);
		
		JButton btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnOdabranoDugme=btnKvadrat;
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta kvadrat");
			
				
			
				
				
			}
		});
		GridBagConstraints gbc_btnKvadrat = new GridBagConstraints();
		gbc_btnKvadrat.fill = GridBagConstraints.BOTH;
		gbc_btnKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_btnKvadrat.gridx = 3;
		gbc_btnKvadrat.gridy = 4;
		pnlKomande.add(btnKvadrat, gbc_btnKvadrat);
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Unutrasnjost");
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 6;
		gbc_lblBojaUnutrasnjosti.gridy = 4;
		pnlKomande.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);
		
		JButton btnKrug = new JButton("Krug");
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnOdabranoDugme=btnKrug;
				JOptionPane.showMessageDialog(null, "Kliknite na mesto na kome zelite da se nacrta krug");
			}
		});
		
		
		btnUnutrasnjost.setBackground(Color.WHITE);
		GridBagConstraints gbc_btnUnutrasnjost = new GridBagConstraints();
		gbc_btnUnutrasnjost.insets = new Insets(0, 0, 5, 5);
		gbc_btnUnutrasnjost.gridx = 8;
		gbc_btnUnutrasnjost.gridy = 4;
		pnlKomande.add(btnUnutrasnjost, gbc_btnUnutrasnjost);
		GridBagConstraints gbc_btnKrug = new GridBagConstraints();
		gbc_btnKrug.fill = GridBagConstraints.BOTH;
		gbc_btnKrug.insets = new Insets(0, 0, 5, 5);
		gbc_btnKrug.gridx = 2;
		gbc_btnKrug.gridy = 5;
		pnlKomande.add(btnKrug, gbc_btnKrug);
		

		
		pnlCrtez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//	System.out.println("uso u if");
				if (btnOdabranoDugme==btnTacka)
				{
					xTacka=e.getX();
					yTacka=e.getY();
					
					t1 = new Tacka (xTacka, yTacka);
					t1.crtajSe(pnlCrtez.getGraphics());
					System.out.println("nije proslo if");
				}
				else if (btnOdabranoDugme==btnLinija)
				{
				   xTacka=e.getX();
				   yTacka=e.getY();
				   l1= new Linija( new Tacka(xTacka,yTacka), new Tacka(0,0));
				   l1.crtajSe(pnlCrtez.getGraphics());
				
				}
				
				else if (btnOdabranoDugme==btnKvadrat)
				{
					xTacka=e.getX();
					yTacka=e.getY();
					DijalogKvadrataCrtanje dk = new DijalogKvadrataCrtanje();
					dk.setVisible(true);
					kv1=new Kvadrat(new Tacka(xTacka, yTacka), dk.getDuzinaStranice());
					
					kv1.crtajSe(pnlCrtez.getGraphics());
				}
				else if (btnOdabranoDugme==btnPravougaonik)
				{
					
						xTacka=e.getX();
						yTacka=e.getY();
						DijalogPravougaonik dijalogPravougaonik = new DijalogPravougaonik();
						dijalogPravougaonik.setVisible(true);
						//pr1=dijalogPravougaonik.getPodaci();
						pr1= new Pravougaonik(new Tacka(xTacka, yTacka), dijalogPravougaonik.getDuzina(), dijalogPravougaonik.getSirina());
						pr1.crtajSe(pnlCrtez.getGraphics());
					
					
				}
				else if (btnOdabranoDugme==btnKrug)
				{
					xTacka=e.getX();
					yTacka=e.getY();
					DijalogKrug dijalogKrug= new DijalogKrug();
					dijalogKrug.setVisible(true);
					krug= new Krug(new Tacka(xTacka, yTacka), dijalogKrug.getPoluprecnik());
					krug.crtajSe(pnlCrtez.getGraphics());
				}
				
				
			}
		
			
		});
		
		
		
		
	}
	

}
