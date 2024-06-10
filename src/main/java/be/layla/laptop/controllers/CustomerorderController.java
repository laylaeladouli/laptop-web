package be.layla.laptop.controllers;

import be.layla.laptop.model.Customerorder;
import be.layla.laptop.repositories.CustomerorderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CustomerorderController {


    private final Logger logger = LoggerFactory.getLogger(CustomerorderController.class);

    @Autowired
    private CustomerorderRepository customerorderRepository;



    @GetMapping({"/orderlaptopdetails/{id}", "/orderlaptopdetails"})
    public String orderlaptopdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "orderlaptopdetails";

        Optional<Customerorder> customerorderFromDb = customerorderRepository.findById(id);

        if (customerorderFromDb.isPresent()) {
            Customerorder customerorder = customerorderFromDb.get();
            double shippingCost = 10.0;
            double totalPrice = customerorder.getLaptop().getPrice() + shippingCost;
            model.addAttribute("customerorder", customerorderFromDb.get());
            model.addAttribute("shippingCost", shippingCost);
            model.addAttribute("totalPrice", totalPrice);

        }
        return "orderlaptopdetails";
    }







}
