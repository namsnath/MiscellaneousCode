package package1;

public class Travel_17BCI0113 {
    String fromPlace;
    String toPlace;
    int cost;
    int yearOfTravel;

    public String getDetails() {
        return String.format("%s-%s (%d) => Rs %d", fromPlace, toPlace, yearOfTravel, cost);
    }
}