package be.thomasmore.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Beverage {
    @Id
    private int id;
    private String name;
    private String type;
    private double price;
    private boolean suggested;

    public Beverage() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSuggested() {
        return suggested;
    }

    public void setSuggested(boolean suggested) {
        this.suggested = suggested;
    }
}
