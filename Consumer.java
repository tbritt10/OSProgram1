/**
 * Consumer.java
 *
 * This is the consumer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class Consumer extends Thread
{
   public Consumer(BoundedBuffer b)
   {
      buffer = b;
   }

   public void run()
   {
   //Date message;
   int bufferNum;
   int sum;
   int n;
   String name = this.getName();

     while (true)
      {
         int sleeptime = (int) (BoundedBuffer.NAP_TIME_CONSUMER * Math.random()) +4;

         System.out.println(name +" sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // consume an item from the buffer
         System.out.println(name +" wants to consume.");

         //message = (Date)buffer.remove();
         bufferNum = (int)buffer.remove();
         
         sum = 0;
         n = bufferNum;
          
         while (n != 0) { 
            sum = sum + n % 10; 
            n = n/10; 
        } 
         
         System.out.println(name +" consumed "+bufferNum + " Sum of digits in " + name + ": " +sum);
      }
   }

   private  BoundedBuffer buffer;

}


