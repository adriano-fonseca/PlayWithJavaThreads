package com.company.app.threadsafe;

public class BankAccount {
  
  private int balance = 100;
  
  public void withdrawal(int amount) {
      balance=balance-amount;
  }
  
  
  /**
   * @author adriano-fonseca
   * 
   *  In this method the method doAnotherStuffIndependly don't need to be synchronized
   *  and the another twice need. So, doThat and doThis are grouped in a unique atomic 
   *  transaction. 
   */
  public void go() {
    doAnotherStuffIndependly();
    synchronized (this) {
      doThat();
      doThis();
    }
    
  }
  
  /**
   * @author adriano-fonseca 
   * @param amount
   * 
   * This method should be synchronized because if was not there is 
   * possible have negative balance.
   * 
   * For see that just remove synchronized from mathod sighnature
   * 
   */
  public synchronized void  makeWithdrawal(int amount) {
    if(amount <= getBalance()){
      System.out.println(Thread.currentThread().getName()+" will make a withdrawal");
      try{
      System.out.println(Thread.currentThread().getName()+" are going to sleep!");
      Thread.sleep(1000);
      }catch(InterruptedException ie){
        ie.printStackTrace();
      }
        withdrawal(amount);
        System.out.println(Thread.currentThread().getName()+" woke up!");
        System.out.println(Thread.currentThread().getName()+" has ended the withdrawal!");
    }else{
      System.out.println(Thread.currentThread().getName()+" THERES IS NOT ENOUG MONEY!");
    }
  }
  
  public int getBalance() {
    return balance;
  }
  
  private void doThat() {
    System.out.println("That done!");
  }
  
  private void doThis() {
    System.out.println("This done!");
  }
  
  private void doAnotherStuffIndependly() {
    System.out.println("Another stuff done!");
  }
}
