import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<ArrayList<Node>> list;
    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static int[] dist;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        dist = new int[N+1];
        
        list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++){
            list.get(road[i][0]).add(new Node(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Node(road[i][0], road[i][2]));
        }
        
        for(int i = 1; i <= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        bfs();
        
        for(int i = 1; i <= N; i++){
            if(dist[i] <= K) answer++;
        }

        return answer;
    }
    public static void bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        dist[1] = 0;
        
        while(!pq.isEmpty()){
            Node now = pq.poll();
            
            if(dist[now.idx] < now.cost) continue;
            for(Node next : list.get(now.idx)){
                if(dist[next.idx] > now.cost + next.cost){
                    dist[next.idx] = now.cost + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}