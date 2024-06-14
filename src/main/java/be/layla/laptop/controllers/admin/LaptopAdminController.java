package be.layla.laptop.controllers.admin;

import be.layla.laptop.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class LaptopAdminController {


    private static final Logger logger = LoggerFactory.getLogger(LaptopAdminController.class);

    @Autowired
    private LaptopRepository laptopRepository;
    private Model model;
    private int id;


    @GetMapping("/laptopedit/{id}")
    public String laptopEdit(Model model, @PathVariable(required = false) Integer id) {

        logger.info("laptopedit " + id);
        model.addAttribute("laptops", laptopRepository.findAll());
        return "admin/laptopedit";
    }




}
