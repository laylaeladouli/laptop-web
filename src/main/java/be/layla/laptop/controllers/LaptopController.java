package be.layla.laptop.controllers;

import be.layla.laptop.model.Laptop;
import be.layla.laptop.repositories.LaptopRepository;
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
public class LaptopController {

    private final Logger logger = LoggerFactory.getLogger(LaptopController.class);

    @Autowired
    private LaptopRepository laptopRepository;


    @GetMapping({"/laptop"})
    public String laptop(Model model) {
        logger.info("laptop");
        final Iterable<Laptop> allLaptops = laptopRepository.findAll();
        model.addAttribute("laptops", allLaptops);
        model.addAttribute("showFilters", false);
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

            Laptop laptop = laptopFromDb.get();
            model.addAttribute("laptop", laptop);
            model.addAttribute("prevId", prevLaptopFromDb.get().getId());
            model.addAttribute("nextId", nextLaptopFromDb.get().getId());
            model.addAttribute("orderCount", laptop.getOrderCount());
        }else {
            model.addAttribute("orderCount", 0);
        }
        return "laptopdetails";
    }


    @GetMapping("/laptop/filter")
    public String laptopListWithFilter(Model model,
                                       @RequestParam(required = false) String brandName,
                                       @RequestParam(required = false) String priceRange,
                                       @RequestParam(required = false) String ramRange) {

        logger.info(String.format("laptopListWithFilter -- brandName=%s, priceRange=%s, ramRange=%s ", brandName, priceRange, ramRange));

        List<Laptop> laptops = laptopRepository.findByFilter( brandName, priceRange, ramRange );


        model.addAttribute("laptops", laptops);
        model.addAttribute("showFilters", true);
        model.addAttribute("brandName", brandName);
        model.addAttribute("priceRange", priceRange);
        model.addAttribute("ramRange", ramRange);
        return "laptop";
    }
}
