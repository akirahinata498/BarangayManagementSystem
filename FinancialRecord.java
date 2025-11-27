package BarangayManagementSystem;

public abstract class FinancialRecord implements Transparancy {
    private String financeID;
    private double totalCost;

    private String transactionType;
    private String dateOfTransaction;
    private String status;
    
        FinancialRecord(String financeID,  String transactionType, String dateOfTransaction, String status) {
            this.financeID = financeID;
            this.transactionType = transactionType;
            this.dateOfTransaction = dateOfTransaction;
            this.status = status;
        }   


FinancialRecord() {
}
    //getters
    public String getFinance() {
        return financeID;
    }
    public double getTotalCost() {
        return totalCost;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public String getDateOfTransaction() {
        return dateOfTransaction;
    }
    public String getStatus() {
        return status;
    }


    //setters
    public void setFinanceID(String financeID){
        this.financeID = financeID;
    }
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public void setDateOfTransaction(String dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }
    public void setStatus(String status) {
        this.status = status;
    }


    
}
