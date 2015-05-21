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
    private String picture;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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

    @Override
    public String toString() {
        return "Guitar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", body='" + body + '\'' +
                ", scale=" + scale +
                ", neck='" + neck + '\'' +
                ", fingerboard='" + fingerboard + '\'' +
                ", picture='" + picture + '\'' +
                ", manufacturer=" + manufacturer +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guitar guitar = (Guitar) o;

        if (id != guitar.id) return false;
        if (Double.compare(guitar.price, price) != 0) return false;
        if (Double.compare(guitar.scale, scale) != 0) return false;
        if (name != null ? !name.equals(guitar.name) : guitar.name != null) return false;
        if (body != null ? !body.equals(guitar.body) : guitar.body != null) return false;
        if (neck != null ? !neck.equals(guitar.neck) : guitar.neck != null) return false;
        if (fingerboard != null ? !fingerboard.equals(guitar.fingerboard) : guitar.fingerboard != null) return false;
        if (picture != null ? !picture.equals(guitar.picture) : guitar.picture != null) return false;
        if (manufacturer != null ? !manufacturer.equals(guitar.manufacturer) : guitar.manufacturer != null)
            return false;
        return !(category != null ? !category.equals(guitar.category) : guitar.category != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (body != null ? body.hashCode() : 0);
        temp = Double.doubleToLongBits(scale);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (neck != null ? neck.hashCode() : 0);
        result = 31 * result + (fingerboard != null ? fingerboard.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
