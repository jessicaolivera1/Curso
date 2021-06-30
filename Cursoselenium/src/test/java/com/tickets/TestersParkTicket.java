package com.tickets;

public class TestersParkTicket extends TicketsParks {
	
	
	double adultTicket;
	double childTicket;
	double studentticket;
	boolean student = false;
	String priceDay;
	String park;
	int age;
	double studentChild;
	double specialDiscount=0;
	
	// constructor 
	public TestersParkTicket (double price,boolean student,int edad) {
		super ();
		this.adultTicket=price;
		this.childTicket=price* (0.85);
		this.studentticket=price *(0.6);
		this.student=student;
		this.priceDay="precio día regular";
		this.park="Testers Park";
		this.age=edad;
		this.studentChild=price*(0.4);//6
		
		
	}
	
	// segundo constructor 
	
	public TestersParkTicket (double price, double specialDiscount) {
		super ();
		this.park=" Testers Park";
		this.priceDay=" Descuento día especial";
		this.specialDiscount=price-specialDiscount;
	}

	// encapsulacion
	
		private void setPriceDay(String priceDay) {
			this.priceDay=priceDay;
			
		}
		
		
		private String getPriceDay(){
			return priceDay;
		}
		@Override
		public double getTicketPrice() {
			// TODO Auto-generated method stub
			
			double priceTicket;
			
			if (specialDiscount>0) {
				
				priceTicket=specialDiscount;

				System.out.println("Precio por día de niño todos los boletos a "+specialDiscount);

			} else {
				if (age>=18 && !student) {
					priceTicket=adultTicket;
					System.out.println("precio adulto: $ " +adultTicket );
				} else if ( age>=18 && student) {

					priceTicket=studentticket;
					System.out.println("precio Estudiante: $ " +studentticket );
				} else if (age<18  && student) {

					System.out.println("precio niño estudiante $ "+  studentChild);

					priceTicket=studentChild;

				} else {
					priceTicket=childTicket;
					System.out.println("precio niño: $ " +childTicket );
				}
			}

			return priceTicket;
		}

		@Override
		public void printPriceDay() {
			// TODO Auto-generated method stub
			
			System.out.println(welcomeMessageString()+ park +getPriceDay());
			
		}
		
		@Override
		
		public void printPriceDay(String authkey, String priceDay) {
			setPriceDay(priceDay);
			
			System.out.println(welcomeMessageString()+ park +getPriceDay());
			
			
		}


}
