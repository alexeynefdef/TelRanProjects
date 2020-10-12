package de.telran.contacts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contact/add")
    public String addContact() {
        return "contact-form";
    }
}
