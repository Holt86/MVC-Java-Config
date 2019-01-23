package ru.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by User on 23.01.2019.
 */

@Configuration
@ComponentScan(basePackages = {"ru.mvc.services"})
public class AppConfiguration {
}
