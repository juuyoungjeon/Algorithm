import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] digit = {9,8,7,6,5,4,3,2,1,0};
	static List<Long> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		solve(0,0);
		
		Collections.sort(list);
		if(N > list.size()) {
			System.out.println(-1);
			
		}else {
			System.out.println(list.get(N-1));
		}
	}
	public static void solve(long num, int idx) {
		if(idx == 10) {
			if(!list.contains(num)) {
				list.add(num);
			}
			return;
		}
		
		solve(num, idx + 1);
		solve(num*10 + digit[idx], idx + 1);
	}
}