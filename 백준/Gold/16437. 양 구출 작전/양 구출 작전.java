import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static class Node{
		long value;
		boolean kinds; // true : 양, false : 늑대
		public Node(long value, boolean kinds) {
			this.kinds = kinds;
			this.value = value;
		}
	}
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static Node[] nodes;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		nodes = new Node[N+1];
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		nodes[1] = new Node(0, true);
		for(int i = 2; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			char t = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			list.get(p).add(i);
			nodes[i] = new Node(a, t == 'S');
		}
		
		sb.append(search(1));
		System.out.println(sb);
		

	}
	public static long search(int index) {
		long sum = 0;
		
		for(int next : list.get(index)) {
			sum += search(next);
		}
		
		if(nodes[index].kinds) {
			return sum + nodes[index].value;
		}else {
			return sum - nodes[index].value < 0? 0 : sum - nodes[index].value;
		}
	}

}