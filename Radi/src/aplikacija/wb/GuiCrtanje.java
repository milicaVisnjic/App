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
import java.util.Stack;

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
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;


public class GuiCrtanje extends JFrame {
	
	private int xTacka;
	private int yTacka;
	Tacka t1;
	Linija l1;
	Kvadrat kv1;
	Pravougaonik pr1;
	Krug kr1;
	private int xTacka1;
	private int yTacka1;
	Tacka vracenaTacka;
	
	private JButton btnOdabranoDugme;
	private Oblik oblik=null;
	JPanel pnlCrtez;
	Oblik selektovan = null;
	DijalogTackaModifikacija dt;
	 private Stack<Oblik>stek = new Stack<Oblik>();
	
	
	int klik = 1;

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
		setBounds(100, 100, 655, 400);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		
		JPanel pnlKomande = new JPanel();
		pnlGlavni.add(pnlKomande, BorderLayout.NORTH);
		
		
		pnlCrtez = new JPanel();
		pnlCrtez.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				osvezi();
			}
		});
		
		pnlCrtez.setBackground(Color.WHITE);
		
	
		
		
		pnlGlavni.add(pnlCrtez, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCrtez = new GridBagLayout();
		gbl_pnlCrtez.columnWidths = new int[]{0};
		gbl_pnlCrtez.rowHeights = new int[]{0};
		gbl_pnlCrtez.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_pnlCrtez.rowWeights = new double[]{Double.MIN_VALUE};
		pnlCrtez.setLayout(gbl_pnlCrtez);
		pnlKomande.setLayout(new MigLayout("", "[97px][5px][71px][17.00][62px][53px][19.00][95px]", "[14px][23px][23px][23px]"));
		
		
		JLabel lblOblici = new JLabel("Oblici");
		pnlKomande.add(lblOblici, "cell 0 0 3 1,alignx center,aligny center");
		
		JButton btnTacka = new JButton("Tacka");
		btnTacka.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta tacka");
				
		
				
				
				btnOdabranoDugme=btnTacka;
				
				
			}
		});
		
		JLabel lblBoje = new JLabel("Boje");
		pnlKomande.add(lblBoje, "cell 4 0,alignx center,growy");
		pnlKomande.add(btnTacka, "cell 0 1,grow");
		
		JButton btnLinija = new JButton("Linija");
		btnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Kliknite na dva mesta na ekranu, izmedju kojih zelite da se nacrta linija");
				btnOdabranoDugme=btnLinija;
			}
		});
		pnlKomande.add(btnLinija, "cell 2 1,grow");
		
		JButton btnPravougaonik = new JButton("Pravougaonik");
		btnPravougaonik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOdabranoDugme=btnPravougaonik;
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta pravougaonik");
				
				
			}
		});
		
		JSeparator separator = new JSeparator();
		pnlKomande.add(separator, "cell 3 0 1 4");
		
		JLabel lblBojaIvice = new JLabel("Kontura");
		pnlKomande.add(lblBojaIvice, "cell 4 1,alignx center,aligny center");
		
		JButton btnKontura = new JButton("");
		btnKontura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color izborBoje= jcc.showDialog(null, "izaberite boju za konturu", Color.black);
				btnKontura.setBackground(izborBoje);
			}
		});
		
		
		btnKontura.setBackground(Color.BLACK);
		btnKontura.setForeground(Color.BLACK);
		pnlKomande.add(btnKontura, "cell 5 1,grow");
		
		JButton btnSelektovanje = new JButton("Selektovanje");
		btnSelektovanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnOdabranoDugme=btnSelektovanje;
				
			}
		});
		//git
		
		JSeparator separator_1 = new JSeparator();
		pnlKomande.add(separator_1, "cell 6 0 1 4");
		pnlKomande.add(btnSelektovanje, "cell 7 1,alignx right,aligny center");
		pnlKomande.add(btnPravougaonik, "cell 0 2,grow");
		
		JButton btnKvadrat = new JButton("Kvadrat");
		btnKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnOdabranoDugme=btnKvadrat;
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta kvadrat");
			
				
			
				
				
			}
		});
		pnlKomande.add(btnKvadrat, "cell 2 2,grow");
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Unutrasnjost");
		pnlKomande.add(lblBojaUnutrasnjosti, "cell 4 2,alignx center,aligny center");
		
		JButton btnUnutrasnjost = new JButton("");
		btnUnutrasnjost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser jcc = new JColorChooser();
				Color izborBoje= jcc.showDialog(null, "izaberite boju za unutrasnjost", Color.black);
				btnUnutrasnjost.setBackground(izborBoje);
				
				
			}
		});
		
		
		btnUnutrasnjost.setBackground(Color.WHITE);
		pnlKomande.add(btnUnutrasnjost, "cell 5 2,grow");
		
		JButton btnKrug = new JButton("Krug");
		btnKrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnOdabranoDugme=btnKrug;
				Krug k = new Krug(new Tacka(100,100), 20);
				//k.crtajSe(pnlCrtez.getGraphics());
				JOptionPane.showMessageDialog(null, "Kliknite na mesto na kome zelite da se nacrta krug");
			}
		});
		
		JButton btnModifikacija = new JButton("Modifikacija");
		//btnModifikacija.setEnabled(false);
		
		pnlKomande.add(btnModifikacija, "cell 7 2,growx");
		pnlKomande.add(btnKrug, "cell 0 3,grow");
		

		
		
		pnlCrtez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//	System.out.println("uso u if");
				if (btnOdabranoDugme==btnTacka)
				{
					xTacka=e.getX();
					yTacka=e.getY();
					//DijalogTackaModifikacija dtm= new DijalogTackaModifikacija();
				
					xTacka1=xTacka;
					yTacka1=yTacka;
					
					t1 = new Tacka (xTacka, yTacka, btnKontura.getBackground());
					t1.crtajSe(pnlCrtez.getGraphics());
					stek.push(t1);
					System.out.println("nije proslo if");
					
					
					
				}
				else if (btnOdabranoDugme==btnLinija)
				{
					if(klik == 1){
						 xTacka=e.getX();
						 yTacka=e.getY();
						 klik++;
					}else{
						 int xTacka1=e.getX();
						 int yTacka1=e.getY();
						 
						 System.out.println(btnKontura.getBackground());
						 l1 = new Linija( new Tacka(xTacka,yTacka), new Tacka(xTacka1,yTacka1),btnKontura.getBackground());
						 l1.crtajSe(pnlCrtez.getGraphics());
						 stek.push(l1);
						 
						 klik = 1;
					}
				  
				  
				
				}
				
				else if (btnOdabranoDugme==btnKvadrat)
				{
					xTacka=e.getX();
					yTacka=e.getY();
					DijalogKvadrataCrtanje dk = new DijalogKvadrataCrtanje();
					dk.setVisible(true);
					kv1=new Kvadrat(new Tacka(xTacka, yTacka), dk.getDuzinaStranice(), btnKontura.getBackground(), btnUnutrasnjost.getBackground());
					
					kv1.crtajSe(pnlCrtez.getGraphics());
					stek.push(kv1);
				}
				else if (btnOdabranoDugme==btnPravougaonik)
				{
					
						xTacka=e.getX();
						yTacka=e.getY();
						DijalogPravougaonikCrtanje dijalogPravougaonik = new DijalogPravougaonikCrtanje();
						dijalogPravougaonik.setVisible(true);
						//pr1=dijalogPravougaonik.getPodaci();
						pr1= new Pravougaonik(new Tacka(xTacka, yTacka), dijalogPravougaonik.getDuzina(), dijalogPravougaonik.getSirina(), btnKontura.getBackground(), btnUnutrasnjost.getBackground());
						pr1.crtajSe(pnlCrtez.getGraphics());
						stek.push(pr1);
					
				}
				else if (btnOdabranoDugme==btnKrug)
				{
					xTacka=e.getX();
					yTacka=e.getY();
					DijalogKrugCrtanje dijalogKrug= new DijalogKrugCrtanje();
					dijalogKrug.setVisible(true);
					kr1= new Krug(new Tacka(xTacka, yTacka), dijalogKrug.getPoluprecnik(), btnKontura.getBackground(), btnUnutrasnjost.getBackground());
					System.out.println(dijalogKrug.getPoluprecnik());
					kr1.crtajSe(pnlCrtez.getGraphics());
					stek.push(kr1);		
					
				}
				else if (btnOdabranoDugme==btnSelektovanje)
				{
					selektovan = null;
					xTacka=e.getX();
					yTacka=e.getY();
					
					osvezi();
					//sto ovde ide od kraja steka 
					for(int i = stek.size() - 1; i >= 0  ; i--)
					{
						if(stek.elementAt(i).sadrzi(xTacka, yTacka)){
							stek.elementAt(i).selektovan(pnlCrtez.getGraphics());
							//stek.elementAt(i).crtajSe(pnlCrtez.getGraphics());
							selektovan = stek.elementAt(i);
							return;
						}
					}
					
				}
				System.out.println("Trenutno stanje na steku");
				// nije radio unapred, moralo je unazad!
				for(int i = stek.size() - 1; i >= 0  ; i--)
				{
					System.out.println(stek.elementAt(i));
				}
				
				
			}
		
			
		});
		
		//btnModifikacija.setEnabled(false);
		btnModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnModifikacija.setEnabled(false);
			
				if (selektovan instanceof Tacka)
				{
					btnModifikacija.setEnabled(true);
					
					
					 dt = new DijalogTackaModifikacija();
					// dt.setX((Tacka)selektovan.getX());
				     dt.setVisible(true);
					
					
					stek.removeElement(selektovan);
					t1=dt.getPodaci();
					osvezi();
					t1.crtajSe(pnlCrtez.getGraphics());
					stek.push(t1);
					selektovan=null;
					
					
				}
				else if (selektovan instanceof Linija)
				{
					btnModifikacija.setEnabled(true);
					DijalogLinija dl = new DijalogLinija();
					
					dl.setVisible(true);
					stek.removeElement(selektovan);
				
					l1=dl.getPodaci();
					
					osvezi();
					
					l1.crtajSe(pnlCrtez.getGraphics());
					stek.push(l1);
					
					selektovan=null;
					//osvezi();
					
					
				} else if (selektovan instanceof Kvadrat) {
					
					btnModifikacija.setEnabled(true);
					
					
					DijalogKvadratModifikacija dk = new DijalogKvadratModifikacija();
					
					
					dk.setVisible(true);
					
					
					stek.removeElement(selektovan);
					kv1=dk.getPodaci();
					osvezi();
					kv1.crtajSe(pnlCrtez.getGraphics());
					stek.push(kv1);
					selektovan=null;
					
				} else if (selektovan instanceof Pravougaonik) {
					btnModifikacija.setEnabled(true);
					DijalogPravougaonikModifikacija dp = new DijalogPravougaonikModifikacija();
					dp.setVisible(true);
					stek.removeElement(selektovan);
					pr1=dp.getPodaci();
					osvezi();
					pr1.crtajSe(pnlCrtez.getGraphics());
					stek.push(pr1);
					selektovan=null;
					
					
				} else if (selektovan instanceof Krug)
				{
					btnModifikacija.setEnabled(true);
					DijalogKrugModifikacija dk= new DijalogKrugModifikacija();
					dk.setVisible(true);
					
					stek.removeElement(selektovan);
					kr1=dk.getPodaci();
					osvezi();
					kr1.crtajSe(pnlCrtez.getGraphics());
					stek.push(kr1);
					selektovan=null;
					
				}
				
				
				
			}
		});
		
		
	}
	public void osvezi(){
		// prvo crtamo prvi element!!!
		// beli pravougaonik za osvezavanje
		Pravougaonik p = new Pravougaonik(new Tacka(0,0), pnlCrtez.getWidth(),  pnlCrtez.getHeight(), Color.WHITE);
		p.crtajSe(pnlCrtez.getGraphics());
		for(int i = 0; i < stek.size(); i++)
		{
			stek.elementAt(i).crtajSe(pnlCrtez.getGraphics());
			System.out.println("osvezavaam");
		}
		
	}

	

	
}
