package Transaction;

import java.util.ArrayList;
import java.util.Date;
public class Deposit{


    private double amount; 
    private Date date;
    private String deposittype;
    private static List<String> transationLog = new ArrayList<>();

    public Deposit(double amount, String deposittype)
    {
        if(isValidAmount(amount))
        {
            this.amount = amount ; 
            this.deposittype = deposittype;
            tihs.date = new Date();
            logTransaction();

        }
        else 
        {

            throw new IllegalArgumentException("Invalid deposit amount");
        }


    }

    public Deposit(double amount)
    {
            this(amount,"Cash")

    }

    public boolean isValidAmount(double amount){
        return amount > 0 ; 
    }

    public double getAmount(double amount){
        return amount;

    }

    public Date getdate(){
        return date; 
    }

    public String getDepositType(){
        return deposittype;

    }
    private void logTransaction(){
        String logentry = String.format("Deposit of %.2f (%s) on %s" , amount , deposittype , date);
        transationLog.add(logentry);  
    }

    public void displaydepositentry(){
        System.out.println("Deposit Amount:" , amount);
        System.out.println("Deposit Date:" , date);
        System.out.println("Deposit Type" , deposittype);
    }

}
