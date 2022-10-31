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

public class PrimsAlgo {

    public static void prims(int[][] adj) {
        int V = adj.length;

        boolean[] visited = new boolean[V];
        int[] weight = new int[V];
        int[] parent = new int[V];
        weight[0] = 0;
        for (int i = 1; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        parent[0] = -1;

        for (int i = 0; i < V; i++) {
            int minvertex = findMinVertex(weight, visited);
            visited[minvertex] = true;
            for (int j = 0; j < V; j++) {
                if (adj[minvertex][j] != 0 && !visited[j]) {
                    if (adj[minvertex][j] < weight[j]) {
                        weight[j] = adj[minvertex][j];
                        parent[j] = minvertex;
                    }
                }
            }
        }
        for (int i = 1; i < V; i++) {
            if (parent[i] < i) {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            } else {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            }
        }
    }

    public static int findMinVertex(int[] weight, boolean[] visited) {
        int minindex = -1;
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (minindex == -1 || weight[i] < weight[minindex])) {
                minindex = i;
            }
        }
        return minindex;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] adj = new int[V][V];
        for (int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            int weight = s.nextInt();
            adj[sv][ev] = weight;
            adj[ev][sv] = weight;
        }

        prims(adj);
    }
}
//    public static void prims(int[][] adj){
//        int v=adj.length;
//        boolean[] visited=new boolean[v];
//        int[] parent=new int[v];
//        int[] weight=new int[v];
//        weight[0]=0;
//        parent[0]=-1;
//        for(int i=1;i<v;i++){
//            weight[i]=Integer.MAX_VALUE;
//        }
//        
//        for(int i=0;i<v;i++){
//            int minvertex=findminVertex(weight, visited);
//            visited[minvertex]=true;
//            
//            for(int j=0;j<v;j++){
//                if(adj[minvertex][j]!=0 && !visited[j]){
//                    if(adj[minvertex][j]<weight[j]){
//                        weight[j]=adj[minvertex][j];
//                        parent[j]=minvertex;
//                    }
//                }
//            }
//            
//        }
//        
//        for(int i=1;i<v;i++){
//                if(parent[i]<i){
//                    System.out.println(parent[i]+" "+i+" "+weight[i]);
//                }else{
//                    System.out.println(i+" "+parent[i]+" "+weight[i]);
//                }
//            }
//        
//    }
//    
//    public static int findminVertex(int[] weight, boolean[] visited){
//        int minvertex=-1;
//        for(int i=0;i<weight.length;i++){
//            if(!visited[i]&&(minvertex==-1 || weight[i]<weight[minvertex])){
//                minvertex=i;
//            }
//        }
//        
//        return minvertex;
//    }
//
//	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int V = s.nextInt();
//		int E = s.nextInt();
//
//		/* Write Your Code Here
//		 * Complete the Rest of the Program
//		 * You have to take input and print the output yourself
//		 */
//        int[][] adj=new int[V][V];
//        for(int i=0;i<E;i++){
//            int sv=s.nextInt();
//            int dv=s.nextInt();
//            int weight=s.nextInt();
//            adj[sv][dv]=weight;
//            adj[dv][sv]=weight;
//        }
//        prims(adj);
//	}
//    
//}
