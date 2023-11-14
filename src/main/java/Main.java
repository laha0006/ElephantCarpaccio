import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many items are you buying? ");
        double amount = inputInt();

        System.out.println("Item price? ");
        double itemPrice = inputInt();

        //System.out.println("Tax Rate in percent? ");
        //double taxRate = scanner.nextDouble();
        double taxRate = 0;

        while(taxRate == 0) {
            System.out.println("State Codes: UT, NV, TX, AL, CA");
            System.out.println("Input state code: ");
            //scanner.nextLine();
            String stateCode = scanner.nextLine();
            taxRate = switch(stateCode.toUpperCase()) {
                case "UT" -> 6.85;
                case "NV" -> 8;
                case "TX" -> 6.25;
                case "AL" -> 4;
                case "CA" -> 8.25;
                default -> 0;
            };
        }

        taxRate = 1 + (taxRate / 100);
        double discount = 0;
        double totalPrice = amount * itemPrice;
        if(totalPrice >= 1000 && totalPrice < 5000) {
            discount = 0.03;
        }
        if(totalPrice >= 5000 && totalPrice < 7000) {
            discount = 0.05;
        }
        if(totalPrice >= 7000 && totalPrice < 10000) {
            discount = 0.07;
        }
        if(totalPrice >= 10000 && totalPrice < 50000) {
            discount = 0.10;
        }
        if(totalPrice >= 50000 ) {
            discount = 0.15;
        }
        discount = 1-discount;
        totalPrice = totalPrice * discount;
        totalPrice = totalPrice *taxRate;


        System.out.println("Total price " + totalPrice);

    }

    public static double inputInt() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            try {
                double number = sc.nextDouble();
                sc.nextLine();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("Must be a number");
                sc.nextLine();
            }
        }
    }
}
