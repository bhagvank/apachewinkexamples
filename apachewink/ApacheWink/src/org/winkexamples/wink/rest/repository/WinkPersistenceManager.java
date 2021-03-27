package org.winkexamples.wink.rest.repository;


import java.util.ArrayList;
import java.util.List;

import org.winkexamples.wink.rest.pojo.Employee;

public class WinkPersistenceManager {

	private List<Employee> employeeList = new ArrayList<Employee>();
	private static WinkPersistenceManager manager;
	private static int id=0;
	
	private WinkPersistenceManager() {
		
	}
	
	public Employee getEmployee(long empId) {
		
		System.out.println("Finding Employee " + empId);
		Employee employee = null;
		boolean found = false;
		for(int i=0;i<employeeList.size();i++) {
			
			employee = employeeList.get(i);
			if(employee.getId()==empId) {
				found = true;
				break;
			}
		}
		if(!found) employee=null;
		return employee;
	}
	
	public void add(Employee employee) {
		
		System.out.println("Adding Employee");
		
		id++;
		employee.setId(id);
		employeeList.add(employee);
	}
	
	public List<Employee> get() {
		System.out.println(" all employees");
		return employeeList;
	}
	
	public void update(long empId, String empName) {
		System.out.println("Database: Modified One Product");
		
		for(int i=0;i<employeeList.size();i++) {
			
			Employee employee = employeeList.get(i);
			if(employee.getId()==empId) {
				employee.setName(empName);
				employeeList.remove(i);
				employeeList.add(i,employee);
			}
		}
		return;
	}
	
	public void delete(long empId) {
		System.out.println("removing the employee");
		
		for(int i=0;i<employeeList.size();i++) {
			
			Employee employee = employeeList.get(i);
			if(employee.getId()==empId) employeeList.remove(i);
		}
		return;
	}
	
	public static WinkPersistenceManager getInstance() {
		
		if(manager==null) {
			synchronized(WinkPersistenceManager.class) {
				if(manager==null) {
					manager = new WinkPersistenceManager();
				}
			}
		}
		return manager;
	}
}
