import java.util.*;
import java.io.*;

public class Main {
	static int m,n,cnt=0;
	static long l;
	static int[] animal;
	static int[] gun;
	static class Node{
		int a;
		int b;
		public Node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	static ArrayList<ArrayList<Node>> list;
	static Node[] animals;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//사대의 수
		m = Integer.parseInt(st.nextToken());
		//동물의 수
		n = Integer.parseInt(st.nextToken());
		//사정거리
		l = Long.parseLong(st.nextToken());
		
		gun = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			gun[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(gun);
		
		animals = new Node[n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			animals[i] = new Node(a,b);
		}
		
		solve();
		System.out.println(cnt);
	}
	public static void solve() {
		cnt = 0;
		for(int i = 0; i < n; i++) {
			int s = 0;
			int e = m -1;
			while(s<=e) {
				int mid = (s + e) / 2;
				long dist = Math.abs(gun[mid] - animals[i].a) + animals[i].b;
				
				if(dist <= l) {
					cnt++;
					break;
				}
				if(animals[i].a < gun[mid]) {
					e = mid -1;
				}else {
					s = mid + 1;
				}
			}
		}
		
	}

}
//https://loosie.tistory.com/714
//https://data-make.tistory.com/593