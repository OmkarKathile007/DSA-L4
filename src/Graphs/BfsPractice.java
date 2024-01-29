package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsPractice {

    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;

        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        int V=11;

        for (int i=1;i<=V;i++){
            graph[i]=new ArrayList<>();
        }

        graph[1].add(new Edge(1,4,1));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,5,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,1,1));

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,7,1));

        graph[4].add(new Edge(4,1,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,9,1));

        graph[5].add(new Edge(5,2,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
        graph[6].add(new Edge(6,7,1));

        graph[7].add(new Edge(7,3,1));
        graph[7].add(new Edge(7,3,1));

        graph[8].add(new Edge(8,9,1));
        graph[8].add(new Edge(8,7,1));

        graph[9].add(new Edge(9,8,1));
        graph[9].add(new Edge(9,4,1));
    }

    public static void BreadthFirstSearch(ArrayList<Edge>[] graph){
        Queue<Integer> q=new LinkedList<>();
        boolean visit[]=new boolean[graph.length];
        q.add(0);

        while (!q.isEmpty()){
            int curr=q.remove();
            if (!visit[curr]){
                System.out.print(curr+" ");
                visit[curr]=true;

                for (int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }



    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean visit[]){
        if (src==dest){
            return true;
        }
        visit[src]=true;
        for (int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if (!visit[e.dest] && hasPath(graph,e.dest,dest,visit)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V=10;
      ArrayList<Edge>[] graph=new ArrayList[V];
      createGraph(graph);
      BreadthFirstSearch(graph);
//        System.out.println();
//        System.out.println(hasPath(graph,0,4,new boolean[V]));

    }
}
