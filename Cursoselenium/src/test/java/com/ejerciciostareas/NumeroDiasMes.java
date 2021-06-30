package com.ejerciciostareas;

public class NumeroDiasMes {


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
	}


	public static int getDaysInMonth (int mes,int anio) {
		
		int valorregreso=0;
		
		if (mes<1 || mes>12) {
			return -1;	
		} else if (anio<1 || anio>9999) {
			
			return -1;
			
		}  
		
		switch (mes) {
		
		case 1:case 3: case 5: case 7: case 8: case 10: case 12:
			valorregreso=31;
			break;
		
		case 2:
			
			boolean regresametodo1=metodoanioBisiesto(anio);
			
			if (regresametodo1==true) {
				
				valorregreso=29;
				
			}
			 
			else {
				valorregreso=28;
			}
			 
		
			break;
			
	
		case 4: case 6: case 9: case 11:
			valorregreso=30;
			break;
				
			
	
		
		}
		
		

		return valorregreso;
		
		
	}

}

