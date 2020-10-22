package de.telran.person.controller;

import de.telran.person.dto.PersonDto;
import de.telran.person.exception.PersonNotFoundException;
import de.telran.person.model.Person;
import de.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{id}")
    public PersonDto get(@PathVariable int id) {
        Person personFromRepo = personService.get(id);
        if (personFromRepo == null) {
            throw new PersonNotFoundException("Person not found");
        }
        return new PersonDto(personFromRepo);
    }

    @GetMapping("/persons/")
    public List<PersonDto> getAll() {
        return personService.getAll().stream().map(PersonDto::new).collect(Collectors.toList());
    }

    @PostMapping("/persons")
    public PersonDto create(@RequestBody PersonDto personDto) {
        Person person = personService.create(personDto.firstName, personDto.lastName, personDto.age);
        personDto.id = person.getId();
        return personDto;
    }

    @PutMapping("/persons/{id}")
    public void edit(@RequestBody PersonDto personDto, @PathVariable int id) {
        personService.edit(id,personDto.firstName, personDto.lastName, personDto.age);
    }

    @DeleteMapping("/persons/{id}")
    public PersonDto delete(@PathVariable int id) {
        Person removedPersonFromRepo = personService.remove(id);
        return new PersonDto(removedPersonFromRepo);
    }







}
