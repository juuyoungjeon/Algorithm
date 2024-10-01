import java.util.*;
import java.io.*;

public class Main {
	static int ans, cnt;
	static int[] test, arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		test = new int[10];
		arr = new int[10];
		for(int i = 0; i < 10; i++) {
			test[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);
		System.out.println(ans);

	}
	public static void dfs(int depth) {
		if(depth == 10) {
			cnt = 0;
			for(int i = 0; i < 10; i++) {
				if(arr[i] == test[i]){
					cnt++;
				}
				if(cnt == 5) {
					ans++;
					return;
				}
			}
			return;
		}
		for(int i = 1; i <= 5; i++) {
			if(depth > 1) {
				if(arr[depth - 2] == arr[depth - 1] && arr[depth - 1] == i) continue;
			}
			arr[depth] = i;
			dfs(depth + 1);
		}
		
	}

}