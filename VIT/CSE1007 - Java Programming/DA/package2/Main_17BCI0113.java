package package2;

import java.util.Scanner;
import package1.*;

class Main_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = 3;

        Travel_17BCI0113 intl[] = new InternationalTravel_17BCI0113[n];
        Travel_17BCI0113 natl[] = new NationalTravel_17BCI0113[n];

        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter details for International Travel " + (i+1));
            System.out.print("From Place: ");
            String fromPlace = s.nextLine();
            
            System.out.print("From Country: ");
            String fromCountry = s.nextLine();
            
            System.out.print("To Place: ");
            String toPlace = s.nextLine();

            System.out.print("To Country: ");
            String toCountry = s.nextLine();

            System.out.print("Year: ");
            int year = Integer.parseInt(s.nextLine());

            System.out.print("Cost: ");
            int cost = Integer.parseInt(s.nextLine());

            intl[i] = new InternationalTravel_17BCI0113(fromPlace, fromCountry, toPlace, toCountry, cost, year);
        }

        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter details for National Travel " + (i+1));
            System.out.print("From Place: ");
            String fromPlace = s.nextLine();
            
            System.out.print("From State: ");
            String fromState = s.nextLine();
            
            System.out.print("To Place: ");
            String toPlace = s.nextLine();

            System.out.print("To State: ");
            String toState = s.nextLine();

            System.out.print("Year: ");
            int year = Integer.parseInt(s.nextLine());

            System.out.print("Cost: ");
            int cost = Integer.parseInt(s.nextLine());

            natl[i] = new NationalTravel_17BCI0113(fromPlace, fromState, toPlace, toState, cost, year);
        }

        String future = getNextTravelInfo();

        System.out.println("\nDetails: ");
        for(int i = 0; i < n; i++) {
            System.out.println("Intl " + (i+1) + ":" + intl[i].getDetails());
        }

        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.println("Natl " + (i+1) + ":"  + natl[i].getDetails());
        }

        System.out.println("\nFuture:\n" + future);
    }

    static String getNextTravelInfo() {
        Scanner s = new Scanner(System.in);
        int n = 3;
        String data = "";
        for(int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Future Trip " + (i + 1));
            System.out.print("Place: ");
            data += s.nextLine();
            System.out.print("Year: ");
            data += String.format("(%d)\n", Integer.parseInt(s.nextLine()));
        }

        return data;
    }
}