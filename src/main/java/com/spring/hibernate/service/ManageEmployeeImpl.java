package com.spring.hibernate.service;


import com.spring.hibernate.config.SpringConfig;
import com.spring.hibernate.model.Employee;
import com.spring.hibernate.repository.EmployeeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageEmployeeImpl {
    private static EmployeeDAO dao = null;


    public static void main(String[] args) {

        ManageEmployeeImpl me = new ManageEmployeeImpl();

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        dao = ctx.getBean(EmployeeDAO.class);
        dao = new EmployeeDAO();

        Employee e1 = new Employee();
        e1.setFirstName("Sara");
        e1.setLastName("Ali");
        e1.setSalary(100000);

        Employee e2 = new Employee();
        e2.setFirstName("Lisa");
        e2.setLastName("Ann");
        e2.setSalary(500000);

        dao.save(e1);
        dao.save(e2);

        me.listAll("Initial");

        e1.setLastName("Khan");
        dao.update(e1);

        me.listAll("Updated");

        dao.delete(e1);

        me.listAll("Deleted");

    }

    public String listAll(String message){
        String s = null;
        List<Employee> l2 = dao.getAll();
        System.out.println("---------------"+message+" Listing----------------");
        for(Employee e : l2){
            System.out.println(e.getFirstName()+"\t"+e.getLastName()+"\t"+e.getSalary());
            s +=e.getFirstName()+"\t"+e.getLastName()+"\t"+e.getSalary();
        }
        return s;
    }

}
