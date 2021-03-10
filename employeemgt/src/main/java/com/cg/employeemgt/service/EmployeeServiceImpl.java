package com.cg.employeemgt.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cg.employeemgt.dao.IEmployeeDao;
import com.cg.employeemgt.entities.Employee;
import com.cg.employeemgt.exceptions.InvalidEmployeeNameException;
import com.cg.employeemgt.exceptions.InvalidIdException;
import com.cg.employeemgt.exceptions.InvalidScoreException;


@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public Employee addEmployee(String name, int score) {
		validateName(name);
		validateScore(score);
		Employee employee=new Employee(name,score);
		dao.add(employee);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		validateId(id);
		Employee employee=dao.findById(id);
		return employee;		
	}


	@Override
	public List<Employee> findAll() {
		List<Employee>employees=dao.findAll();
		return employees;
	}

	@Override
	public Employee updateName(int id, String name){
		validateName(name);
		Employee employee=findById(id);
		employee.setName(name);
		employee=dao.update(employee);
		return employee;
	}

	@Override
	public void deleteById(int id) {
       dao.deleteById(id);
	}

	void validateScore(int score){
		if(score<0){
         throw new InvalidScoreException("score can't be negative");
		}
	}

   void validateName(String name){
		if(name==null || name.isEmpty() || name.trim().isEmpty()){
			throw new InvalidEmployeeNameException("name can't be null or empty");
		}
	}

	void validateId(int id){
		if(id <0){
			throw new InvalidIdException("id should not be negative");
		}
	}
}
