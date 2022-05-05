package tables;

public class Cities {
    private int id;
    private String country;
    private String name;
    private float latitude;
    private float longitude;
    private String capital;

    public Cities(int id, String country, String name, float latitude, float longitude, String capital) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capital = capital;
    }

    public Cities(String country, String name, float latitude, float longitude, String capital) {
        this.country = country;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.capital = capital;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String isCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getDistanceTo(Cities destination) {            // distanta intre orase
        double latitudeInRadians = Math.toRadians(this.latitude);
        double longitudeInRadians = Math.toRadians(this.longitude);
        double destinationLatitudeInRadians = Math.toRadians(destination.getLatitude());
        double destinationLongitudeInRadians = Math.toRadians(destination.getLongitude());

        double distanceLatitude = destinationLatitudeInRadians - latitudeInRadians;
        double distanceLongitude = destinationLongitudeInRadians - longitudeInRadians;

        double haversineFormula = Math.pow(Math.sin(distanceLatitude / 2), 2) + Math.cos(latitudeInRadians) * Math.cos(destinationLatitudeInRadians) * Math.pow(Math.sin(distanceLongitude / 2),2);

        double haversineFormulaSqrt = 2 * Math.asin(Math.sqrt(haversineFormula));

        double radiusOdEarthInKilometers = 6371;

        return haversineFormulaSqrt * radiusOdEarthInKilometers;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", capital=" + capital +
                '}';
    }
}
