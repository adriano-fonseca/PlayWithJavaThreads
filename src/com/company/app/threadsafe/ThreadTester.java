package com.company.app.threadsafe;

public class ThreadTester {

   public static void main(String[] args){
     Runnable threadJob = new EduardoAndMonicaJob();
     Thread menager1 = new Thread(threadJob);
     Thread menager2 = new Thread(threadJob);
     menager1.setName("Eduardo");
     menager2.setName("Monica");
     menager1.start();
     menager2.start();
   }
}
