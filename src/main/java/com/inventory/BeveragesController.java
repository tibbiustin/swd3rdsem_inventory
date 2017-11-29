package com.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by andy on 28/11/17.
 */
@Controller
public class BeveragesController {
    private static AtomicLong counter = new AtomicLong();

    @GetMapping("/beverages/show")
    public ModelAndView show(){
        ModelAndView mv = new ModelAndView("beverages");
        mv.getModel().put("beveragesList", Beverages.getBeveragesList());
        mv.getModel().put("beverages", "Here are the beverages");
        return mv;
    }



    @GetMapping("/beverages/edit")
    public ModelAndView editUser(
            @RequestParam(name = "id", defaultValue = "0")
                    long id) {
        System.out.println("id = " + id);
        ModelAndView mv = new ModelAndView("edit");

        mv.getModel().put("user", Beverages.getBeveragesById(id));

        return mv;
    }




}
