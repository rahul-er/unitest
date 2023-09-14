package com.unimoni.glmodule.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.unimoni.glmodule.exception.ResourceNotFoundException;
import com.unimoni.glmodule.model.EmployeeDetails;
import com.unimoni.glmodule.model.EmployeeLoanDetails;
import com.unimoni.glmodule.model.LoanScheme;
import com.unimoni.glmodule.dao.IEmpLoanRepository;
import com.unimoni.glmodule.dao.IEmpRepository;
import com.unimoni.glmodule.dao.ILoanScheme;
import com.unimoni.glmodule.dto.EmployeeLoanResponse;

@Service
public class EmpService {

    private final IEmpRepository empRepo;
    private final IEmpLoanRepository empLoanRepo;
    private final ILoanScheme loanSchemeRepo;

    @Autowired
    public EmpService(IEmpRepository empRepos, IEmpLoanRepository empLoanRepo, ILoanScheme loanSchemeRepo) {
        this.empRepo = empRepos;
        this.empLoanRepo = empLoanRepo;
        this.loanSchemeRepo = loanSchemeRepo;
    }
    
	public EmployeeDetails createEmployee(EmployeeDetails employeeDetails) {
		return empRepo.save(employeeDetails);
	}

    public List<EmployeeDetails> getAllEmployees() {
        return empRepo.findAll();
    }

    public EmployeeDetails getEmployeeById(Long id) {
        return empRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }    
    
    public EmployeeDetails updateEmployee(Long id, EmployeeDetails employeeDetails){
    	
		EmployeeDetails empDetails = getEmployeeById(id);	
			if (employeeDetails.getFirstName() != null) {
		    	empDetails.setFirstName(employeeDetails.getFirstName());
		    }
		
		    if (employeeDetails.getLastName() != null) {
		    	empDetails.setLastName(employeeDetails.getLastName());
		    }
		
		    if (employeeDetails.getEmailId() != null) {
		    	empDetails.setEmailId(employeeDetails.getEmailId());
		    } 
		return empRepo.save(empDetails);    
    } 

    public EmployeeDetails deleteEmployee(Long id) {
        EmployeeDetails employeeDetails = getEmployeeById(id);
        empRepo.delete(employeeDetails);
        return employeeDetails;
    }

    @Transactional
    public EmployeeLoanResponse loanOfemployee(Long employeeId, String loanType, String loanAmount) {
        EmployeeDetails empDetail = getEmployeeById(employeeId);

        // Update employee details
        empDetail.setFirstName(empDetail.getFirstName());
        empDetail.setLastName(empDetail.getLastName());
        empDetail.setEmailId(empDetail.getEmailId());

        // Save the updated employee details
        empRepo.save(empDetail);

        // Create a new EmployeeLoanDetails object
        EmployeeLoanDetails empLoanDetail = new EmployeeLoanDetails();
        empLoanDetail.setLoanType(loanType);
        empLoanDetail.setEmployeeId(empDetail);
        empLoanDetail.setLoanAmount(loanAmount);

        // Save the employee's loan details
        empLoanRepo.save(empLoanDetail);

        // Create the response object
        EmployeeLoanResponse empLoanResponse = new EmployeeLoanResponse();
        empLoanResponse.setLoanId(empLoanDetail.getLoanId());
        empLoanResponse.setEmployeeId(empDetail.getEmployeeId());
        empLoanResponse.setFirstName(empDetail.getFirstName());
        empLoanResponse.setLastName(empDetail.getLastName());
        empLoanResponse.setLoanType(empLoanDetail.getLoanType());
        empLoanResponse.setLoanAmount(empLoanDetail.getLoanAmount());

        return empLoanResponse;
    }

	public LoanScheme schemeGeneration(LoanScheme loanScheme) {
		LoanScheme loanSchemeUpd = new LoanScheme();
		loanSchemeUpd.setInterestRate(loanScheme.getInterestRate());
		loanSchemeUpd.setSchemeName(loanScheme.getSchemeName());
		loanSchemeUpd.setTenure(loanScheme.getTenure());
		loanSchemeUpd.setAddDate(LocalDateTime.now());
		loanSchemeUpd.setModDate(LocalDateTime.now());
		loanSchemeRepo.save(loanSchemeUpd);
		return loanSchemeUpd;
	}
	
	public List<LoanScheme> getAllSchemes(){
		return loanSchemeRepo.findAll();
	}
	
	public LoanScheme getSchemeById(Long schemeId) {
		return loanSchemeRepo.findById(schemeId).orElseThrow(() -> new ResourceNotFoundException("Loan scheme is not found with given id:"+schemeId));
    }  
	
	public LoanScheme schemeUpdation(long schemeId, LoanScheme updLoanScheme) {
		LoanScheme loanScheme = getSchemeById(schemeId);
		System.out.println("loanScheme-----"+loanScheme);
		if(updLoanScheme.getSchemeName() != null){
			loanScheme.setSchemeName(updLoanScheme.getSchemeName());
		}
		
		if(!Double.isNaN(updLoanScheme.getInterestRate())){
			loanScheme.setInterestRate(updLoanScheme.getInterestRate());
		}
		
		if(updLoanScheme.getTenure() != null){
			loanScheme.setTenure(updLoanScheme.getTenure());
		}
		loanSchemeRepo.save(loanScheme);
		return loanScheme;
	}
}
