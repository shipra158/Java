package com.cg.employeemgt.service;



import java.util.List;

import com.cg.employeemgt.entities.Employee;

public interface IEmployeeService {

   Employee addEmployee(String name, int score);
    
   Employee findById(int id);

    List<Employee>findAll();

    Employee updateName(int id, String name);

    void deleteById(int id);

}
