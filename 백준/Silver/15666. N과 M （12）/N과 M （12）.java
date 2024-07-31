import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] res;
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> hs = new HashSet<>();
	static Set<String> set = new LinkedHashSet<>(); //순서가 있음
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//길이가 K인 수열 오름차순으로 출력
		//같은 수 여러번 골라도 됨
		//N개의 자연수 중에서 M개 고르기
		//중복은 안됨
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		res = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		dfs(0,0);
//		list = new ArrayList<>(hs);
//		Collections.sort(list);
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		hs.stream().sorted().forEach(System.out::println);
		
		for(String str : set) {
			System.out.println(str);
		}
	}
	public static void dfs(int depth, int start) {
		if(depth == M) {
			String s = "";
			for(int i = 0; i < M; i++) {
				s += (res[i] + " ");
			}
//			hs.add(s);
			set.add(s);
			return;
		}
		for(int i = start; i < N; i++) {
			res[depth] = arr[i];
			dfs(depth + 1, i);
		}
	}

}