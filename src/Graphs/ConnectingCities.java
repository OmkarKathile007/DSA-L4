package Graphs;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {

        int dest;
        int wt;

        Edge(int d,int w){

            this.dest=d;
            this.wt=w;
        }

        @Override
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }
    }






    public static int connectingCities(int cities[][]){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean []vis=new boolean[cities.length];

        pq.add(new Edge(0,0));
        int finalcost=0;
        while (!pq.isEmpty()){
            Edge curr=pq.remove();
//            finalcost+=curr.wt;
            if(!vis[curr.dest]){
                vis[curr.dest]=true;
                finalcost+=curr.wt;
                for (int i=0;i<cities[curr.dest].length;i++){
                    if (cities[curr.dest][i]!=0){
                        pq.add(new Edge(i,cities[curr.dest][i]));
                    }
                }
            }
        }

        return finalcost;
    }

    public static void main(String[] args) {

        int cities[][]={{0,1,2,3,4},
                {1,0,5,0,7},
                {2,5,0,6,0},
                {3,0,6,0,0},
                {4,7,0,0,0}};

        System.out.println(connectingCities(cities));
    }
}
