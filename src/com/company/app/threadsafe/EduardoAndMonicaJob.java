package com.company.app.threadsafe;

public class EduardoAndMonicaJob implements Runnable {
  
  private BankAccount account = new BankAccount();

  @Override
  public void run() {
//    go();
    for(int x=0; x<50; x++){
       account.makeWithdrawal(10);
       if(account.getBalance()<0){
         System.out.println("BLEW UP!");
       }
        /*uncomment this to test specific synchronized parts */
//      account.go();
    }
  }
}
