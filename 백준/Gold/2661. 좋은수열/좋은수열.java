import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr = {1,2,3};
	static char[] res;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
	
		res = new char[N];
		
		recur(0,"");
		
	}
	public static void recur(int depth, String line) {
		if(depth == N) {
			System.out.println(line);
			System.exit(0);;
		}
		
		for(int i = 0; i < 3; i++) {
			if(check(line + arr[i])) recur(depth + 1, line + arr[i]);
		}
	}
	
	public static boolean check(String line) {
		for(int i = 1; i <= line.length()/2; i++) {
			if(line.substring(line.length() - i, line.length()).equals(line.substring(line.length() - i * 2, line.length() - i)))
				return false;
		}
		return true;
	}

}