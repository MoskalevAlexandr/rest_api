package com.beoatch.spring_boot_rest.controllers;


import com.beoatch.spring_boot_rest.entity.Human;
import com.beoatch.spring_boot_rest.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {
    private HumanService humanService;

    @Autowired
    public AppController (HumanService humanService) {
        this.humanService = humanService;
    }

    @GetMapping("/human")
    public List<Human> showAll() {
        List<Human> people = humanService.showPeople();
        return people;
    }

    @GetMapping("/human/{id}")
    public Human getHuman(@PathVariable int id) {
        Human human = humanService.getHuman(id);
        return human;
    }


    @PostMapping("/human")
    public Human addNewHuman(@RequestBody Human human) {
        humanService.saveHuman(human);
        return human;
    }

    @PutMapping("/human")
    public Human updateHuman(@RequestBody Human human) {
        humanService.saveHuman(human);
        return human;
    }

    @DeleteMapping("/human/{id}")
    public String deleteHuman(@PathVariable int id) {
        humanService.deleteHuman(id);
        return "Human with ID = " + id + " was deleted";
    }

    @GetMapping("/human/docs/number/{number}")
    public Object getHumanByDocNumber(@PathVariable int number) {
        return humanService.getHumanByDocNumber(number);
    }

    @GetMapping("/human/docs/date/{date}")
    public List<Human> getPeopleByDateOfBirth(@PathVariable LocalDate date) {
        return humanService.getPeopleByDateOfBirth(date);
    }

    @GetMapping("/human/docs/{surname}/{name}/{patronymic}")
    public List<Human> getPeopleBySNP(@PathVariable String surname,
                                      @PathVariable String name,
                                      @PathVariable String patronymic) {
        return humanService.getPeopleBySNP(surname, name, patronymic);
    }
}