package Availability;

public class Availability{
    int rentalPeriod;
    double destinationDistance;
    public Availability(int rentalPeriod,double destinationDistance){
        this.rentalPeriod=rentalPeriod;
        this.destinationDistance=destinationDistance;
    }
    public boolean getAvailability(){
        if(rentalPeriod>10 || destinationDistance>1000){

            return false;
        }
        else {
            return true;
        }
    }
}

