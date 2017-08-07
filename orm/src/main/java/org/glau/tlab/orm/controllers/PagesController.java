package org.glau.tlab.orm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PagesController {

    @RequestMapping("/")
    public String getIndexPage() {
        return "index";
    }

}
