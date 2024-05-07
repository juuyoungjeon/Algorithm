import java.util.*;
import java.io.*;

public class Main {
	static int k;
	static String[] arr;
	static boolean[] visited;
	static List<String> list = new ArrayList<>();
	static int[] result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		k = Integer.parseInt(br.readLine());
		
		arr = br.readLine().split(" ");
		
		visited = new boolean[10];
		
		dfs("", 0);
		
		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
		
	}
	
	public static void dfs(String num, int idx) {
		if(idx == k + 1) {
			list.add(num);
			return;
		}
		
		for(int j = 0; j < 10; j++) {
			if(visited[j]) continue;
			
			if(idx == 0 || check(Character.getNumericValue(num.charAt(idx - 1)), j, arr[idx - 1])) {
				visited[j] = true;
				dfs(num + j, idx + 1);
				visited[j] = false;
			}
		}
	}
	
	public static boolean check(int a, int b, String c) {
		if(c.equals(">")) {
			if(a < b) return false;
		}else if (c.equals("<")) {
			if(a > b) return false;
		}
		return true;
	}

}