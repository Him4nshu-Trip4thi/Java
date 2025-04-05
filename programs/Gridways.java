public class Gridways {
    public static int gridWays(int i,int j, int row, int col){
        if(i==row-1 && j==col-1){
            return 1;
        }
        else if(i==row || j==row){
            return 0;
        }

        int w1=gridWays(i+1, j, row, col);
        int w2=gridWays(i, j+1, row, col);

        return w1+w2;
    }
    public static void main (String Args[]){
        int row=10;
        int col=10;


        System.out.println("Total no. of ways from SRC to DST are : "+gridWays(0,0,row,col));
        
    }
    
}
