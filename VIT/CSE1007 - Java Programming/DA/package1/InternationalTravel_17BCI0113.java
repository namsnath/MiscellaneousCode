package package1;

import package1.Travel_17BCI0113;

public class InternationalTravel_17BCI0113 extends Travel_17BCI0113 {
    String fromCountry;
    String toCountry;

    public InternationalTravel_17BCI0113(String fromPlace, String fromCountry, String toPlace, String toCountry, int cost, int year) {
        super.fromPlace = fromPlace;
        this.fromCountry = fromCountry;

        super.toPlace = toPlace;
        this.toCountry = toCountry;

        super.cost = cost;
        super.yearOfTravel = year;
    }

    public String getDetails() {
        return String.format("%s(%s)-%s(%s) (%d) => Rs %d", fromPlace, fromCountry, toPlace, toCountry, yearOfTravel, cost);
    }
}