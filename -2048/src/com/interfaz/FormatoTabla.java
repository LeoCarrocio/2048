package com.interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class FormatoTabla extends DefaultTableCellRenderer{


	@Override
	public Component getTableCellRendererComponent(JTable tabla, Object valor, boolean bol, boolean focus, int fila,
			int columna) {
		JLabel celda = (JLabel)super.getTableCellRendererComponent(tabla, valor,bol,focus,fila,columna);
		
		
		if (tabla.getModel().getValueAt(fila, columna).equals(2) || tabla.getModel().getValueAt(fila, columna).equals(4)){
			celda.setForeground(Color.BLACK);
			
		}
		else{
			celda.setForeground(Color.WHITE);
		}
		
		
		if (tabla.getModel().getValueAt(fila, columna).equals(2)){
			
			celda.setBackground(Color.white);	
			celda.setFont(new Font ("Arial Black", Font.PLAIN,30));
			celda.setText("  2");
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(4)){
			celda.setBackground(new Color(  224, 216, 179   ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,30));
			celda.setText("  4");
			
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(8)){
			celda.setBackground(new Color( 180, 176, 115   ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,30));
			celda.setText("  8");
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(16)){
			celda.setBackground(new Color(  200, 143, 89    ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,30));
			celda.setText(" 16");
		}else if (tabla.getModel().getValueAt(fila, columna).equals(32)){
			celda.setBackground(new Color(  121, 50, 7   ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,30));
			celda.setForeground(Color.WHITE);
			celda.setText(" 32");
		}else if (tabla.getModel().getValueAt(fila, columna).equals(64)){
			celda.setBackground(new Color(  143, 64, 15    ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,30));
			celda.setText(" 64");
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(128)){
			celda.setBackground(Color.yellow);
			celda.setFont(new Font ("Arial Black", Font.PLAIN,28));
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(256)){
			celda.setBackground(new Color( 196, 205, 15   ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,28));
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(512)){
			celda.setBackground(new Color( 238, 241, 171    ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,28));
			
		}else if (tabla.getModel().getValueAt(fila, columna).equals(1024)){
			celda.setBackground(new Color( 202, 207, 113   ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,20));
		
		}else if (tabla.getModel().getValueAt(fila, columna).equals(2048)){
			celda.setBackground(new Color(  183, 188, 81 ));
			celda.setFont(new Font ("Arial Black", Font.PLAIN,20));
		
			
		}else {
			celda.setBackground(new Color ( 193, 178, 157 ));

		}
		
		
		
		
		
		
		return celda;
	}
}
