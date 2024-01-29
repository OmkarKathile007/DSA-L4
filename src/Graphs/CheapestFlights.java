package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    static void createGraph(ArrayList<Edge> []graph,int flights[][]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        for (int i=0;i<graph.length;i++){
            int src=flights[i][0];
            int dest=flights[i][1];
            int wt=flights[i][2];
            Edge e = new Edge(src,dest,wt);
            graph[src].add(e);
        }
    }


    static class Info{
        int v;
        int cost;
        int stops;

        Info(int v,int c,int stops){
            this.v=v;
            this.cost=c;
            this.stops=stops;
        }
    }

    static int CheapFlights(ArrayList<Edge> []graph,int flight[][],int src,int dst,int k){
        int dist[]=new int[graph.length];
        for (int i=0;i< graph.length;i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        while (!q.isEmpty()){
            Info curr=q.remove();
            if(curr.stops>k){
                break;
            }
            for (int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int w=e.wt;

                if (curr.cost+w<dist[v] && curr.stops<=k){
                    dist[v]=curr.cost+w;
                    q.add(new Info(v,dist[v],curr.stops+1));
                }
            }
        }
        if (dist[dst]==Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dist[dst];
        }
    }


    public static void main(String[] args) {
        int n=4;
        int flight[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src=0;
        int dst=3;
        int k=1;
        ArrayList<Edge>[] graph=new ArrayList[n];
        createGraph(graph,flight);
        System.out.println(CheapFlights(graph,flight,src,dst,k));


    }
}
