package ru.mvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by User on 23.01.2019.
 */

@Configuration
@Import(DBConfiguration.class)
@ComponentScan(basePackages = {"ru.mvc.services"})
public class AppConfiguration {
}
