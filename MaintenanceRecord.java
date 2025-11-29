package BarangayManagementSystem;

import java.util.Scanner;

public class MaintenanceRecord extends FinancialRecord{

    private String maintenance;
    private String description;
    private String serviceProvider;
    private double laborCost;
    private double materialsCost;
  
    MaintenanceRecord(String financeID,  String dateOfTransaction, String status, String maintenance, String description, String serviceProvider, double laborCost, double materialsCost) {
        super(financeID, "Maintenance", dateOfTransaction, status);
        setMaintenance(maintenance);
        setDescription(description);
        setServiceProvider(serviceProvider);
        setLaborCost(laborCost);
        setMaterialsCost(materialsCost);
        setTotalCost(getMaterialsCost() + getLaborCost());
    }

    MaintenanceRecord() {
    }
    
    @Override
    public void addRecord(Scanner scan) {
        scan.nextLine();
        String financeID = "MTR-" +  year + "-" + String.format("%05d", newCountedRecord());
        System.out.print("Enter Maintenance Type: ");
        String maintenanceType = scan.nextLine();
        System.out.print("Enter Maintenance Description: ");
        String maintenanceDescription = scan.nextLine();
        System.out.print("Enter Service Provider: ");
        String serviceProvider = scan.nextLine();
        System.out.print("Enter Labor Cost: ");
        double labor = scan.nextDouble();
        System.out.println("Enter the Materials Cost");
        double materials = scan.nextDouble();
        String transactionDate = TransactionDate(scan);
        scan.nextLine();
        System.out.print("Enter the Transaction Status: ");
        String status = scan.nextLine();
        MaintenanceRecord maintenanceRecord = new MaintenanceRecord(financeID, transactionDate, status, maintenanceType, maintenanceDescription, serviceProvider, labor, materials);
        financeManager.addRecord(maintenanceRecord);
    }

    @Override
    public void deleteRecord(Scanner scan) {

    }

    @Override
    public void viewAllRecord(Scanner scan) {
       for (FinancialRecord records : financeManager.getAllRecords()) {
        if (records instanceof MaintenanceRecord payrollRecord) {
            System.out.println(payrollRecord.toString());
        }
       }
    }

    @Override
    public void editRecord(Scanner scan) {
      
    }



    //getters
    private String getMaintenance() {
        return maintenance;
    }
    public String getDescription() {
        return description;
    }
    public String getServiceProvider() {
        return serviceProvider;
    }
    public double getLaborCost() {
        return laborCost;
    }
    public double getMaterialsCost() {
        return materialsCost;
    }


    //setters
    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }
    public void setMaterialsCost(double materialsCost) {
        this.materialsCost = materialsCost;
    }


    @Override
    public String toString() {
        return "Maintenance ID: " + getFinanceID() + "\n" + 
               "Transaction Type: " + getTransactionType() + "\n" +
               "Maintenance Type: " + getMaintenance() + "\n" +
               "Maintenance Description: " + getDescription() + "\n" + 
               "Labor Cost: " + getLaborCost() + "\n" + 
               "Materials Cost: " + getMaterialsCost() + "\n" +
               "Total Cost: " + getTotalCost() + "\n" + 
               "Service Provider: " + getServiceProvider() + "\n" + 
               "Date of Transaction: " + getDateOfTransaction()+ "\n" + 
               "Transaction Status: " + getStatus() + "\n" ;
    }
}
