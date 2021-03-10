package com.cg.employeemgt.ui;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.employeemgt.entities.Employee;
import com.cg.employeemgt.exceptions.InvalidEmployeeNameException;
import com.cg.employeemgt.exceptions.InvalidIdException;
import com.cg.employeemgt.exceptions.InvalidScoreException;
import com.cg.employeemgt.service.IEmployeeService;

@Component
public class EmployeeUI {
    @Autowired
    private IEmployeeService service ;


    public void start() {
        try {
            Employee mounika = service.addEmployee("mounika", 70);
            display(mounika);
            Employee madhuri = service.addEmployee("madhuri", 75);
            display(madhuri);

            Employee rohit = service.addEmployee("rohit", 80);
            display(rohit);

            Employee fetchedEmployee = service.findById(mounika.getId());
            System.out.println("displaying fetched employee for id=" + mounika.getId());
            display(fetchedEmployee);

            System.out.println("displaying all employees");
            List<Employee> list = service.findAll();
            displayAll(list);
        }catch(InvalidIdException e){
            System.out.println(e.getMessage());
         }
        catch(InvalidScoreException e){
            System.out.println(e.getMessage());
           // e.printStackTrace();
        }
        catch(InvalidEmployeeNameException e){
           System.out.println(e.getMessage());
           //  e.printStackTrace();
        }
        catch(Exception e){
            System.out.println("something went wrong");
            //e.printStackTrace();
        }

    }

    public void displayAll(Collection<Employee> employees){
        for(Employee employee:employees){
            display(employee);
        }
    }

    public void display(Employee employee){
        System.out.println(employee.getId()+"-"+employee.getName()+"-"+"-"+ employee.getScore());
    }


}


