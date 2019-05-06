package com.interfaz;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow ventana = new MainWindow();
					ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("IconoGame.png"));
		setForeground(Color.ORANGE);
		setFont(new Font("Arial Black", Font.PLAIN, 12));
		setBackground(Color.BLACK);
		setTitle("2048Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 470, 297);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGame = new JLabel(" 2048 GAME");
		lblGame.setForeground(new Color(139, 0, 0));
		lblGame.setFont(new Font("Freestyle Script", Font.ITALIC, 40));
		lblGame.setBackground(Color.RED);
		lblGame.setBounds(143, 53, 278, 67);
		contentPane.add(lblGame);
		
		JButton Boton_JUGAR = new JButton("JUGAR");
		Boton_JUGAR.setIcon(new ImageIcon(("JostickMain.png")));
		Juego ventanaJuego = new Juego();
		Boton_JUGAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaJuego.setVisible(true);
				dispose();//Pisa la ventana anterior
				
			}
		});
		Boton_JUGAR.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		Boton_JUGAR.setForeground(Color.BLACK);
		Boton_JUGAR.setBackground(new Color(105, 105, 105));
		Boton_JUGAR.setBounds(36, 121, 143, 34);
		contentPane.add(Boton_JUGAR);
		
		JButton Boton_Records = new JButton("RECORDS");
		Boton_Records.setIcon(new ImageIcon("trofeo.png"));
		
		Boton_Records.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> lista = new ArrayList<String>();
				lista.add("1020");
				lista.add("2020");
				lista.add("4020");
				lista.add("5020");
				Records historial = new Records(lista);
				historial.setVisible(true);
				MainWindow.this.dispose();
				
			}
			
		});
		
		
		
		
		Boton_Records.setBackground(Color.GRAY);
		Boton_Records.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		Boton_Records.setForeground(Color.BLACK);
		Boton_Records.setToolTipText("RECORDS");
		Boton_Records.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Boton_Records.setBounds(161, 197, 143, 34);
		contentPane.add(Boton_Records);
		
		JButton Boton_SALIR = new JButton("SALIR");
		Boton_SALIR.setIcon(new ImageIcon("SalirMain.png"));
		
		Boton_SALIR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Boton_SALIR.setBackground(Color.GRAY);
		Boton_SALIR.setForeground(Color.BLACK);
		Boton_SALIR.setFont(new Font("Freestyle Script", Font.PLAIN, 22));
		Boton_SALIR.setBounds(268, 121, 153, 34);
		contentPane.add(Boton_SALIR);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Bienvenido.png"));
		lblNewLabel.setBounds(199, 11, 81, 43);
		contentPane.add(lblNewLabel);
	}
}
