import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Street implements Comparable<Street> {

    private String name;
    private int length;
    List<Intersection> intersections= new ArrayList<>();   //retin intersectiile de la ambele capete ale strazii


    public Street(String name, int length, List<Intersection> intersections) {
        this.name = name;
        this.length = length;
        this.intersections = intersections;
    }

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public boolean joinsThree(List<Intersection> intersections){   //vede daca nodurile de la capetele strazilor, unesc cel putin 3 strazi
            for(Intersection I: intersections)
                if(I.getStreetsSize()>3)
                    return true;
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<Intersection> getIntersections() {
        return intersections;
    }

    public void setIntersections(List<Intersection> intersections) {
        this.intersections = intersections;
    }

    @Override
    public int compareTo(Street other) {
        if (other == null) throw new NullPointerException();
        return (this.length - other.length);
    }


    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}
