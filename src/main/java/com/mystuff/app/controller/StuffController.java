package com.mystuff.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mystuff.app.entity.Stuff;
import com.mystuff.app.service.StuffService;


@Controller
@RequestMapping("/mystuff")
public class StuffController {

    private StuffService stuffService;

    @Autowired
    public StuffController(StuffService stuffService) {
        this.stuffService = stuffService;
    }


    @GetMapping()
    public String getMainPage(Model model){
        List<Stuff> stuff = stuffService.getStuff();
        model.addAttribute("stuff",stuff);
        return "mystuff";
    }


    @GetMapping("/add")
    public String get_addStuff(){
        return "add";
    }

    @PostMapping("/add")
    public String addstuff(@RequestParam String stuff_name){
        stuffService.addStuff(new Stuff(stuff_name));
        return "redirect:/mystuff";
    }

    @GetMapping("/delete")
    public String get_deleteStuff(){
        return "delete";
    }

    @PostMapping("/delete")
    public String  deleteStuff(@RequestParam String stuff_name){
        stuffService.deleteStuffByName(stuff_name);
        return "redirect:/mystuff";
    }
    
}
