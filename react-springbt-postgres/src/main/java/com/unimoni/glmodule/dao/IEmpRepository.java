package com.unimoni.glmodule.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.unimoni.glmodule.model.EmployeeDetails;

@Repository
public interface IEmpRepository extends JpaRepository<EmployeeDetails, Long> {
	
}



