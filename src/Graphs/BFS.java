package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BFS {

    static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }


    static void CreateGraph(ArrayList<Edge> graph[]){

        for (int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

//        graph[0].add(new Edge(0,1,1));

//        graph[1].add(new Edge(0,1,1));
//        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,1));
//
//        graph[2].add(new Edge(2,0,1));
//        graph[2].add(new Edge(2,4,1));
//        graph[2].add(new Edge(2,1,0));
//
//        graph[3].add(new Edge(3,4,1));
//        graph[3].add(new Edge(3,1,1));
//        graph[3].add(new Edge(3,5,1));
//
//        graph[4].add(new Edge(4,5,1));
//        graph[4].add(new Edge(4,3,1));
//        graph[4].add(new Edge(4,2,1));
//
//        graph[5].add(new Edge(5,3,1));
//        graph[5].add(new Edge(5,6,1));
//        graph[5].add(new Edge(5,3,1));
//
//        graph[6].add(new Edge(6,5,1));


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

    static void BFS(ArrayList<Edge>[] graph){
        boolean visit[]=new boolean[graph.length];
        for (int i=0;i<graph.length;i++){
            if (!visit[i]) {
                BFSUtil(graph,visit);
            }
        }
    }
    static void BFSUtil(ArrayList<Edge>[] graph,boolean visit[]){
        Queue<Integer> q= new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()){
            int current=q.remove();
            if (!visit[current]){
                System.out.print(current+" ");
                visit[current]=true;
                for(int i=0;i<graph[current].size();i++){
                    Edge e=graph[current].get(i);
                    q.add(e.dest);
                }
            }
        }
    }



    public static void main(String[] args) {

        int V=9;
        ArrayList<Edge> []graph=new ArrayList[10];
        CreateGraph(graph);
        BFS(graph);

    }
}
