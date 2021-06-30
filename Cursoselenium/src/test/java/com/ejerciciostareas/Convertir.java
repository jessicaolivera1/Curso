package com.ejerciciostareas;

public class Convertir {

	
	public static void printMegaBytesAndKiloBytes (int kiloBytes) {
		
		int megabytes=kiloBytes/1024;  
		int kilobytesrestantes=kiloBytes % 1024;
	
	
	if (kiloBytes>=0) {
		
		System.out.println(kiloBytes + " KB" +" = "+megabytes +" MB " +"Y "+kilobytesrestantes +" KB");
		
		
	} else  {
		
		System.out.println("Valor no valido");
	}
		
	
	}
	
}
