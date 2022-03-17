public class Street implements Comparable<Street> {

    private String name;
    private int length;
    private Intersection source;
    private Intersection destination;

    public Street(String name, int length) {
        this.name = name;
        this.length = length;
    }


    @Override
    public int compareTo(Street other) {
        if (other == null ) throw new NullPointerException();
        return (this.length - other.length);
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
}
