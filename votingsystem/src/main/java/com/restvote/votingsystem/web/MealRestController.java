package com.restvote.votingsystem.web;

import com.restvote.votingsystem.model.Meal;
import com.restvote.votingsystem.service.MealService;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = MealRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealRestController {
    static final String REST_URL = "/rest/Meales";
    private final Logger log = LoggerFactory.getLogger(MealRestController.class);

    @Autowired
    private MealService service;

    @GetMapping("/{id}")
    public Meal get(@PathVariable("id") int id) throws NotFoundException {
        log.info("get Meal with id {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Meal> getAll() {
        log.info("get list of all Meales");
        return service.getAll();
    }
}
