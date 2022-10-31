/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
import java.util.*;

public class AllConnectedComponents {

    public static void bfs(int[][] edges, int sv, boolean[] visited, ArrayList<Integer> a) {
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            a.add(front);
            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }

            }
        }
    }

    public static void dfs(int[][] edges, int sv, boolean[] visited, ArrayList<Integer> a) {
        a.add(sv);
        visited[sv] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(edges, i, visited, a);
            }
        }
    }

    public static void allcomp(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                ArrayList<Integer> a = new ArrayList<>();
                bfs(edges, i, visited, a);
                Collections.sort(a);
                for (int j = 0; j < a.size(); j++) {
                    System.out.print(a.get(j) + " ");

                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
         */
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();
        int[][] edges = new int[v][v];
        for (int i = 0; i < e; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }
        allcomp(edges);
    }
}
