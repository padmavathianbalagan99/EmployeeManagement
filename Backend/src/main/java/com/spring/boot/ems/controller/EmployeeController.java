package com.spring.boot.ems.controller;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	import com.spring.boot.ems.entity.Employee;
	import com.spring.boot.ems.service.EmployeeService;

	import java.util.List;

	@RestController
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping("/employee")
	public class EmployeeController {
	    private final EmployeeService employeeService;

	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Employee>> getAllEmployees () {
	        List<Employee> employees = employeeService.findAllEmployees();
	        return new ResponseEntity<>(employees, HttpStatus.OK);
	    }

	    @GetMapping("/find/{id}")
	    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id) {
	        Employee employee = employeeService.findEmployeeById(id);
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
	        Employee newEmployee = employeeService.addEmployee(employee);
	        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	    }

	    @PutMapping("/update")
	    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
	        Employee updateEmployee = employeeService.updateEmployee(employee);
	        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
	        employeeService.deleteEmployee(id);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	}