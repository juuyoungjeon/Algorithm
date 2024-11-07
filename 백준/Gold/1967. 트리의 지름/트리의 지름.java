import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<int[]>[] graph;
    static int[] dist;
    static int maxDistanceNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        // First DFS to find the farthest node from node 1
        dist = new int[n + 1];
        maxDistanceNode = 1;
        dist[1] = 0;
        dfs(1, -1);

        // Second DFS to find the diameter of the tree
        int startNode = maxDistanceNode;
        dist = new int[n + 1];
        dist[startNode] = 0;
        dfs(startNode, -1);

        int maxDistance = 0;
        for (int d : dist) {
            if (d > maxDistance) {
                maxDistance = d;
            }
        }

        System.out.println(maxDistance);
    }

    static void dfs(int cur, int prev) {
        for (int[] next : graph[cur]) {
            int nxtNode = next[0];
            int d = next[1];
            if (nxtNode != prev) {
                dist[nxtNode] = dist[cur] + d;
                if (dist[nxtNode] > dist[maxDistanceNode]) {
                    maxDistanceNode = nxtNode;
                }
                dfs(nxtNode, cur);
            }
        }
    }
}