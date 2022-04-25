package Week1;

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class BBQ {

  public static void main(String[] args) {
    Queue<String> q = new LinkedList<String>();
    String[] words = new String[] { "seven", "slimy", "snakes", "sallying", "slowly", "slithered", "southward"};
  
    for(String x : words) {
      System.out.println("Enqueued Data: "+ x);
      System.out.println("Words Count: "+ q.size());
      System.out.print("Data: ");
        
      q.add(x);
      System.out.println(q);
      System.out.println("\n");
    }
    for (String x : words) {
      System.out.println("Dequeued Data: "+ x);
      System.out.println("Words Count: "+ q.size());
      System.out.print("Data: ");
      q.poll();
      System.out.println(q);
      System.out.println("\n");
    }
  }
}

