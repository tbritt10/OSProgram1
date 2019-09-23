/**
 * Producer.java
 *
 * This is the producer thread for the bounded buffer problem.
 *
 * @author Greg Gagne, Peter Galvin, Avi Silberschatz
 * @version 1.0 - July 15, 1999
 * Copyright 2000 by Greg Gagne, Peter Galvin, Avi Silberschatz
 * Applied Operating Systems Concepts - John Wiley and Sons, Inc.
 */

import java.util.*;

public class Producer extends Thread
{
   public Producer(BoundedBuffer b) {
      buffer = b;
   }

   public void run()
   {
   //Date message;
   int max = 50000; 
   int min = 8000; 
   int range = max - min + 1; 
   String name = this.getName();

      while (true)
      {
         int sleeptime = (int) (BoundedBuffer.NAP_TIME_PRODUCER * Math.random()) +3;

         System.out.println(name +" sleeping for " + sleeptime + " seconds");

         try { sleep(sleeptime*1000); }
         catch(InterruptedException e) {}

         // produce an item & enter it into the buffer
         int randNum = (int) (Math.random() * range) + min;
         //message = new Date();
         System.out.println(name +" produced " + randNum);

         buffer.enter(randNum);
      }
   }

   private  BoundedBuffer buffer;

}
