package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DfsPractice {

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    static void CreateGraph(ArrayList<Edge>[] graph){

        for (int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);

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
//        graph[5].add(new Edge(5,6,1));

//        graph[6].add(new Edge(6,5,1));

    }



    static void DFS(ArrayList<Edge>[] graph){
      boolean vis[]=new boolean[graph.length];

      for (int i=0;i< graph.length;i++){
          if (!vis[i]){
              DFSUtil(graph,i,vis);
          }
      }
    }
    static void DFSUtil(ArrayList<Edge>[] graph,int curr,boolean visit[]){

        System.out.print(curr+" ");
        visit[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if (!visit[e.dest]){
                DFSUtil(graph,e.dest,visit);
            }
        }


    }
    public static void main(String[] args) {
        int V=7;
     ArrayList<Edge>[] graph=new ArrayList[V];
     CreateGraph(graph);

     DFS(graph);
    }
}
