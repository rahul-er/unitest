package com.unimoni.glmodule.dto;

public class EmployeeLoanRequest {

    private long employeeId;
    private String loanType;
    private String loanAmount;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public String toString() {
        return "EmployeeLoanRequest [employeeId=" + employeeId + ", loanType=" + loanType + ", loanAmount=" + loanAmount
                + "]";
    }
}
