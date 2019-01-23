package ru.mvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.mvc.configuration.AppConfiguration;
import ru.mvc.services.MailService;

/**
 * Created by User on 23.01.2019.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MailService service = ctx.getBean(MailService.class);
        System.out.println(service.getMessage());

    }
}
