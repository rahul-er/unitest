package com.unimoni.glmodule.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.unimoni.glmodule.model.EmployeeDetails;

@Entity
@Table(name = "EmployeeLoanDetails")
public class EmployeeLoanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private EmployeeDetails employeeId;

    @Column(name = "loanAmount")
    private String loanAmount;

    @Column(name = "loanType")
    private String loanType;

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public EmployeeDetails getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeDetails employeeId) {
        this.employeeId = employeeId;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Override
    public String toString() {
        return "EmployeeLoan [loanId=" + loanId + ", employeeId=" + employeeId + ", loanAmount=" + loanAmount
                + ", loanType=" + loanType + "]";
    }
}
