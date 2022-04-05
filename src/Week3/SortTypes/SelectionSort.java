package src.Week3.SortTypes;
import java.util.*;


public class SelectionSort {  
    public static void doTheSort(ArrayList<Integer> arr){  
        for (int i = 0; i < arr.size() - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < arr.size(); j++){  
                if (arr.get(j) < arr.get(index)){  
                    index = j; //searching for lowest index  
                }  
            }  
            int smallerNumber = arr.get(index);   
            arr.set(index, arr.get(i)); 
            arr.set(i, smallerNumber);  
        }  
    }  
}
       