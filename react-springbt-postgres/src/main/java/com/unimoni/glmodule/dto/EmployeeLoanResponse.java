package com.unimoni.glmodule.dto;

public class EmployeeLoanResponse {

    private long employeeId;
    private long loanId;
    private String firstName;
    private String lastName;
    private String loanType;
    private String loanAmount;

    // Constructors (default and parameterized) can be added if needed

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "EmployeeLoanResponse [employeeId=" + employeeId + ", loanId=" + loanId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", loanType=" + loanType + ", loanAmount=" + loanAmount + "]";
    }
}
