package com.interfaz;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.logica.JuegoLogica;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;


public class Juego extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTable table;
	private Integer [][] matriz = new Integer[4][4];
	private JuegoLogica juegoLogica;
	private JLabel puntajeNumero;
	private JLabel labelIzq;
	private JLabel labelDer;
	private JLabel labelArriba;
	private JLabel labelAbajo;
	private JLabel lblGanaste;
	private JLabel lblPerdiste;
	private JCheckBox checkAyuda;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Juego frame = new Juego();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public String getPuntaje(){
		return puntajeNumero.getText();
	}

	/**
	 * Create the frame.
	 */
	
	public void inicializarFlechas() {
		labelIzq = new JLabel();
		labelIzq.setIcon(new ImageIcon("izquierda.png"));
		labelIzq.setBounds(60, 178, 26, 16);
		labelIzq.setVisible(false);
		contentPane.add(labelIzq);
		
		labelDer = new JLabel();
		labelDer.setIcon(new ImageIcon("derecha.png"));
		labelDer.setBounds(330,176, 35, 16);
		labelDer.setVisible(false);
		contentPane.add(labelDer);
		
		labelArriba = new JLabel("^");
		labelArriba.setIcon(new ImageIcon("arriba.png"));
		labelArriba.setBounds(195,40,20,22);
		labelArriba.setVisible(false);
		contentPane.add(labelArriba);
		
		labelAbajo = new JLabel();
		labelAbajo.setIcon(new ImageIcon("abajo.png"));
		labelAbajo.setBounds(195, 315, 20,22);
		labelAbajo.setVisible(false);
		contentPane.add(labelAbajo);
		
	}
	
	@SuppressWarnings("serial")
	public void inicializarTablero() {
		panel = new JPanel();
		panel.setBounds(57,61,300, 300);
		FormatoTabla formatoTabla = new FormatoTabla();
		
		contentPane.add(panel);
		
		
		lblGanaste= new JLabel();
		lblGanaste.setIcon(new ImageIcon("ganaste.gif"));
		lblGanaste.setBounds(358, 180, 217, 146);
		lblGanaste.setVisible(false);
		
		panel.add(lblGanaste);
		
		lblPerdiste= new JLabel();
		lblPerdiste.setIcon(new ImageIcon("perdiste.gif"));
		lblPerdiste.setBounds(320, 180, 217, 146);
		lblPerdiste.setVisible(false);
		
		panel.add(lblPerdiste);		
		
		table = new JTable();
		table.setEnabled(false);
		table.setToolTipText("");
		table.setBorder(new LineBorder(new Color(153, 153, 0), 3));
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Tahoma", Font.BOLD, 20));
		table.setRowHeight(60);
		panel.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
				{"", "", "", ""},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
	
		table.setDefaultRenderer(Object.class,formatoTabla);		
	}
	
	public void inicializar() {
		puntajeNumero = new JLabel("0");
		matriz = juegoLogica.obtenerMatriz();
		setIconImage(Toolkit.getDefaultToolkit().getImage("IconoGame.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 591, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		inicializarFlechas();
		inicializarTablero();
		
		contentPane.setFocusable(true);
		contentPane.requestFocus();
		contentPane.addKeyListener(new KeyAdapter(){	
		
		@Override
		public void keyPressed(KeyEvent e) {
				
			
			
			
			
				if (e.getKeyCode()==KeyEvent.VK_UP ){				
					matriz = juegoLogica.aplicarMovimiento(1);
					dibujarTablero();
					sugerirCambio();
				}if (KeyEvent.VK_DOWN==e.getKeyCode()){
					matriz = juegoLogica.aplicarMovimiento(3);
					dibujarTablero();
					sugerirCambio();
				}if (KeyEvent.VK_RIGHT==e.getKeyCode()){
					matriz = juegoLogica.aplicarMovimiento(2);
					dibujarTablero();
					sugerirCambio();
				}if (KeyEvent.VK_LEFT==e.getKeyCode()) {
					matriz = juegoLogica.aplicarMovimiento(0);
					dibujarTablero();
					sugerirCambio();
				}if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
			        System.exit(0);
				
				}	
	
		});		
		
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setForeground(Color.black);
		lblPuntaje.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPuntaje.setBounds(425, 51, 90, 31);
		contentPane.add(lblPuntaje);
		dibujarTablero();
		sugerirCambio();
	}
	public Juego() {
		setResizable(false);
		juegoLogica = new JuegoLogica();
		inicializar();
		
	}
	
	private void sugerirCambio() {
		int sentido = juegoLogica.sugerirMovimiento();

//		checkAyuda = new JCheckBox("Ayuda");
//		checkAyuda.setBounds(361, 208, 97, 23);
//		contentPane.add(checkAyuda);
//		
//		
//		checkAyuda.addItemListener(new ItemListener(){
//			@Override
//			public void itemStateChanged(ItemEvent e)
//			{
//				
//				
//				if(e.getStateChange()==ItemEvent.SELECTED){
//					if(sentido == 0) {
//						labelIzq.setVisible(true);
//						labelDer.setVisible(true);
//						labelArriba.setVisible(false);
//						labelAbajo.setVisible(false);
//					}else {
//						labelArriba.setVisible(true);
//						labelAbajo.setVisible(true);
//						labelIzq.setVisible(false);
//						labelDer.setVisible(false);
//						
//					}
//					checkAyuda.setEnabled(false);
//				//	checkAyuda.setEnabled(false);//ACCION
//				}
//					
//					else
//					{
//						labelIzq.setVisible(false);
//						labelDer.setVisible(false);
//						labelArriba.setVisible(false);
//						labelAbajo.setVisible(false);
//						
//						//ACCION
//					}
//				
//			
//			}
//			});	
//		
		
		if(sentido == 0) {
			labelIzq.setVisible(true);
			labelDer.setVisible(true);
			labelArriba.setVisible(false);
			labelAbajo.setVisible(false);
		}else {
			labelArriba.setVisible(true);
			labelAbajo.setVisible(true);
			labelIzq.setVisible(false);
			labelDer.setVisible(false);
			
		}
		
		
		
		
	}
	private void dibujar() {
		
		System.out.println("**********************");
		System.out.println("**********************");
		System.out.println(matriz[0][0]+" "+matriz[0][1]+" "+matriz[0][2]+" "+matriz[0][3]);
		System.out.println(matriz[1][0]+" "+matriz[1][1]+" "+matriz[1][2]+" "+matriz[1][3]);
		System.out.println(matriz[2][0]+" "+matriz[2][1]+" "+matriz[2][2]+" "+matriz[2][3]);
		System.out.println(matriz[3][0]+" "+matriz[3][1]+" "+matriz[3][2]+" "+matriz[3][3]);
	}
	
	private void dibujarTablero() {
		
		puntajeNumero.setForeground(Color.RED);
		puntajeNumero.setBackground(Color.DARK_GRAY);
		puntajeNumero.setBounds(428, 95, 77, 31);
		puntajeNumero.setFont(new Font ("Arial Black", Font.PLAIN,20));
		puntajeNumero.setText(juegoLogica.getPuntaje().toString());
		contentPane.add(puntajeNumero);		
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juegoLogica.agregarPuntaje();
				juegoLogica.reiniciar();
				inicializar();
				
			}
		});
		btnIniciar.setBounds(418, 9, 87, 25);
		contentPane.add(btnIniciar);
		
		cargarTabla();
		dibujar();
		
		if(juegoLogica.isFinalizo() && juegoLogica.isGano()) {
			
			lblGanaste.setVisible(true);
			
		}else if(juegoLogica.isFinalizo() && !juegoLogica.isGano()){
			
			lblPerdiste.setVisible(true);
		}
	}
	
	private void  cargarTabla() {
		for(int i = 0;i<matriz.length;i++) {
			for(int j = 0 ;j<matriz.length;j++) {
				
				if(matriz[i][j].equals(0)) {
					table.getModel().setValueAt("",i,j);
				}else {
					table.getModel().setValueAt(matriz[i][j], i, j);
				}
			}
		}
	}
}
	