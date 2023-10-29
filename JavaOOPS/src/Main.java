import Availability.*;
import Car.*;
import java.util.*;
import Administartor.*;
import Customer.*;

public class Main {
    public static void main(String[] args) {



        System.out.println("Hello and welcome!\n");
        Car car1=new Car("#C12P1","Fortuner", 4000, 7);
        Car car2=new Car("#C12P2","Renault Kwid", 2000, 5);
        Car car3=new Car("#C12P3","BMW", 10000, 2);

        Scanner sc=new Scanner(System.in);
        System.out.println("Name:");
        String customerName=sc.nextLine();
        System.out.println("Id:");
        String customerId=sc.nextLine();
        System.out.println("Age:");
        int customerAge=sc.nextInt();

        System.out.println("Cars Availaible:\n");
        System.out.println("➥\t"+car1.getCarId()+"\n\t"+car1.getCarModelName()+"\n\t"+car1.getCarPrice()+"\n\t"+car1.getCarSeat()+"\n\n");
        System.out.println("➥\t"+car2.getCarId()+"\n\t"+car2.getCarModelName()+"\n\t"+car2.getCarPrice()+"\n\t"+car2.getCarSeat()+"\n\n");
        System.out.println("➥\t"+car3.getCarId()+"\n\t"+car3.getCarModelName()+"\n\t"+car3.getCarPrice()+"\n\t"+car3.getCarSeat()+"\n\n");


        boolean carIdInput=true;
        while(carIdInput){
            System.out.println("Enter carId:");
            String enteredCarId = sc.next();
            System.out.println("Enter rental Days:");
            int rentalDays=sc.nextInt();
            System.out.println("Enter destination distance:");
            double destinationDistance=sc.nextDouble();

            Availability carAvail=new Availability(rentalDays,destinationDistance);
            carAvail.getAvailability();
            if(!carAvail.getAvailability()){
                System.out.println("Car isn't available.");
                return;
            }
            double carPrice1=car1.getCarPrice();
            double carPrice2=car2.getCarPrice();
            double carPrice3=car3.getCarPrice();

            if(enteredCarId.equals(car1.getCarId())){
                Accounts acc1=new Accounts();
                acc1.calCost(rentalDays,carPrice1 );
                acc1.printCost(rentalDays,carPrice1 );
                carIdInput=false;
            }
            else if(enteredCarId.equals(car2.getCarId())){
                Accounts acc2=new Accounts();
                acc2.calCost(rentalDays,carPrice2 );
                acc2.printCost(rentalDays,carPrice2 );
                carIdInput=false;
            }
            else if(enteredCarId.equals(car3.getCarId())){
                Accounts acc3=new Accounts();
                acc3.calCost(rentalDays,carPrice3 );
                acc3.printCost(rentalDays,carPrice3 );
                carIdInput=false;
            }
            else{
                System.out.println("Please enter a valid Id");
            }
        }


        System.out.println("Do you want to rent?(Y/N)");
        char input=sc.next().charAt(0);
        System.out.println((input == 'Y' || input == 'y') ? "Confirmation done!!" : "Sorry! Confirmation interrupted.");

    }
}
