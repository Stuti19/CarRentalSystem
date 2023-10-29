package Car;

abstract class absCar{
    abstract public String getCarId();
    abstract public String getCarModelName();
    abstract public double getCarPrice();
    abstract public int getCarSeat();
}
public class Car extends absCar {
    String carId;
    String carModelName;
    double carPrice;
    int carSeat;

    public Car(String carId, String carModelName,double carPrice,int carSeat){
        this.carId=carId;
        this.carModelName=carModelName;
        this.carPrice=carPrice;
        this.carSeat=carSeat;
    }

    public String getCarId(){
        return carId;
    }
    public String getCarModelName(){
        return carModelName;
    }
    public double getCarPrice(){
        return carPrice;
    }
    public int getCarSeat(){
        return carSeat;
    }

}
