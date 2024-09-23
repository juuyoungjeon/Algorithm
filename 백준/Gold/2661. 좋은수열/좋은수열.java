import java.util.*;
import java.io.*;

public class Main {
	static int[] arr = {1,2,3};
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		solve(0,"");
		
	}
	public static void solve(int depth, String num) {
		if(depth == N) {
			System.out.println(num);
			System.exit(0);
		}
		for(int i = 0; i < 3; i++) {
			if(check(num + arr[i])) {
				solve(depth + 1, num + arr[i]);
			}
		}
	}

	public static boolean check(String str) {
		for(int i = 1; i <= str.length()/2; i++) {
			if(str.substring(str.length() - i, str.length()).equals(str.substring(str.length() - i * 2, str.length()- i))){
				return false;	
			}
		}
		return true;
	}
}