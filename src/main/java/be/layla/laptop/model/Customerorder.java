package be.layla.laptop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Customerorder {

    @Id
    private Integer id;
    private String paymentMethode;

    @ManyToOne(fetch = FetchType.LAZY)
    private Laptop laptop;

    public Customerorder() {
    }


    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaymentMethode() {
        return paymentMethode;
    }

    public void setPaymentMethode(String paymentMethode) {
        this.paymentMethode = paymentMethode;
    }
}
