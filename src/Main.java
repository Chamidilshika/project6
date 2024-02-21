
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String option;
        Garage garage = new Garage();

        System.out.println("------------------------------CAR PARKING GARAGE SYSTEM-------------------------\n");
        do {
            System.out.println("Enter 'a' for arrival or 'd' for departure : ");
            System.out.println("Enter 'b' for Display Cars that park in Garage : ");
            System.out.println("Enter 'c' for Find the Car : ");
            System.out.println("Enter 'e' for Exit : ");
            System.out.print("\nEnter Your Option : ");
            option = sc.next();
            System.out.println("");
            switch (option){
                case "a":
                    System.out.print("Enter Your Car's License Plate Number : ");
                    String licensePlate = sc.next();
                    garage.arriveCar(licensePlate);

                    break;

                case "d":
                    System.out.print("Enter Your Car's License Plate Number : ");
                    licensePlate = sc.next();
                    garage.departCar(licensePlate);

                    break;

                case "b":
                    garage.displaycars();

                    break;

                case "c":
                    System.out.print("Enter Your Car's License Plate Number : ");
                    licensePlate = sc.next();
                    garage.findCarPosition(licensePlate);

                    break;

                case "e":
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid Option!.Please try Again!");

                    break;
            }

        } while (option!="e");
    }
}