package com.epam.khodyka.db.entiry;

/**
 * Created by Andrii_Khodyka on 5/6/2015.
 */
public class Guitar {
    private int id;
    private String name;
    private double price;
    private String body;
    private double scale;
    private String neck;
    private String fingerboard;
    private Manufacturer manufacturer;
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public double getScale() {
        return scale;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getFingerboard() {
        return fingerboard;
    }

    public void setFingerboard(String fingerboard) {
        this.fingerboard = fingerboard;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
