import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] visited;
	static int cnt,kind,max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visited = new int[10];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(twoPointer(0,0));

	}

	public static int twoPointer(int left, int right) {
		if(right == N) {
			return max;
		}
		if(visited[arr[right]] == 0) {
			kind++;
		}
		visited[arr[right]]++;
		cnt++;
		
		if(kind > 2) {
			visited[arr[left]]--;
			cnt--;
			if(visited[arr[left]] == 0) {
				kind--;
			}
			left++;
		}
		
		max = Math.max(cnt, max);
		
		return twoPointer(left, right + 1);
	}
	
}