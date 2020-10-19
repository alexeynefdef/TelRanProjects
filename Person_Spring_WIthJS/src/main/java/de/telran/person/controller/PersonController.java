package de.telran.person.controller;

import de.telran.person.dto.PersonDto;
import de.telran.person.model.Person;
import de.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/persons/{id}")
    public PersonDto get(@PathVariable int id) {
        Person personFromRepo = personService.getPerson(id);
        PersonDto personDto = new PersonDto();
        personDto.firstName = personFromRepo.getFirstName();
        personDto.lastName = personFromRepo.getLastName();
        personDto.age = personFromRepo.getAge();
        personDto.id = personFromRepo.getId();
        return personDto;
    }

    @GetMapping("/persons")
    public List<PersonDto> getAll() {
        return personService.getAll();
    }

    @PostMapping("/persons")
    public PersonDto create(@RequestBody PersonDto personDto) {
        Person person = personService.create(personDto.firstName, personDto.lastName, personDto.age);
        personDto.id = person.getId();
        return personDto;
    }

    @PutMapping("/persons{id}")
    public void edit(@RequestBody PersonDto personDto, @PathVariable int id) {
        Person personToUpdate = new Person(personDto.firstName);
        personToUpdate.setLastName(personDto.lastName);
        personToUpdate.setAge(personDto.age);
        personToUpdate.setId(id);
        personService.updatePerson(personToUpdate);
    }

    @DeleteMapping("/persons{id}")
    public PersonDto delete(@PathVariable int id) {
        Person removedPersonFromRepo = personService.removePerson(id);
        PersonDto personDto = new PersonDto();
        personDto.firstName = removedPersonFromRepo.getFirstName();
        personDto.lastName = removedPersonFromRepo.getLastName();
        personDto.age = removedPersonFromRepo.getAge();
        personDto.id = removedPersonFromRepo.getId();
        return personDto;
    }







}
