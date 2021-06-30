package com.ejercicioclase;

public class Multiplicacion {

	public static void main(String[] args) {
		
	double z=multiplicacionnumeros (8,1);
	imprimemultiplicacion(z);

	}
	
	//metodos se declaran fuera del main
	public static  double multiplicacionnumeros (int x, int y ) {
		return (x*y);
		
		
	}
	
	public static void imprimemultiplicacion (double z) {
		System.out.println(z);
	}

}
