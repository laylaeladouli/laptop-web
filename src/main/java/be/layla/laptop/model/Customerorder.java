package be.layla.laptop.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Customerorder {

    @Id
    private Integer id;
    private String paymentMethod;


    @ManyToOne(fetch = FetchType.LAZY)
    private Laptop laptop;

    @OneToMany(mappedBy = "customerorder")
    private Collection<Accessorie> accessories;
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;



    public Customerorder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Laptop getLaptop() {
        return laptop;
    }
    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Collection<Accessorie> getAccessories() {
        return accessories;
    }

    public void setAccessories(Collection<Accessorie> accessories) {
        this.accessories = accessories;
    }
}
