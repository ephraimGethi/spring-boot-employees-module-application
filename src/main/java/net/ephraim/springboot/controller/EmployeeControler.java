package net.ephraim.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import net.ephraim.springboot.exception.ResourceNotFoundException;
import net.ephraim.springboot.model.Employee;
import net.ephraim.springboot.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeControler {
	@Autowired
	private EmployeeRepository employeeRepository;
	@CrossOrigin("*")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
	return employeeRepository.findAll();	
	};
	@CrossOrigin("*")
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
				}
	@CrossOrigin("*")
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
	
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employees with id of does not exist" + id));
	return ResponseEntity.ok(employee);
	}
	@CrossOrigin("*")
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployees(@PathVariable Long id,@RequestBody Employee employeedetails) {
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employees with id of does not exist" + id));
	employee.setFirstName(employeedetails.getFirstName());
	employee.setLastName(employeedetails.getLastName());
	employee.setEmailId(employeedetails.getEmailId());
	
	Employee updateEmployeesEmployee = employeeRepository.save(employee);
	return ResponseEntity.ok(updateEmployeesEmployee);
	}
	@CrossOrigin("*")
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employees with id of does not exist" + id));
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	public EmployeeRepository getEmployeeRepository() {
		return employeeRepository;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

}
