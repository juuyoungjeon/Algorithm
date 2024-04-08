import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K;
//	static Hastmap<Integer, Integer> tm = new Hastmap<>();
	static TreeMap<Integer, Integer> tm = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		tm.put(-2_000_000_001, -1);//null 방지 최소값 삽입
        tm.put(2_000_000_001, -1);//null 방지 최대값 삽입
        
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int key = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			tm.put(key, value);
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			if(a == 1) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				tm.put(b, c);
			}else if(a == 2) {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(tm.containsKey(b)) {
					tm.put(b, c);
				}else {
					int newKey = find(tm.ceilingKey(b), tm.floorKey(b), b);
					if(newKey >= 0) {
						tm.put(newKey, c);
					}
				}
			}else {
				int b = Integer.parseInt(st.nextToken());
				if(tm.containsKey(b)) {
					sb.append(tm.get(b)).append("\n");
				}else {
					int newKey = find(tm.ceilingKey(b), tm.floorKey(b), b);
					if(newKey == -1) {
						sb.append(-1).append("\n");
					}else if(newKey == -2) {
						sb.append("?").append("\n");
					}else {
						sb.append(tm.get(newKey)).append("\n");
					}
				}
			}
		}
		
		System.out.println(sb);
	}
	
//	ceilingKey(): 현재 key 값 이상의 키들 중에서 가장 작은 키 반환
//	floorKey(): 현재 key 값 이하의 키들 중에서 가장 큰 키 반환
//	없으면 null 반환
	static int val1, val2;
	public static int find(Integer cKey, Integer fKey, int key) {
//		if(cKey != null) {
//		}
//		if(fKey != null) {
//		}
		val1 = Math.abs(cKey - key);
		val2 = Math.abs(fKey - key);
		
		if(val1 > K && val2 > K) {
			return -1;
		}else {
			if(val1 <= K && val2 <= K) {
				if(val1 == val2) {
					return -2;
				}else if(val1 < val2) {
					return cKey;
				}else {
					return fKey;
				}
			}else if(val1 > K) {
				return fKey;
			}else {
				return cKey;
			}
		}
	}

}