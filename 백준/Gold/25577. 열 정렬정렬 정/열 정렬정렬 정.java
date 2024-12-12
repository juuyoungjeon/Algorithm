import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] sortedArr;
	static boolean[] visited;
	static HashMap<Integer, Integer> hm = new HashMap<>();
 	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		sortedArr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sortedArr[i] = arr[i];
		}
		
		Arrays.sort(sortedArr);
		
		for(int i = 0; i < N; i++) {
			hm.put(sortedArr[i], i);
		}
		
		for(int i = 0; i < N; i++) {
			arr[i] = hm.get(arr[i]);
		}
		
		int ans = 0;
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			
			int cycleLen = 0;
			int cur = i;
			
			while(!visited[cur]) {
				visited[cur] = true;
				cycleLen++;
				cur = arr[cur];
			}
			
			ans += cycleLen - 1;
		}
		
		System.out.println(ans);
		
		
	}

}