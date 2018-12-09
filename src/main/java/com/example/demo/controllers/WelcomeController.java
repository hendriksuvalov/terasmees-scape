package com.example.demo.controllers;

import com.example.demo.entities.BrowserStats;
import com.example.demo.repositories.BrowserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @Autowired
    BrowserRepo browserRepo;
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("text", "This is text");
        return "index";
    }

    @RequestMapping("/forums")
    public String forums(Model model) {
        return "forums";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/post")
    public String post(Model model) {
        return "post";
    }

    @RequestMapping("/newtopic")
    public String topic(Model model) {
        return "newtopic";
    }

    @RequestMapping("/sitemap")
    public String sitemap(Model model) {
        return "sitemap";
    }

    @RequestMapping("/statistics")
    public String statistics(Model model) {
        model.addAttribute("attribuut", browserRepo.findTopBrowser());
        model.addAttribute("osattribuut" ,browserRepo.findTopos());
        model.addAttribute("uriattribuut", browserRepo.findTopUri());


        return "statistics";
    }


}
