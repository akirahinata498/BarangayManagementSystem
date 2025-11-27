package BarangayManagementSystem;

import java.util.Scanner;
import java.lang.Thread.State;
import java.time.LocalDate;
import java.time.Month;

public class PayrollRecord extends FinancialRecord{
    private String employeeName;
    private String emeployeeID;
    private String position;
    private double grossPay;
    private int workingDays;
    private double companyLoan;
    private double philHealth;
    private double sss;
    private double pagIbig;
    private double dailyRate;

    private LocalDate today = LocalDate.now();
    private int year = today.getYear();
    private FinancialRecorderManager financeManager;
    private Validations validation;
    

    PayrollRecord(String financeID, String dateOfTransaction, String status, String employeeName, String employeeID
        ,String position,  int workingDays, double dailyRate) {
        super(financeID, "Payroll", dateOfTransaction, status);
        setEmployeeName(employeeName);
        setEmployeeID(employeeID);
        setPosition(position);
        setWorkingDays(workingDays);
        setDailyRate(dailyRate);
        computeGrossPay();
        setCompanyLoan(getGrossPay());
        setPhilHealth(getGrossPay());
        setSSS(getGrossPay());
        setPagIbig(getGrossPay());
        computeNetPay();
    }

    PayrollRecord() {
        this.financeManager = FinancialRecorderManager.getInstance();
        this.validation = new Validations();
    }


    @Override
    public void addRecord(Scanner scan) {
        scan.nextLine();
       String financeID = "PAY-" + year + "-" + String.format("%05d", newCountedRecord());
       System.out.print("Enter Employee Name: ");
       String name = scan.nextLine();
       System.out.print("Enter Employee ID: ");
       String id = scan.nextLine();
       System.out.print("Enter Employee Position: ");
       String position = scan.nextLine();
       System.out.print("Enter Number of Working Days: ");
       int workDays = scan.nextInt();
       System.out.print("Daily Rate: ");
       double rate = scan.nextDouble();
       String dateOfTransaction = validation.validateDateOfBirth(scan);
       scan.nextLine();
       System.out.print("Enter the payroll status of user: ");
       String statusUser = scan.nextLine();
       PayrollRecord payroll = new PayrollRecord(financeID, dateOfTransaction, statusUser, employeeName, id, position, workDays, dailyRate);
       financeManager.addRecord(payroll);
    }
    @Override
    public void deleteRecord(Scanner scan) {
 
    }
    @Override
    public void viewAllRecord(Scanner scan) {
       for (FinancialRecord records : financeManager.getAllRecords()) {
        if (records instanceof PayrollRecord payrollRecord) {
            System.out.println(payrollRecord.toString());
        }
       }
    }
    @Override
    public void editRecord(Scanner scan)  {

    }
    public void computeNetPay() {
        double deductions = getSSS() + getCompanyLoan() + getPhilHealth() + getPagIbig();
        System.out.println("The deductions are " + deductions);
        setTotalCost(getGrossPay() - deductions);
    }
    public int newCountedRecord() {
        int totalPayrollRecords = 0;
        for (FinancialRecord records : financeManager.getAllRecords()) {
            if (records instanceof PayrollRecord) {
                totalPayrollRecords++;
            }
        }
        return totalPayrollRecords++;
    }

    public void computeGrossPay() {
        setGrossPay(getDailyRate() * getWorkingDays());
    }
    

    

//getters 
public String getEmployeeName() {
    return employeeName;
}
public String getEmployeeID() {
    return emeployeeID;
}
public int getWorkingDays() {
    return workingDays;
}
public String getPosition() {
    return  position;
}
public double getGrossPay() {
    return grossPay;
}
public double getCompanyLoan() {
    return companyLoan;
}
public double getPhilHealth() {
    return philHealth;
}
public double getSSS() {
    return sss;
}
public double getPagIbig() {
    return pagIbig;
}
public double getDailyRate() {
    return dailyRate;
}



//setters
public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
}
public void setEmployeeID(String employeeID) {
    this.emeployeeID = employeeID;
}
public void setWorkingDays(int workingDays) {
    this.workingDays = workingDays;
}
public void setPosition(String position) {
    this.position = position;
}
public void setGrossPay(double grossPay) {
    this.grossPay = grossPay;
}
public void setCompanyLoan(double companyLoan) {
    this.companyLoan = companyLoan;
}

public void setPhilHealth(double philHealth) {
    this.philHealth = (philHealth == 0) ? 0 : philHealth * (5/100);
}
public void setSSS(double sss) {
    this.sss = (sss == 0)  ? 0 : getGrossPay() * (3/100);
}
public void setPagIbig(double pagIbig) {
    this.pagIbig = (pagIbig == 0) ? 0 : getGrossPay() * (2/100);
}
public void setDailyRate(double dailyRate) {
    this.dailyRate = dailyRate;
}
    // private String employeeName;
    // private String emeployeeID;
    // private String position;
    // private double grossPay;
    // private int workingDays;
    // private double companyLoan;
    // private double philHealth;
    // private double sss;
    // private double pagIbig;
    // private double dailyRate;

@Override
public String toString() {
    return "Employee ID: " + getEmployeeID() + "\n" +
           "Employee Name: " + getEmployeeName() + "\n" + 
           "Employee Position: " + getPosition() + "\n" + 
           "Employee Daily Rate: " + getDailyRate() + "\n" +
           "Employee Working Days: " + getWorkingDays() + "\n" + 
           "Employee Company Loan: " + getCompanyLoan() + "\n" + 
           "Employee PhilHealth Contribution: " + getPhilHealth() + "\n" + 
           "Employee SSS Contribution: " + getSSS() + "\n" + 
           "Employee Pag-Ibig Contribution: " + getPagIbig() + "\n" + 
           "Employee Net Pay: " + getTotalCost(); 
}


}
