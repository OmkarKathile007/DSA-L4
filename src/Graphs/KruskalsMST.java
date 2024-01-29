package Graphs;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KruskalsMST {
    static int n=4;
    static int par[]=new int[n];
    static int rank[]=new int[n];

    static void init(){

        for (int i=0;i< par.length;i++){
            par[i]=i;
        }
    }

    public static int find(int x){
        if (x==par[x]){
            return x;
        }

        return par[x]=find(par[x]);
    }

    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);

        if (rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]<rank[parB]){
            par[parA]=parB;
        }
        else{
            par[parB]=parA;
        }
    }

    static class Edge implements Comparable<Edge>{
      int src;
      int dest;
      int wt;

      public Edge(int src,int dest,int wt){
          this.src=src;
          this.wt=wt;
          this.dest=dest;
      }

      @Override
        public int compareTo(Edge e){
          return this.wt-e.wt;
      }
    }

    public static void createGraph(ArrayList<Edge> graph){

        graph.add(new Edge(0,1,10));
        graph.add(new Edge(0,2,15));
        graph.add(new Edge(0,3,30));
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(2,3,50));




    }

    public static void KruskalMST(ArrayList<Edge>graph,int V){
        init();
        Collections.sort(graph);
        int mstcost=0;
        int count=0;

        for (int i=0;count<V-1;i++){
           Edge e =graph.get(i);

           int parA=find(e.src);
           int parB=find(e.dest);

           if (parA!=parB){
               union(e.src,e.dest);
               mstcost+=e.wt;
               count++;
           }
        }
        System.out.println(mstcost);
    }

    public static void main(String[] args) {
        int n=4;
        ArrayList<Edge> graph=new ArrayList();
        createGraph(graph);
        KruskalMST(graph,n);


    }
}
