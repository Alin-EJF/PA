package com.company;

import java.util.ArrayList;

public class Solution {
    //vector de camere pentru a asigna fiecarui event - index camera potrivita
    public Room[] assignment;

    /**
     * constructorul default: initializarea vectorului assignment cu lungimea egala cu numarul
     * de evenimente existente
     */
    public Solution(Problem problem) {
        this.assignment = new Room[problem.events.size()];
    }


    //algoritm greedy pentru gasirea unei solutii posibile de asignare a unei sali fiecarui eveniment
    public void greedySolution(Problem problema) {

        for (Event event : problema.events) {
            for (Room room : problema.rooms) {
                int index = problema.events.indexOf(event); //salvez indexul eventului

                /**
                 *verificare daca capacitatea salii este mai mare sau egala cu numarul de participanti ai evenimentului
                 *verificare daca tipul evenimentului este identic cu tipul salii, ex C1 -Lecture Hall, L2 - Computer Lab
                 */
                if (room.capacity >= event.getSize()) {
                    if (event.getName().charAt(0) == 'C' && room instanceof LectureHall && verifyTime(problema.events, room, index)) {
                        assignment[index] = room;
                        break;
                    } else if (event.getName().charAt(0) == 'L' && room instanceof ComputerLab && verifyTime(problema.events, room, index)) {
                        assignment[index] = room;
                        break;
                    }
                }

            }
        }

        //afisarea solutiei
        for (int index = 0; index < assignment.length; index++)
            if (assignment[index] != null) {
                System.out.println(problema.events.get(index).getName() + "->" + assignment[index].getName());
            }
    }


    /**
     * metoda pentru a verifica daca sala gasita nu a fost deja asignata unui alt eveniment
     * altfel, se verifica daca intervalele de timp ale celor doua evenimente nu se suprapun
     */
    private boolean verifyTime(ArrayList<Event> events, Room room, int index) {

        Event unassignedEvent = events.get(index); //evenimentul pt care se verifica daca i se poate asigna sala

        for (int iterator = 0; iterator < events.size(); iterator++) {
            if (assignment[iterator] == room) {

                Event resolvedEvent = events.get(iterator); //eveniment ce are asignata aceeasi sala

                //evenimentul neasignat incepe in timpul evenimentului deja asignat
                if (unassignedEvent.getStart() < resolvedEvent.getEnd() && unassignedEvent.getStart() >= resolvedEvent.getStart())
                    return false;
                //evenimentul neasignat incepe inainte de evenimentul deja asignat ,dar se termina in timpul acestuia
                if (unassignedEvent.getEnd() > resolvedEvent.getStart() && unassignedEvent.getEnd() <= resolvedEvent.getEnd())
                    return false;
            }
        }
        return true;
    }


}
