import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		long d = 0;
		long g = 0;
		boolean[] visited = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			long a = list.get(i).size();
			if(a >= 3) {
				g += (a*(a-1)*(a-2))/6;
			}
			visited[i] = true;
			for(int nxt : list.get(i)) {
				int b = list.get(nxt).size();
				if(!visited[nxt]) {
					d += (a-1)*(b-1);
				}
			}
		}
		if(d > 3*g) {
			System.out.println("D");
		}else if(d < 3*g) {
			System.out.println("G");
		}else {
			System.out.println("DUDUDUNGA");
		}
	}

}