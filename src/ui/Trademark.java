package ui;

import model.Vendor;

public class Trademark {
    private int id;
    private String title;
    private Vendor vendor;

    public Trademark(int id, String title, Vendor vendor) {
        this.id = id;
        this.title = title;
        this.vendor = vendor;
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
        return "Trademark{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", vendor=" + vendor +
                '}';
    }
}
