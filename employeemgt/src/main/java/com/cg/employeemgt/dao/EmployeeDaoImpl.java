package com.cg.employeemgt.dao;

import java.util.*;

import com.cg.employeemgt.entities.Employee;
import com.cg.employeemgt.exceptions.EmployeeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;


@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private StoreHolder storeHolder;

	private Map<Integer, Employee> store;


	@PostConstruct
	public void afterInit(){
		store=storeHolder.getStore();
	}


	public int generateId() {
    	int generatedId=store.size()+1;
	    return generatedId;
	}


	@Override
	public void add(Employee employee) {
		int id=generateId();
		employee.setId(id);
		store.put(id, employee);
	}

	@Override
	public Employee update(Employee employee){
		store.put(employee.getId(),employee);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		if(!store.containsKey(id)) {
			throw new EmployeeNotFoundException("employee doesn't exist for id="+id);
		}
		Employee employee=store.get(id);
	    return employee; 
	}

	@Override
	public List<Employee> findAll() {
		Collection<Employee>employee=store.values();
		List<Employee>list=new ArrayList<>(employee);
		return list;		
	}

	@Override
	public void deleteById(int id) {
		store.remove(id);

	}

}
