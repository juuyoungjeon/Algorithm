import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		indegree = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			//큐에서 학생번호 꺼내기
			int num = q.poll();
			//꺼낸 학생번호를 출력값에 저장
			sb.append(num + " ");
			//꺼낸 학생번호의 키 비교한 정보 가져오기
			ArrayList<Integer> now = list.get(num);
			
			for(int i : now) {
				//해당 학생보다 뒤에 서야하는 학생 정보 가져오기
				int tmp = i;
				//뒤에 서야하는 학생의 진입차수 감소
				indegree[tmp]--;
				//감소한 진입차수가 0이면 큐에 학생번호 넣기
				if(indegree[tmp] == 0) {
					q.offer(tmp);
				}
			}
		}
		
		System.out.println(sb);
	}

}