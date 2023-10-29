import Availability.*;
import Car.*;

import java.io.*;
import java.util.*;
import Administartor.*;
import Customer.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) {

        //creating a file
        File myFile=new File("carInput.txt");
        try{
            myFile.createNewFile();
        }catch(IOException e){
            System.out.println("Sorry!File cant be created.");
            e.printStackTrace();
        }

        //writing in a file
//        try{
//            FileWriter fileWriter=new FileWriter("carInput.txt");
//            fileWriter.write("gthjkl");
//            fileWriter.close();
//        }
//        catch(IOException e){
//            e.printStackTrace();
//        }

        //reading from a file
//        try{
//            Scanner sc=new Scanner(myFile);
//            while(sc.hasNextLine()){
//                String line=sc.nextLine();
//                System.out.println(line);
//            }
//            sc.close();
//        }
//        catch(FileNotFoundException e){
//            e.printStackTrace();
//        }


        String filePath = "carInput.txt";
        String Car1_1 = "",Car2_1 = "",Car3_1 = "";
        String Car1_2 = "",Car2_2 = "",Car3_2 = "";
        double Car1_3 = 0.0,Car2_3 = 0.0,Car3_3 = 0.0;
        int Car1_4 = 0,Car2_4 = 0,Car3_4 = 0;
        try {
            Path path = Paths.get(filePath);
            Car1_1 = Files.readAllLines(path, StandardCharsets.UTF_8).get(0);
            Car1_2 = Files.readAllLines(path, StandardCharsets.UTF_8).get(1);
            String  str1= Files.readAllLines(path, StandardCharsets.UTF_8).get(2);
            Car1_3 = Double.parseDouble(str1);
            String  str2= Files.readAllLines(path, StandardCharsets.UTF_8).get(3);
            Car1_4 = Integer.parseInt(str2);

            Car2_1 = Files.readAllLines(path, StandardCharsets.UTF_8).get(4);
            Car2_2 = Files.readAllLines(path, StandardCharsets.UTF_8).get(5);
            String  str3= Files.readAllLines(path, StandardCharsets.UTF_8).get(6);
            Car2_3 = Double.parseDouble(str3);
            String  str4= Files.readAllLines(path, StandardCharsets.UTF_8).get(7);
            Car2_4 = Integer.parseInt(str4);

            Car3_1 = Files.readAllLines(path, StandardCharsets.UTF_8).get(8);
            Car3_2 = Files.readAllLines(path, StandardCharsets.UTF_8).get(9);
            String  str5= Files.readAllLines(path, StandardCharsets.UTF_8).get(10);
            Car3_3 = Double.parseDouble(str5);
            String  str6= Files.readAllLines(path, StandardCharsets.UTF_8).get(11);
            Car3_4 = Integer.parseInt(str6);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Car car1=new Car(Car1_1,Car1_2, Car1_3, Car1_4);
        Car car2=new Car(Car2_1,Car2_2, Car2_3, Car2_4);
        Car car3=new Car(Car3_1,Car3_2, Car3_3, Car3_4);


        System.out.println("\nHello and welcome to our rental services!\n");
//        Car car1=new Car("#C12P1","Fortuner", 4000, 7);
//        Car car2=new Car("#C12P2","Audi", 7000, 5);
//        Car car3=new Car("#C12P3","BMW", 10000, 2);

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your name:");
        String customerName=sc.nextLine();
        System.out.println("Enter your Aadhar no.:");
        String customerId=sc.nextLine();
        System.out.println("Enter your age:");
        int customerAge=sc.nextInt();

        System.out.println("\nCars Available:\n");
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
            System.out.println("\n");

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
        System.out.println((input == 'Y' || input == 'y') ? "\nCongratulations!! Confirmation done." : "Sorry! Confirmation interrupted.");

    }
}
