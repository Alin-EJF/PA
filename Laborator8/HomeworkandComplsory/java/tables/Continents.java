package tables;

public class Continents {
    private int id;
    private String name;

    public Continents(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Continents(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Continents{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
