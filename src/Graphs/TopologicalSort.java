package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    static class Edge{
        int src;
        int dest;

        Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,0));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    static void topSort(ArrayList<Edge>[] graph){
        boolean []vis=new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i=0;i<graph.length;i++){
            if (!vis[i]){
                topSortUtil(graph,vis,i,s);
            }
        }
        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }

    static void topSortUtil(ArrayList<Edge>[] graph,boolean vis[],int curr,Stack<Integer> s){
        vis[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if (!vis[e.dest]){
                topSortUtil(graph,vis,e.dest,s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {

    }
}
