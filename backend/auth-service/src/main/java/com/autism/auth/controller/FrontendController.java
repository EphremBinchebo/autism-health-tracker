package com.autism.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontendController {

    @RequestMapping({"/autism-tracker/**"})
    public String forward() {
        return "forward:/autism-tracker/index.html";
    }
}
