package com.unimoni.glmodule.controller;

import java.util.List;
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
import org.w3c.dom.ls.LSInput;

import com.unimoni.glmodule.exception.ResourceNotFoundException;
import com.unimoni.glmodule.model.EmployeeDetails;
import com.unimoni.glmodule.model.LoanScheme;
import com.unimoni.glmodule.dao.IEmpRepository;
import com.unimoni.glmodule.dto.EmployeeLoanRequest;
import com.unimoni.glmodule.dto.EmployeeLoanResponse;
import com.unimoni.glmodule.service.EmpService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private IEmpRepository iEmployeeRepository;
    

    @Autowired
    private final EmpService empService;
	
	@Autowired
	public EmployeeController(EmpService empService) {
		this.empService = empService;
	}
    
    
    // Get all employees
    @GetMapping("/employees")
    public List<EmployeeDetails> getAllEmployees() {
        return iEmployeeRepository.findAll();
    }

    // Create an employee
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDetails> createEmployee(@RequestBody EmployeeDetails employeeDetails) {
    	EmployeeDetails empDetails = empService.createEmployee(employeeDetails);
        return ResponseEntity.ok(empDetails);
    }
    
    // loan for employee
    @PostMapping("/employees/loanOfEmp")
    public ResponseEntity<EmployeeLoanResponse> loanOfemployee(@RequestBody EmployeeLoanRequest testClass){
    	EmployeeLoanResponse empLoanResponse  = empService.loanOfemployee(testClass.getEmployeeId(), testClass.getLoanType(), testClass.getLoanAmount());  	
    	return ResponseEntity.ok(empLoanResponse);
    }

    // Get an employee by ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> getEmployeeById(@PathVariable Long id) {
        EmployeeDetails employeeDetails = iEmployeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return ResponseEntity.ok(employeeDetails);
    }

    // Update an employee by ID
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDetails employeeDetails) {	
        return ResponseEntity.ok(empService.updateEmployee(id,employeeDetails));
    }
    
    // Delete an employee details
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
    	empService.deleteEmployee(id);
        return ResponseEntity.ok("Employee details successfully deleted.");
    }
    
    // Generate loan scheme
    @PostMapping("/schemeGen")
    public LoanScheme schemeGeneration(@RequestBody LoanScheme loanScheme){
    	return empService.schemeGeneration(loanScheme);
    }
    
    // Get all loan schemes
    @GetMapping("/getAllSchemes")
    public List<LoanScheme> getAllSchemes(){
    	return empService.getAllSchemes();
    }
   
    // Loan scheme updation 
    @PutMapping("/updateScheme/{schemeId}")
    public LoanScheme schemeUpdation(@PathVariable long schemeId, @RequestBody LoanScheme updLoanScheme){
		return empService.schemeUpdation(schemeId,updLoanScheme);
    }
    
}
