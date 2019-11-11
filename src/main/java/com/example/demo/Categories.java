package com.example.demo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    private String categoryName;
//    private String sedan;
//    private String SUV;
//    private String miniVan;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Set<Car> cars;

    // No-arg Constructor
    public Categories() {
    }

    // Constructor with arguments


    public Categories(String categoryName, Set<Car> cars) {
        this.categoryName = categoryName;
        this.cars = cars;
    }

    // getters and setters methods

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
