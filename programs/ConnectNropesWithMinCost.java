import java.util.PriorityQueue;

public class ConnectNropesWithMinCost {
    public static int minCost(int arr[]){
        int n=arr.length;
        int res=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            res+=first+second;
            pq.add(first+second);
        }
        return res;

    }
    public static void main(String args[]){
        int arr[]={4,3,2,6};
        System.out.println("The minimum cost to connect two ropes: "+minCost(arr));
    }
    
}
