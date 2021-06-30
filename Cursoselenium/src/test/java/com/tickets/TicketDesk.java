package com.tickets;

public class TicketDesk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//inputs
		double price=100;
		boolean isStudent=true;
		int age=10;
		String authkey= "1234";
		String specialDay=" Descuento";
		double specialDiscount=30;
		
		//polimorfismo 
		
		TicketsParks ticket=new CoolParkTicket(price,isStudent,age);
		//ticket.printPriceDay();
		ticket.printPriceDay(authkey, specialDay);
		double coolprice=ticket.getTicketPrice();
		
	
		
		// tester park
		
		ticket=new TestersParkTicket(price,isStudent,age);
		//ticket.printPriceDay();
		ticket.printPriceDay(authkey, specialDay);
		
		double testersPrice=ticket.getTicketPrice();
		
		TicketsParks ticketDiscount =new  TestersParkTicket(price,specialDiscount);
		ticketDiscount.printPriceDay();
		double discount=ticketDiscount.getTicketPrice();
	}

}

// si es niño y estudiante que de otro precio

// utilizar el metodo printpriceDay con la KEY como parametro 
// agregar constructor a la clase TestersParkticket que tenga un descuento especial 
// generar un metodo statico en ticketDesk que sume el total de los tickets e imprima el precio final 

