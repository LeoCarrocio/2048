package com.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Records extends JFrame {

	private JPanel contentPane;
	private List<String> lista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					List<String> lista = new ArrayList<String>();
					Records frame = new Records(lista);
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Records(List<String> puntajes) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setFont(new Font("Arial Black", Font.PLAIN, 20));
		list.setBounds(71, 47, 122, 215);
		list.setModel(cargarLista(puntajes));
		
		contentPane.add(list);
		
		JLabel lblPuntajes = new JLabel("Puntajes");
		lblPuntajes.setFont(new Font("Stencil", Font.PLAIN, 15));
		lblPuntajes.setBounds(91, 28, 122, 31);
		contentPane.add(lblPuntajes);
		
		
		
		JLabel MedallaOro = new JLabel("");
		MedallaOro.setIcon(new ImageIcon("1.png"));
		MedallaOro.setBounds(36, 43, 34, 35);
		contentPane.add(MedallaOro);
		
		JLabel MedallaPlata = new JLabel("\r\n");
		MedallaPlata.setIcon(new ImageIcon("2.png"));
		MedallaPlata.setBounds(36, 76, 28, 35);
		contentPane.add(MedallaPlata);
		
		JLabel MedallaBronze = new JLabel("");
		MedallaBronze.setIcon(new ImageIcon("3.png"));
		MedallaBronze.setBounds(36, 108, 46, 30);
		contentPane.add(MedallaBronze);
		
		JLabel Puntos = new JLabel("");
		Puntos.setIcon(new ImageIcon("objetivo.png"));
		Puntos.setBounds(110, 0, 74, 36);
		contentPane.add(Puntos);
			
		
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DefaultListModel cargarLista(List<String> listaPuntaje) {
		DefaultListModel listaModel = new DefaultListModel();
		for(String puntaje :listaPuntaje) {
			
	
			
			listaModel.addElement(puntaje);
		}
		return listaModel;
	}

}
