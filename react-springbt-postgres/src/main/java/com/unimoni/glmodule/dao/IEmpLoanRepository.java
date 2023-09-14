package com.unimoni.glmodule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimoni.glmodule.model.EmployeeLoanDetails;

public interface IEmpLoanRepository extends JpaRepository<EmployeeLoanDetails, Long> {

}
