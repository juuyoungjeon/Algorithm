import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] list;
    static boolean[][] visited;
    static int[] result;
    static int n;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        
        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for(int j = 0; j < m; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        
        result = new int[n + 1];
        visited = new boolean[n + 2][10]; //[n번째 날][떡의 종류]
        dfs(1, 0);
        System.out.println("-1");
        
    }    
    
    public static void dfs(int depth, int prev) {
        if(depth == n + 1) {
            for(int i = 1; i < n + 1; i++) {
                System.out.println(result[i]);
            }
            System.exit(0);
        }
    
        for(int i = 1; i < 10; i++) {
            if(i != prev && visited[depth + 1][i] == false && list[depth].contains((Integer)i)) {
                visited[depth + 1][i] = true;
                result[depth] = i;
                dfs(depth + 1, i);
            }
        }
    }

}