package com.inventory.controllers;

import com.inventory.models.Beverage;
import com.inventory.models.BeverageRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.inventory.models.DatabaseConnection.getConnection;

/**
 * Created by George Stratulat on 28/11/2017.
 */
@Controller
public class AdminController {

    @Autowired
    BeverageRepository beverageRepo;

    @GetMapping("/storemanager")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("StoreManager");
        mv.getModel().put("beverageList", beverageRepo.findAll());
        return mv;
    }

    @GetMapping(value= "/storemanager/add")
    public ModelAndView sad(){
        ModelAndView mv = new ModelAndView("add");
        return mv;
    }



    @PostMapping(value = "/storemanager/add")
    public ModelAndView doSave( @RequestParam(name="name") String name,
                               @RequestParam(name="quantity") float quantity, @RequestParam(name="price_per_unit") float price_per_unit){

        Beverage beverage = new Beverage( name, quantity, price_per_unit);
        beverageRepo.save(beverage);
        ModelAndView mv = new ModelAndView("redirect:/storemanager");
       return mv;

    }

    @RequestMapping(value = "/storemanager/saveEdit",method = RequestMethod.POST)
    public ModelAndView saveEdit(@RequestParam(name="id") int id,
            @RequestParam(name="name") String name,
            @RequestParam(name="quantity") float quantity, @RequestParam(name="price_per_unit") float price_per_unit) {
        ModelAndView mv = new ModelAndView("redirect:/storemanager");
        Beverage beverage = beverageRepo.findOne(id);
        beverage.setId(id);
        beverage.setName(name);
        beverage.setPrice_per_unit(price_per_unit);
        beverage.setQuantity(quantity);
        beverageRepo.save(beverage);
        return mv;
    }

    @GetMapping("/storemanager/edit")
    public ModelAndView edit(
            @RequestParam(name = "id")
                    int id) {
        ModelAndView mv = new ModelAndView("edit");
        mv.getModel().put("beverage", beverageRepo.findOne(id));

        return mv;
    }

    @RequestMapping(value = "/storemanager/delete", method = RequestMethod.GET)
    public ModelAndView delete(@RequestParam(name="id") int id) {
        beverageRepo.delete(beverageRepo.findOne(id));
        ModelAndView mv = new ModelAndView("redirect:/storemanager");
        return mv;
    }

}
