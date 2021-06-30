package com.ejerciciostareas;

public class VerificadordeNumeros {
	
	
	
	public  void imprimirVerificadorNumeros( int valor1,int valor2,int valor3) {
		
		if(valor1<0 || valor2<0 || valor3<0) {
			
			System.out.println("Valor no valido");
			
			
		} else if (valor1==valor2 && valor3==valor2) {
			System.out.println("Todos los numeros son iguales");
			
			
		} else if (valor1!=valor2 && valor2!=valor3 &&valor3!=valor1) {
			System.out.println("Todos los numeros son diferentes");
			
			
		}else {
			System.out.println("Ni todos son igules ni diferentes");
		}
		
		System.out.println("el valor en el parametro 1 es= "+valor1);
		System.out.println("el valor en el parametro 2 es= "+valor2);
		System.out.println("el valor en el parametro 3 es= "+valor3);
		
	}
	

}
