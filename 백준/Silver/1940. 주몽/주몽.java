import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int s= 0;
		int e= N-1;
		while(s < e) {
			if(arr[s] + arr[e] < M) {
				s++;
			}else if(arr[s] + arr[e] > M) {
				e--;
			}else {
				cnt++;
				s++;
				e--;
			}
		}
		
		System.out.println(cnt);
	}

}