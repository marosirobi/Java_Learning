package model.interfaces;

interface FlightEnabled {

    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();
    void land();

    //preferred declaration
    void fly();
}
