package model;

public class Trademark {
    private int id;
    private String title;
    private Vendor vendor;

    public Trademark(int id) {
        this.id = id;
    }

    public Trademark(String title) {
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

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return title;
    }
}
