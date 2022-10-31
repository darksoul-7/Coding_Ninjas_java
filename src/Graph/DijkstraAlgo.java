/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Lenovo
 */
import java.util.Scanner;

public class DijkstraAlgo {

    public static void dikstra(int[][] adj) {
        int V = adj.length;

        boolean[] visited = new boolean[V];
        int[] distance = new int[V];

        distance[0] = 0;
        for (int i = 1; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < V - 1; i++) {
            int U = findminver(distance, visited);
            visited[U] = true;
            for (int j = 0; j < V; j++) {
                if (adj[U][j] != 0 && !visited[j]) {
                    int c_dist = distance[U] + adj[U][j];
                    if (distance[j] > c_dist) {
                        distance[j] = c_dist;
                    }
                }

            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    public static int findminver(int[] distance, boolean[] visited) {
        int minvertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && (minvertex == -1 || distance[i] < distance[minvertex])) {
                minvertex = i;
            }
        }
        return minvertex;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        /* Write Your Code Here
		 * Complete the Rest of the Program
		 * You have to take input and print the output yourself
         */
        int[][] adj = new int[V][V];

        for (int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            int weight = s.nextInt();
            adj[sv][ev] = weight;
            adj[ev][sv] = weight;
        }
        dikstra(adj);
    }
}
