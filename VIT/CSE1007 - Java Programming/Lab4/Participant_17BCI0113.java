import java.util.Scanner;

class Participant_17BCI0113 {
    String name;
    String phno;
    String branch;
    String university;
    String result;

    String[] resultClassification = {"L1", "L2", "L3", "L4", "L5"};

    public static void main(String args[]) {
        Participant_17BCI0113 p[] = new Participant_17BCI0113[3];
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Participant " + i + " details:");
            System.out.print("Name: ");
            String name = s.nextLine();

            System.out.print("Phone: ");
            String phone = s.nextLine();

            System.out.print("Branch: ");
            String branch = s.nextLine();

            System.out.print("University: ");
            String univ = s.nextLine();

            System.out.print("Result: ");
            String res = s.nextLine();
            
            p[i] = new Participant_17BCI0113(name, phone, branch, univ, res);
            System.out.println();
        }

        System.out.println("\n\n");
        for (int i = 0; i < 3; i++) {
            System.out.println("Participant " + i + ": ");
            System.out.println("Phone: " + p[i].phno);
            System.out.println("University: " + p[i].university);
            System.out.println("Branch: " + p[i].branch);
            System.out.println("Result: " + p[i].result);
            System.out.println(Participant_17BCI0113.getResultString(p[i].result) + "\n");
        }
    }

    Participant_17BCI0113(String name, String phno, String branch, String univ, String result) {
        this.name = name;
        this.phno = phno;
        this.branch = branch;
        this.university = univ;
        this.result = result;
    }

    static String getResultString(String result) {
        switch (result) {
            case "L1": return "Congrats! Selected for FTI and FTE";
            case "L2": ;
            case "L3": return "Congrats! Selected for FTI, FTE can be offered based on performance";
            case "L4": ;
            case "L5": return "Congrats! Selected for part-time Internship for 21 days";
            default: return "";
        }
    }
}