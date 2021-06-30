package com.java;

public class Switch {

	public static void main(String[] args) {
		
		
		
	int temperatura=87;
	
	switch (temperatura) {
	
	case 5:
		
		System.out.println("Mucho frio");
		
		break;
		
	case 10:
		
		System.out.println("muy frio");
		break;
		
		
	case 20:
	case 25:
		
		System.out.println("Templado");
		break;
		
		
	case 35:
		
		System.out.println("Calor");
		break;
		
		
		default:
			
			System.out.println("No encontro relacion por la temperatura");
			break;
			
			
			
			
		
	
		
	}

	}

}
