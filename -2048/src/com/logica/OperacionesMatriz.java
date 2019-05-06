package com.logica;

public final class OperacionesMatriz // clase que realiza operaciones de cualquier matriz generica
{
	public static boolean compararMatriz(Integer[][] matriz2,Integer[][] matriz1) // compara la matriz y devuelve falso o verdadero
	{
		boolean iguales = true;
		for(int i = 0;i<matriz1.length;i++) {
			for(int j = 0;j<matriz1.length;j++) {
				if(!matriz1[i][j].equals(matriz2[i][j])) {
					return false;
				}
			}
		}
		return iguales;
	}
	public static Integer[][] cargarMatriz(Integer[][] matrizOrigen) // carga una matris solicitada 
	{
		Integer [][] matrizDestino = new Integer[4][4];
		for(int i = 0;i<matrizOrigen.length;i++) {
			for(int j = 0;j<matrizOrigen.length;j++) {
				matrizDestino[i][j] = matrizOrigen[i][j];
			}
		}
		return matrizDestino;
	}
	public static Integer[][] crearMatriz() // crea la matriz y la pone en 0
	{
		Integer[][] matriz = {{new Integer(0),new Integer(0),new Integer(0),new Integer(0)},
						  {new Integer(0),new Integer(0),new Integer(0),new Integer(0)},
						  {new Integer(0),new Integer(0),new Integer(0),new Integer(0)},
						  {new Integer(0),new Integer(0),new Integer(0),new Integer(2)}};
		return matriz;
	}
	public static boolean matrizLlena(Integer [][] matriz) // pregunta si esta llena la matriz
	{
		boolean llena = true;
		for(int i = 0;i<matriz.length;i++) {
			for(int j = 0;j<matriz.length;j++) {
				if(matriz[i][j].equals(0)) {
					return false;
				}
			}
		}
		return llena;
	}
}
