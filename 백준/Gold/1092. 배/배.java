import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static Integer[] crain;
	static Integer[] box;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		crain = new Integer[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(crain, Collections.reverseOrder());
		
		M = Integer.parseInt(br.readLine());
		box = new Integer[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(box, Collections.reverseOrder());
		
		if(crain[0] < box[0]) {
			System.out.println(-1);
			return;
		}
		
		int[] crains_position = new int[N];
		boolean[] visited = new boolean[M];
		
		while(M>0) {
			for(int i = 0; i < N; i++) {
				if(M == 0) break;
				for(int j = crains_position[i]; j < box.length; j++) {
					if(visited[j] == true) continue;
					if(crain[i] < box[j]) {
						crains_position[i]++;
						continue;
					}else if(crain[i] >= box[j]) {
						visited[j] = true;
						M--;
						break;
					}
				}
			}
			ans++;
		}
		System.out.println(ans);
	}

}