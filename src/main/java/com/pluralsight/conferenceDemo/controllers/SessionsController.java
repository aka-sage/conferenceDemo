package com.pluralsight.conferenceDemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pluralsight.conferenceDemo.models.Session;
import com.pluralsight.conferenceDemo.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions") // route path for REST
public class SessionsController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    // @SuppressWarnings("deprecation")
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        return sessionRepository.findById(id).get();
        // getOne(id); depreciated method
    }

    @PostMapping // by default Spring will generate code 200
    // @ResponseStatus(HttpStatus.CREATED)//will map it to 201
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    /*
     * By default Spring only provides GET/POST mapping, rest we have to specify per
     * use case.
     */

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    @PutMapping(value = "{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // since this is a PUT, we expect all attributes to be passed in.
        // TODO: Add validation that all attributes are passed in otherwise
        // return a 400 bad pay load.
        Session existingSession = sessionRepository.findById(id).get();
        BeanUtils.copyProperties(session, existingSession, /* ...ignoreProperties: */"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
