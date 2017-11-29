package com.inventory.controllers;


import com.inventory.models.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andy on 29/11/17.
 */
@Controller
public class CustomerController {

    @Autowired
    BeverageRepository beverageRepo;

    @GetMapping("/customer")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("index");
        mv.getModel().put("beverageList", beverageRepo.findAll());
        return mv;
    }

}




