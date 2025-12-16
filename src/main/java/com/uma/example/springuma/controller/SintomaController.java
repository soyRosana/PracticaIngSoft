package com.uma.example.springuma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uma.example.springuma.model.Sintoma;
import com.uma.example.springuma.model.SintomaService;

@Controller
@RequestMapping("/sintomas")
public class SintomaController {
    
    @Autowired
    private SintomaService sintomaService; 
    
    @PostMapping
    public String saveSintoma(@ModelAttribute Sintoma sintoma, RedirectAttributes redirectAttributes) {
        try {
            sintomaService.addSintoma(sintoma);
            redirectAttributes.addFlashAttribute("create", true);
            return "redirect:/listSintomas"; 
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("create", false);
            return "redirect:/listSintomas";
        }
    }

    @PutMapping
    public String updateSintoma(@ModelAttribute Sintoma sintoma, RedirectAttributes redirectAttributes) {
        try {
            Sintoma sintomaActualizado = sintomaService.updateSintoma(sintoma);
            if (sintomaActualizado != null) {
                redirectAttributes.addFlashAttribute("update", true);
            } else {
                 redirectAttributes.addFlashAttribute("update", false);
            }
            return "redirect:/listSintomas";
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("update", false);
            return "redirect:/listSintomas";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteSintoma(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            sintomaService.removeSintomaID(id);
            redirectAttributes.addFlashAttribute("delete", true);
            return "redirect:/listSintomas"; 
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("delete", false);
            return "redirect:/listSintomas";
        }
    }
}
