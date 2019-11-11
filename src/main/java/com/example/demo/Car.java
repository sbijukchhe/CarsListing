package com.example.demo;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;
    private String make;
    private String model;
    private String year;
    private String color;
    private double MSRP;
    private String headshot;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Categories categories;

    // No-arg Constructor
    public Car() {
    }

    // Constructor with arguments

    public Car(String make, String model, String year, String color, double MSRP, String headshot, Categories categories) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.MSRP = MSRP;
        this.headshot = headshot;
        this.categories = categories;
    }


    // getters and setters methods

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMSRP() {
        return MSRP;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }
}
