package be.layla.laptop.controllers;

import be.layla.laptop.model.Accessorie;
import be.layla.laptop.repositories.AccessorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AccessorieController {

    @Autowired
    private AccessorieRepository accessorieRepository;


    @GetMapping({"/accessorie"})
    public String accessorie (Model model) {
        model.addAttribute("accessories", accessorieRepository.findAll());
        return "accessorie";
    }


    @GetMapping({"/accessoriedetails/{id}", "/accessoriedetails"})
    public String accessoriedetails(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "accessoriedetails";

        Optional<Accessorie> accessorieFromDb = accessorieRepository.findById(id);
        //noinspection OptionalIsPresent
        if (accessorieFromDb.isPresent()) {
            Optional<Accessorie> prevAccessorieFromDb = accessorieRepository.findFirstByIdLessThanOrderByIdDesc(id);
            if (prevAccessorieFromDb.isEmpty())
                prevAccessorieFromDb = accessorieRepository.findFirstByOrderByIdDesc();
            Optional<Accessorie> nextAccessorieFromDb = accessorieRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
            if (nextAccessorieFromDb.isEmpty())
                nextAccessorieFromDb = accessorieRepository.findFirstByOrderByIdAsc();

            model.addAttribute("accessorie", accessorieFromDb.get());
            model.addAttribute("prevId", prevAccessorieFromDb.get().getId());
            model.addAttribute("nextId", nextAccessorieFromDb.get().getId());
        }
        return "accessoriedetails";
    }

}
