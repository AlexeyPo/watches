package model;

public class Vendor {
    private int id;
    private String title;
    private Country country;

    public Vendor(int id, String title, Country country) {
        this.id = id;
        this.title = title;
        this.country = country;
    }

    public Vendor(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", country=" + country +
                '}';
    }
}
