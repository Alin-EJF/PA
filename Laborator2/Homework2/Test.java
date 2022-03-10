package com.company;

public class Test {
    public static void main(String[] args) {

        //crearea unui vector de evenimente
        Event[] events = new Event[5];
        events[0] = new Event("C1", 100, 8, 10);
        events[1] = new Event("C2", 100, 10, 12);
        events[2] = new Event("L1", 30, 8, 10);
        events[3] = new Event("L2", 30, 8, 10);
        events[4] = new Event("L3", 30, 10, 12);

        System.out.println("Events: ");
        for (Event i : events)
            System.out.println(i.toString());

        //crearea unui vector de camere
        Room[] rooms = new Room[4];
        rooms[0] = new ComputerLab("401", 30, "Linux");
        rooms[1] = new ComputerLab("403", 30, "Windows");
        rooms[2] = new ComputerLab("405", 30, "Windows");
        rooms[3] = new LectureHall("309", 100, true);

        System.out.println("Rooms: ");
        for (Room i : rooms)
            System.out.println(i.toString());

        //initializarea unei probleme
        Problem problema = new Problem();

        //introducerea camerelor si evenimentelor in problema
        for (Room room : rooms)
            problema.addRoom(room);
        for (Event event : events)
            problema.addEvent(event);

        //initializarea unei solutii pentru problema
        Solution solution = new Solution(problema);

        //generararea si afisarea solutiei
        solution.greedySolution(problema);

    }
}
