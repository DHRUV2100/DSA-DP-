package MinCostPath;
public class Main {
    public static int minCostMaze(int[][] maze,int i,int j){
        //bc
        if(i==0&&j==0)
            return maze[i][j];
        int ansU=Integer.MAX_VALUE;
        int ansL=Integer.MAX_VALUE;
        //faith
        //up
        if(i-1>=0){
            ansU=minCostMaze(maze, i-1, j);
        }
        //left
        if(j-1>=0){
            ansL=minCostMaze(maze, i, j-1);
        }
        //exp
        int ans=(Math.min(ansL,ansU))+maze[i][j];
        return ans;
    }
    public static int minCostMazeMemo(int[][] maze,int i,int j,int[][] dp){
        //bc
        if(i==0&&j==0)
            return dp[i][j]=maze[i][j];
        //subporblem
        if(dp[i][j]!=0)
            return dp[i][j];    
        int ansU=Integer.MAX_VALUE;
        int ansL=Integer.MAX_VALUE;
        //faith
        //up
        if(i-1>=0){
            ansU=minCostMazeMemo(maze, i-1, j,dp);
        }
        //left
        if(j-1>=0){
            ansL=minCostMazeMemo(maze, i, j-1,dp);
        }
        //exp
        int ans=(Math.min(ansL,ansU))+maze[i][j];
        return dp[i][j]=ans;
    }
    public static int minCostMazeTabu(int[][] maze){
        int[][] dp=new int[maze.length][maze[0].length];
        //dir
        for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[0].length; j++) {
                    //bc
                    if(i==0&&j==0)
                        dp[i][j]=maze[i][j];
                    else{
                        int ansU=Integer.MAX_VALUE;
                        int ansL=Integer.MAX_VALUE;
                        //faith
                        //up
                        if(i-1>=0){
                            ansU=dp[i-1][j];
                        }
                        //left
                        if(j-1>=0){
                            ansL=dp[i][j-1];
                        }
                        //exp
                        int ans=(Math.min(ansL,ansU))+maze[i][j];
                        dp[i][j]=ans;
                    }    
                }
            }
            return dp[maze.length-1][maze[0].length-1];
        }
        public static int minCostMazeTabuSO(int[][] maze){
            int[] prev=new int[maze[0].length];
            int[] curr=new int[maze[0].length];
            //for the first row
            prev[0]=maze[0][0];
            for (int j = 1; j < curr.length; j++) {
                prev[j]=prev[j-1]+maze[0][j];
            }
            //for normal rows
            for (int i = 1; i < maze.length; i++){
                for (int j = 0; j < curr.length; j++) {
                   if(j==0){
                    curr[j]=prev[j]+maze[i][j];
                   }
                   else{
                    int ansU=prev[j];
                    int ansL=curr[j-1];
                    curr[j]=Math.min(ansL,ansU)+maze[i][j];
                   } 
                }
                //update prev
                for (int j = 0; j < prev.length; j++) {
                    prev[j]=curr[j];
                }
            }
            return prev[prev.length-1];
        } 
    public static void main(String[] args) {
        int[][] maze={{5,9,6},{11,5,2}};

        System.out.println(minCostMaze(maze, 1, 2));
    }
}
