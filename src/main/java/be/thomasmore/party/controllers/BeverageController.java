package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Beverage;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.BeverageRepository;
import be.thomasmore.party.repositories.VenueRepository;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BeverageController {

    @Autowired
    BeverageRepository beverageRepository;

    @GetMapping("/beveragelist")
    public String beverageList(Model model){
        final Iterable<Venue> allBeverages = beverageRepository.findAll();
        model.addAttribute("beverages", allBeverages );

        return "beveragelist";
    }


}
