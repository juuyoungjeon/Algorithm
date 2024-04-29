import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static HashSet<Integer> set = new HashSet<>();
	static int ans = 1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			set.add(arr[i]);
		}
		
		for(int k : set) {
			int cnt = 1;
			int now = arr[0];
			for(int i = 1; i < N; i++) {
				if(arr[i] == k) continue;
				if(now != arr[i]) {
					cnt = 1;
				}else {
					cnt++;
					ans = Math.max(ans, cnt);
				}
				now = arr[i];
			}
		}
		System.out.println(ans);
	}

}