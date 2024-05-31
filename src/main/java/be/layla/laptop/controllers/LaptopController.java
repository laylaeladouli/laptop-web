package be.layla.laptop.controllers;

import be.layla.laptop.model.Laptop;
import be.layla.laptop.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class LaptopController {

    @Autowired
    private LaptopRepository laptopRepository;


    @GetMapping({"/laptop"})
    public String laptop (Model model) {
        model.addAttribute("laptops", laptopRepository.findAll());
        return "laptop";
    }

    @GetMapping({"/laptopdetails/{id}", "/laptopdetails"})
    public String laptopdetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "laptopdetails";

        Optional<Laptop> laptopFromDb = laptopRepository.findById(id);
        //noinspection OptionalIsPresent
        if (laptopFromDb.isPresent()) {
            Optional<Laptop> prevLaptopFromDb = laptopRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevLaptopFromDb.isEmpty())
                prevLaptopFromDb = laptopRepository.findFirstByOrderByIdDesc();
            Optional<Laptop> nextLaptopFromDb = laptopRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextLaptopFromDb.isEmpty())
                nextLaptopFromDb = laptopRepository.findFirstByOrderByIdAsc();

            model.addAttribute("laptop", laptopFromDb.get());
            model.addAttribute("prevId", prevLaptopFromDb.get().getId());
            model.addAttribute("nextId", nextLaptopFromDb.get().getId());
        }
        return "laptopdetails";
    }
}
