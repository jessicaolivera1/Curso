package com.java;

public class ArreglosBidimencional {

	public static void main(String[] args) {
		
		String[][] nombreedad=new String [4][2];
		nombreedad [0][0]="Rikardo";
		nombreedad [0][1]="30";
		nombreedad [1][0]="jessica";
		nombreedad [1][1]="31";
		nombreedad [2][0]="Aide";
		nombreedad [2][1]="32";
		nombreedad [3][0]="Felipe";
		nombreedad [3][1]="33";
		
		System.out.println("el nombre de la persona es " + nombreedad [0][0] + " y su edad es "+ nombreedad [0][1]);
		
		
		

	}
	
	public void printnombreedad(String nombre,String edad) {
		
		
		
		System.out.println("el nombre de la persona es "+ nombre);
		
		
	}

}
