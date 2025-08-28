package model.TreeSetChallenge;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

    class Seat implements Comparable<Seat>{

        private String seatNumber;

        private boolean reserved;

        public Seat(char row, int seatNo) {
            this.seatNumber = "%c%03d".formatted(row,seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNumber.compareTo(o.seatNumber);
        }
    }

    private String name;
    private int seatsInRow;
    private NavigableSet<Seat> seats;

    public Theatre(String name, int rows, int totalNumOfSeats) {
        this.name = name;
        this.seatsInRow = totalNumOfSeats / rows;

        seats = new TreeSet<>();
        for(int i = 0; i < totalNumOfSeats; i++){
            char rowChar = (char) (i / seatsInRow + (int) 'A');
            int seatInRow = i % seatsInRow + 1;
            seats.add(new Seat(rowChar,seatInRow));
        }
    }

    public void printSeatMap(){
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine,name);

        int index = 0;
        for(Seat s : seats){
            System.out.printf("%-8s%s",
                    s.seatNumber + (s.reserved ? "(●)" : ""),
                    (index++ + 1) % seatsInRow == 0 ? "\n" : "");
        }
        System.out.println(separatorLine);
    }

    public String reserveSeat(char row, int seat){
        Seat requestedSeat = new Seat(row,seat);
        Seat requested = seats.ceiling(requestedSeat);

        if(requested == null || !requested.seatNumber.equals(requestedSeat.seatNumber)){
            System.out.print("--> no such seat: " + requestedSeat);
            System.out.printf(": seat must be between %s and %s%n",
                    seats.first().seatNumber, seats.last().seatNumber);
        }else{
            if(!requested.reserved){
                requested.reserved = true;
                return requested.seatNumber;
            }else{
                System.out.println("Seat's already reserved.");
            }
        }
        return null;
    }
}
