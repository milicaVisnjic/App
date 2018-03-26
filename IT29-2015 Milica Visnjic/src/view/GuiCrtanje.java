package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
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
	
	private DrawingPanel crtanje;
	private State state;
	private JButton btnDelete;
	private JButton btnModification;
	private JButton btnContour;
	private JButton btnAreaColor;
	private int click = 1;
	private JPanel pnlMain;
	private JButton btnUndo;
	private JButton btnRredo;
	private JButton btnLog;
	private JButton saveLogButton;
	private JButton loadLogButton;
	private JButton saveDrawingButton;
	private JButton loadDrawingButton;
	
	
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public JButton getBtnKontura() {
		return btnContour;
	}
	public JButton getBtnUnutrasnjost() {
		return btnAreaColor;
	}
	
	public JButton getBtnModifikacija() {
		return btnModification;
	}
	public void setState(State state) {
		this.state = state;
	}
	

	public State getstate() {
		return state;
	}
	public DrawingPanel getCrtanje() {
		return crtanje;
	}
	
	public JButton getBtnObrisi() {
		return btnDelete;
	}

	/**
	 * Create the frame.
	 */
	public GuiCrtanje() {
		
		
		crtanje=new DrawingPanel();
		ShapeRepository.getInstance().addObserver(crtanje);
		crtanje.setBackground(Color.white);
		
		setTitle("Milica Visnjic IT29-2015");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		pnlMain = new JPanel();
		pnlMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlMain.setLayout(new BorderLayout(0, 0));
		setContentPane(pnlMain);
		
		
		pnlMain.add(crtanje, BorderLayout.CENTER);
		
	
		JButton btnPoint = new JButton("Point");
		btnPoint.addMouseListener(new SelectedStateMouseAdapter(this, State.POINT));
		
		
		JButton btnLine = new JButton("Line");
		btnLine.addMouseListener(new SelectedStateMouseAdapter(this, State.LINE));
			

		JButton btnRectangle = new JButton("Rectangle");
		btnRectangle.addMouseListener(new SelectedStateMouseAdapter(this, State.RECTANGLE));
		
		JButton btnHexagon = new JButton("Hexagon");
		btnHexagon.addMouseListener(new SelectedStateMouseAdapter(this, State.HEXAGON));
	
		btnLog = new JButton("Log");
		btnLog.addActionListener(new LogListener());
				
		JLabel lblContourColor = new JLabel("Contour");
		
		
		btnContour = new JButton("");
		btnContour.addMouseListener(new SelectColorMouseAdapter());
		
		
		btnContour.setBackground(Color.BLACK);
		btnContour.setForeground(Color.BLACK);

		
		JButton btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new SelectedStateMouseAdapter(this, State.SELECT));
		
		
		JButton btnSquare = new JButton("Square");
		btnSquare.addMouseListener(new SelectedStateMouseAdapter(this, State.SQUARE));
		
		
		JLabel lblAreaColor = new JLabel("Area color");
		
		btnAreaColor = new JButton("");
		btnAreaColor.addMouseListener(new SelectColorMouseAdapter());
		
		
		btnAreaColor.setBackground(Color.WHITE);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addMouseListener(new SelectedStateMouseAdapter(this, State.CIRCLE));
		
		btnModification = new JButton("Modification");
		btnModification.setEnabled(false);
		
		btnUndo = new  JButton("Undo");
		btnUndo.setEnabled(false);
		btnUndo.addActionListener(new UndoListener(this));
		
		btnRredo = new  JButton("Redo");
		btnRredo.setEnabled(false);
		btnRredo.addActionListener(new RedoListener(this));
		
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new DeleteActionListener(this));
		
		btnModification.addActionListener(new UpdateActionListener(this));
	
		
		saveLogButton = new JButton("Save log");
		saveLogButton.addActionListener(new SaveLogListener());
		saveDrawingButton = new JButton("Save drawing");
		saveDrawingButton.addActionListener(new SaveDrawingListener());
		loadLogButton = new JButton("Load log");
		loadLogButton.addActionListener(new LoadLogListener());
		loadDrawingButton = new JButton("Load drawing");
		loadDrawingButton.addActionListener(new LoadDrawingListener());
		
		
		JPanel pnlShapes = new JPanel();
		pnlShapes.add(btnPoint);
		pnlShapes.add(btnLine);
		pnlShapes.add(btnCircle);
		pnlShapes.add(btnSquare);
		pnlShapes.add(btnRectangle);
		pnlShapes.add(btnHexagon);
		pnlShapes.add(lblContourColor);
		pnlShapes.add(btnContour);
		pnlShapes.add(lblAreaColor);
		pnlShapes.add(btnAreaColor);
		
		pnlMain.add(pnlShapes, BorderLayout.NORTH);
		
		JPanel pnlActions = new JPanel();
		pnlActions.add(btnSelect);
		pnlActions.add(btnDelete);
		pnlActions.add(btnModification);
		pnlActions.add(btnUndo);
		pnlActions.add(btnRredo);
		pnlActions.add(btnLog);
		pnlActions.add(saveDrawingButton);
		pnlActions.add(loadDrawingButton);
		pnlActions.add(saveLogButton);
		pnlActions.add(loadLogButton);
		
		
		pnlMain.add(pnlActions, BorderLayout.SOUTH);
		
		/*
		JPanel newPanel = new JPanel();
		newPanel.add(saveDrawingButton);
		newPanel.add(loadDrawingButton);
		newPanel.add(saveLogButton);
		newPanel.add(loadLogButton);
		
		pnlMain.add(newPanel, BorderLayout.AFTER_LAST_LINE);
	*/
		
		crtanje.addMouseListener(new DrawMouseListener(this));
		ShapeRepository.getInstance().addObserver(this);
		
	}
	public JButton getUndoButton() {
		return btnUndo;
	}
	public JButton getRedoButton() {
		return btnRredo;
	}
	@Override
	public void update(Observable o, Object arg) {
		if(arg == null) {
			return;
		}
		if((boolean)arg && ((ShapeRepository)o).getSelectedShapes().size() ==1 ) {
			btnModification.setEnabled(true);
			btnDelete.setEnabled(true);
		}else if((boolean)arg){
			btnDelete.setEnabled(true);
			btnModification.setEnabled(false);
		
		}else {
			btnModification.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}

	
}
