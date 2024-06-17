package be.layla.laptop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;

@Entity
public class Customer {

    @Id
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String city;


    @OneToMany(mappedBy = "customer")
    private Collection<Customerorder> customerorders;


    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Collection<Customerorder> getCustomerorders() {
        return customerorders;
    }

    public void setCustomerorders(Collection<Customerorder> customerorders) {
        this.customerorders = customerorders;
    }
}
