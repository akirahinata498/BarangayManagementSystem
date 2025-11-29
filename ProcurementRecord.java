package BarangayManagementSystem;

import java.util.Scanner;

public class ProcurementRecord extends FinancialRecord{
    private String item;
    private String purpose;
    private String supplier;
    private double unitCost;
    private int quantity;

    ProcurementRecord(String financeID, String dateOfTransaction, String status, String item, String purpose, String supplier, double unitCost, int quantity){ 
        super(financeID, "Procurement", dateOfTransaction, status);
        setItem(item);
        setPurpose(purpose);
        setSupplier(supplier);
        setUnitCost(unitCost);
        setQuantity(quantity);

    }

    ProcurementRecord() {
    }

    @Override
    public void addRecord(Scanner scan) {
        scan.nextLine();
        String financeID = "PRC-" + year + "-" + String.format("%05d", newCountedRecord());
        System.out.print("Enter Item Name: ");
        String itemName = scan.nextLine();
        System.out.print("Enter Item's Purpose: ");
        String itemPurpose = scan.nextLine();
        System.out.print("Enter Item's Unit Cost: ");
        double itemUnitCost = scan.nextDouble();
        System.out.print("Enter quantity: ");
        int itemQuantity = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Item's Supplier: ");
        String itemSupplier = scan.nextLine();
        String transactionDate = TransactionDate(scan);
        System.out.print("Enter Transaction Status: ");
        String status = scan.nextLine();
        ProcurementRecord procurementRecord = new ProcurementRecord(financeID, transactionDate, status, itemName, itemPurpose, itemSupplier, itemUnitCost, itemQuantity);
        financeManager.addRecord(procurementRecord);
    }

    @Override
    public void deleteRecord(Scanner scan) {
        scan.nextLine();
             System.out.print("Enter the Procurement id that you want to delete: ");
        String procurementID = scan.nextLine();
        for (FinancialRecord financeRecord : financeManager.getAllRecords()) {
            if (financeRecord instanceof FinancialRecord && procurementID.equals(financeRecord.getFinanceID())) {
                financeManager.getAllRecords().remove(financeRecord);
   
                System.out.println("Record deleted Successfully");
                break;
            }
        }
    }

    @Override
    public void viewAllRecord(Scanner scan) {
       for (FinancialRecord records : financeManager.getAllRecords()) {
        if (records instanceof ProcurementRecord procurementRecord) {
            System.out.println(procurementRecord.toString());
        }
       }
    }
    @Override
    public void editRecord(Scanner scan) {
        
    }

    public void computeProcurementCost() {
        
    }

    //getteres
    public String getItem() {
        return item;
    }
    public String getPurpose() {
        return purpose;
    }
    public String getSupplier() {
        return supplier;
    }
    public double getUnitCost() {
        return unitCost;
    }
    public int getQuantity() {
        return quantity;
    }



    ///setters
    public void setItem(String item) {
        this.item = item;
    }
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Procurement ID: " + getFinanceID() + "\n" +
               "Transaction Type: " + getTransactionType() + "\n" + 
               "Item Type: " + getItem() + "\n" +
               "Purpose: " + getPurpose() + "\n" + 
               "Unit Cost: " + getUnitCost() + "\n" + 
               "Quantity: " + getQuantity() + "\n" + 
               "Total Cost: " + getTotalCost() + "\n" +
               "Supplier: " + getSupplier() + "\n" + 
               "Date of Transaction: " + getDateOfTransaction() + "\n"; 
    }
}   
