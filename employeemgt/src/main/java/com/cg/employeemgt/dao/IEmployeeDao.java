package com.cg.employeemgt.dao;
import com.cg.employeemgt.entities.Employee;

import java.util.List;



public interface IEmployeeDao
{

    void add (Employee employee);

    Employee findById(int id);

    List<Employee>findAll();

    Employee update(Employee employee);

    void deleteById(int id);
}