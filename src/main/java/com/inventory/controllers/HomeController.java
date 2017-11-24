package com.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by George Stratulat on 24/11/2017.
 */
@Controller
public class HomeController {
    @GetMapping("/admin")
    public String index() { return "login"; }


    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ModelAndView verifyLogin(@RequestParam String username, @RequestParam String password){
        String verifyu = "admin",verifyp = "1234";
        ModelAndView modelAndview = new ModelAndView("login");
        ModelAndView modelAndView2 = new ModelAndView("dashboard");


        if((verifyu == username) && (verifyp == password)){
            return modelAndview;
        }
        return modelAndView2;
    }

}
