package aplikacija.wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Linija;
import geometrija.Tacka;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;

public class Gui extends JFrame {

	protected static final JButton JButton = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOblici = new JLabel("Oblici");
		lblOblici.setHorizontalAlignment(SwingConstants.CENTER);
		lblOblici.setBounds(24, 11, 46, 14);
		contentPane.add(lblOblici);
		
		JButton btnTacka = new JButton("Tacka");
		btnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Kliknite na ekran gde zelite da se nacrta tacka");
			}
		});
		btnTacka.setBounds(0, 33, 89, 23);
		contentPane.add(btnTacka);
		
		
		JButton btnLinija = new JButton("Linija");
		btnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Kliknite na ekran 2 puta, gde zelit da vam se nacrta linija");
			}
		});
		btnLinija.setBounds(94, 33, 89, 23);
		contentPane.add(btnLinija);
		
		
		JPanel pnlCrtanje = new JPanel();
		pnlCrtanje.addMouseListener(new MouseAdapter() {
			int x=0,y=0;
			//int x1=0,y1=0;
			@Override
			public void mouseClicked(MouseEvent e) {
				//if(JButton==btnTacka)
				//{
					x=e.getX();
					y=e.getY();
					Tacka t1= new Tacka(x,y);
					t1.crtajSe(getGraphics());
				//}else if(JButton==btnLinija)
				//{
				//	x=e.getX();
					//y=e.getY();
					//x1=e.getX();
					//y1=e.getY();
					//Linija l1= new Linija(new Tacka(x,y), new Tacka(x1,y1));
					//l1.crtajSe(getGraphics());
					
			//	}
				
				
				
			}
		});
		pnlCrtanje.setBounds(0, 58, 434, 203);
		contentPane.add(pnlCrtanje);
		
		
	}
}
