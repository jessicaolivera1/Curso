package com.ejerciciostareas;

public class AnioBisiesto {
	
	public static  boolean metodoanioBisiesto (int anio) {
	int divisible4= anio%4;
	int divisible400= anio%400;
	int divisible100= anio%100;
	boolean estaenrango=false;
	
	
	if (anio>=1 && anio<=9999) {
		estaenrango=true;

	}

	if (estaenrango) {
		
		if (divisible400==0) {
			
			System.out.println("el año es bisiesto");
			
			return true;
			
		} else if (divisible4==0 && divisible100!=0) {
			
			System.out.println("el año es bisiesto");
			
			return true;
			
		}
		System.out.println("el año no es bisiesto");

		return false;
		
	

	} else {

		System.out.println("el año esta fuera del rango");
		return false;
	}





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	if (anio>=1 && anio<=9999 && divisible4==0) {
//		
//		
//			
//		return true;
//
//		
//	} else if (anio>=1 && anio<=9999 && divisible400==0) {
//		
//		return true;
//		
//	} else if (anio>=1 && anio<=9999 && divisible100==0) {
//		
//		return false;
//	}
//	
//	
//
//	else {
//		
//		
//	return false;	
//	}
	
	

}
}
