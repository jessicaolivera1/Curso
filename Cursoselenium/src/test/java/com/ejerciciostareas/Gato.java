package com.ejerciciostareas;

//Los gatos pasan la mayor parte del día jugando. En particular, juegan si la temperatura está entre 25 y 35 (inclusive). A menos que sea verano, el límite superior es 45 (inclusive) en lugar de 35.
//
//Escriba un método isCatPlaying que tenga 2 parámetros. El método debe devolver verdadero si el gato está jugando; de lo contrario, devolver falso
//
//El primer parámetro debe ser de tipo booleano y debe llamarse "verano" que representa si es verano.
//El segundo parámetro representa la temperatura y es de tipo int con el nombre "temperatura".
//
//
//EJEMPLOS DE ENTRADA / SALIDA:
//
//* isCatPlaying (verdadero, 10); debe devolver falso ya que la temperatura no está en el rango de 25 a 45
//
//* isCatPlaying (falso, 36); debe devolver falso ya que la temperatura no está en el rango de 25 a 35 (el parámetro de verano es falso)
//
//* isCatPlaying (falso, 35); debería volver a verdadero ya que la temperatura está en el rango de 25 a 35

public class Gato {
	// declaracion de variables
	//int temperatura=0;
	
	//boolean verano=true;
	// metodo con dos parametros el cual regresa un valor 
	
	public   boolean CatPlaying  (int temperatura,boolean verano) {
		boolean valorRegro;
		// evaluación 
		if ((verano==true || verano==false ) && temperatura>=25 && temperatura<=35) {

			valorRegro=true;

			System.out.println("el minino se encuentra jugando  y hay una temperatura entre los 25 y 35 grados");



		} else if (verano==true && temperatura>=25 && temperatura<=45) {


			valorRegro=true;

			System.out.println("el minino se encuentra jugando en verano y hay una temperatura entre los 25 y 45 grados");

		}else {

			valorRegro=false;


		}
		System.out.println(valorRegro);
		
		
		// regreso valor del metodo
		return valorRegro;

		
		
		
		
		
		
		
		
		
		
		
		
	}
		
	
	
	
	
	

}
