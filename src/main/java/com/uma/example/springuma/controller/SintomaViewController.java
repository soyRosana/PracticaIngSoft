package com.uma.example.springuma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uma.example.springuma.model.Sintoma;
import com.uma.example.springuma.model.SintomaService;

@Controller
@RequestMapping("/")
public class SintomaViewController {

    @Autowired
    private SintomaService sintomaService;
    
    @GetMapping
    public String indexView() {
        return "indexC";
    }

    @GetMapping("/addSintoma")
    public String addSintomaView(Model model) {
        model.addAttribute("sintoma", new Sintoma());
        return "addSintoma";
    }

    @GetMapping("/listSintomas")
    public String listSintomasView(Model model) {
        
        model.addAttribute("sintomas", sintomaService.getAllSintomas());
        
        return "listSintoma";
    }

    @GetMapping("/editSintoma/{id}")
    public String editSintomaView(@PathVariable("id") Long id, Model model) {

        model.addAttribute("sintoma", sintomaService.getSintoma(id));
        return "updateSintoma";
    }
    
}
