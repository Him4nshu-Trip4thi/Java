import java.util.*;
import java.util.Collections;
public class learnArrayList {
    public static void main (String Args[]){
        ArrayList <Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(7);
        arr.add(4);
        arr.add(5);
        arr.add(3);
        arr.add(11);
        arr.add(0);
        
        arr.remove(1);
        arr.remove(2);

       System.out.println(arr.get(1));


        System.out.println(arr);
        System.out.println(arr.size());
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)>max)
            {
                max=arr.get(i);
            }
            System.out.println(max);
        }


        System.out.println(arr);
        Collections.sort(arr);
        System.out.println(arr);
        Collections.sort(arr, Collections.reverseOrder());
        System.out.println(arr);

    }
    
}
