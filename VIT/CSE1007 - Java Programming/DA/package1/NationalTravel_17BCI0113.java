package package1;

import package1.Travel_17BCI0113;

public class NationalTravel_17BCI0113 extends Travel_17BCI0113 {
    String fromState;
    String toState;

    public NationalTravel_17BCI0113(String fromPlace, String fromState, String toPlace, String toState, int cost, int year) {
        super.fromPlace = fromPlace;
        this.fromState = fromState;

        super.toPlace = toPlace;
        this.toState = toState;

        super.cost = cost;
        super.yearOfTravel = year;
    }

    public String getDetails() {
        return String.format("%s(%s)-%s(%s) (%d) => Rs %d", fromPlace, fromState, toPlace, toState, yearOfTravel, cost);
    }
}