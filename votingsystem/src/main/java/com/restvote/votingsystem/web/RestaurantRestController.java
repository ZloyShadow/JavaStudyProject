package com.restvote.votingsystem.web;

import com.restvote.votingsystem.model.Restaurant;
import com.restvote.votingsystem.service.RestaurantService;
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
@RequestMapping(value = RestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantRestController {
    static final String REST_URL = "/rest/restaurants";
    private final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    @Autowired
    private RestaurantService service;

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable("id") int id) throws NotFoundException {
        log.info("get restaurant with id {}", id);
        return service.get(id);
    }

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("get list of all restaurants");
        return service.getAll();
    }
}
