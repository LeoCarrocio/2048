package com.logica;

public class prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tablero tab= new Tablero();
		Integer[][] matriz = tab.getMatriz();
		tab.calcularMatriz(1);
		tab.calcularMatriz(3);
		tab.calcularMatriz(2);

	}

}
