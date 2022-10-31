/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class IsConnected {

    public static void bfs(int[][] mat, int sv, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int i = 0; i < mat.length; i++) {
                if (mat[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;

                }
            }
        }

    }

    public static void dfs(int[][] mat, int sv, boolean[] visited) {
        visited[sv] = true;
        for (int i = 0; i < mat.length; i++) {
            if (mat[sv][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(mat, i, visited);
            }
        }
    }

    public static boolean isConnected(int[][] mat) {
        boolean[] visited = new boolean[mat.length];
        bfs(mat, 0, visited);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
         */
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        if (v == 0 && e == 0) {
            System.out.print(true);
        } else {
            int[][] adjacent = new int[v][v];
            for (int i = 0; i < e; i++) {
                int sv = s.nextInt();
                int ev = s.nextInt();
                adjacent[sv][ev] = 1;
                adjacent[ev][sv] = 1;
            }
            boolean ans = isConnected(adjacent);
            System.out.print(ans);
        }
    }

}
