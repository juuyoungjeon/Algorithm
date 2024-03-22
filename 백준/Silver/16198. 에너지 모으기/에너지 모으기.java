import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] W;
	static boolean[] visited;
	static ArrayList<Integer> list;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N+1];
		
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			list.add(a);
		}
		solve(0);
		System.out.println(max);
		
//		solve(list, 0);
	}
	public static void solve(int sum) {
		if(list.size()==2) {
			max = Math.max(max, sum);
			return;
		}
		for(int i = 1; i < list.size() - 1; i++) {
			int tmp = list.get(i);
			int energy = list.get(i - 1) * list.get(i + 1);
			list.remove(i);
			solve(sum + energy);
			list.add(i, tmp);
			
		}
	}

}