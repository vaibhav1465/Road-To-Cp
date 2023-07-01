//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                int N = Integer.parseInt(br.readLine().trim());
                String[] S1 = br.readLine().trim().split(" ");
                String[] S2 = br.readLine().trim().split(" ");
                int[] KnightPos = new int[2];
                int[] TargetPos = new int[2];
                for(int i = 0; i < 2; i++){
                    KnightPos[i] = Integer.parseInt(S1[i]);
                    TargetPos[i] = Integer.parseInt(S2[i]);
                }
                Solution obj = new Solution();
                int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
                System.out.println(ans);
           }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution
    {
        static class Pair {
            int r;
            int c;
            int count;
            Pair(int i,int j,int c){
                this.r=i;
                this.c=j;
                this.count=c;
            }
        }
        //Function to find out minimum steps Knight needs to reach target position.
        public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n)
        {
            // Code 
            int s_r = KnightPos[1];
            int s_c = KnightPos[0];
            int d_r = TargetPos[1];
            int d_c = TargetPos[0];
           
            boolean[][] vis = new boolean[n+1][n+1];
            Queue<Pair> q = new LinkedList<Pair>();
            q.add(new Pair(s_r,s_c,0));
            int min_count = Integer.MAX_VALUE;
            int found=0;
            
            while(!q.isEmpty()){
                 Pair curr = q.remove();
                 int i = curr.r;
                 int j = curr.c;
                 int count = curr.count;
                 if(i==d_r && j==d_c && min_count > count ){
                     min_count =count;
                     found=1;
                 }
            if (i + 1 < n+1 && j-2 >=1 && !vis[i + 1][j-2]) {
                q.add(i-1,j-2,count+1);
             }
             if (i + 1 <n+1  && j+2 <n+1 && !vis[i + 1][j+2]) {
                q.add(i-1,j-2,count+1);
             }
             if (i-2 >= 1 && j+1 < n+1 && !vis[i - 2][j+1]) {
                q.add(i-2,j+1,count+1);
             }
             if (i+2 < n+1 && j+1< n+1 && !vis[i + 2 ][j+1]) {
                q.add(i+2,j+1,count+1);
             }
             if (i - 1 >=1  && j-2 >=1 && !vis[i - 1][j-2]) {
                q.add(i-1,j-2,count +1);
             }
             if (i - 1 >=1  && j+2 <n+1 && !vis[i - 1][j+2]) {
                q.add(i-1,j+2,count + 1);
             }
             if (i + 2 < n+1 && j-1 >=1 && !vis[i +2 ][j-1]) {
                q.add(i+2,j-1,count +1);
             }
             if (i - 2 >= 1 && j-1>=1 && !vis[i - 1][j-1]) {
                q.add(i-2,j-1,count +1 );
             }
            }
            
            
            if(found==1)
            return min_count;
            else
            return -1;
        }
    }
        
    