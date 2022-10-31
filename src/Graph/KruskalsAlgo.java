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

class Edges implements Comparable<Edges> {

    int source;
    int destination;
    int weight;

    public int compareTo(Edges o) {
        return this.weight - o.weight;
    }

}

public class KruskalsAlgo {

    public static void kruskals(Edges[] input, int V) {
        Arrays.sort(input);

        int count = 0;
        int k = 0;

        int[] parent = new int[V];
        Edges[] output = new Edges[V - 1];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        while (count != V - 1) {
            Edges currparent = input[k];
            int sourceparent = parentCall(parent, currparent.source);
            int destparent = parentCall(parent, currparent.destination);
            if (sourceparent != destparent) {
                output[count] = currparent;
                count++;
                parent[sourceparent] = destparent;
            }
            k++;
        }
        for (int i = 0; i < V - 1; i++) {
            if (output[i].source <= output[i].destination) {
                System.out.println(output[i].source + " " + output[i].destination + " " + output[i].weight);
            } else {
                System.out.println(output[i].destination + " " + output[i].source + " " + output[i].weight);
            }
        }
    }

    public static int parentCall(int[] parent, int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return parentCall(parent, parent[vertex]);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();

        Edges[] input = new Edges[E];
        for (int i = 0; i < E; i++) {
            input[i] = new Edges();
            input[i].source = s.nextInt();
            input[i].destination = s.nextInt();
            input[i].weight = s.nextInt();
        }
        kruskals(input, V);
    }
}
