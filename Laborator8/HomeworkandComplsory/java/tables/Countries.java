package tables;

public class Countries {
    private int id;
    private String name;
    private String code;
    private String continent;

    public Countries(int id, String name, String code, String continent) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
    }

    //TESTING AUTO_INCREMENT
    public Countries( String name, String code, String continent) {

        this.code = code;
        this.name = name;
        this.continent = continent;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
