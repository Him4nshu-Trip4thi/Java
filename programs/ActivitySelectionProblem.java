import java.util.*;

public class ActivitySelectionProblem{
    public static ArrayList<Integer> activitySelection(int start[], int end[]){
        //2D array created from start and end
        int activity[][]=new int[start.length][3];
        for(int i=0;i<start.length;i++){
            activity[i][0]=i;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        //sorting
        Arrays.sort(activity, Comparator.comparingDouble(o->o[2])); //sorting based on 3rd columnIndex of EndTime...(o->o[2])

        //rest all same
        ArrayList<Integer> ans=new ArrayList<>();
        int maxAct=0;

        //1st Activity
        maxAct=1;
        ans.add(activity[0][0]);
        
        //for rest of the activity
        int lastEnd=activity[0][2];
        for(int i=1;i<end.length;i++){
            if(activity[i][1]>=lastEnd){
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd=activity[i][2];
            }
        }
        System.out.println("Maximum Activity that can be performed: "+maxAct);
        return ans;
    }

    public static ArrayList<Integer> activitySelectionforSortedET(int start[], int end[]){
        ArrayList<Integer> ans=new ArrayList<>();
        int maxAct=0;
        
        //1st Activity
        maxAct=1;
        ans.add(0);
        //for rest of the activity
        int lastEnd=end[0];
        for(int i=1;i<end.length;i++){
            if(start[i]>=lastEnd){
                maxAct++;
                ans.add(i);
                lastEnd=end[i];
            }
        }
        System.out.println("Maximum Activity that can be performed: "+maxAct);
        return ans;
    }
    public static void main (String args[]){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9}; //endtime sorted

        ArrayList<Integer> ans=new ArrayList<>();
        ans=activitySelection(start,end);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}