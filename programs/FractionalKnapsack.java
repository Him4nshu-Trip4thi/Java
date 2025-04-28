import java.util.*;

public class FractionalKnapsack{
    public static int knapsack(int value[], int weight[], int w){
        //sorting ratio
        double ratio[][]=new double[value.length][2];
        for(int i=0;i<value.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=value[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o->o[1])); 

        //calculateValue
        int capacity=w;
        int finalVal=0;
        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(capacity>weight[idx]){  //include all items
                finalVal+=value[idx];
                capacity-=weight[idx];
            }
            else{  //include fractional item
                finalVal+=(ratio[i][1]*capacity);
                capacity=0;
                break;
            }
        }
        return finalVal;

    }
    public static void main (String args[]){
        int value[]={60,100,120};
        int weight[]={10,20,30};
        int w=50;
        System.out.println("The minimum total value: "+knapsack(value,weight,w));
    }
}