/*************************************************************
* Main.java
* Driver for Loan class
* John Young
* 
* Advanced Java Programming - BCIS 3342 - 021
* Unit 7 Assignment
* Due Date: March 9, 2025
*************************************************************/


public class Main {
  public static void main(String[] args) {


    Loan loan = new Loan();  // Instantiate a Loan object
    loan.getLoanInfo();      // Get loan information from user
    //loan.output();         // Display loan information

    // Calculate and store the payment amount
    loan.setPaymentAmount(loan.calculatePayment());

    // Display the payment # and loan balance
    loan.calculateBalance(loan.getNumberOfPayments());

  }  // End of main method
}  // End of Main class