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
import java.util.*;

public class GetPathBFS {

    public static ArrayList<Integer> getPath(int[][] mat, int v1, int v2, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v1);
        visited[v1] = true;
        ArrayList<Integer> a = new ArrayList<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int i = 0; i < mat.length; i++) {
                if (mat[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    h.put(i, front);
                    if (i == v2) {
                        a.add(i);
                        while (!a.contains(v1)) {
                            int b = h.get(i);
                            a.add(b);
                            i = b;
                        }
                        return a;
                    }
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
