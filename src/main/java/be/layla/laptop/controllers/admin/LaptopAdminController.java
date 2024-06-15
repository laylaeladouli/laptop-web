package be.layla.laptop.controllers.admin;

import be.layla.laptop.model.Laptop;
import be.layla.laptop.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/admin")
@Controller
public class LaptopAdminController {


    private static final Logger logger = LoggerFactory.getLogger(LaptopAdminController.class);

    @Autowired
    private LaptopRepository laptopRepository;

    @ModelAttribute("laptop")
    public Laptop findLaptop(@PathVariable(required = false) Integer id) {
        logger.info("findLaptop " + id);
        if (id == null) return new Laptop();
        Optional<Laptop> optionalLaptop = laptopRepository.findById(id);
        if (optionalLaptop.isPresent())
            return optionalLaptop.get();
        return null;
    }


    @GetMapping("/laptopedit/{id}")
    public String laptopEdit(Model model, @PathVariable(required = false) Integer id) {
        logger.info("laptopedit " + id);
        model.addAttribute("laptops", laptopRepository.findAll());
        return "admin/laptopedit";
    }


    @PostMapping("/laptopedit/{id}")
    public String laptopEditPost(@PathVariable Integer id, Laptop laptop){

        logger.info("laptopEditPost" + id + " -- new name=" + laptop.getBrandName());
        laptopRepository.save(laptop);
        return "redirect:/laptopedit/" + id;
    }
}
