/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.*;

/**
 *
 * @author Lenovo
 */
public class Graph {

    public static void printHelperDFS(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                printHelperDFS(edges, i, visited);
            }
        }
    }
//    public static void print(int[][] edges, int sv){
//        boolean[] visited=new boolean[edges.length];
//        printHelper(edges,sv,visited);
//    }

    public static void printDFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelperDFS(edges, i, visited);
            }
        }

    }

    public static void printHelperBFS(int[][] edges, int si, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(si);
        visited[si] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.print(front + " ");
            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void printBFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                printHelperBFS(edges, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] edges = new int[n][n];
        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }
        printDFS(edges);
        printBFS(edges);
    }
}
