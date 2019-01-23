package ru.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mvc.models.Message;
import ru.mvc.services.MailService;

/**
 * Created by User on 23.01.2019.
 */
@RestController
@RequestMapping(MailControllers.REST_URL)
public class MailControllers {

    public static final String REST_URL = "/";

    @Autowired
    private MailService mailService;

    @GetMapping(/*value = "/mail",*/ produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> getMessage(){
        Message message = mailService.getMessage();
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
