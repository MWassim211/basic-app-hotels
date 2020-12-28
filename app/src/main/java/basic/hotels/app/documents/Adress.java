package basic.hotels.app.documents;

public class Adress {
    private String city;
    private String country;


    public Adress() {
    }

    public Adress(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
