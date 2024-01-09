import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int max = 0;
			int res = 0;
			
			int x = 0;
			
			ArrayList<Integer> list = new ArrayList<>();
			StringTokenizer st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			for(int j = 0; j < list.size() - 1; j++	) {
				for(int k = j + 1; k < list.size(); k++) {
					res = gcd(list.get(j), list.get(k));
					max = Math.max(max,res);
				}
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int gcd(int a, int b) {
		int tmp;
		while(b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		
		return a;
	}

}