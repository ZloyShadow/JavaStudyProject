package com.restvote.votingsystem.web;

import com.restvote.votingsystem.AuthorizedUser;
import com.restvote.votingsystem.model.Restaurant;
import com.restvote.votingsystem.model.Vote;
import com.restvote.votingsystem.service.VoteService;
import com.restvote.votingsystem.util.DateUtil;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = VoteRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteRestController {
    static final String REST_URL = "/rest/votes";
    private final Logger log = LoggerFactory.getLogger(VoteRestController.class);

    @Autowired
    private VoteService service;

    @GetMapping()
    public Vote get(@RequestParam(value = "date", required = false)
                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws NotFoundException {
        int userId = AuthorizedUser.id();
        log.info("get vote for user {} for this date {}", userId, date);
        return service.get(userId, DateUtil.getDefault(date));
    }

    @GetMapping("/all")
    public List<Vote> getAll(){
        log.info("getting list of all Votes");
        return service.getAll();
    }

    @DeleteMapping()
    public void delete(@RequestParam(value = "date", required = false)
                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws NotFoundException {
        int userId = AuthorizedUser.id();
        log.info("deleting vote for user {} for this date {}", userId, date);
        service.delete(userId, DateUtil.getDefault(date));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote take(@RequestBody Restaurant restaurant) throws NotFoundException {
        int userId = AuthorizedUser.id();
        log.info("vote for restaurant {} and user {}", restaurant, userId);
        return service.save(restaurant, userId);
    }
}
