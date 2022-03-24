import java.util.*;

public class City {

    List<Street> edges = new LinkedList<>();


    public void Greedy(Street streets, Intersection intersection) {        //calculeaza un MST alegand o strada si o intersectie de inceput
        while (intersection.getStreets() != null) {  // && !visited

            intersection.setVisited(true);  //am vizitat nodul

            Greedy(Collections.min(intersection.getStreets()), bestIntersection(streets.intersections.get(0), streets.intersections.get(1)));
        }
    }

 public Intersection bestIntersection(Intersection intersection1, Intersection intersection2) {     //decide intersectia care are strazi cu lungime mai mica
        if (Collections.min(intersection1.getStreets()).getLength() < Collections.min(intersection2.getStreets()).getLength() && !intersection1.isVisited())
            return intersection1;
        else if (!intersection2.isVisited())
            return intersection2;

        return null;
    }

}
