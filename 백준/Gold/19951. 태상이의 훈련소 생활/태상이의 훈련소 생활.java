import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] prefix = new int[N + 2];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			prefix[start] += k;
			prefix[end + 1] -= k;
		}
		
		for(int i = 1; i <= N; i++) {
			prefix[i] += prefix[i-1];
			arr[i] += prefix[i];
			
			System.out.print(arr[i] + " ");
		}
	}

}