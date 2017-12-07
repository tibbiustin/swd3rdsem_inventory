package com.inventory.controllers;


import com.inventory.models.Beverage;
import com.inventory.models.BeverageRepository;
import com.inventory.models.CustomerOrder;
import com.inventory.models.CustomerOrderRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by andy on 29/11/17.
 */
@Controller
public class CustomerController {

    @Autowired
    BeverageRepository beverageRepo;
    @Autowired
    CustomerOrderRepository customerOrderRepository;

    @GetMapping("/")
    public ModelAndView doHome() {
        ModelAndView mv = new ModelAndView("index");
        mv.getModel().put("beverageList", beverageRepo.findAll());
        return mv;
    }



    @PostMapping("/order")
    public ModelAndView buy(
            @RequestParam(name="id", defaultValue = "-1") int id,
            @RequestParam(name = "quantity", defaultValue = "0")
            float quantity,
            @RequestParam(name = "customerName", defaultValue = "NO_NAME")
            String customerName){

        Beverage beverage;
        beverage = beverageRepo.findOne(id);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setCustomerName(customerName);
        customerOrder.setQuantity(quantity);
        customerOrder.setTotalPrice(quantity * beverage.getPrice_per_unit());
        customerOrder.setProductName(beverage.getName());
        System.out.println(beverage.getName());
        customerOrderRepository.save(customerOrder);
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }

    @GetMapping("/order/add")
    public ModelAndView signup(
            int id) {
        ModelAndView mv = new ModelAndView("customerOrder");
        mv.getModel().put("beverage", beverageRepo.findOne(id));
        System.out.println(id);
        return mv;
    }



}




