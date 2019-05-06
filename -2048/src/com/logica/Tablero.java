package com.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Tablero // clase encargada de los movimientos del tablero 
{
	// atributos
	
	private Integer[][] matriz;
	private int indiceVacio;
	private List<Integer> filaVacia;
	private List<Integer> columnaVacia;
	private int unionesMovimiento;
	private int puntosMovimiento;
	private int contadorMovimiento;
	private final int num = 2048;
	private boolean hayCambios;
	private boolean gano = false;
	
	// constructores
	
	public Tablero() {
		super();
		matriz = OperacionesMatriz.crearMatriz();
		hayCambios = true;//new boolean[]{false,false,false,false};
	}
	public Tablero(Integer[][] matriz) {
		super();
		this.matriz = matriz;
		hayCambios = true;//new boolean[]{false,false,false,false};
	}
	
	//Setters & Getters

	int getPuntosMovimiento() {
		return puntosMovimiento;
	}
	void setPuntosMovimiento(int puntosMovimiento) {
		this.puntosMovimiento = puntosMovimiento;
	}
	int getUnionesMovimiento() {
		return unionesMovimiento;
	}
	void setUnionesMovimiento(int unionesMovimiento) {
		this.unionesMovimiento = unionesMovimiento;
	}
	Integer[][] getMatriz() {
		return matriz;
	}
    void setMatriz(Integer[][] matriz) {
		this.matriz = matriz;
	}
    boolean getGano() {
    	return this.gano;
    }
    boolean hayCambios() {
    	return hayCambios;
    }
   
    // metodos de clase 
    
    // movimientos de clumna en los dos  sentidos y sumas 
	private boolean moverColumnaArriba(int columna){

		boolean terminar = false;
		boolean cero = false;
		int indiceCero = 0;
		int i = 0;
		int contadorTotal = 0;
		while(!terminar) {
			if(matriz[i][columna].equals(0)) {
				if(!cero) {
					cero = true;
					indiceCero = i;
				}
			}else {
				if(cero) {
					matriz[indiceCero][columna]=matriz[i][columna];
					matriz[i][columna]=0;
					contadorMovimiento++;
					i = 0;
					cero = false;
					indiceCero = i;
				}
			}
			
			i++;
			contadorTotal++;
			if(matriz.length == i) {
				terminar = true;
			}
					
					
		}
		return contadorTotal != 4;
	}
	private boolean sumarColumnaArriba(int columna){
		boolean terminar = false;
		int i = 0;
		int contadorTotal = 0;
		while(!terminar) {
			
			if(matriz[i][columna].equals(matriz[i+1][columna]) && !matriz[i][columna].equals(0)) {
				matriz[i][columna] = matriz[i][columna]+matriz[i][columna];
				matriz[i+1][columna] = 0;
				unionesMovimiento++;
				puntosMovimiento = puntosMovimiento + matriz[i][columna];
				if(matriz[i][columna].equals(num)) {
					gano = true;
				}
				contadorTotal++;
			}
			i++;
			if(matriz.length-1 == i) {
				terminar = true;
			}
			
		}
		return contadorTotal != 0;
	}
	private boolean moverColumnaAbajo(int columna){
		boolean terminar = false;
		boolean cero = false;
		int indiceCero = 0;
		int i = 3;
		int contadorTotal = 0;
		while(!terminar) {
			if(matriz[i][columna].equals(0)) {
				if(!cero) {
					cero = true;
					indiceCero = i;
				}
			}else {
				if(cero) {
					matriz[indiceCero][columna]=matriz[i][columna];
					matriz[i][columna]=0;
					contadorMovimiento++;
					i = 3;
					cero = false;
					indiceCero = i;
				}
			}
			
			i--;
			contadorTotal++;
			if(-1 == i) {
				terminar = true;
			}
					
					
		}
		return contadorTotal != 4;
	}
	private boolean sumarColumnaAbajo(int columna){
		boolean terminar = false;
		int i = 3;
		int contadorTotal = 0;
		while(!terminar) {
			
			if(matriz[i][columna].equals(matriz[i-1][columna]) && !matriz[i][columna].equals(0)) {
				matriz[i][columna] = matriz[i][columna]+matriz[i][columna];
				matriz[i-1][columna] = 0;
				unionesMovimiento++;
				puntosMovimiento = puntosMovimiento + matriz[i][columna];
				if(matriz[i][columna].equals(num)) {
					gano = true;
				}
				contadorTotal++;
			}
			
			
			if(1 == i) {
				terminar = true;
			}
			i--;
			
		}
		return contadorTotal != 0;
	}

	//movimientos de filas en los dos sentidos y sumas
	private boolean sumarFilaIzq(int fila){
		boolean terminar = false;
		int i = 0;
		int contadorTotal = 0;
		while(!terminar) {
			
			if(matriz[fila][i].equals(matriz[fila][i+1]) && !matriz[fila][i].equals(0)) {
				matriz[fila][i] = matriz[fila][i]+matriz[fila][i];
				matriz[fila][i+1] = 0;
				contadorTotal++;
				unionesMovimiento++;
				puntosMovimiento = puntosMovimiento + matriz[fila][i];
				if(matriz[fila][i].equals(num)) {
					gano = true;
				}
			}
			
			if(matriz.length-2 == i) {
				terminar = true;
			}else {
				i++;
			}
			
			
		}
		
		return contadorTotal != 0;
				
	}
	private boolean moverFilaIzq(int fila){
		boolean terminar = false;
		boolean cero = false;
		int indiceCero = 0;
		int contadorTotal = 0;
		int i = 0;
		while(!terminar) {
			if(matriz[fila][i].equals(0)) {
				if(!cero) {
					cero = true;
					indiceCero = i;
				}
			}else {
				if(cero) {
					matriz[fila][indiceCero]=matriz[fila][i];
					matriz[fila][i]=0;
					contadorMovimiento++;
					i = 0;
					cero = false;
					indiceCero = i;
				}
			}
			
			i++;
			contadorTotal++;
			if(matriz.length == i) {
				terminar = true;
			}
					
					
		}
		return contadorTotal != 4;
	}
	private boolean moverFilaDer(int fila){
		boolean terminar = false;
		boolean cero = false;
		int indiceCero = 0;
		int i = 3;
		int contadorTotal = 0;
		while(!terminar) {
			if(matriz[fila][i].equals(0)) {
				if(!cero) {
					cero = true;
					indiceCero = i;
				}
			}else {
				if(cero) {
					matriz[fila][indiceCero]=matriz[fila][i];
					matriz[fila][i]=0;
					contadorMovimiento++;
					i = 3;
					cero = false;
					indiceCero = i;
				}
			}
			i--;
			contadorTotal++;
			if(-1 == i) {
				terminar = true;
			}			
		}	
		return contadorTotal != 4;
	}
	private boolean sumarFilaDer(int fila){
		boolean terminar = false;
		int i = 3;
		int contadorTotal = 0;
		while(!terminar) {
			
			if(matriz[fila][i].equals(matriz[fila][i-1]) && !matriz[fila][i].equals(0)) {
				matriz[fila][i] = matriz[fila][i]+matriz[fila][i];
				matriz[fila][i-1] = 0;
				contadorTotal++;
				unionesMovimiento++;
				puntosMovimiento = puntosMovimiento + matriz[fila][i];
				if(matriz[fila][i].equals(num)) {
					gano = true;
				}
			}
			
			if(1 == i) {
				terminar = true;
			}else {
				i--;
			}
			
		}
		return contadorTotal != 0;
	}
	
	// movimientos donde llama a las filas y colunas 
	private void movimientoIzq(int fila){
		
		moverFilaIzq(fila);
		sumarFilaIzq(fila);
		moverFilaIzq(fila);
		/*boolean mover1 = moverFilaIzq(fila);
		boolean sumar =  sumarFilaIzq(fila);
		boolean mover2 = moverFilaIzq(fila);
		if(!mover1 && !sumar && !mover2) {
			sinCambios[fila] = true;
		}*/
		
	}
	private void movimientoDer(int fila){
		
		 moverFilaDer(fila);
		sumarFilaDer(fila) ;
		moverFilaDer(fila) ;
		/*boolean mover1 = moverFilaDer(fila);
		boolean sumar =  sumarFilaDer(fila);
		boolean mover2 = moverFilaDer(fila);
		if(!mover1 && !sumar && !mover2) {
			sinCambios[fila] = true;
		}*/
		
	}
	private void movimientoArriba(int columna){
		
		moverColumnaArriba(columna);
		sumarColumnaArriba(columna);
		moverColumnaArriba(columna);
		/*boolean mover1 = moverColumnaArriba(columna);
		boolean sumar =  sumarColumnaArriba(columna);
		boolean mover2 = moverColumnaArriba(columna);
		if(!mover1 && !sumar && !mover2) {
			sinCambios[columna] = true;
		}*/

		
	}
	private void movimientoAbajo(int columna){
		
		 moverColumnaAbajo(columna);
		sumarColumnaAbajo(columna) ;
		moverColumnaAbajo(columna) ;
		/*boolean mover1 = moverColumnaAbajo(columna);
		boolean sumar =  sumarColumnaAbajo(columna);
		boolean mover2 = moverColumnaAbajo(columna);
		if(!mover1 && !sumar && !mover2) {
			sinCambios[columna] = true;
		}*/
	}

	
	void calcularMovimiento(int sentido) // recive el sentido de los movimientos y luego llama a los metodos
	{
		
		//inicializarCambios();
		unionesMovimiento = 0;
		puntosMovimiento = 0;
		contadorMovimiento = 0;
		hayCambios = true;
		for(int i = 0;i<matriz.length;i++) {
			switch (sentido) {
			    case 0: 
			    	movimientoIzq(i); 
			    break;
			    case 1: 
			    	movimientoArriba(i);
			    break;
			    case 2: 
			    	movimientoDer(i);
			    break;
			    case 3: 
			    	movimientoAbajo(i);
			    break;
			}
		}
		if(puntosMovimiento == 0 && contadorMovimiento == 0) {
			hayCambios = false;
		}
		
	}	
    void calcularMatriz(int sentido,Integer[][] matriz) // recive el sentido de los movimientos y luego llama a los metodos
    {
		
		for(int i = 0;i<matriz.length;i++) {
			switch (sentido) {
			    case 0: 
			    	movimientoIzq(i); 
			    break;
			    case 1: 
			    	movimientoArriba(i);
			    break;
			    case 2: 
			    	movimientoDer(i);
			    break;
			    case 3: 
			    	movimientoAbajo(i);
			    break;
			}
		}
		
	}	

	
	private int dosOCuatro() // devuelve un numero entre dos o cuatro;
	{
		Random aleatorio= new Random();
		int num=(aleatorio.nextInt(2));
		if(num==0)
			return 2;
		else
		    return 4;
	}
	private void posicionesLibres() throws ExceptionTablero // devuelve los casilleros que estan libres
	{
		int n=-1;
		for (int fila=0; fila<this.matriz.length; fila++) 
		{
			
			for(int colu=0; colu<this.matriz.length; colu++) 
			{
				if(this.matriz[fila][colu].equals(0)){
					filaVacia.add(fila);
					columnaVacia.add(colu);
					n = 0;
				}
			}
		}
		if (n == -1){
			throw new ExceptionTablero("No hay lugar en la matriz"); 
		}
	}
	private void posicionAleatorio() // devuelve una posicion aleatorio para colocar los numeros
	{
			int num = filaVacia.size()-1;
			Random aleatorio = new Random();
			if(num == 0) {
				indiceVacio = 0;
			}else {
				indiceVacio = (aleatorio.nextInt(num));
			}
	}	
    void colocarAleatorio() throws ExceptionTablero // coloca el aleatorio en el tablero
    {
    	filaVacia = new ArrayList<Integer>();
		columnaVacia = new ArrayList<Integer>();
		posicionesLibres();
		posicionAleatorio();
		
		int indiceFila = (int) filaVacia.get(this.indiceVacio);
		int indiceColumna = (int) columnaVacia.get(this.indiceVacio);
		this.matriz[indiceFila][indiceColumna] = dosOCuatro();
	}

}
