package src.Week3;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;  

import src.util.ConsoleColors;

public class Sorting {

  public static void main(String[] args) {
    System.out.println("===========SELECTION SORT===========");
    analyze("selection");
    System.out.println();
    
    System.out.println("===========BUBBLE SORT===========");
    analyze("bubble");
    System.out.println();
    
    System.out.println("===========INSERTION SORT===========");
    analyze("insertion");
    System.out.println();

    System.out.println("===========MERGE SORT===========");
    analyze("merge");
    System.out.println();
  }
  public static void analyze(String method) {
    ArrayList<Integer> allTwelve = new ArrayList<Integer>();
    int TIMES = 12;
    int SIZE = 5000;
    int sum = 0;
    int time = 0;
    for(int i=0; i< TIMES; i++) {
        BigData s = new BigData(SIZE, method);
        for(int j = 0; j<s.getData().size(); j++) {
            // To see data, uncomment next line
            // System.out.println(s.getData());
            sum += s.getData().get(j);
        }
        System.out.println("Average random: " + sum / ((i+1)*SIZE));
        System.out.println("Nanoseconds: " + s.getTimeElapsed()+"\n");
        time += s.getTimeElapsed();
        allTwelve.add(s.getTimeElapsed());
    }

    Collections.sort(allTwelve);
    
    System.out.println(ConsoleColors.CYAN+"Analysis for "+ method+" sort :D");
    System.out.println("Total Nanoseconds: " + time );
    System.out.println("Total Seconds: " + time /1000000000.0);
    System.out.println("ALL times in Nanoseconds: " + allTwelve);
    System.out.println("Average time in seconds "+ConsoleColors.GREEN_UNDERLINED+"(with high and low): "+ConsoleColors.CYAN+ time/12/1000000000.0);

    
    Integer allTen = 0;
    System.out.println("LOW (in nano): "+allTwelve.remove(0)); // remove smallest
    System.out.println("HIGH (in nano): "+allTwelve.remove(allTwelve.size()-1)); //remove largest
    for(Integer d : allTwelve) {
      allTen += d;
    }
    
    System.out.println("Average time in seconds "+ConsoleColors.GREEN_UNDERLINED+"(high low OMITTED): "+ConsoleColors.CYAN+ allTen/10/1000000000.0);
    // System.out.println("Average random in ALL ITERATIONS: " + sum / (TIMES*SIZE));
    if(method.equals("merge")) {
      System.out.println(ConsoleColors.PURPLE+"\nnote: FASTEST!!!!!");
    }

    System.out.println(ConsoleColors.RESET);
   
  
  
    
  }
}
