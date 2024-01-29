package Graphs;

import java.util.ArrayList;

public class PrintAllPaths {


    static class Edge{
        int src;
        int des;

        Edge(int src,int des){
            this.src=src;
            this.des=des;
        }
    }


    static void createGraph(ArrayList<Edge> []graph){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
    static void printAllPaths(ArrayList<Edge> []graph,int src,int dest,String path){
        if (src==dest){
            System.out.println(path+dest);
            return;
        }
        for (int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            printAllPaths(graph,e.des,dest,path+src+" -> ");
        }
    }
    public static void main(String[] args)
    {
        int V=6;
    ArrayList<Edge>[] graph = new ArrayList[V];

    createGraph(graph);
    printAllPaths(graph,5,1,"");
    }
}
