package org.example.springjpahibernatevegetablelist.controller;

import org.example.springjpahibernatevegetablelist.model.Vegetable;
import org.example.springjpahibernatevegetablelist.service.IVegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vegetables")
public class VegetableController {
    @Autowired
    private IVegetableService iVegetableService;

    @GetMapping("")
    public String index(Model model) {
        List<Vegetable> vegetableList = iVegetableService.findAll();
        model.addAttribute("vegetables", vegetableList);
        return "/index";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("vegetable", iVegetableService.findById(id));
        return "/view";
    }
}
