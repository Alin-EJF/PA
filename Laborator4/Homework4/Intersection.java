import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Intersection {
    private String name;
    private boolean visited;
    private List<Street> streets = new ArrayList<>();


    public Intersection(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /* adaug lista de strazi al fiecarui nod (interesectie) */

    public void setStreets(Street... Streets) {
        Collections.addAll(streets, Streets);
    }

    public List<Street> getStreets() {
        return streets;
    }

    public int getStreetsSize() {
        return streets.size();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Intersection)) return false;
        Intersection that = (Intersection) o;
        return Objects.equals(getName(), that.getName());
    }


    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }



}
