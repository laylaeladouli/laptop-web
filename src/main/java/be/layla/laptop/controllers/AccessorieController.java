package be.layla.laptop.controllers;

import be.layla.laptop.model.Accessorie;
import be.layla.laptop.repositories.AccessorieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AccessorieController {

    private final Logger logger = LoggerFactory.getLogger(AccessorieController.class);


    @Autowired
    private AccessorieRepository accessorieRepository;


    @GetMapping({"/accessorie"})
    public String accessorie (Model model) {
        logger.info("accessorie");
        final Iterable<Accessorie> allAccessories = accessorieRepository.findAll();
        model.addAttribute("accessories", allAccessories);
        model.addAttribute("showFilters", false);
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



    @GetMapping("/accessorie/filter")
    public String accessorieListWithFilter(Model model,
                                       @RequestParam(required = false) String productName,
                                       @RequestParam(required = false) String priceRange) {

        logger.info(String.format("accessorieListWithFilter -- productName=%s, priceRange=%s ", productName, priceRange ));

        List<Accessorie> accessories = accessorieRepository.findByFilter( productName, priceRange );

        model.addAttribute("accessories", accessories);
        model.addAttribute("showFilters", true);
        model.addAttribute("productName", productName);
        model.addAttribute("priceRange", priceRange);

        return "accessorie";
    }

}
