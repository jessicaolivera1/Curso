package com.java;

public class LimiteVelocidad {

	public static void main(String[] args) {
		
		int velocidad=130;// kILOMETROS POR HORA
		int limitevelocidad=100;
		
		
//		if (velocidad>limitevelocidad) {
//			
//			System.out.println("MULTA");
//		} else {
//			
//			System.out.println("El coche va en la velocidad adecuada");
//		}
			// IF ANIDADO / IF ELSE

		boolean highway = true;

		if(highway) {

			System.out.println("estamos conduciendo en una higway");

			limitevelocidad=120;

			if (velocidad>limitevelocidad) {

				System.out.println("MULTA");
			} else {

				System.out.println("El coche va en la velocidad adecuada");
			}

		} else if (velocidad>limitevelocidad) {
			System.out.println("el coche esta en una calle y va a exceso de velocidad, MULTA ");
		} else {
			System.out.println("el coche va en una calle y va a una velocidad permitida");
		}
	}

}
