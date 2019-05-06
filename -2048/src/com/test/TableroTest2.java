package com.test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import com.logica.Tablero;

public class TableroTest2 {

	 Integer[][] matriz;
	 Tablero tablero;
	 @Before
	  public void setUp() throws Exception {
		 Integer[][] matriz = {{2,0,2,0},{0,0,0,0},{0,4,4,0},{2,0,0,2}};
		 tablero = new Tablero(matriz);
	  }
	 
	 @Test
	 public void moverIzquierda() {
		 tablero.calcularMatriz(0);
		 Integer[][] matrizRes = tablero.getMatriz();
		 
		 ArrayList<Integer> listaRes = new ArrayList<Integer>();
		 listaRes.add(matrizRes[0][0]);
		 listaRes.add(matrizRes[1][0]);
		 listaRes.add(matrizRes[2][0]);
		 listaRes.add(matrizRes[3][0]);
		 
		 ArrayList<Integer> lista = new ArrayList<Integer>();
		 lista.add(4);
		 lista.add(0);
		 lista.add(8);
		 lista.add(4);
		 assertEquals(listaRes,lista);
		 
	 }

	 @Test
	 public void moverArriba() {
		 tablero.calcularMatriz(1);
		 Integer[][] matrizRes = tablero.getMatriz();
		 
		 ArrayList<Integer> listaRes = new ArrayList<Integer>();
		 listaRes.add(matrizRes[0][0]);
		 listaRes.add(matrizRes[0][1]);
		 listaRes.add(matrizRes[0][2]);
		 listaRes.add(matrizRes[0][3]);
		 
		 ArrayList<Integer> lista = new ArrayList<Integer>();
		 lista.add(4);
		 lista.add(4);
		 lista.add(2);
		 lista.add(2);
		 assertEquals(listaRes,lista);
		 
	 }
	 
	 @Test
	 public void moverDerecha() {
		 tablero.calcularMatriz(2);
		 Integer[][] matrizRes = tablero.getMatriz();
		 
		 ArrayList<Integer> listaRes = new ArrayList<Integer>();
		 listaRes.add(matrizRes[0][3]);
		 listaRes.add(matrizRes[1][3]);
		 listaRes.add(matrizRes[2][3]);
		 listaRes.add(matrizRes[3][3]);
		 
		 ArrayList<Integer> lista = new ArrayList<Integer>();
		 lista.add(4);
		 lista.add(0);
		 lista.add(8);
		 lista.add(4);
		 assertEquals(listaRes,lista);
		 
	 }
	 
	 @Test
	 public void moverAbajo() {
		 tablero.calcularMatriz(3);
		 Integer[][] matrizRes = tablero.getMatriz();
		 
		 ArrayList<Integer> listaRes = new ArrayList<Integer>();
		 listaRes.add(matrizRes[3][0]);
		 listaRes.add(matrizRes[3][1]);
		 listaRes.add(matrizRes[3][2]);
		 listaRes.add(matrizRes[3][3]);
		 
		 ArrayList<Integer> lista = new ArrayList<Integer>();
		 lista.add(4);
		 lista.add(4);
		 lista.add(4);
		 lista.add(2);
		 assertEquals(listaRes,lista);
		 
	 }

}
