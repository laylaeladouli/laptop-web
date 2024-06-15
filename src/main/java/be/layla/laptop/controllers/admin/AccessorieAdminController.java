package be.layla.laptop.controllers.admin;

import be.layla.laptop.model.Accessorie;
import be.layla.laptop.model.Laptop;
import be.layla.laptop.repositories.AccessorieRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/admin")
@Controller
public class AccessorieAdminController {


    private static final Logger logger = LoggerFactory.getLogger(AccessorieAdminController.class);

    @Autowired
    private AccessorieRepository accessoieRepository;

    @ModelAttribute("accessorie")
    public Accessorie findAccessorie(@PathVariable(required = false) Integer id) {
        logger.info("findAccessorie " + id);
        if (id == null) return new Accessorie();

        Optional<Accessorie> optionalAccessorie = accessoieRepository.findById(id);
        if (optionalAccessorie.isPresent())
            return optionalAccessorie.get();
        return null;
    }


    @GetMapping("/accessorieedit/{id}")
    public String accessorieEdit(Model model, @PathVariable(required = false) Integer id) {
        logger.info("accessorieedit " + id);
        model.addAttribute("accessories", accessoieRepository.findAll());
        return "admin/accessorieedit";
    }


    @PostMapping("/accessorieedit/{id}")
    public String accessorieEditPost(Model model,
                                 @PathVariable Integer id,
                                 @Valid Accessorie accessorie,
                                 BindingResult bindingResult) {

        logger.info("accessorieEditPost" + id + " -- new name=" + accessorie.getBrandName());
        if (bindingResult.hasErrors()) {
            return "admin/accessorieedit";
        }
        accessoieRepository.save(accessorie);
        return "redirect:/admin/accessorieedit/" + id;
    }


    @GetMapping("/accessorienew")
    public String accessorieNew(Model model) {
        model.addAttribute("accessories", accessoieRepository.findAll());
        logger.info("accessorienew ");
        return "admin/accessorienew";
    }


    @PostMapping("/accessorienew")
    public String accessorieNewPost(Model model,
                                @ModelAttribute("accessorie") @Valid Accessorie accessorie,
                                BindingResult bindingResult) {
        logger.info("accessorieNewPost -- new name=" + accessorie.getBrandName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("accessorie", accessorie);
            return "admin/accessorienew";
        }
        accessoieRepository.save(accessorie);
        return "redirect:/admin/accessoriedetails";
    }

}
