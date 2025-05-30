package com.prueba.vscode.springvscode.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prueba.vscode.springvscode.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String getDetails() {
        return "details";
    }

    @GetMapping("/details2")
    public String getDetails2(Model model) {
        model.addAttribute("title", "TITULO D2");
        model.addAttribute("name", "Ortega");
        model.addAttribute("lastname", "Hernandez");
        return "details2";
    }
    
    @GetMapping("/details3")
    public String getDetails3(Map<String, Object> model) {
        model.put("title", "Mapa Ramon");
        model.put("name", "Ortega");
        model.put("lastname", "Hernandez");
        return "details2";
    }

    @RequestMapping(path = "/details4", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDetails4() {
        Map<String, Object> model = new HashMap<>();
        model.put("title", "Controller Json");
        model.put("name", "Ortega");
        model.put("lastname", "Hernandez");
        return model;
    }

    @GetMapping("/details5")
    public String details5(Model model) {
        model.addAttribute("title", "Personas");
        User user = new User ("Juan", "Albarez", "pe@com");
        model.addAttribute("titulo1", "Persona 1");
        model.addAttribute("user1", user);
        User user2 = new User ("Simon", null, "pe@com");
        model.addAttribute("titulo2", "Persona 2");
        model.addAttribute("user2", user2);

        return "details2_user";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        
        model.addAttribute("title", "Lista Usuarios");
        return "user-list";
    }

    @ModelAttribute("users")
    public List<User> userList() {
        return Arrays.asList(new User("Pedro", "Ramiro", "pe@com"),
                                    new User("Vicktor", "Zurman", "vi@com"),
                                    new User("Doris", "Cora", "do@com"),
                                    new User("Gabriel", "Niman", null));
    }
}
