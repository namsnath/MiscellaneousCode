import java.util.Scanner;

class Registration_17BCI0113 {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        Course courses[] = new Course[3];
        Student students[] = new Student[3];

        for(int i = 0; i < 3; i++) {
            String code, title, venue, slot;
            System.out.print("Enter Course " + i + " Code: ");
            code = s.nextLine();

            System.out.print("Enter Course " + i + " Title: ");
            title = s.nextLine();

            System.out.print("Enter Course " + i + " Venue: ");
            venue = s.nextLine();

            System.out.print("Enter Course " + i + " Slot: ");
            slot = s.nextLine();
            courses[i] = new Course(code, title, venue, slot);
            System.out.println();
        }

        System.out.println();
        for(int i = 0; i < 3; i++) {
            String regno, name;
            System.out.print("Enter Student " + i + " RegNo: ");
            regno = s.nextLine();

            System.out.print("Enter Student " + i + " Name: ");
            name = s.nextLine();
            students[i] = new Student(regno, name);
            System.out.println();
        }

        System.out.println("\n\nCourses:");
        for(int i = 0; i < 3; i++) {
            System.out.println(courses[i].getObjectString());
        }

        System.out.println("\n\nStudents:");
        for(int i = 0; i < 3; i++) {
            System.out.println(students[i].getObjectString());
        }
    }
}

class Course {
    private String code;
    private String title;
    private String venue;
    private String slot;

    Course() {}
    
    Course(String code, String title, String venue, String slot) {
        this.code = code;
        this.title = title;
        this.venue = venue;
        this.slot = slot;
    }

    String getCode() {
        return this.code;
    }

    void setCode(String code) {
        this.code = code;
    }

    String getTitle() {
        return this.title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getVenue() {
        return this.venue;
    }

    void setVenue(String venue) {
        this.venue = venue;
    }

    String getSlot() {
        return this.slot;
    }

    void setSlot(String slot) {
        this.slot = slot;
    }

    String getObjectString() {
        return String.format("%s - %s - %s - %s", code, title, venue, slot);
    }
}

class Student {
    private String regno;
    private String name;

    Student() {}

    Student(String regno, String name) {
        this.regno = regno;
        this.name = name;
    }

    String getRegno() {
        return this.regno;
    }

    void setRegno(String regno) {
        this.regno = regno;
    }

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }


    String getObjectString() {
        return String.format("%s - %s", regno, name);
    }
}