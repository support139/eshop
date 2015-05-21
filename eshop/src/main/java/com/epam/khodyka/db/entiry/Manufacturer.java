package com.epam.khodyka.db.entiry;

/**
 * Created by Andrii_Khodyka on 5/7/2015.
 */
public class Manufacturer {
    private int id;
    private String manufacturer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (id != that.id) return false;
        return !(manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
