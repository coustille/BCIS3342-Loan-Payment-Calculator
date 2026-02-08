/*************************************************************
* Loan.java
* This class calculates loan payment amount based on number
* of payments using recursion.
* John Young
*  
* Advanced Java Programming - BCIS 3342 - 021
* Unit 7 Assignment
* Due Date: March 9, 2025
*************************************************************/
import java.util.Scanner;

public class Loan {
    private double loanAmount = 0.0;
    private double loanBalance = 0.0;
    private double rate = 0.0;
    private double paymentAmount = 1.0;
    private int numberOfPayments = 0;

// ***********************************************************************
    // Method to calculate loan payment amount 
    public double calculatePayment() {
        double payment = loanAmount / (calculatePVIFA(numberOfPayments));
        System.out.printf("%nPayment Amount: $ %,.2f%n%n", payment);
        return payment;
    }  // End of calculatePayment method


// ***********************************************************************

    // Method to calculate PVIFA using recursion. This calculates
    // gains of interest over time using Present Value Interest
    // Factor of Annuity (PVIFA) formula - P = (1−(1+r)−n)/r,
    // where r = interest rate, n = number of payments,
    // and P = present value of loan.
    private double calculatePVIFA(int numberOfPayments) {
        // stopping condition
        if (numberOfPayments == 0) {
            return 0.0;
        }
        // recursively call calculatePVIFA until stopping condition
        return 1.0 / Math.pow(1.0 + rate, numberOfPayments) + 
               calculatePVIFA(numberOfPayments - 1);
    }  // end method calculatePVIFA

// ***********************************************************************
    // Method to calculate loan balance and print the payment # and
    // loan balance for each payment using recursion.
    public double calculateBalance(int numberOfPayments){
        double balance = 0.0;    // local variable to hold balance
        // stopping condition
        if (numberOfPayments == 0){
            loanBalance = loanAmount;  // set loan balance to loan amount
            System.out.printf("Payment # %2d, Balance: $ %.2f%n%n", numberOfPayments,                 loanBalance);  // display payment # and balance for payment 0
            return loanBalance;
        } else {
            // recursively call calculateBalance until stopping condition
            balance = (calculateBalance(numberOfPayments - 1) * (1 + rate)) 
                - paymentAmount;
            System.out.printf("Payment # %2d, Balance: $ %.2f%n%n", 
                numberOfPayments, balance);  // display payment # and balance
            return balance;
        }
    }  // End of calculateBalance method

// ***********************************************************************
    public void getLoanInfo() {
        // Create a Scanner object for keyboard input.
        Scanner stdIn = new Scanner(System.in); 

        System.out.println("Enter the loan, rate, and number of payments: ");
        loanAmount = stdIn.nextDouble();
        rate = stdIn.nextDouble();
        numberOfPayments = stdIn.nextInt();
    }  // End of getLoanInfo method

// ***********************************************************************
    // Method for testing purposes
    public void output() {
        System.out.printf("Loan amount: $ %,.2f\n", loanAmount);
        System.out.println("Rate: " + rate);
        System.out.println("Number of payments: " + numberOfPayments);
        System.out.printf("Initial Payment amount: %,.2f%n", paymentAmount);
    }  // End of output method

// ***********************************************************************
    // Setter method for paymentAmount
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }  // End of setPaymentAmount method

// ***********************************************************************
    // Getter method for PaymentAmount
    public double getPaymentAmount() {
        return paymentAmount;
    }  // End of getPaymentAmount method

// ***********************************************************************
    // getter method for numberOfPayments
    public int getNumberOfPayments() {
        return numberOfPayments;
    }  // End of getNumberOfPayments method

}  // End of Loan class