package com.java;
//clase coche 
public class Coche {
	
	
	
	public String llandas;
	
	public String marca;
	
	//constructor 
	
	public Coche (String llantas,String marca) {
		
		this.llandas=llantas;
		this.marca=marca;
		
			
	}
	
	
	// sobre carga de metodos reutilizar el metodo enviando otros parametros
	
	public static int operadores(int x,int y) {
		return x+y;
		
	}
	
	public static int operadores (int x, int y,int z) {
		return x+y+z;
	}
		
	

}
