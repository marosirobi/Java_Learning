package model.challenge2;

public class Printer {

    private int tonerLevel, pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel >= 0 && tonerLevel <= 100) ? tonerLevel : -1;
        pagesPrinted = 0;
        this.duplex = duplex;
    }



    public int addToner(int tonerAmount){
        if(tonerAmount > 100 || tonerAmount <= 0){
            return -1;
        }
        int tempAmount = tonerAmount + tonerLevel;
        if(tempAmount > 100 || tempAmount < 0){
            return -1;
        }

        tonerLevel += tonerAmount;
        return  tonerLevel;
    }



    public int printPages(int pages){
        int jobPages = (duplex) ? (pages / 2) + (pages % 2) : pages;
        pagesPrinted += jobPages;
        return jobPages;
    }

    public int getPagesPrinted(){
        return pagesPrinted;
    }
}
