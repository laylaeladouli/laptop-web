package be.layla.laptop.controllers;


import be.layla.laptop.model.Customer;
import be.layla.laptop.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




import java.util.Optional;

@Controller
public class CustomerController {


    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping({"/customer/{id}", "/customer"})
    public String customer(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "customer";
        Optional<Customer> customerfromdb = customerRepository.findById(id);
        model.addAttribute("customer", customerfromdb.get());

        return "customer";
    }

}
