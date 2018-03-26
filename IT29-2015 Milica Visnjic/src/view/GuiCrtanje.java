package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import view.State;

import controller.DeleteActionListener;
import controller.DrawMouseListener;
import controller.LoadDrawingListener;
import controller.LoadLogListener;
import controller.LogListener;
import controller.RedoListener;
import controller.SaveDrawingListener;
import controller.SaveLogListener;
import controller.SelectColorMouseAdapter;
import controller.SelectedStateMouseAdapter;
import controller.UndoListener;
import controller.UpdateActionListener;
import model.ShapeRepository;
import net.miginfocom.swing.MigLayout;


public class GuiCrtanje extends JFrame implements Observer{
	
	private PanelZaCrtanje crtanje;
	private State state;
	private JButton btnObrisi;
	private JButton btnModifikacija;
	private JButton btnKontura;
	private JButton btnUnutrasnjost;
	private int klik = 1;
	private JPanel pnlGlavni;
	private JButton undoButton;
	private JButton redoButton;
	private JButton logButton;
	private JButton saveLogButton;
	private JButton loadLogButton;
	private JButton saveDrawingButton;
	private JButton loadDrawingButton;
	
	
	public int getKlik() {
		return klik;
	}
	public void setKlik(int klik) {
		this.klik = klik;
	}
	public JButton getBtnKontura() {
		return btnKontura;
	}
	public JButton getBtnUnutrasnjost() {
		return btnUnutrasnjost;
	}
	
	public JButton getBtnModifikacija() {
		return btnModifikacija;
	}
	public void setState(State state) {
		this.state = state;
	}
	

	public State getstate() {
		return state;
	}
	public PanelZaCrtanje getCrtanje() {
		return crtanje;
	}
	
	public JButton getBtnObrisi() {
		return btnObrisi;
	}

	/**
	 * Create the frame.
	 */
	public GuiCrtanje() {
		
		
		crtanje=new PanelZaCrtanje();
		ShapeRepository.getInstance().addObserver(crtanje);
		crtanje.setBackground(Color.white);
		
		setTitle("Natasa Bosnjak IT7/15");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 400);
		pnlGlavni = new JPanel();
		pnlGlavni.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlGlavni.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlGlavni);
		
		JPanel pnlKomande = new JPanel();
		pnlGlavni.add(pnlKomande, BorderLayout.NORTH);
		pnlKomande.setLayout(new MigLayout("", "[97px][5px][71px][17.00][62px][53px][19.00][95px]", "[14px][23px][23px][23px]"));
		pnlGlavni.add(crtanje, BorderLayout.CENTER);
		
		JLabel lblOblici = new JLabel("Oblici");
		pnlKomande.add(lblOblici, "cell 0 0 3 1,alignx center,aligny center");
		
		JButton btnTacka = new JButton("Point");
		btnTacka.addMouseListener(new SelectedStateMouseAdapter(this, State.POINT));
		
		JLabel lblBoje = new JLabel("Boje");
		pnlKomande.add(lblBoje, "cell 4 0,alignx center,growy");
		pnlKomande.add(btnTacka, "cell 0 1,grow");
		
		JButton btnLinija = new JButton("Line");
		btnLinija.addMouseListener(new SelectedStateMouseAdapter(this, State.LINE));
			
		pnlKomande.add(btnLinija, "cell 2 1,grow");
		
		JButton btnPravougaonik = new JButton("Rectangle");
		btnPravougaonik.addMouseListener(new SelectedStateMouseAdapter(this, State.RECTANGLE));
		
		JButton btnSestougao = new JButton("Hexagon");
		btnSestougao.addMouseListener(new SelectedStateMouseAdapter(this, State.HEXAGON));
	
		logButton = new JButton("Log");
		logButton.addActionListener(new LogListener());
		
		JSeparator separator = new JSeparator();
		pnlKomande.add(separator, "cell 3 0 1 4");
		
		JLabel lblBojaIvice = new JLabel("Kontura");
		pnlKomande.add(lblBojaIvice, "cell 4 1,alignx center,aligny center");
		
		btnKontura = new JButton("");
		btnKontura.addMouseListener(new SelectColorMouseAdapter());
		
		
		btnKontura.setBackground(Color.BLACK);
		btnKontura.setForeground(Color.BLACK);
		pnlKomande.add(btnKontura, "cell 5 1,grow");
		
		JButton btnSelektovanje = new JButton("Selektovanje");
		btnSelektovanje.addMouseListener(new SelectedStateMouseAdapter(this, State.SELECT));
	
		
		JSeparator separator_1 = new JSeparator();
		pnlKomande.add(separator_1, "cell 6 0 1 4");
		pnlKomande.add(btnSelektovanje, "cell 7 1,alignx right,aligny center");
		pnlKomande.add(btnPravougaonik, "cell 0 2,grow");
		pnlKomande.add(btnSestougao);
		
		
		JButton btnKvadrat = new JButton("Square");
		btnKvadrat.addMouseListener(new SelectedStateMouseAdapter(this, State.SQUARE));
		pnlKomande.add(btnKvadrat, "cell 2 2,grow");
		
		JLabel lblBojaUnutrasnjosti = new JLabel("Unutrasnjost");
		pnlKomande.add(lblBojaUnutrasnjosti, "cell 4 2,alignx center,aligny center");
		
		btnUnutrasnjost = new JButton("");
		btnUnutrasnjost.addMouseListener(new SelectColorMouseAdapter());
		
		
		btnUnutrasnjost.setBackground(Color.WHITE);
		pnlKomande.add(btnUnutrasnjost, "cell 5 2,grow");
		
		JButton btnKrug = new JButton("Circle");
		btnKrug.addMouseListener(new SelectedStateMouseAdapter(this, State.CIRCLE));
		
		btnModifikacija = new JButton("Modifikacija");
		btnModifikacija.setEnabled(false);
		
		undoButton = new  JButton("Undo");
		undoButton.setEnabled(false);
		undoButton.addActionListener(new UndoListener(this));
		
		redoButton = new  JButton("Redo");
		redoButton.setEnabled(false);
		redoButton.addActionListener(new RedoListener(this));
		
		pnlKomande.add(btnModifikacija, "cell 7 2,growx");
		pnlKomande.add(btnKrug, "cell 0 3,grow");
		
		btnObrisi = new JButton("Obrisi");
		btnObrisi.setEnabled(false);
		btnObrisi.addActionListener(new DeleteActionListener(this));
		
		btnModifikacija.addActionListener(new UpdateActionListener(this));
	
		pnlKomande.add(btnObrisi, "cell 7 3,growx");
		pnlKomande.add(undoButton);
		pnlKomande.add(redoButton);
		pnlKomande.add(logButton);
		
		saveLogButton = new JButton("Save log");
		saveLogButton.addActionListener(new SaveLogListener());
		saveDrawingButton = new JButton("Save drawing");
		saveDrawingButton.addActionListener(new SaveDrawingListener());
		loadLogButton = new JButton("Load log");
		loadLogButton.addActionListener(new LoadLogListener());
		loadDrawingButton = new JButton("Load drawing");
		loadDrawingButton.addActionListener(new LoadDrawingListener());
		
		JPanel noviPanel = new JPanel();
		noviPanel.add(saveDrawingButton);
		noviPanel.add(loadDrawingButton);
		noviPanel.add(saveLogButton);
		noviPanel.add(loadLogButton);
		
		pnlGlavni.add(noviPanel, BorderLayout.SOUTH);
	
		
		crtanje.addMouseListener(new DrawMouseListener(this));
		ShapeRepository.getInstance().addObserver(this);
		
	}
	public JButton getUndoButton() {
		return undoButton;
	}
	public JButton getRedoButton() {
		return redoButton;
	}
	@Override
	public void update(Observable o, Object arg) {
		if(arg == null) {
			return;
		}
		if((boolean)arg && ((ShapeRepository)o).getSelectedShapes().size() ==1 ) {
			btnModifikacija.setEnabled(true);
			btnObrisi.setEnabled(true);
		}else if((boolean)arg){
			btnObrisi.setEnabled(true);
			btnModifikacija.setEnabled(false);
		
		}else {
			btnModifikacija.setEnabled(false);
			btnObrisi.setEnabled(false);
		}
	}

	
}
