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
public class HasPath {

    public static boolean hasPath_DFS(int[][] mat, int v1, int v2, boolean[] visited) {
        if (v1 == v2) {
            return true;
        }
        visited[v1] = true;
        for (int i = 0; i < mat.length; i++) {
            if (!visited[i] && mat[i][v1] == 1) {
                if (hasPath_DFS(mat, i, v2, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPath_BFS(int[][] mat, int v1, int v2, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        visited[v1] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int i = 0; i < mat.length; i++) {
                if (!visited[i] && mat[i][front] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }

        }
        return visited[v2];
    }

    public static void main(String[] args) {
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
        if (v1 == v || v2 == v) {
            System.out.println(false);
        } else {
            boolean[] visited = new boolean[v];
            System.out.println(hasPath_BFS(adjacent, v1, v2, visited));
            System.out.println(hasPath_DFS(adjacent, v1, v2, visited));
        }
    }
}
