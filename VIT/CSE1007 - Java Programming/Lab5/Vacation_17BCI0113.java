/*
*1. Create a class called vacation with*

Data members 
(1) Place 
(2) Date 
(3) Activities [array of elements], 
(4) Cost of each activity [array of elements]

Methods 

(1) GetMethod
(2) PrintMethod

Inherit the data members and methods to a new class called “SummerVacation” and include the data members 

(1) CourseTitle 
(2) OnlinePlatform [eg: nptel, courseera, udemey..] 
(3) Duration

Methods 

(1) GetMethod
(2) PrintMethod
(3) Calculate the total cost spent in vacation by creating static method

Define atleast two objects in main method and invoke the methods defined in the class definition.

*2. Modify the above program by defining the parent class to be an abstract class.*
*3. Make necessary changes in the program by creating an interface vacation and implement it in a class SummerVacation as given above.*
*/

import java.util.Scanner;

class Vacation_17BCI0113 {
    String place;
    String date;
    static String activities[];
    static int activityCosts[];
    static int activityIndex;

    Vacation_17BCI0113() {}

    Vacation_17BCI0113(int length) {
        activities = new String[length];
        activityCosts = new int[length];
        activityIndex = 0;
    }

    Vacation_17BCI0113(String place, String date, int cost, String activityTitle) {
        this.place = place;
        this.date = date;
        this.activities[activityIndex] = activityTitle;
        this.activityCosts[activityIndex] = cost;
        activityIndex++;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int count = 2;

        // Initialise data members with length constructor
        new Vacation_17BCI0113(10);
        SummerVacation objs[] = new SummerVacation[count];

        // Data
        String place, date, title, platform;
        int cost, duration;

        for (int i = 0; i < count; i++) {
            System.out.println("Enter course " + i + " details");

            System.out.print("Course Title: ");
            title = s.nextLine();
            System.out.print("Platform: ");
            platform = s.nextLine();
            System.out.print("Duration (days): ");
            duration = Integer.parseInt(s.nextLine());

            System.out.print("Place: ");
            place = s.nextLine();
            System.out.print("Date: ");
            date = s.nextLine();
            System.out.print("Cost: ");
            cost = Integer.parseInt(s.nextLine());

            objs[i] = new SummerVacation(place, date, cost, title, platform, duration);
            System.out.println();
        }
        System.out.println("\nTotal Cost: " + SummerVacation.getTotalCost());
    }
}

class SummerVacation extends Vacation_17BCI0113 {
    String courseTitle;
    String onlinePlatform;
    int duration;

    SummerVacation() {
        super();
    }

    SummerVacation(String place, String date, int cost, String title, String platform, int duration) {
        super(place, date, cost, title);
        this.courseTitle = title;
        this.onlinePlatform = platform;
        this.duration = duration;
    }

    static int getTotalCost() {
        int sum = 0;
        for(int i = 0; i < Vacation_17BCI0113.activityIndex; i++) {
            sum += Vacation_17BCI0113.activityCosts[i];
        }
        return sum;
    }
}