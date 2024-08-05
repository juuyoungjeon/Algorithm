import java.util.*;
import java.io.*;

public class Main {
	static int N,K;
	static int[] C;
	static class Node implements Comparable<Node>{
		int weight;
		int price;
		public Node(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		public int compareTo(Node o) {
			if(this.weight == o.weight) {
				return o.price - this.price;
			}
			return this.weight - o.weight;
		}
	}
	static ArrayList<Node> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		C = new int[K];
		
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.add(new Node(m, v));
		}
		//보석 무게 기준 오름차순
		Collections.sort(list);

		for(int i = 0; i < K; i++) {
			C[i] = Integer.parseInt(br.readLine());
		}
		
		//가방 무게 오름차순
		Arrays.sort(C);
		
		//우선순위큐는 항상 가격이 내림차순 정렬되도록 설정
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		long ans = 0;
		
		for(int i = 0, j = 0; i < K; i++) {
			//현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음
			while(j < N && list.get(j).weight <= C[i]) {
				pq.add(list.get(j++).price);
			}
			
			//우선순위 큐에 있는 요소 하나 뺴서 가방에 넣음
			//pq는 내림차순으로 정렬되어 있으므로
			//첫번째 요소가 가장 큼
			if(!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		System.out.println(ans);
		
	}

}