/*
    Create classes Students and HostelBlocks with necessary details. 
    Store the objects as collections in a File. 
    Create threads for Hostel_Incharge to allocate rooms based on cgpa. 
    If incharges are trying to allocate the same rooms,
    handle the situation using inter thread communication.
*/
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

class Student implements Serializable {
    String name;
    String regno;
    double cgpa;
    String gender;
    int preferredHostel;
    int preferredRoom;

    private static final Random r = new Random();

    Student(String regno, String name, int preferredHostel, int preferredRoom) {
        this.regno = regno;
        this.name = name;

        this.cgpa = r.nextDouble() * 10;
        this.gender = r.nextDouble() >= 0.5 ? "Male" : "Female";

        this.preferredHostel = preferredHostel;
        this.preferredRoom = preferredRoom;
    }

    @Override 
    public String toString() {
        return String.format("(%s) %s - %s: %f -> Block# %d Room #%d", regno, name, gender, cgpa, preferredHostel, preferredRoom);
    }
}

class Room implements Serializable {
    String roomNumber;
    ArrayList<Student> occupants;

    Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.occupants = new ArrayList<Student>();
    }

    synchronized void allotTo(Student s) {
        occupants.add(s);
        notify();
    }

    @Override
    public String toString() {
        List<String> occs = occupants.stream().map(s -> s.regno).collect(Collectors.toList());
        String occupantList = String.join(", ", occs);

        return String.format("Room #%s - %s", this.roomNumber, occupantList);
    }
}

class HostelBlock implements Serializable {
    String initial;
    String name;
    ArrayList<Room> rooms;

    HostelBlock(String initial, String name, int roomCount) {
        this.initial = initial;
        this.name = name;
        this.rooms = new ArrayList<Room>();

        for(int i = 0; i < roomCount; i++) {
            rooms.add(
                new Room(String.format("%04d", i+1))
            );
        }
    }

    @Override
    public String toString() {
        List<String> roomStrings = this.rooms.stream().map(r -> r.toString()).collect(Collectors.toList());
        String roomList = String.join("\n", roomStrings);

        return String.format("Hostel Block %s\nRooms:\n%s", this.initial, roomList);
    }
}

class RoomAllocation_17BCI0113 {
    ArrayList<Student> students;
    ArrayList<HostelBlock> hostels;

    private static final Random r = new Random();

    RoomAllocation_17BCI0113() {
        this.students = new ArrayList<Student>();
        this.hostels = new ArrayList<HostelBlock>();
    }

    RoomAllocation_17BCI0113(int studentCount, int hostelCount, int roomCount) {
        this();
        for(int i = 0; i < studentCount; i++) {

            int hostel = r.nextInt(hostelCount);
            int room = r.nextInt(roomCount);

            students.add(
                new Student(
                    String.format("17BCI%04d", i+1), 
                    String.format("Student%04d", i+1),
                    hostel,
                    room
                )
            );
        }

        for(int i = 0; i < hostelCount; i++) {
            hostels.add(
                new HostelBlock(
                    "" + (char)(i+65), 
                    String.format("Hostel%c", (char)(i+65)),
                    roomCount
                )
            );
        }
    }

    void writeStudentsToFile() {

    }

    public static void main(String args[]) throws Exception {
        int studentCount = 200;
        int hostelCount = 5;
        int roomCount = 5;

        RoomAllocation_17BCI0113 ra = new RoomAllocation_17BCI0113(
            studentCount, hostelCount, roomCount
        );

        ra.students.sort((s1, s2) -> {
            if(s1.cgpa > s2.cgpa) return -1;
            if(s1.cgpa < s2.cgpa) return 1;
            return 0;
        });
        // ra.students.forEach((v) -> System.out.println(v.toString()));


        // Warden 1
        Thread warden1 = new Thread(() -> {
            for(int i = 0; i < studentCount; i += 2) {
                Student s = ra.students.get(i);
                
                HostelBlock prefHostel = ra.hostels.get(s.preferredHostel);
                Room prefRoom = prefHostel.rooms.get(s.preferredRoom);

                prefRoom.allotTo(s);
            }
        });

        // Warden 2
        Thread warden2 = new Thread(() -> {
            for(int i = 1; i < studentCount; i += 2) {
                Student s = ra.students.get(i);

                HostelBlock prefHostel = ra.hostels.get(s.preferredHostel);
                Room prefRoom = prefHostel.rooms.get(s.preferredRoom);

                prefRoom.allotTo(s);
            }
        });

        warden1.start();
        warden2.start();

        warden1.join();
        warden2.join();

        ra.hostels.forEach(h -> System.out.println(h.toString()));
    }
}