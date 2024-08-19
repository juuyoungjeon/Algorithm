import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static HashSet<Integer> hs = new HashSet<>();
	static ArrayList<Integer> list;
	static int cnt = 1;
	static int max = 1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			hs.add(arr[i]);
		}
		
		for(int c : hs) {
			cnt = 1;
			int prev = arr[0];
			for(int i = 1; i < N; i++) {
				if(arr[i] == c) continue;
				if(prev != arr[i]) {
					cnt = 1;
				}else {
					cnt++;
				}
				max = Math.max(max, cnt);
				prev = arr[i];
			}
		}
		
		System.out.println(max);
		
	}

}