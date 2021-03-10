package com.cg.employeemgt.dao;

	import java.util.*;
import com.cg.employeemgt.entities.Employee;

import org.springframework.stereotype.Component;

	@Component
	public class StoreHolder {

	    public StoreHolder() {
	    }

	    private Map<Integer, Employee> store = new HashMap<>();

	    public Map<Integer, Employee> getStore() {
	        return store;
	    }


	}


