package org.winkexamples.wink.rest.services;


import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.winkexamples.wink.rest.pojo.Employee;
import org.winkexamples.wink.rest.repository.WinkPersistenceManager;

@Path("employees")
public class WinkWebService {

	WinkPersistenceManager persistenceManager = WinkPersistenceManager.getInstance();
	

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployees() {
		
		List<Employee> employees = persistenceManager.get();
		String empList = new String("");
		
		for(Employee employee: employees) {
			empList+=employee.toString() + "\n";
		}
		
		return empList;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Employee getEmployeeById(@PathParam(value="id") long id) {
		System.out.println(id);
		Employee employee = persistenceManager.getEmployee(id);
		return employee;
	}
	
	@GET
	@Path("/json/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeJsonById(@PathParam(value="id") long id) {
		Employee employee = persistenceManager.getEmployee(id);
		return employee;
	}

	
	@POST
	public String addEmployees(String employee) {
		
		Employee emp = new Employee();
		emp.setName(employee);
		persistenceManager.add(emp);
		
		return employee;
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteEmployee(@PathParam(value="id") long id) {
		
		persistenceManager.delete(id);
		return;
	}
	
	@PUT
	@Path("/{id}")
	public void modifyEmployee(@PathParam(value="id") long id, String empName) {
		
		persistenceManager.update(id, empName);
		return;
	}
}
