import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int cnt;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		cnt = 0;
		
		solve(0);
		System.out.println(cnt);
	}
	public static void solve(int depth) {
		if(depth == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			arr[depth] = i;
			
			if(Possible(depth)) {
				solve(depth + 1);
			}
		}
	}
	
	public static boolean Possible(int col) {
		for(int i = 0; i < col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			}else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}

}