package com.ejerciciostareas;

public class Suma {

	public boolean hasEqualSum (int num1, int num2, int num3) {
		boolean valorregreso;
		int resultadoSuma= num1+num2;
		
		if (resultadoSuma==num3) {
			
			//System.out.println("la suma de los dos primeros parametros es igual al tercero");
			valorregreso=true;
			
			
		} else {
			
			//System.out.println("la suma de los dos primeros parametros no es igual al tercero");
			valorregreso=false;
			
			
		}
		
	return valorregreso ;	
	}
}
