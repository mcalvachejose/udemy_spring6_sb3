package com.prueba.vscode.springvscode.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.prueba.vscode.springvscode.models.User;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> details() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Titulo del Mensaje");
        model.put("name", "Raimundo");
        model.put("lastname", "Sokenza");
        return model;
    }
    
    @GetMapping("/details8")
    public Map<String, Object> details2() {
        User user = new User ("Juan", "Albarez");
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Titulo del Mensaje");
        model.put("user", user);
      
        return model;
    }

      @GetMapping("/details9")
    public String details9(Model model) {
        model.addAttribute("title", "Personas");
        User user = new User ("Juan", "Albarez");
        model.addAttribute("titulo1", "Persona 1");
        model.addAttribute("user1", user);
        model.addAttribute("user1", user);
        User user2 = new User ("Simon", "Del Cano");
        model.addAttribute("titulo2", "Persona 2");
        model.addAttribute("user2", user2);
        model.addAttribute("user2", user2);

        return "details2_user";
    }
}
