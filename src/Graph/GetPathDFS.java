/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class GetPathDFS {

    public static ArrayList<Integer> getPath(int[][] mat, int v1, int v2, boolean[] visited) {
        if (v1 == v2) {
            ArrayList<Integer> a = new ArrayList<>();
            visited[v1] = true;
            a.add(v1);
            return a;
        }
        visited[v1] = true;
        for (int i = 0; i < mat.length; i++) {
            if (mat[v1][i] == 1 && !visited[i]) {
                ArrayList<Integer> a = getPath(mat, i, v2, visited);
                if (a != null) {
                    a.add(v1);

                    return a;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
         */
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int[][] adjacent = new int[v][v];
        for (int i = 0; i < e; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            adjacent[sv][ev] = 1;
            adjacent[ev][sv] = 1;
        }
        int v1 = s.nextInt();
        int v2 = s.nextInt();
        boolean[] visited = new boolean[v];

        ArrayList<Integer> arr = getPath(adjacent, v1, v2, visited);
        if (arr != null) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }
    }
}
