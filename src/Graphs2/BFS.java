package Graphs2;

import java.util.*;

public class BFS {
    static class Edge{
        int dest;
        int wt;

        Edge(int dest,int wt){
            this.dest=dest;
            this.wt=wt;
        }

    }

    public static ArrayList<Integer> BFS(ArrayList<ArrayList<Edge>> graph){
        ArrayList<Integer> al = new ArrayList<>();
        boolean vis[]=new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(graph.get(0).get(0).dest);
//        vis[0]=true;
        while (!q.isEmpty()){
            Integer curr=q.remove();
            al.add(curr);
            for (Edge  i:graph.get(curr)){
                if (!vis[curr]){
                    vis[curr]=true;
                    q.add(i.dest);
                }
            }

        }
        return al;


    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Edge>> graph=new ArrayList<>();
        int V=8;
        for (int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(1,1));
        graph.get(0).add(new Edge(5,1));
        graph.get(1).add(new Edge(2,1));
        graph.get(1).add(new Edge(3,1));
        graph.get(1).add(new Edge(0,1));
        graph.get(5).add(new Edge(6,1));
        graph.get(5).add(new Edge(8,1));
        graph.get(5).add(new Edge(1,1));
        graph.get(6).add(new Edge(7,1));
        graph.get(6).add(new Edge(5,1));
        graph.get(3).add(new Edge(4,1));
        graph.get(3).add(new Edge(1,1));
        graph.get(4).add(new Edge(7,1));
        graph.get(7).add(new Edge(4,1));

        System.out.println(BFS(graph));


    }
}
