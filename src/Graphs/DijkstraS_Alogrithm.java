package Graphs;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraS_Alogrithm {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n,int path){
            this.n=n;
            this.path=path;
        }

        @Override
        public int compareTo(Pair p2){
            return Integer.compare(this.path,p2.path);
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,8));
        graph[0].add(new Edge(0,2,3));

        graph[1].add(new Edge(1,0,8));
        graph[1].add(new Edge(1,3,1));
        graph[1].add(new Edge(1,3,2));

        graph[2].add(new Edge(2,0,3));
        graph[2].add(new Edge(2,1,4));

        graph[3].add(new Edge(3,1,2));
        graph[3].add(new Edge(3,2,7));
        graph[3].add(new Edge(3,5,4));

        graph[4].add(new Edge(4,2,2));
        graph[4].add(new Edge(4,3,7));
        graph[4].add(new Edge(4,5,3));

        graph[5].add(new Edge(5,3,4));
        graph[5].add(new Edge(5,4,3));
//        graph[0].add(new Edge(0,1,2));
//        graph[0].add(new Edge(0,2,4));
//
//        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,7));
//
//        graph[2].add(new Edge(2,4,3));
//
//        graph[3].add(new Edge(3,5,1));
//
//        graph[4].add(new Edge(4,5,5));
//        graph[4].add(new Edge(4,3,2));

    }



    public static void Dijkstra(ArrayList<Edge>[] graph,int src){
        int dist[]=new int[graph.length];

        for (int i=0;i<dist.length;i++){
            if (i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[dist.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        while (!pq.isEmpty()){
            Pair curr=pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v,dist[v]));
                    }

                }
            }
        }

        for (int i=0;i<dist.length;i++){
            System.out.print(dist[i]+" -> ");
        }
        System.out.print("END");
        System.out.println();


    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);

        Dijkstra(graph,0);
    }
}
