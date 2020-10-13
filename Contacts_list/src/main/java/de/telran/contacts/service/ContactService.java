package de.telran.contacts.service;

import de.telran.contacts.model.Contact;
import de.telran.contacts.repository.IContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private final IContactRepo contactRepo;

    public ContactService(@Autowired IContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    public void add(Contact contact){
        contactRepo.add(contact);
    }

    public List<Contact> getAll() {
        return contactRepo.getAll();
    }
}
