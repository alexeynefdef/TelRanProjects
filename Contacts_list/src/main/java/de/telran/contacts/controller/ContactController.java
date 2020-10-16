package de.telran.contacts.controller;

import de.telran.contacts.model.Contact;
import de.telran.contacts.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact/add")
    public String addContactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("/contact/save")
    public String addContact(@ModelAttribute Contact contact) {
        if (contact.getId() > 0) {
            contactService.edit(contact);
        } else {
            contactService.add(contact);
        }
        return "redirect:/contacts";
    }

    @GetMapping("/contact/{id}/edit")
    public String editContactPage(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute(contact);
        return "contact-form";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        List<Contact> contacts = contactService.getAll();
        model.addAttribute("contacts",contacts);
        return "contacts";
    }

    @GetMapping("/")
    public String home() {
        return "homepage";
    }

    @GetMapping("/contact/{id}/delete")
    public String deleteContact(@PathVariable int id) {
        contactService.remove(id);
        return "redirect:/contacts";
    }

    @GetMapping("contact/{id}")
    public String getContactInfo(@PathVariable int id, Model model) {
        Contact contact = contactService.get(id);
        model.addAttribute("contact",contact);
        return "contact";
    }

}
