//{ Driver Code Starts
//Initial Template for Java

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
            String[] str = br.readLine().trim().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int[][] matrix = new int[N][M];
            for(int i=0; i<N; i++)
            {
                String[] s = br.readLine().trim().split(" ");
                for(int j=0; j<M; j++)
                    matrix[i][j] = Integer.parseInt(s[j]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.closedIslands(matrix, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        for(int i=0; i<N; i++){
            if(matrix[i][0] == 1)
                searchIslands(matrix, i, 0, N, M, 0);
            
            if(matrix[i][M-1] == 1)
                searchIslands(matrix, i, M-1, N, M, 0);
        }
        
        for(int i=0; i<M; i++){
            if(matrix[0][i] == 1)
               searchIslands(matrix, 0, i, N, M, 0);
                
            if(matrix[N-1][i] == 1)
                searchIslands(matrix, N-1, i, N, M, 0);
        }
        
        return numIslands(N, M, matrix);
    }
    
    
    
    public int numIslands(int n, int m, int[][] grid) {
        int rows = n;
        int cols = m;
        
        int noOfIslands=0;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    searchIslands(grid, i, j, rows, cols, 2);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    
    private void searchIslands(int[][] grid, int x, int y, int rows, int cols, int k)
    {
        if(x<0 || x>=rows || y<0 || y>=cols || grid[x][y] != 1)
            return;
            
        grid[x][y] = k;
        
        searchIslands(grid, x-1, y, rows, cols, k);
        searchIslands(grid, x+1, y, rows, cols, k);
        searchIslands(grid, x, y-1, rows, cols, k);
        searchIslands(grid, x, y+1, rows, cols, k);
    }
}