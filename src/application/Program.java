package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
		    System.out.print("Room number: ");
		    int number = scan.nextInt();
		    System.out.print("Check-in date (dd/mm/yyyy): ");
		    Date checkIn = sdf.parse(scan.next());
		    System.out.print("Check-out date (dd/mm/yyyy): ");
		    Date checkOut = sdf.parse(scan.next());
	
	        Reservation reservation = new Reservation(number, checkIn, checkOut);
	        System.out.println("Reservation: "+reservation);
	        System.out.println();
	
	        System.out.println("Enter data to update reservation: ");
	        System.out.print("Check-in date (dd/mm/yyyy): ");
	        checkIn = sdf.parse(scan.next());
	        System.out.print("Check-out date (dd/mm/yyyy): ");
	        checkOut = sdf.parse(scan.next());
	        
	        reservation.updateDates(checkIn,checkOut);
	
	        System.out.println("Reservation: "+ reservation);
        }
        catch (ParseException e) {
			System.out.println("Invalid date format!");
		}
        catch(DomainExceptions e) {
        	System.out.println("Error in reservation: " + e.getMessage());
        }
        catch(RuntimeException e) {
        	System.out.println("Unexpected Error!");
        }
        scan.close();

	}
}
