package com.autism.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {

    @RequestMapping(value = { "/", "/autism-tracker/**" })
    public String forward() {
        return "forward:/index.html";
    }
}
