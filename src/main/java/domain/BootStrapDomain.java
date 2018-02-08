package domain;

import application.services.DepartmentAppService;
import application.services.PositionAppService;
import domain.data.repositories.EmployeeRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by sadok on 07/02/2018.
 */
@WebListener
public class BootStrapDomain implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("******************** initializing data *************************");
        new DepartmentAppService();
        new PositionAppService();
        new EmployeeRepository();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
