package ru.mvc.services;

import org.springframework.stereotype.Service;
import ru.mvc.models.Message;

/**
 * Created by User on 23.01.2019.
 */

@Service
public class MailService {


    public Message getMessage(){
        return new Message("user@mail.ru", "User1");
    }
}
