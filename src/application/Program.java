package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scan.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(scan.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(scan.next());

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: O check-ou não pode ser anterior ao check-in!");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: "+reservation);
            System.out.println();

            System.out.println("Enter data to update reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(scan.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(scan.next());
            
            String error = reservation.updateDates(checkIn,checkOut);
            
            if(error != null) {
            	System.out.println("Error in reservation: " + error);
            }
            else {
            	System.out.println("Reservation: "+ reservation);
            }

        }
        scan.close();

	}

}
