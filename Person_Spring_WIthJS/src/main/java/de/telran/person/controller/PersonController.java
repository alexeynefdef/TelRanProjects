package de.telran.person.controller;

import de.telran.person.dto.PersonDto;
import de.telran.person.model.Person;
import de.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
        PersonDto personDto = null;
        try {
            personDto = new PersonDto(personService.get(id));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        return personDto;
    }

    @GetMapping("/persons")
    public List<PersonDto> getAll() {
        return personService.getAll()
                .stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
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
        return new PersonDto(personService.remove(id));
    }

    @GetMapping("/persons/name/{name}")
    public List<PersonDto> getAllByName(@PathVariable String name) {
        return personService.getAllByName(name)
                .stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/agebefore/{age}")
    public List<PersonDto> getAllByAgeBefore(@PathVariable int age) {
        return personService.getAllByAgeBefore(age)
                .stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/age")
    public List<PersonDto> getAllByAgeFrom(@RequestParam(defaultValue = "0") int after,
                                           @RequestParam(defaultValue = "150") int before) {
        return personService.getAllByAgeBetween(after,before)
                .stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }
}
