package ru.mvc.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppConfigInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootCtx =
                new AnnotationConfigWebApplicationContext();

        rootCtx.register(AppConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootCtx));

        AnnotationConfigWebApplicationContext mvcCtx =
                new AnnotationConfigWebApplicationContext();
        mvcCtx.register(WebAppConfiguration.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher-servlet", new DispatcherServlet(mvcCtx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
