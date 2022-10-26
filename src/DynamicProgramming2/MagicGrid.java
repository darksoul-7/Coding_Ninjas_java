/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Magic Grid


Send Feedback
You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.
Input format:
The first line contains the number of test cases T. T cases follow. Each test case consists of R C in the first line followed by the description of the grid in R lines, each containing C integers. Rows are numbered 1 to R from top to bottom and columns are numbered 1 to C from left to right. Cells with A[i][j] < 0 contain poison, others contain magic juice.
Output format:
Output T lines, one for each case containing the minimum strength you should start with from the cell (1,1) to have a positive strength through out his journey to the cell (R,C).
Constraints:
1 ≤ T ≤ 5
2 ≤ R, C ≤ 500
-10^3 ≤ A[i][j] ≤ 10^3
A[1][1] = A[R][C] = 0
Time Limit: 1 second
Sample Input 1:
3
2 3
0 1 -3
1 -2 0
2 2
0 1
2 0
3 4
0 -2 -3 1
-1 4 0 -2
1 -2 -3 0
Sample Output 1:
2
1
2
 */
package DynamicProgramming2;

/**
 *
 * @author Lenovo
 */
public class MagicGrid{
    
    public static int getMinimumStrength_mem(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] storage=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                storage[i][j]=-1;
            }
        }
        return getMinimumStrength_mem(grid,0,0,m,n,storage);
    }
    public static int getMinimumStrength_mem(int[][] grid, int i, int j, int r, int c, int[][] storage){
        if(i>=r||j>=c){
            return Integer.MAX_VALUE;
        }
        if(storage[i][j]!=-1){
            return storage[i][j];
        }
        if(i==r-1 && j==c-1){
            if(grid[i][j]<=0){
                return grid[i][j]+1;
            }else{
                return 1;
            }
        }
        int res1=getMinimumStrength_mem(grid,i+1,j,r,c,storage);
        int res2=getMinimumStrength_mem(grid,i,j+1,r,c,storage);
        int min=Math.min(res1,res2)-grid[i][j];
        if(min<=0){
            storage[i][j]=1;
        }else{
            storage[i][j]=min;
        }
        return storage[i][j];
    }
    public static int getMinimumStrength_dp(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[m-1][n]=1;
        dp[m][n-1]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int min=Math.min(dp[i+1][j],dp[i][j+1])-grid[i][j];
                if(min<=0){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=min;
                }
            }
        }
        int ans=dp[0][0];
        return ans;
    }
    public static int getMinimumStrength_rec(int[][] grid) {

        return getMinimumStrength_rec(grid, 0, 0, grid.length, grid[0].length);
    }

    public static int getMinimumStrength_rec(int[][] grid, int i, int j, int r, int c) {
        if (i >= r || j >= c) {
            return Integer.MAX_VALUE;
        }
        if (i == r - 1 && j == c - 1) {
            if (grid[i][j] <= 0) {
                return grid[i][j] + 1;
            } else {
                return 1;
            }
        }
        int res1 = getMinimumStrength_rec(grid, i + 1, j, r, c);
        int res2 = getMinimumStrength_rec(grid, i, j + 1, r, c);
        int min = Math.min(res1, res2) - grid[i][j];

        if (min <= 0) {
            return 1;
        } else {
            return min;
        }
    }
    
    public static void main(String[] args) {
        int[][] arr={{0, -2, -3, 1},{-1, 4, 0, -2},{1, -2, -3, 0}};
        System.out.println(getMinimumStrength_dp(arr));
        System.out.println(getMinimumStrength_mem(arr));
        System.out.println(getMinimumStrength_rec(arr));
    }
}