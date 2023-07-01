//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
          boolean[][] vis=new boolean[n][n];
          ArrayList<String> result = new ArrayList<String>();
          findAllPossiblePaths(m,n,vis,0,0,n-1,n-1,"",result);
          return result;
    }
    public static void findAllPossiblePaths(int[][] m,int n ,boolean[][] vis,int i,int j,int d_r,int d_c,String path,ArrayList<String> result){
        
     if(i==d_r && j==d_c){
         result.add(path);
         return;
     }
     vis[i][j]=true;
     if (i - 1 >= 0 && m[i - 1][j] != 0 && !vis[i - 1][j]) {
        findAllPossiblePaths(m, n, vis, i - 1, j, d_r, d_c, path + "U", result);
    }
    if (i + 1 < n && m[i + 1][j] != 0 && !vis[i + 1][j]) {
        findAllPossiblePaths(m, n, vis, i + 1, j, d_r, d_c, path + "D", result);
    }
    if (j - 1 >= 0 && m[i][j - 1] != 0 && !vis[i][j - 1]) {
        findAllPossiblePaths(m, n, vis, i, j - 1, d_r, d_c, path + "L", result);
    }
    if (j + 1 < n && m[i][j + 1] != 0 && !vis[i][j + 1]) {
        findAllPossiblePaths(m, n, vis, i, j + 1, d_r, d_c, path + "R", result);
    }
    
    vis[i][j]=false;
    }
    
}
