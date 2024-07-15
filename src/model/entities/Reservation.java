package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(){
    }
    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkIn = checkin;
        this.checkOut = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime() - checkIn.getTime(); // pegar a diferença das datas em milisegundos
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public String updateDates(Date checkin, Date checkout){
    	Date now = new Date();
        if(checkIn.before(now) || checkOut.before(now)){
            return "A data de reserva nao pode ser anterior a data atual!";
        }
        if(!checkOut.after(checkIn)){
            return "O check-out não pode ser anterior ao check-in!";
        }
        this.checkIn = checkin;
        this.checkOut = checkout;
        return null;
    }
    @Override
    public String toString(){
        return "ROOM "+roomNumber+", check-in: "+ sdf.format(checkIn)+", check-out: "+sdf.format(checkOut)+", "+ duration()+" nights";
    }
}
