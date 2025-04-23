import java.util.*;
public class Interleave2HalfQueue{
    public static void interleave(Queue<Integer> q){
        int size=q.size();
        Queue<Integer> qfirst=new LinkedList<>();
        for(int i=0;i<size/2;i++){
            qfirst.add(q.remove());
        }

        while(!qfirst.isEmpty()){
            q.add(qfirst.remove());
            q.add(q.remove());
        }
        System.out.print("The interleaved Queue: ");
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
    public static void main (String args[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        q.add(11);
        q.add(12);

        interleave(q);
    }
    
}
