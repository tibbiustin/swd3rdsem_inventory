package com.inventory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Tibi on 22/11/2017.
 */

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() { return "index"; }
}
