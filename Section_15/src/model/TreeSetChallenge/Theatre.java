package model.TreeSetChallenge;

import java.util.NavigableSet;
import java.util.Set;
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

    private boolean validate(int count, char first, char last, int min, int max){
        boolean result = (min > 0 || seatsInRow >= count || (max - min + 1) >= count);
        result = result && seats.contains(new Seat(first,min));
        if(!result){
            System.out.printf("Invalid! %1$d seats between %2$c[%3$d-%4$d]-%5$c[%3$d-%4$d] Try again", count,first,min,max,last);
            System.out.printf(": Seats must be between %s and %s%n",seats.first().seatNumber, seats.last().seatNumber);
        }
        return result;
    }

    public Set<Seat> reserveSeats(int count, char minRow, char maxRow,
                                  int minSeat, int maxSeat){

        char lastValid = seats.last().seatNumber.charAt(0);
        maxRow = (maxRow < lastValid) ? maxRow : lastValid;
        if(!validate(count, minRow, maxRow, minSeat, maxSeat)){
            return null;
        }
        NavigableSet<Seat> selected = null;

        for(char letter = minRow; letter <= maxRow; letter++){

            NavigableSet<Seat> contiguous = seats.subSet(
                    new Seat(letter, minSeat),true,
                    new Seat(letter, maxSeat),true);

            int index = 0;
            Seat first = null;
            for(Seat current : contiguous){
                if(current.reserved){
                    index = 0;
                    continue;
                }
                first = (index == 0) ? current : first;
                if(++index == count){
                    selected = contiguous.subSet(first, true, current, true);
                    break;
                }
            }

            if(selected != null){
                break;
            }
        }
        Set<Seat> reservedSeats = null;
        if(selected != null){
            selected.forEach(s -> s.reserved = true);
            reservedSeats = new TreeSet<>(selected);
        }
        return reservedSeats;
    }
}
