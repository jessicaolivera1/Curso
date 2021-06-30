package com.pintor;

public class CalculaPintura {
	
	int cantidadCubetas=0;
	double area;


	public int cuentaNumeroCubetas (double ancho, double altura, double areaxCubeta ,int extraCubetas) {

		area=ancho*altura;
	float	temporal=(float) ((area/areaxCubeta)-extraCubetas);
	cantidadCubetas= Math.round(temporal);
	
		return cantidadCubetas;
	}

}
