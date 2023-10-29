package Administartor;
import Car.*;
abstract class absAdministrator{
    abstract public double calCost(int rentalPeriod,double carPrice);
    abstract public void printCost(int rentalPeriod,double carPrice);
}
public class Accounts extends absAdministrator {
    double cost;

    double damageCost;
//    int rentalPeriod;
//    double carPrice;

    public double calCost(int rentalPeriod,double carPrice){
        double tax=0.05;
        cost=carPrice*rentalPeriod;
        cost=cost*tax+cost;
        return cost;
    }
    public void printCost(int rentalPeriod,double carPrice){
        double tax=0.05;
        System.out.println("Car Price: "+carPrice);
        System.out.println("Taxes involved: "+tax*100+"%");
        System.out.println("Total price: "+calCost(rentalPeriod,carPrice));
    }
}
