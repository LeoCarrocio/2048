package com.logica;

import java.util.ArrayList;
import java.util.List;

public class JuegoLogica // clase que hace la lojica del juego 2048
{
	// atributos de clase 
	private Tablero tablero;
	private boolean finalizo;
	private Integer puntaje;
	private boolean gano;
	private List<Integer> listaHistorica;
	
	// getter & setter
	public boolean isFinalizo() {
		return finalizo;
	}
	public boolean isGano() {
		return gano;
	}
	public Integer getPuntaje() {
		return puntaje;
	}
	public List<Integer> getListaHistorica() {
		return listaHistorica;
	}
	public Integer[][] obtenerMatriz(){// 
		return tablero.getMatriz();
	}
	
	// constructor
	public JuegoLogica() {
		super();
		tablero = new Tablero();
		finalizo = false;
		gano = false;
		puntaje = 0;
		listaHistorica = new ArrayList<Integer>();
		
	}
	public JuegoLogica(Integer[][] matriz) {
		super();
		tablero = new Tablero(matriz);
		finalizo = false;
		gano = false;
		puntaje = 0;
		listaHistorica = new ArrayList<Integer>();
		
	}

	// metodos
	public void reiniciar() // reinicia la logica del juego 
	{
		tablero = new Tablero();
		finalizo = false;
		gano = false;
		puntaje = 0;
	}
	public Integer[][] aplicarMovimiento(int sentido)  // aplica los movimientos y devuelve una nueva matriz
	{
		
		try {
			tablero.calcularMovimiento(sentido);
			puntaje = puntaje + tablero.getPuntosMovimiento();
			if(tablero.getGano()) {
				finalizo = true;
				gano = true;
			}
			if(tablero.hayCambios()){
				tablero.colocarAleatorio();
			}
			
			
		} catch (ExceptionTablero e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			finalizo = true;
			gano = false;
			agregarPuntaje();
			
		}
		return tablero.getMatriz();
	}
	public void agregarPuntaje() // coloca el puntage a una lista 
	{
		List<Integer> lista = new ArrayList<Integer>();
		if(listaHistorica.size() == 0) {
			listaHistorica.add(this.puntaje);
		}else {
			for(Integer puntaje :listaHistorica) {
				if(puntaje > this.puntaje) {
					lista.add(puntaje);
				}else {
					lista.add(this.puntaje);
					lista.add(puntaje);
				}
			}
			listaHistorica = lista;
		}			
		
	}
	public int sugerirMovimiento() // sugiere movimientos apartir de las uniones de los 4 mov posibles y devuelve el mejor resultado 
	{
		List<Integer> puntosMovimientos = new ArrayList<Integer>();
		List<Integer> unionesMovimientos = new ArrayList<Integer>();
		Integer[][] matriz;
		Tablero tableroLocal;
		int contador = 0;
		boolean iguales = true;
		for(int i = 0;i<2;i++) {
			matriz = OperacionesMatriz.cargarMatriz(tablero.getMatriz());
			tableroLocal = new Tablero(matriz);
			tableroLocal.calcularMovimiento(i);
			puntosMovimientos.add(tableroLocal.getPuntosMovimiento());
			unionesMovimientos.add(tableroLocal.getUnionesMovimiento());
			if(OperacionesMatriz.compararMatriz(matriz,tablero.getMatriz()) && OperacionesMatriz.matrizLlena(matriz)) {
				contador++;
			}
		}
		if(contador == 2) {
			finalizo = true;
		}
		return calcularMayor(puntosMovimientos,unionesMovimientos);
	}
	private int calcularMayor(List<Integer> puntosMovimientos, // calcula la mejor posivilidad de movimiento a raiz de dos listas
							  List<Integer> unionesMovimientos) 
	{
		int indiceMayor = 0;
		
		if(unionesMovimientos.get(1) > unionesMovimientos.get(0)) {
			indiceMayor = 1;
		}else if(unionesMovimientos.get(0) == unionesMovimientos.get(1)) {
			if(puntosMovimientos.get(1) > puntosMovimientos.get(0) ) {
				indiceMayor = 1;
			}
		}
		
		return indiceMayor;
	}
	
	
}
