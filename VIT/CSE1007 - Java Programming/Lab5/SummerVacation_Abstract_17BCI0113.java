import java.util.Scanner;

abstract class VacationAbstract {
    String place;
    String date;
    static String activities[];
    static int activityCosts[];
    static int activityIndex;

    static void initialiseActivityData(int length) {
        activities = new String[length];
        activityCosts = new int[length];
        activityIndex = 0;
    }

    static void addActivity(int cost, String activityTitle) {
        activities[activityIndex] = activityTitle;
        activityCosts[activityIndex] = cost;
        activityIndex++;
    }
}

class SummerVacation_Abstract_17BCI0113 extends VacationAbstract {
    String courseTitle;
    String onlinePlatform;
    int duration;

    SummerVacation_Abstract_17BCI0113(String place, String date, int cost, String title, String platform, int duration) {
        this.place = place;
        this.date = date;
        this.courseTitle = title;
        this.onlinePlatform = platform;
        this.duration = duration;

        VacationAbstract.addActivity(cost, title);
    }

    static int getTotalCost() {
        int sum = 0;
        for(int i = 0; i < VacationAbstract.activityIndex; i++) {
            sum += VacationAbstract.activityCosts[i];
        }
        return sum;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int count = 2;

        // Initialise data members with length constructor
        VacationAbstract.initialiseActivityData(10);
        SummerVacation_Abstract_17BCI0113 objs[] = new SummerVacation_Abstract_17BCI0113[count];

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

            objs[i] = new SummerVacation_Abstract_17BCI0113(place, date, cost, title, platform, duration);
            System.out.println();
        }
        System.out.println("\nTotal Cost: " + SummerVacation_Abstract_17BCI0113.getTotalCost());
    }

    
}