package Graphs;

import java.util.ArrayList;

public class IsCycled {

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

        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,1));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,0));

        graph[4].add(new Edge(4,2));
    }

    static boolean IsCycle(ArrayList<Edge> []graph){
        boolean visit[]=new boolean[graph.length];

        for (int i=0;i< graph.length;i++){
            if (!visit[i]){
                if (IsCycleUtil(graph,visit,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean IsCycleUtil(ArrayList<Edge> []graph,boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if (!vis[e.dest] ){
                if (IsCycleUtil(graph,vis,e.dest,curr)) {
                    return true;
                }
            }
            else if(vis[e.dest] && e.dest!=par){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> [] graph=new ArrayList[V];

        createGraph(graph);
        System.out.println(IsCycle(graph));
    }
}
