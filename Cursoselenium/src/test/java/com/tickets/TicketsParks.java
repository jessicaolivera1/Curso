package com.tickets;

public   abstract class  TicketsParks {
	// instancia de variasble o instancia de un objeto
	String welcomeMessage;
	// constructor
	public TicketsParks() {
		this.welcomeMessage= "Bienvenidos a Cooltesters Parks";
		
	}
	
	// metodo obtener mensaje
	
	public String welcomeMessageString () {
		
		return this.welcomeMessage;
	}
	
	public abstract double getTicketPrice ();
	public abstract  void printPriceDay ();

	public abstract void printPriceDay(String authkey, String priceDay) ;
		
		
	
	

}
