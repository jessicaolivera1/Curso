package com.java;

public class Dowhile {

	public static void main(String[] args) {
		
	// cuantas veces se tiene que sumar un numero para llegar a 100
		
		int numerolimite= 20;
		int sumatotal=0;
		int contador= 0;
		
		
		do {
			
			sumatotal=sumatotal+numerolimite;
			++contador;
			
			
		}while (sumatotal<100);
		
		System.out.println("el numero se sumo "+ contador +"veces");
		
		
		
	}

}
